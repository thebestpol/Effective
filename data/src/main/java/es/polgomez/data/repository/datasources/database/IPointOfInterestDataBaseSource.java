package es.polgomez.data.repository.datasources.database;

import es.polgomez.data.entities.PointOfInterestDetailEntity;
import es.polgomez.data.entities.PointsOfInterestEntity;
import rx.Observable;

/**
 * An interface of database source
 */
public interface IPointOfInterestDataBaseSource {

    Observable<PointsOfInterestEntity> obtainPointsOfInterest();

    void persistPointsOfInterest(PointsOfInterestEntity pointsOfInterest);

    void deletePointsOfInterest();

    Observable<PointOfInterestDetailEntity> obtainPointOfInterest(int pointOfInterestId);

    void persisPointOfInterest(PointOfInterestDetailEntity pointOfInterest);

    void deletePointOfInterest(PointOfInterestDetailEntity pointOfInterest);
}
