package es.polgomez.domain.executor;

import rx.Scheduler;

public interface MainThread {

    Scheduler getScheduler();
}
