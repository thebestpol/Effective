package es.polgomez.domain.interactors.pointofinterest;

import es.polgomez.domain.executor.MainThread;
import es.polgomez.domain.executor.ThreadExecutor;
import es.polgomez.domain.interactors.Interactor;
import es.polgomez.domain.repository.PointOfInterestRepository;
import rx.Observable;

/**
 * Class that represents the use case of get the detail of a point of interest
 */
public class GetPointOfInterestDetail extends Interactor {

    private final int pointOfInterestId;
    private final PointOfInterestRepository pointOfInterestRepository;

    protected GetPointOfInterestDetail(int pointOfInterestId,
                                       PointOfInterestRepository pointOfInterestRepository,
                                       ThreadExecutor threadExecutor, MainThread mainThread) {
        super(threadExecutor, mainThread);
        this.pointOfInterestId = pointOfInterestId;
        this.pointOfInterestRepository = pointOfInterestRepository;
    }

    @Override
    public Observable buildInteractorObservable() {
        return pointOfInterestRepository.getPointsOfInterest(pointOfInterestId);
    }
}
