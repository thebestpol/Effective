package es.polgomez.domain.interactor;

import es.polgomez.domain.executor.MainThread;
import es.polgomez.domain.executor.ThreadExecutor;
import es.polgomez.domain.repository.PointOfInterestRepository;
import rx.Observable;

public class PointOfInterestInteractor extends Interactor{


    private final PointOfInterestRepository pointOfInterestRepository;

    public PointOfInterestInteractor(PointOfInterestRepository pointOfInterestRepository,
                                     ThreadExecutor threadExecutor, MainThread mainThread) {
        super(threadExecutor, mainThread);
        this.pointOfInterestRepository = pointOfInterestRepository;
    }

    @Override
    Observable buildInteractorObservable() {
        return pointOfInterestRepository.getPointOfInterests();
    }
}
