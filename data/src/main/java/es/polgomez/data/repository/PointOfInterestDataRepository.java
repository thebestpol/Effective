package es.polgomez.data.repository;

import es.polgomez.data.mapper.DataMapper;
import es.polgomez.data.repository.datasources.api.PointOfInterestNetworkDataSource;
import es.polgomez.data.repository.datasources.database.PointOfInterestDataBaseSource;
import es.polgomez.data.repository.datasources.exceptions.InvalidCacheException;
import es.polgomez.domain.PointOfInterestDetail;
import es.polgomez.domain.PointsOfInterest;
import es.polgomez.domain.repository.PointOfInterestRepository;
import rx.Observable;

public class PointOfInterestDataRepository implements PointOfInterestRepository {

    private final PointOfInterestNetworkDataSource networkDataSource;
    private final PointOfInterestDataBaseSource dataBaseSource;
    private final DataMapper dataMapper;

    private DataPopulate dataPopulate;

    public PointOfInterestDataRepository(PointOfInterestNetworkDataSource networkDataSource,
                                         PointOfInterestDataBaseSource dataBaseSource) {
        this.networkDataSource = networkDataSource;
        this.dataBaseSource = dataBaseSource;

        dataPopulate = new DataPopulate(dataBaseSource);
        dataMapper = new DataMapper();
    }

    @Override
    public Observable<PointsOfInterest> getPointsOfInterest() {
        return null;
    }

    @Override
    public Observable<PointOfInterestDetail> getPointsOfInterest(int pointId) {
        return null;
    }

}
