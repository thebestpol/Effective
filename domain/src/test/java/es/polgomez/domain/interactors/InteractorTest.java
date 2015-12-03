package es.polgomez.domain.interactors;


import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import es.polgomez.domain.executor.MainThread;
import es.polgomez.domain.executor.ThreadExecutor;
import rx.Observable;
import rx.Observer;
import rx.Subscriber;
import rx.observers.TestObserver;
import rx.observers.TestSubscriber;
import rx.schedulers.Schedulers;
import rx.schedulers.TestScheduler;

import static org.hamcrest.MatcherAssert.assertThat;

public class InteractorTest {

    private Interactor interactor;

    @Mock
    private ThreadExecutor threadExecutor;
    @Mock
    private MainThread mainThread;

    // method names with should

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);

        Mockito.when(mainThread.getScheduler()).thenReturn(new TestScheduler());

        interactor = new Interactor(threadExecutor, mainThread) {
            @Override
            public Observable buildInteractorObservable() {
                return Observable.from(Arrays.asList(1, 2, 3));
            }

            @Override
            public void execute(Subscriber interactorSubscriber) {
                // TODO check why must do this? With super doesn't work
                buildInteractorObservable().subscribe(interactorSubscriber);
            }
        };
    }

    @Test
    public void testInteractorShouldUnsubscribeSubscriber() {
        TestSubscriber<Object> testSubscriber = TestSubscriber.create();
        interactor.execute(testSubscriber);
        interactor.unsubscribe();

        Assert.assertTrue(testSubscriber.isUnsubscribed());
        testSubscriber.assertNoErrors();
        testSubscriber.assertCompleted();
    }

    @Test
    public void testInteractorShouldSubscribeCorrectly() {
        TestSubscriber<Integer> testSubscriber = TestSubscriber.create();
        interactor.execute(testSubscriber);

        testSubscriber.assertValueCount(3);
        testSubscriber.assertReceivedOnNext(Arrays.asList(1, 2, 3));
        testSubscriber.assertNoErrors();
        testSubscriber.assertCompleted();
    }

    @Test
    public void testInteractor() {
        TestSubscriber<Integer> testSubscriber = TestSubscriber.create();
    }
}
