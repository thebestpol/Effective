package es.polgomez.domain.executor;

import java.util.concurrent.Executor;

public interface ThreadExecutor extends Executor {

    void execute(Runnable runnable);

}
