package es.polgomez.data.repository.datasources.api;

import es.polgomez.data.entities.PointOfInterestDetailEntity;
import es.polgomez.data.entities.PointsOfInterestEntity;
import es.polgomez.data.repository.datasources.IPointOfInterestNetworkDataSource;
import es.polgomez.data.repository.datasources.api.entities.mapper.ApiPointOfInterestDetailMapper;
import es.polgomez.data.repository.datasources.api.entities.mapper.ApiPointsOfInterestMapper;
import es.polgomez.data.repository.datasources.api.service.PointsOfInterestApiService;
import rx.Observable;

/**
 * Implementation of network data source
 */
public class PointOfInterestNetworkDataSource implements IPointOfInterestNetworkDataSource {

    private final PointsOfInterestApiService apiService;

    private final ApiPointsOfInterestMapper apiPointsOfInterestMapper;
    private final ApiPointOfInterestDetailMapper apiPointOfInterestDetailMapper;

    public PointOfInterestNetworkDataSource(PointsOfInterestApiService apiService) {
        this.apiService = apiService;

        this.apiPointsOfInterestMapper = new ApiPointsOfInterestMapper();
        this.apiPointOfInterestDetailMapper = new ApiPointOfInterestDetailMapper();
    }

    @Override
    public Observable<PointsOfInterestEntity> fetchPointsOfInterest() throws Exception {
        return apiService.getApiPointsOfInterestList().map(apiPointOfInterestList ->
            apiPointsOfInterestMapper.dataToModel(apiPointOfInterestList)
        );
    }

    @Override
    public Observable<PointOfInterestDetailEntity> fetchPointOfInterestDetail(int id) throws Exception {
        return apiService.getApiPointOfInterest(id).map(apiPointOfInterest ->
            apiPointOfInterestDetailMapper.dataToModel(apiPointOfInterest)
        );
    }
}
