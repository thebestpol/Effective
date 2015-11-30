package es.polgomez.data.repository.datasources.database;

import es.polgomez.data.repository.cache.item.ItemCachePolicy;
import es.polgomez.data.repository.cache.list.ListCachePolicy;
import es.polgomez.data.repository.datasources.exceptions.InvalidCacheException;
import es.polgomez.domain.PointOfInterest;
import es.polgomez.domain.PointOfInterestDetail;
import es.polgomez.domain.PointsOfInterest;

/**
 * Implementation of point of interest database source
 */
public class PointOfInterestDataBaseSource implements IPointOfInterestDataBaseSource {

    // TODO integrate realm and

    private ItemCachePolicy<PointOfInterestDetail> pointOfInterestDetailCachePolicy =
            new ItemCachePolicy<>();
    private ItemCachePolicy<PointsOfInterest> pointsOfInterestDetailCachePolicy =
            new ItemCachePolicy<>();
    private ItemCachePolicy<PointOfInterest> pointOfInterestCachePolicy = new ItemCachePolicy<>();
    private ListCachePolicy<PointOfInterest> pointsOfInterestListCachePolicy =
            new ListCachePolicy<>(pointOfInterestCachePolicy);

    @Override
    public PointsOfInterest obtainPointsOfInterest() throws InvalidCacheException {
        // TODO
        PointsOfInterest pointsOfInterest = null;
        if (pointsOfInterestDetailCachePolicy.isValid(pointsOfInterest)) {
            return pointsOfInterest;
        } else {
            throw new InvalidCacheException();
        }
    }

    @Override
    public void persistPointsOfInterest(PointsOfInterest pointsOfInterest) throws Exception {

    }

    @Override
    public void deletePointsOfInterest(PointsOfInterest pointsOfInterest) throws Exception {

    }

    @Override
    public PointOfInterestDetail obtainPointOfInterest(int id) throws InvalidCacheException {
        // TODO
        PointOfInterestDetail pointOfInterestDetail = null;
        if (pointOfInterestDetailCachePolicy.isValid(pointOfInterestDetail)) {
            return pointOfInterestDetail;
        } else {
            throw new InvalidCacheException();
        }
    }

    @Override
    public void persisPointOfInterest(PointOfInterest pointOfInterest) throws Exception {

    }

    @Override
    public void deletePointOfInterest(PointOfInterest pointOfInterest) throws Exception {

    }

    @Override
    public void persistPointOfInterestDetail(PointOfInterestDetail pointOfInterestDetail) throws Exception {

    }
}
