package es.polgomez.data.repository;

import es.polgomez.data.entities.PointOfInterestDetailEntity;
import es.polgomez.data.entities.PointsOfInterestEntity;
import es.polgomez.data.repository.datasources.database.IPointOfInterestDataBaseSource;

/**
 * Class to fill with network data the data base
 */
public class DataPopulate {

    private final IPointOfInterestDataBaseSource dataBaseSource;

    public DataPopulate(IPointOfInterestDataBaseSource dataBaseSource) {
        this.dataBaseSource = dataBaseSource;
    }

    public void populatePointsOfInterest(PointsOfInterestEntity pointsOfInterest) {
        if (pointsOfInterest != null) {
            dataBaseSource.persistPointsOfInterest(pointsOfInterest);
        }
    }

    public void populatePointOfInterestDetail(PointOfInterestDetailEntity pointOfInterestDetail) {
        if (pointOfInterestDetail != null) {
            dataBaseSource.persisPointOfInterest(pointOfInterestDetail);
        }
    }
}
