package es.polgomez.domain.interactors.executor;

import org.junit.Before;
import org.junit.Test;
import org.mockito.MockitoAnnotations;

import es.polgomez.domain.executor.ThreadExecutor;

public class ThreadExecutorTest {

    private ThreadExecutor threadExecutor = new ThreadExecutor();

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testWithNullRunnableExecutorShouldThrowException() {
        threadExecutor.execute(null);
    }
}
