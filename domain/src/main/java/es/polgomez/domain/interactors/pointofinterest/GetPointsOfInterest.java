package es.polgomez.domain.interactors.pointofinterest;

import es.polgomez.domain.executor.MainThread;
import es.polgomez.domain.executor.ThreadExecutor;
import es.polgomez.domain.interactors.Interactor;
import es.polgomez.domain.repository.PointOfInterestRepository;
import rx.Observable;

/**
 * Class that represents the usa case to get the list of points of interest
 */
public class GetPointsOfInterest extends Interactor {

    private final PointOfInterestRepository pointOfInterestRepository;

    public GetPointsOfInterest(PointOfInterestRepository pointOfInterestRepository,
                               ThreadExecutor threadExecutor, MainThread mainThread) {
        super(threadExecutor, mainThread);
        this.pointOfInterestRepository = pointOfInterestRepository;
    }

    @Override
    public Observable buildInteractorObservable() {
        return pointOfInterestRepository.getPointsOfInterest();
    }
}
