package es.polgomez.data.repository.datasources.api;

import es.polgomez.data.entities.PointOfInterestDetailEntity;
import es.polgomez.data.entities.PointsOfInterestEntity;
import rx.Observable;

/**
 * Network data source
 */
public interface IPointOfInterestNetworkDataSource {

    Observable<PointsOfInterestEntity> fetchPointsOfInterest();

    Observable<PointOfInterestDetailEntity> fetchPointOfInterestDetail(int id);

}
