package es.polgomez.data.repository;

import es.polgomez.data.repository.datasources.database.IPointOfInterestDataBaseSource;
import es.polgomez.domain.PointOfInterest;
import es.polgomez.domain.PointsOfInterest;

/**
 * Class to fill with network data the data base
 */
public class DataPopulate {

    // TODO custom exception?

    private final IPointOfInterestDataBaseSource dataBaseSource;

    public DataPopulate(IPointOfInterestDataBaseSource dataBaseSource) {
        this.dataBaseSource = dataBaseSource;
    }

    public void populatePointOfInterest(PointOfInterest pointOfInterest) {
        try {
            dataBaseSource.persisPointOfInterest(pointOfInterest);
        } catch (Exception e) {
            // TODO  handle exception
            e.printStackTrace();
        }
    }

    public void populatePointsOfInterest(PointsOfInterest pointsOfInterest) {
        try {
            dataBaseSource.persistPointsOfInterest(pointsOfInterest);
        } catch (Exception e) {
            // TODO handle exception
            e.printStackTrace();
        }
    }
}
