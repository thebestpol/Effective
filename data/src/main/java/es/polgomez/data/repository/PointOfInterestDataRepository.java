package es.polgomez.data.repository;

import java.util.List;

import javax.inject.Singleton;

import es.polgomez.data.mapper.DataMapper;
import es.polgomez.data.repository.cache.item.ItemCachePolicy;
import es.polgomez.data.repository.cache.list.ListCachePolicy;
import es.polgomez.data.repository.datasources.api.PointOfInterestNetworkDataSource;
import es.polgomez.data.repository.datasources.database.PointOfInterestDataBaseSource;
import es.polgomez.domain.PointOfInterest;
import es.polgomez.domain.PointOfInterestDetail;
import es.polgomez.domain.PointsOfInterest;
import es.polgomez.domain.repository.PointOfInterestRepository;
import rx.Observable;

@Singleton
public class PointOfInterestDataRepository implements PointOfInterestRepository {

    private final PointOfInterestNetworkDataSource networkDataSource;
    private final PointOfInterestDataBaseSource dataBaseSource;

    // TODO keep working in this way, mapper and repository(factory)

    private ItemCachePolicy<PointOfInterestDetail> pointOfInterestDetailCachePolicy =
            new ItemCachePolicy<>();
    private ItemCachePolicy<PointsOfInterest> pointsOfInterestDetailCachePolicy =
            new ItemCachePolicy<>();
    private ItemCachePolicy<PointOfInterest> pointOfInterestCachePolicy = new ItemCachePolicy<>();
    private ListCachePolicy<PointOfInterest> pointsOfInterestListCachePolicy =
            new ListCachePolicy<>(pointOfInterestCachePolicy);

    private DataPopulate dataPopulate;

    private final DataMapper dataMapper;

    public PointOfInterestDataRepository(PointOfInterestNetworkDataSource networkDataSource,
                                         PointOfInterestDataBaseSource dataBaseSource) {
        this.networkDataSource = networkDataSource;
        this.dataBaseSource = dataBaseSource;

        dataPopulate = new DataPopulate(dataBaseSource);
        dataMapper = new DataMapper();
    }

    @Override
    public Observable<List<PointOfInterest>> getPointsOfInterest() {
        PointsOfInterest pointsOfInterest = new PointsOfInterest();
        boolean hasException = false;
        String exceptionMessage = null;
        try {
            pointsOfInterest = dataBaseSource.obtainPointsOfInterest();
            if (!pointsOfInterestDetailCachePolicy.isValid(pointsOfInterest)
                    && !pointsOfInterestListCachePolicy.isValid(pointsOfInterest.getPointsOfInterest())) {
                pointsOfInterest = dataMapper.transform(networkDataSource.fetchPointsOfInterest());
                dataPopulate.populatePointsOfInterest(pointsOfInterest);
            }
        } catch (Exception e) {
            // TODO handle exception
            hasException = true;
            exceptionMessage = e.getMessage();
        }

        final boolean hasError = hasException;
        final String errorMessage = exceptionMessage;
        final PointsOfInterest resultPointsOfInterest = pointsOfInterest;

        return Observable.create(subscriber -> {
            if (hasError) {
                subscriber.onError(new Exception(errorMessage));
            } else {
                subscriber.onNext(resultPointsOfInterest.getPointsOfInterest());
                subscriber.onCompleted();
            }
        });
    }

    @Override
    public Observable<PointOfInterestDetail> getPointsOfInterest(int pointId) {
        return null;
    }

}
