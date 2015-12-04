package es.polgomez.domain.interactors;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import es.polgomez.domain.executor.MainThread;
import es.polgomez.domain.executor.ThreadExecutor;
import rx.Observable;
import rx.observers.TestSubscriber;

public class InteractorTest {

    private static final String TAG = "InteractorTest";

    private Interactor interactor;

    @Mock
    private ThreadExecutor threadExecutor;
    @Mock
    private MainThread mainThread;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);

        interactor = new Interactor(threadExecutor, mainThread) {
            @Override
            public Observable buildInteractorObservable() {
                return Observable.empty();
            }
        };
    }

    @Test
    public void testInteractorShouldUnsubscribeCorrectly() {
        TestSubscriber<Object> testSubscriber = TestSubscriber.create();
        interactor.execute(testSubscriber);
        interactor.unsubscribe();

        Assert.assertTrue(testSubscriber.isUnsubscribed());
    }
}
