package es.polgomez.data.repository.datasources.database;

import es.polgomez.data.entities.PointOfInterestDetailEntity;
import es.polgomez.data.entities.PointsOfInterestEntity;
import es.polgomez.data.repository.cache.item.ItemCachePolicy;
import es.polgomez.data.repository.datasources.database.entities.PointOfInterestDetailDataBaseEntity;
import es.polgomez.data.repository.datasources.database.entities.PointsOfInterestDataBaseEntity;
import es.polgomez.data.repository.datasources.database.entities.mapper.PointOfInterestDetailDataBaseMapper;
import es.polgomez.data.repository.datasources.database.entities.mapper.PointsOfInterestDataBaseMapper;
import es.polgomez.data.repository.datasources.database.observable.RealmObservable;
import io.realm.Realm;
import io.realm.RealmResults;
import rx.Observable;

/**
 * Implementation of point of interest database source
 */
public class PointOfInterestDataBaseSource implements IPointOfInterestDataBaseSource {

    private final Realm realm;

    private ItemCachePolicy<PointOfInterestDetailDataBaseEntity> pointOfInterestDetailCachePolicy;
    private ItemCachePolicy<PointsOfInterestDataBaseEntity> pointsOfInterestCachePolicy;

    public PointOfInterestDataBaseSource(Realm realm) {
        this.realm = realm;

        pointOfInterestDetailCachePolicy = new ItemCachePolicy<>();
        pointsOfInterestCachePolicy = new ItemCachePolicy<>();
    }

    @Override
    public Observable<PointsOfInterestEntity> obtainPointsOfInterest() {
        PointsOfInterestDataBaseMapper mapper = new PointsOfInterestDataBaseMapper();

        return RealmObservable.object(realm,
                realmParam -> realmParam.allObjects(PointsOfInterestDataBaseEntity.class).first())
                .filter(pointsOfInterestCachePolicy::isValid)
                .map(mapper::dataToModel);
    }

    @Override
    public void persistPointsOfInterest(PointsOfInterestEntity pointsOfInterest) {
        PointsOfInterestDataBaseMapper mapper = new PointsOfInterestDataBaseMapper();
        PointsOfInterestDataBaseEntity dataBaseEntity = mapper.modelToData(pointsOfInterest);

        PointsOfInterestDataBaseEntity pointsOfInterestDataBase = realm
                .allObjects(PointsOfInterestDataBaseEntity.class).first();

        realm.beginTransaction();
        if (pointsOfInterestDataBase == null) {
            realm.copyToRealm(dataBaseEntity);
        } else {
            pointsOfInterestDataBase.setPointsOfInterest(dataBaseEntity.getPointsOfInterest());
        }
        realm.commitTransaction();
    }

    @Override
    public void deletePointsOfInterest() {
        RealmResults<PointsOfInterestDataBaseEntity> realmResults =
                realm.allObjects(PointsOfInterestDataBaseEntity.class);
        if (realmResults != null && !realmResults.isEmpty()) {
            for (int i = 0; i < realmResults.size(); i++) {
                realmResults.get(i).removeFromRealm();
            }
        }
    }

    @Override
    public Observable<PointOfInterestDetailEntity> obtainPointOfInterest(int pointOfInterestId) {
        PointOfInterestDetailDataBaseMapper mapper = new PointOfInterestDetailDataBaseMapper();

        return RealmObservable.object(realm, realmParam ->
                realmParam.where(PointOfInterestDetailDataBaseEntity.class)
                        .equalTo("id", pointOfInterestId).findFirst())
                .filter(pointOfInterestDetailCachePolicy::isValid)
                .map(mapper::dataToModel);
    }

    @Override
    public void persisPointOfInterest(PointOfInterestDetailEntity pointOfInterest) {
        PointOfInterestDetailDataBaseMapper mapper = new PointOfInterestDetailDataBaseMapper();
        PointOfInterestDetailDataBaseEntity dataBaseEntity = mapper.modelToData(pointOfInterest);

        realm.beginTransaction();
        realm.copyToRealmOrUpdate(dataBaseEntity);
        realm.commitTransaction();
    }

    @Override
    public void deletePointOfInterest(PointOfInterestDetailEntity pointOfInterest) {
        PointOfInterestDetailDataBaseMapper mapper = new PointOfInterestDetailDataBaseMapper();
        PointOfInterestDetailDataBaseEntity dataBaseEntity = mapper.modelToData(pointOfInterest);

        PointOfInterestDetailDataBaseEntity pointOfInterestDetailDataBaseEntity = realm
                .where(PointOfInterestDetailDataBaseEntity.class)
                .equalTo("id", dataBaseEntity.getId())
                .findFirst();

        if (pointOfInterestDetailDataBaseEntity != null) {
            pointOfInterestDetailDataBaseEntity.removeFromRealm();
        }
    }
}
