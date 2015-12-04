package es.polgomez.domain.interactors.poinofinterest;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import es.polgomez.domain.PointOfInterestDetail;
import es.polgomez.domain.PointsOfInterest;
import es.polgomez.domain.executor.MainThread;
import es.polgomez.domain.executor.ThreadExecutor;
import es.polgomez.domain.interactors.pointofinterest.GetPointOfInterestDetail;
import es.polgomez.domain.interactors.pointofinterest.GetPointsOfInterest;
import es.polgomez.domain.repository.PointOfInterestRepository;
import rx.Observable;
import rx.observers.TestSubscriber;

public class GetPointOfInterestDetailTest {

    private static final int FAKE_POI_ID = 4;

    @Mock
    PointOfInterestRepository pointOfInterestRepository;
    @Mock
    ThreadExecutor threadExecutor;

    @Mock
    MainThread mainThread;

    private GetPointOfInterestDetail getPointsOfInterestDetail;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);

        Mockito.when(pointOfInterestRepository.getPointsOfInterest(FAKE_POI_ID))
                .thenReturn(Observable.just(Mockito.mock(PointOfInterestDetail.class)));

        getPointsOfInterestDetail = new GetPointOfInterestDetail(FAKE_POI_ID, pointOfInterestRepository,
                threadExecutor, mainThread);
    }

    @Test
    public void testGetPointsOfInterestRequestExecution() {
        TestSubscriber<PointsOfInterest> testSubscriber = TestSubscriber.create();
        getPointsOfInterestDetail.execute(testSubscriber);

        // Test if the method is called one time
        Mockito.verify(pointOfInterestRepository, Mockito.times(1)).getPointsOfInterest(FAKE_POI_ID);
    }
}
