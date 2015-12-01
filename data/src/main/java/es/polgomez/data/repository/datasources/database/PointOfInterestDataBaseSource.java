package es.polgomez.data.repository.datasources.database;

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
    public Observable<PointsOfInterest> obtainPointsOfInterest() throws InvalidCacheException {
        // TODO
        PointsOfInterest pointsOfInterest = null;
        if (pointsOfInterestDetailCachePolicy.isValid(pointsOfInterest)) {
            return null;
        } else {
            throw new InvalidCacheException();
        }
    }

    @Override
    public void persistPointsOfInterest(PointsOfInterest pointsOfInterest){

    }

    @Override
    public void deletePointsOfInterest(PointsOfInterest pointsOfInterest){

    }

    @Override
    public Observable<PointOfInterestDetail> obtainPointOfInterest(int id) throws InvalidCacheException {
        // TODO
        PointOfInterestDetail pointOfInterestDetail = null;
        if (pointOfInterestDetailCachePolicy.isValid(pointOfInterestDetail)) {
            return null;
        } else {
            throw new InvalidCacheException();
        }
    }

    @Override
    public void persisPointOfInterest(PointOfInterest pointOfInterest){

    }

    @Override
    public void deletePointOfInterest(PointOfInterest pointOfInterest){

    }

    @Override
    public void persistPointOfInterestDetail(PointOfInterestDetail pointOfInterestDetail){

    }
}
