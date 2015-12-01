package es.polgomez.data.repository.datasources.database;

import es.polgomez.data.repository.datasources.exceptions.InvalidCacheException;
import es.polgomez.domain.PointOfInterest;
import es.polgomez.domain.PointOfInterestDetail;
import es.polgomez.domain.PointsOfInterest;
import rx.Observable;

/**
 * An interface of database source
 */
public interface IPointOfInterestDataBaseSource {

    Observable<PointsOfInterest> obtainPointsOfInterest() throws InvalidCacheException;

    void persistPointsOfInterest(PointsOfInterest pointsOfInterest);

    void deletePointsOfInterest(PointsOfInterest pointsOfInterest);

    Observable<PointOfInterestDetail> obtainPointOfInterest(int pointOfInterestId) throws InvalidCacheException;

    void persisPointOfInterest(PointOfInterest pointOfInterest);

    void deletePointOfInterest(PointOfInterest pointOfInterest);

    void persistPointOfInterestDetail(PointOfInterestDetail pointOfInterestDetail);
}
