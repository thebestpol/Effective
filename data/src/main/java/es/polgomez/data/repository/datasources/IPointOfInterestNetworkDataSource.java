package es.polgomez.data.repository.datasources;

import es.polgomez.data.entities.PointOfInterestDetailEntity;
import es.polgomez.data.entities.PointsOfInterestEntity;
import rx.Observable;

/**
 * Network data source
 */
public interface IPointOfInterestNetworkDataSource {

    // TODO custom exceptions

    Observable<PointsOfInterestEntity> fetchPointsOfInterest() throws Exception;

    Observable<PointOfInterestDetailEntity> fetchPointOfInterestDetail(int id) throws Exception;

}
