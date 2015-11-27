package es.polgomez.data.repository.datasources.database;

import es.polgomez.domain.PointOfInterest;
import es.polgomez.domain.PointsOfInterest;

/**
 * An interface of database source
 */
public interface IPointOfInterestDataBaseSource {

    // TODO custom exceptions?

    PointsOfInterest obtainPointsOfInterest() throws Exception;

    void persistPointsOfInterest(PointsOfInterest pointsOfInterest) throws Exception;

    void deletePointsOfInterest(PointsOfInterest pointsOfInterest) throws Exception;

    PointOfInterest obtainPointOfInterest(int id) throws Exception;

    void persisPointOfInterest(PointOfInterest pointOfInterest) throws Exception;

    void deletePointOfInterest(PointOfInterest pointOfInterest) throws Exception;
}
