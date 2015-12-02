package es.polgomez.data.repository.datasources.database;

import es.polgomez.data.entities.PointOfInterestDetailEntity;
import es.polgomez.data.entities.PointOfInterestEntity;
import es.polgomez.data.entities.PointsOfInterestEntity;
import es.polgomez.data.repository.cache.item.ItemCachePolicy;
import es.polgomez.data.repository.cache.list.ListCachePolicy;
import es.polgomez.data.repository.datasources.exceptions.InvalidCacheException;
import es.polgomez.domain.PointOfInterest;
import es.polgomez.domain.PointOfInterestDetail;
import es.polgomez.domain.PointsOfInterest;
import io.realm.Realm;
import rx.Observable;

/**
 * Implementation of point of interest database source
 */
public class PointOfInterestDataBaseSource implements IPointOfInterestDataBaseSource {


    private final Realm realm;

    // TODO integrate realm and

    private ItemCachePolicy<PointOfInterestDetail> pointOfInterestDetailCachePolicy;
    private ItemCachePolicy<PointsOfInterest> pointsOfInterestDetailCachePolicy;
    private ItemCachePolicy<PointOfInterest> pointOfInterestCachePolicy;
    private ListCachePolicy<PointOfInterest> pointsOfInterestListCachePolicy;

    public PointOfInterestDataBaseSource(Realm realm) {
        this.realm = realm;

        pointOfInterestDetailCachePolicy = new ItemCachePolicy<>();
        pointsOfInterestDetailCachePolicy = new ItemCachePolicy<>();
        pointOfInterestCachePolicy = new ItemCachePolicy<>();
        pointsOfInterestListCachePolicy = new ListCachePolicy<>(pointOfInterestCachePolicy);
    }

    @Override
    public Observable<PointsOfInterestEntity> obtainPointsOfInterest() {
        return null;
    }

    @Override
    public void persistPointsOfInterest(PointsOfInterestEntity pointsOfInterest) {

    }

    @Override
    public void deletePointsOfInterest(PointsOfInterestEntity pointsOfInterest) {

    }

    @Override
    public Observable<PointOfInterestDetailEntity> obtainPointOfInterest(int pointOfInterestId) {
        return null;
    }

    @Override
    public void persisPointOfInterest(PointOfInterestEntity pointOfInterest) {

    }

    @Override
    public void deletePointOfInterest(PointOfInterestEntity pointOfInterest) {

    }

    @Override
    public void persistPointOfInterestDetail(PointOfInterestDetailEntity pointOfInterestDetail) {

    }
}
