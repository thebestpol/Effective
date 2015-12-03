package es.polgomez.domain.interactors.poinofinterest;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import es.polgomez.domain.PointsOfInterest;
import es.polgomez.domain.executor.MainThread;
import es.polgomez.domain.executor.ThreadExecutor;
import es.polgomez.domain.interactors.pointofinterest.GetPointsOfInterest;
import es.polgomez.domain.repository.PointOfInterestRepository;
import rx.Observable;
import rx.observers.TestSubscriber;

public class GetPointsOfInterestTest {

    @Mock
    PointOfInterestRepository pointOfInterestRepository;
    @Mock
    ThreadExecutor threadExecutor;
    @Mock
    MainThread mainThread;

    private GetPointsOfInterest getPointsOfInterest;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);

        Mockito.when(pointOfInterestRepository.getPointsOfInterest())
                .thenReturn(Observable.just(Mockito.mock(PointsOfInterest.class)));

        getPointsOfInterest = new GetPointsOfInterest(pointOfInterestRepository, threadExecutor,
                mainThread);
    }

    @Test
    public void testGetPointsOfInterestRequestExecution() {
        TestSubscriber<PointsOfInterest> testSubscriber = TestSubscriber.create();
        getPointsOfInterest.execute(testSubscriber);

        // Test if the method is called one time
        Mockito.verify(pointOfInterestRepository, Mockito.times(1)).getPointsOfInterest();
    }
}
