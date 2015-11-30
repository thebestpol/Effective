package es.polgomez.effective.presentation;

import es.polgomez.domain.executor.MainThread;
import rx.Scheduler;
import rx.android.schedulers.AndroidSchedulers;

public class UiThread implements MainThread {

    @Override
    public Scheduler getScheduler() {
        return AndroidSchedulers.mainThread();
    }
}
