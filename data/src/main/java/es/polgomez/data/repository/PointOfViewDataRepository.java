package es.polgomez.data.repository;

import java.util.List;

import javax.inject.Singleton;

import es.polgomez.domain.PointOfInterest;
import es.polgomez.domain.repository.PointOfInterestRepository;
import rx.Observable;

@Singleton
public class PointOfViewDataRepository implements PointOfInterestRepository {

    // TODO keep working in this way, mapper and repository(factory)

    @Override
    public Observable<List<PointOfInterest>> getPointOfInterests() {
        return null;
    }

    @Override
    public Observable<PointOfInterest> getPointOfInterest(int pointId) {
        return null;
    }
}
