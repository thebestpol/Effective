package es.polgomez.data.mapper;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import es.polgomez.data.entities.PointOfInterestEntity;
import es.polgomez.data.entities.PointsOfInterestEntity;
import es.polgomez.domain.PointOfInterest;
import es.polgomez.domain.PointsOfInterest;

public class DataMapperTest {

    private static final String FAKE_ID = "1";
    private static final String FAKE_TITLE = "Title";

    public static final int MOCK_LIST_SIZE = 4;

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

    @Test
    public void testTransformPointsOfInterestWithMocksShouldWorkCorrectly() {
        PointsOfInterestEntity pointsOfInterestEntity = new PointsOfInterestEntity();
        pointsOfInterestEntity.setPointsOfInterest(createPointsOfInestMock());

        PointsOfInterest pointsOfInterest = dataMapper.transformPointsOfInterest(pointsOfInterestEntity);

        Assert.assertNotNull(pointsOfInterest);
        Assert.assertEquals(MOCK_LIST_SIZE, pointsOfInterest.getPointsOfInterest().size());
        Assert.assertTrue(pointsOfInterest.getPointsOfInterest().get(0) instanceof PointOfInterest);
        Assert.assertTrue(pointsOfInterest.getPointsOfInterest().get(1) instanceof PointOfInterest);
        Assert.assertTrue(pointsOfInterest.getPointsOfInterest().get(3) instanceof PointOfInterest);
        Assert.assertTrue(pointsOfInterest.getPointsOfInterest().get(3) instanceof PointOfInterest);
    }

    private List<PointOfInterestEntity> createPointsOfInestMock() {
        PointOfInterestEntity mockPointOfInterest = Mockito.mock(PointOfInterestEntity.class);
        PointOfInterestEntity mock1PointOfInterest = Mockito.mock(PointOfInterestEntity.class);
        PointOfInterestEntity mock2PointOfInterest = Mockito.mock(PointOfInterestEntity.class);
        PointOfInterestEntity mock3PointOfInterest = Mockito.mock(PointOfInterestEntity.class);
        List<PointOfInterestEntity> mockList = new ArrayList<>();
        mockList.add(mockPointOfInterest);
        mockList.add(mock1PointOfInterest);
        mockList.add(mock2PointOfInterest);
        mockList.add(mock3PointOfInterest);

        return mockList;
    }

    @Test
    public void testTransformPointsOfInterestShouldTransformPointOfInterestEntity() {
        PointOfInterestEntity fakePointOfInterestEntity = new PointOfInterestEntity();
        fakePointOfInterestEntity.setId(FAKE_ID);
        fakePointOfInterestEntity.setTitle(FAKE_TITLE);
        List<PointOfInterestEntity> pointOfInterestEntityList = new ArrayList<>();
        pointOfInterestEntityList.add(fakePointOfInterestEntity);

        PointsOfInterestEntity pointsOfInterestEntity = new PointsOfInterestEntity();
        pointsOfInterestEntity.setPointsOfInterest(pointOfInterestEntityList);

        PointsOfInterest pointsOfInterest = dataMapper.transformPointsOfInterest(pointsOfInterestEntity);

        Assert.assertNotNull(pointsOfInterest);
        PointOfInterest pointOfInterest = pointsOfInterest.getPointsOfInterest().get(0);
        Assert.assertNotNull(pointOfInterest);
        Assert.assertEquals(FAKE_ID, Integer.toString(pointOfInterest.getId()));
        Assert.assertEquals(FAKE_TITLE, pointOfInterest.getTitle());
    }

}
