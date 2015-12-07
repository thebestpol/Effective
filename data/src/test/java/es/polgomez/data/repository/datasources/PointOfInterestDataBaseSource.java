package es.polgomez.data.repository.datasources;

import org.junit.Before;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import es.polgomez.data.repository.PointOfInterestDataRepository;
import es.polgomez.data.repository.datasources.api.IPointOfInterestNetworkDataSource;
import es.polgomez.data.repository.datasources.api.PointOfInterestNetworkDataSource;
import es.polgomez.data.repository.datasources.database.IPointOfInterestDataBaseSource;
import es.polgomez.domain.repository.PointOfInterestRepository;
import rx.Observable;

public class PointOfInterestDataBaseSource {

    private PointOfInterestRepository pointOfInterestRepository;

    @Mock
    private IPointOfInterestNetworkDataSource networkDataSource;

    @Mock
    private IPointOfInterestDataBaseSource dataBaseSource;

    @Before
    public void setUp() {

        MockitoAnnotations.initMocks(this);

        Mockito.when(networkDataSource.fetchPointsOfInterest()).thenReturn(Observable.empty());
        Mockito.when(dataBaseSource.obtainPointsOfInterest()).thenReturn(Observable.empty());

        pointOfInterestRepository = new PointOfInterestDataRepository(networkDataSource, dataBaseSource);


        // TODO keep working in this line, test if dataPopulate methos is called one time and others
    }

}
