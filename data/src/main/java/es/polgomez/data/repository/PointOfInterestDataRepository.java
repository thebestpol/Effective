package es.polgomez.data.repository;

import java.util.List;

import javax.inject.Singleton;

import es.polgomez.data.repository.datasources.api.PointOfInterestNetworkDataSource;
import es.polgomez.data.repository.datasources.database.PointOfInterestDataBaseSource;
import es.polgomez.domain.PointOfInterest;
import es.polgomez.domain.PointOfInterestDetail;
import es.polgomez.domain.repository.PointOfInterestRepository;
import rx.Observable;

@Singleton
public class PointOfInterestDataRepository implements PointOfInterestRepository {

    // TODO keep working in this way, mapper and repository(factory)

    public PointOfInterestDataRepository(PointOfInterestNetworkDataSource networkDataSource,
                                         PointOfInterestDataBaseSource dataBaseSource) {

    }

    @Override
    public Observable<List<PointOfInterest>> getPointOfInterests() {
        return null;
    }

    @Override
    public Observable<PointOfInterestDetail> getPointOfInterest(int pointId) {
        return null;
    }

}
