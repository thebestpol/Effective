package es.polgomez.data.repository.datasources.database;

import android.content.Context;

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
    // TODO: context??
    private final Context context;

    private ItemCachePolicy<PointOfInterestDetailDataBaseEntity> pointOfInterestDetailCachePolicy;
    private ItemCachePolicy<PointsOfInterestDataBaseEntity> pointsOfInterestCachePolicy;

    public PointOfInterestDataBaseSource(Context context) {
        this.context = context;

        pointOfInterestDetailCachePolicy = new ItemCachePolicy<>();
        pointsOfInterestCachePolicy = new ItemCachePolicy<>();
    }

    @Override
    public Observable<PointsOfInterestEntity> obtainPointsOfInterest() {
        PointsOfInterestDataBaseMapper mapper = new PointsOfInterestDataBaseMapper();

        return RealmObservable.object(context,
                realmParam -> {
                    RealmResults<PointsOfInterestDataBaseEntity> realmResults = realmParam.allObjects(PointsOfInterestDataBaseEntity.class);
                    if (realmResults.isEmpty()) {
                        return null;
                    } else {
                        return realmResults.first();
                    }

                })
                .filter(pointsOfInterestCachePolicy::isValid)
                .map(mapper::dataToModel);
    }

    @Override
    public void persistPointsOfInterest(PointsOfInterestEntity pointsOfInterest) {
        Realm realm = Realm.getInstance(context);

        PointsOfInterestDataBaseMapper mapper = new PointsOfInterestDataBaseMapper();
        PointsOfInterestDataBaseEntity dataBaseEntity = mapper.modelToData(pointsOfInterest);

        RealmResults<PointsOfInterestDataBaseEntity> realmResults = realm
                .allObjects(PointsOfInterestDataBaseEntity.class);

        PointsOfInterestDataBaseEntity pointsOfInterestDataBase = null;

        if (!realmResults.isEmpty()) {
            pointsOfInterestDataBase = realmResults.first();
        }

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
        Realm realm = Realm.getInstance(context);
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

        return RealmObservable.object(context, realmParam ->
                realmParam.where(PointOfInterestDetailDataBaseEntity.class)
                        .equalTo("id", pointOfInterestId).findFirst())
                .filter(pointOfInterestDetailCachePolicy::isValid)
                .map(mapper::dataToModel);
    }

    @Override
    public void persisPointOfInterest(PointOfInterestDetailEntity pointOfInterest) {
        Realm realm = Realm.getInstance(context);

        PointOfInterestDetailDataBaseMapper mapper = new PointOfInterestDetailDataBaseMapper();
        PointOfInterestDetailDataBaseEntity dataBaseEntity = mapper.modelToData(pointOfInterest);

        realm.beginTransaction();
        realm.copyToRealmOrUpdate(dataBaseEntity);
        realm.commitTransaction();
    }

    @Override
    public void deletePointOfInterest(PointOfInterestDetailEntity pointOfInterest) {
        Realm realm = Realm.getInstance(context);

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
