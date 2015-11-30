package es.polgomez.domain.interactors;

import es.polgomez.domain.executor.MainThread;
import es.polgomez.domain.executor.ThreadExecutor;
import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.schedulers.Schedulers;
import rx.subscriptions.Subscriptions;

public abstract class Interactor {

    private final ThreadExecutor threadExecutor;
    private final MainThread mainThread;

    private Subscription subscription = Subscriptions.empty();

    protected Interactor(ThreadExecutor threadExecutor, MainThread mainThread) {
        this.threadExecutor = threadExecutor;
        this.mainThread = mainThread;
    }

    public void execute(Subscriber interactorSubscriber) {
        subscription = buildInteractorObservable()
            .subscribeOn(Schedulers.from(threadExecutor))
                .observeOn(mainThread.getScheduler())
                .subscribe(interactorSubscriber);
    }

    public abstract Observable buildInteractorObservable();

    public void unsubscribe() {
        if (!subscription.isUnsubscribed()) {
            subscription.unsubscribe();
        }
    }
}
