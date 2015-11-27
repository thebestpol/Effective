package es.polgomez.data.repository.datasources.database;

import es.polgomez.domain.PointOfInterest;
import es.polgomez.domain.PointsOfInterest;

/**
 * Implementation of point of interest database source
 */
public class PointOfInterestDataBaseSource implements IPointOfInterestDataBaseSource {

    // TODO integrate realm and
    
    @Override
    public PointsOfInterest obtainPointsOfInterest() throws Exception {
        return null;
    }

    @Override
    public void persistPointsOfInterest(PointsOfInterest pointsOfInterest) throws Exception {

    }

    @Override
    public void deletePointsOfInterest(PointsOfInterest pointsOfInterest) throws Exception {

    }

    @Override
    public PointOfInterest obtainPointOfInterest(int id) throws Exception {
        return null;
    }

    @Override
    public void persisPointOfInterest(PointOfInterest pointOfInterest) throws Exception {

    }

    @Override
    public void deletePointOfInterest(PointOfInterest pointOfInterest) throws Exception {

    }
}
