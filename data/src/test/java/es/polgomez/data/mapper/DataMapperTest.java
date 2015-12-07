package es.polgomez.data.mapper;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import es.polgomez.domain.PointsOfInterest;

public class DataMapperTest {

    private DataMapper dataMapper;

    @Before
    public void setUp() {
        dataMapper = new DataMapper();
    }

    @Test
    public void testTransformPointsOfInterestWithNullShouldNotCrash() {
        PointsOfInterest pointsOfInterest = dataMapper.transformPointsOfInterest(null);

        Assert.assertNull(pointsOfInterest);
    }

            //transformPointsOfInterest
}
