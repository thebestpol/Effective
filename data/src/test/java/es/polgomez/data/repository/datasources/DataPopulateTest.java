package es.polgomez.data.repository.datasources;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import es.polgomez.data.entities.PointsOfInterestEntity;
import es.polgomez.data.repository.DataPopulate;
import es.polgomez.data.repository.datasources.database.IPointOfInterestDataBaseSource;

public class DataPopulateTest {

    private DataPopulate dataPopulate;

    @Mock
    private IPointOfInterestDataBaseSource dataBaseSource;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);

        dataPopulate = new DataPopulate(dataBaseSource);
    }

    @Test
    public void testDataPopulateShouldCallMethodWhenValidDataIsPast() {
        PointsOfInterestEntity mockPointsOfInterestEntity = Mockito.mock(PointsOfInterestEntity.class);
        dataPopulate.populatePointsOfInterest(mockPointsOfInterestEntity);

        Mockito.verify(dataBaseSource, Mockito.times(1)).persistPointsOfInterest(mockPointsOfInterestEntity);
    }

    @Test
    public void testDataPopulateShouldNotCallMethodWhenInvalidDataIsPast() {
        PointsOfInterestEntity mockPointsOfInterestEntity = null;
        dataPopulate.populatePointsOfInterest(mockPointsOfInterestEntity);

        Mockito.verify(dataBaseSource, Mockito.times(0)).persistPointsOfInterest(mockPointsOfInterestEntity);
    }
}
