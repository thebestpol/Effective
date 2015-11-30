package es.polgomez.data.repository;

import javax.inject.Singleton;

import es.polgomez.data.mapper.DataMapper;
import es.polgomez.data.repository.datasources.api.PointOfInterestNetworkDataSource;
import es.polgomez.data.repository.datasources.database.PointOfInterestDataBaseSource;
import es.polgomez.domain.PointOfInterestDetail;
import es.polgomez.domain.PointsOfInterest;
import es.polgomez.domain.repository.PointOfInterestRepository;
import rx.Observable;

@Singleton
public class PointOfInterestDataRepository implements PointOfInterestRepository {

    private final PointOfInterestNetworkDataSource networkDataSource;
    private final PointOfInterestDataBaseSource dataBaseSource;
    private final DataMapper dataMapper;

    // TODO keep working in this way, mapper and repository(factory)

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
        PointsOfInterest pointsOfInterest = new PointsOfInterest();
        try {
            // TODO this sould return and observable??
            pointsOfInterest = dataBaseSource.obtainPointsOfInterest();
        } catch (Exception e) {
            try {
                return networkDataSource.fetchPointsOfInterest()
                        .map(dataMapper::transformPointsOfInterest)
                        .doOnNext(dataPopulate::populatePointsOfInterest);
            } catch (Exception exception) {
                // TODO handle exception
            }
        }

        return Observable.just(pointsOfInterest);
    }

    @Override
    public Observable<PointOfInterestDetail> getPointsOfInterest(int pointId) {
        return null;
    }

}
