package es.polgomez.effective.presentation;

import android.app.Application;

import es.polgomez.data.repository.PointOfInterestDataRepository;
import es.polgomez.data.repository.datasources.api.PointOfInterestNetworkDataSource;
import es.polgomez.data.repository.datasources.api.service.PointsOfInterestApiService;
import es.polgomez.data.repository.datasources.api.service.ServiceFactory;
import es.polgomez.data.repository.datasources.database.PointOfInterestDataBaseSource;
import es.polgomez.domain.executor.MainThread;
import es.polgomez.domain.executor.ThreadExecutor;
import es.polgomez.domain.interactors.pointofinterest.GetPointOfInterestDetail;
import es.polgomez.domain.interactors.pointofinterest.GetPointsOfInterest;
import es.polgomez.domain.repository.PointOfInterestRepository;
import es.polgomez.effective.presentation.navigation.Navigator;

public class EffectiveApplication extends Application {

    // TODO clear this with DI (dagger)
    private PointOfInterestRepository pointOfInterestRepository;
    private ThreadExecutor threadExecutor;
    private MainThread mainThread;

    private GetPointsOfInterest getPointsOfInterest;

    private Navigator navigator;

    private static EffectiveApplication instance;

    public static EffectiveApplication getInstance() {
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        instance = this;

        threadExecutor = new ThreadExecutor();
        mainThread = new UiThread();

        PointsOfInterestApiService apiService = ServiceFactory.createRetrofitService(
                PointsOfInterestApiService.class, PointsOfInterestApiService.API_SERVICE_ENDPOINT);

        // TODO clear context from repository
        pointOfInterestRepository = new PointOfInterestDataRepository(
                new PointOfInterestNetworkDataSource(apiService),
                new PointOfInterestDataBaseSource(this));

        getPointsOfInterest = new GetPointsOfInterest(pointOfInterestRepository,
                threadExecutor, mainThread);

        navigator = new Navigator();
    }

    public PointOfInterestRepository getPointOfInterestRepository() {
        return pointOfInterestRepository;
    }

    public ThreadExecutor getThreadExecutor() {
        return threadExecutor;
    }

    public MainThread getMainThread() {
        return mainThread;
    }

    public GetPointOfInterestDetail getGetPointOfInterestDetail(int pointOfInterestId) {
        return new GetPointOfInterestDetail(pointOfInterestId, pointOfInterestRepository,
                threadExecutor, mainThread);
    }

    public GetPointsOfInterest getGetPointsOfInterest() {
        return getPointsOfInterest;
    }

    public Navigator getNavigator() {
        return navigator;
    }
}
