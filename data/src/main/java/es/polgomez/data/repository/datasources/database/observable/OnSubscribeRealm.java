package es.polgomez.data.repository.datasources.database.observable;

import io.realm.Realm;
import io.realm.RealmObject;
import io.realm.exceptions.RealmException;
import rx.Observable;
import rx.Subscriber;
import rx.subscriptions.Subscriptions;

/**
 * Implementing Observable.OnSubscribe for RealmObject subclass that follows Observable contract
 */
public abstract class OnSubscribeRealm<T extends RealmObject> implements Observable.OnSubscribe<T> {

    protected final Realm realm;

    public OnSubscribeRealm(Realm realm) {
        this.realm = realm;
    }

    @Override
    public void call(Subscriber<? super T> subscriber) {
        subscriber.add(Subscriptions.create(() -> {
            try {
                realm.close();
            } catch (RealmException e) {
                subscriber.onError(e);
            }
        }));

        T object;
        realm.beginTransaction();

        try {
            object = get();
        } catch (RuntimeException e) {
            realm.cancelTransaction();
            subscriber.onError(new RealmException("Error during trasnaction.", e));
            return;
        } catch (Error error) {
            realm.cancelTransaction();
            subscriber.onError(error);
            return;
        }

        subscriber.onNext(object);
        subscriber.onCompleted();
    }

    public abstract T get();
}
