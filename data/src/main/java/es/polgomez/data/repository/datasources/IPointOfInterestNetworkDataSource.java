package es.polgomez.data.repository.datasources;

import es.polgomez.data.repository.datasources.api.entities.ApiPointOfInterest;
import es.polgomez.data.repository.datasources.api.entities.ApiPointOfInterestList;

/**
 * Network data source
 */
public interface IPointOfInterestNetworkDataSource {

    // TODO custom exceptions

    ApiPointOfInterestList fetchPointsOfInterest() throws Exception;

    ApiPointOfInterest fetchPointOfInterestDetail(int id) throws Exception;

}
