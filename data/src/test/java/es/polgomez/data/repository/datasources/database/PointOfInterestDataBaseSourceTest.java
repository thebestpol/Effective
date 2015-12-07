package es.polgomez.data.repository.datasources.database;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import android.content.Context;

public class PointOfInterestDataBaseSourceTest {

    private PointOfInterestDataBaseSource dataBaseSource;

    @Before
    public void setUp() {
        Context context = Mockito.mock(Context.class);
        dataBaseSource = new PointOfInterestDataBaseSource(context);
    }

    @Test
    public void testPersistPointsOfInterestWithNullValueShouldNotCrash() {
        dataBaseSource.persistPointsOfInterest(null);

        Assert.assertTrue(true);
    }

    @Test
    public void testPersistPointOfInterestWithNullValueShouldNotCrash() {
        dataBaseSource.persisPointOfInterest(null);

        Assert.assertTrue(true);
    }

    @Test
    public void testDeletePointOfInterestWithNullValueShouldNotCrash() {
        dataBaseSource.deletePointOfInterest(null);

        Assert.assertTrue(true);
    }
}