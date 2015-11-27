package es.polgomez.data.repository.datasources.api;

import java.io.IOException;

import es.polgomez.data.repository.datasources.IPointOfInterestNetworkDataSource;
import es.polgomez.data.repository.datasources.api.entities.ApiPointOfInterest;
import es.polgomez.data.repository.datasources.api.entities.ApiPointOfInterestList;

/**
 * Implementation of network data source
 */
public class PointOfInterestNetworkDataSource implements IPointOfInterestNetworkDataSource {

    private PointsOfInterestApiService apiService;

    public PointOfInterestNetworkDataSource(PointsOfInterestApiService apiService) {
        this.apiService = apiService;
    }

    @Override
    public ApiPointOfInterestList fetchPointsOfInterest() throws Exception{
        try {
            ApiPointOfInterestList pointsOfInterest = apiService.getPointsOfInterestList()
                    .execute().body();

            return pointsOfInterest;
        } catch (IOException e) {
            throw new Exception("Network error");
        }
    }

    @Override
    public ApiPointOfInterest fetchPointOfInterestDetail(int id) throws Exception {
        try {
            ApiPointOfInterest pointOfInterest = apiService.getPointOfInterest(id).execute().body();

            return pointOfInterest;
        } catch (IOException e) {
            throw new Exception("Network error");
        }
    }
}
