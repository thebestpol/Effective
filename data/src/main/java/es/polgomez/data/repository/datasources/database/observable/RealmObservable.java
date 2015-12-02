package es.polgomez.data.repository.datasources.database.observable;

import android.content.Context;

import io.realm.Realm;
import io.realm.RealmObject;
import rx.Observable;
import rx.functions.Func1;

public class RealmObservable {

    private RealmObservable() {

    }
    // TODO context??
    public static <T extends RealmObject> Observable<T> object(Context context, final Func1<Realm, T> function) {
        return Observable.create(new OnSubscribeRealm<T>(context) {
            @Override
            public T get(Realm realm) {
                return function.call(realm);
            }
        });
    }

}
