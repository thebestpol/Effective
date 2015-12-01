package es.polgomez.data.repository.datasources.database.observable;

import io.realm.Realm;
import io.realm.RealmObject;
import rx.Observable;
import rx.functions.Func1;

public class RealmObservable {

    private RealmObservable() {

    }

    public static <T extends RealmObject> Observable<T> object(Realm realm, final Func1<Realm, T> function) {
        return Observable.create(new OnSubscribeRealm<T>(realm) {
            @Override
            public T get() {
                return function.call(realm);
            }
        });
    }

}
