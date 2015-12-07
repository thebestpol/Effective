package es.polgomez.data.repository;

import es.polgomez.data.mapper.DataMapper;
import es.polgomez.data.repository.datasources.api.IPointOfInterestNetworkDataSource;
import es.polgomez.data.repository.datasources.api.PointOfInterestNetworkDataSource;
import es.polgomez.data.repository.datasources.database.IPointOfInterestDataBaseSource;
import es.polgomez.data.repository.datasources.database.PointOfInterestDataBaseSource;
import es.polgomez.domain.PointOfInterestDetail;
import es.polgomez.domain.PointsOfInterest;
import es.polgomez.domain.repository.PointOfInterestRepository;
import rx.Observable;

public class PointOfInterestDataRepository implements PointOfInterestRepository {

    private final PointOfInterestNetworkDataSource networkDataSource;
    private final PointOfInterestDataBaseSource dataBaseSource;
    private final DataMapper dataMapper;

    private DataPopulate dataPopulate;

    public PointOfInterestDataRepository(IPointOfInterestNetworkDataSource networkDataSource,
            IPointOfInterestDataBaseSource dataBaseSource) {
        this.networkDataSource = (PointOfInterestNetworkDataSource) networkDataSource;
        this.dataBaseSource = (PointOfInterestDataBaseSource) dataBaseSource;

        dataPopulate = new DataPopulate(dataBaseSource);
        dataMapper = new DataMapper();
    }

    @Override
    public Observable<PointsOfInterest> getPointsOfInterest() {
        return Observable.concat(
                dataBaseSource.obtainPointsOfInterest(),
                networkDataSource.fetchPointsOfInterest().doOnNext(dataPopulate::populatePointsOfInterest)
        ).map(dataMapper::transformPointsOfInterest)
                .first(pointsOfInterest -> pointsOfInterest != null);
    }

    @Override
    public Observable<PointOfInterestDetail> getPointsOfInterest(int pointId) {
        return Observable.concat(
                dataBaseSource.obtainPointOfInterest(pointId),
                networkDataSource.fetchPointOfInterestDetail(pointId).doOnNext(dataPopulate::populatePointOfInterestDetail)
        ).map(dataMapper::transformPointOfInterestDetail)
                .first(pointOfInterestDetail -> pointOfInterestDetail != null);
    }

}
