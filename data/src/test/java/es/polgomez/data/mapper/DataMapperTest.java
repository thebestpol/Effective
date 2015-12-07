package es.polgomez.data.mapper;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import es.polgomez.data.entities.PointsOfInterestEntity;
import es.polgomez.domain.PointsOfInterest;

public class DataMapperTest {

    private DataMapper dataMapper;

    @Before
    public void setUp() {
        dataMapper = new DataMapper();
    }

    @Test
    public void testTransformPointsOfInterestWithNullObjectShouldNotCrash() {
        PointsOfInterest pointsOfInterest = dataMapper.transformPointsOfInterest(null);

        Assert.assertNull(pointsOfInterest);
    }

    @Test
    public void testTransformPointsInterestWithEmptyListValueShouldNotCrashAndReturnEmpty() {
        PointsOfInterestEntity pointsOfInterestEntity = new PointsOfInterestEntity();
        pointsOfInterestEntity.setPointsOfInterest(new ArrayList<>());

        PointsOfInterest pointsOfInterest = dataMapper.transformPointsOfInterest(pointsOfInterestEntity);

        Assert.assertNotNull(pointsOfInterest);
        Assert.assertNotNull(pointsOfInterest.getPointsOfInterest());
        Assert.assertTrue(pointsOfInterest.getPointsOfInterest().isEmpty());
    }

    @Test
    public void testTransformPointsInterestWithNullListValueShouldNotCrash() {
        PointsOfInterestEntity pointsOfInterestEntity = new PointsOfInterestEntity();
        pointsOfInterestEntity.setPointsOfInterest(null);

        PointsOfInterest pointsOfInterest = dataMapper.transformPointsOfInterest(pointsOfInterestEntity);

        Assert.assertNotNull(pointsOfInterest);
        Assert.assertNull(pointsOfInterest.getPointsOfInterest());
    }

            //transformPointsOfInterest
}
