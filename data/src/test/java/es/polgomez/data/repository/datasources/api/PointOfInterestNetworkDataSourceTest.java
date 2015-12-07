package es.polgomez.data.repository.datasources.api;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import es.polgomez.data.entities.PointOfInterestDetailEntity;
import es.polgomez.data.entities.PointOfInterestEntity;
import es.polgomez.data.entities.PointsOfInterestEntity;
import es.polgomez.data.repository.datasources.api.entities.ApiPointOfInterest;
import es.polgomez.data.repository.datasources.api.entities.ApiPointOfInterestList;
import es.polgomez.data.repository.datasources.api.entities.ApiPointOfInterestListItem;
import es.polgomez.data.repository.datasources.api.service.PointsOfInterestApiService;
import rx.Observable;
import rx.observers.TestSubscriber;

public class PointOfInterestNetworkDataSourceTest {

    private static final String FAKE_ID_STRING = "4";

    private static final String FAKE_TITLE = "title";

    private static final String FAKE_GEOCORD = "geocord";

    @Mock
    private PointsOfInterestApiService mockApiService;

    private PointOfInterestNetworkDataSource networkDataSource;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);

        ApiPointOfInterestListItem fakeItem = new ApiPointOfInterestListItem();
        fakeItem.setId(FAKE_ID_STRING);
        fakeItem.setTitle(FAKE_TITLE);
        fakeItem.setGeocoordinates(FAKE_GEOCORD);

        List<ApiPointOfInterestListItem> fakeItemList = new ArrayList<>();
        fakeItemList.add(fakeItem);

        ApiPointOfInterestList fakeApiPointOfInterestList = new ApiPointOfInterestList();
        fakeApiPointOfInterestList.setList(fakeItemList);

        Mockito.when(mockApiService.getApiPointsOfInterestList()).thenReturn(
                Observable.just(fakeApiPointOfInterestList));

        ApiPointOfInterest fakeApiPointOfInterest = new ApiPointOfInterest();
        fakeApiPointOfInterest.setId(FAKE_ID_STRING);
        fakeApiPointOfInterest.setTitle(FAKE_TITLE);

        Mockito.when(mockApiService.getApiPointOfInterest(Mockito.anyInt())).thenReturn(
                Observable.just(fakeApiPointOfInterest));

        networkDataSource = new PointOfInterestNetworkDataSource(mockApiService);
    }

    @Test
    public void testFetchPointsOfInterestShouldReturnStreamCorrectly() {
        TestSubscriber<PointsOfInterestEntity> testSubscriber = TestSubscriber.create();

        networkDataSource.fetchPointsOfInterest().subscribe(testSubscriber);

        testSubscriber.assertNoErrors();
        testSubscriber.assertCompleted();
        testSubscriber.assertValueCount(1);
    }

    @Test
    public void testFetchPointsOfInterestShouldReturnStreamOfPointsOfInterestEntity() {
        TestSubscriber<PointsOfInterestEntity> testSubscriber = TestSubscriber.create();

        networkDataSource.fetchPointsOfInterest().subscribe(testSubscriber);

        testSubscriber.assertNoErrors();
        Assert.assertTrue(testSubscriber.getOnNextEvents().get(0) instanceof PointsOfInterestEntity);
    }

    @Test
    public void testFetchPointsOfInterestShouldReturnStreamWithCorrectPointsOfInterestEntity() {
        TestSubscriber<PointsOfInterestEntity> testSubscriber = TestSubscriber.create();

        networkDataSource.fetchPointsOfInterest().subscribe(testSubscriber);

        testSubscriber.assertNoErrors();

        List<PointsOfInterestEntity> entities = testSubscriber.getOnNextEvents();
        Assert.assertNotNull(entities);
        Assert.assertFalse(entities.isEmpty());

        PointsOfInterestEntity pointsOfInterest = entities.get(0);
        Assert.assertNotNull(pointsOfInterest);
        Assert.assertFalse(pointsOfInterest.getPointsOfInterest().isEmpty());

        PointOfInterestEntity pointOfInterest = pointsOfInterest.getPointsOfInterest().get(0);
        Assert.assertNotNull(pointOfInterest);
        Assert.assertEquals(FAKE_ID_STRING, pointOfInterest.getId());
        Assert.assertEquals(FAKE_TITLE, pointOfInterest.getTitle());
    }

    @Test
    public void testFetchPointOfInterestDetailShouldReturnStreamCorrectly() {
        TestSubscriber<PointOfInterestDetailEntity> testSubscriber = TestSubscriber.create();

        networkDataSource.fetchPointOfInterestDetail(0).subscribe(testSubscriber);

        testSubscriber.assertNoErrors();
        testSubscriber.assertCompleted();
        testSubscriber.assertValueCount(1);
    }

    @Test
    public void testFetchPointOfInterestDetailShouldReturnStreamOfPointOfInterestDetailEntity() {
        TestSubscriber<PointOfInterestDetailEntity> testSubscriber = TestSubscriber.create();

        networkDataSource.fetchPointOfInterestDetail(0).subscribe(testSubscriber);

        testSubscriber.assertNoErrors();
        Assert.assertTrue(testSubscriber.getOnNextEvents().get(0) instanceof PointOfInterestDetailEntity);
    }

    @Test
    public void testFetchPointOfInterestDetailShouldReturnStreamWithCorrectPointOfInterestDetailEntity() {
        TestSubscriber<PointOfInterestDetailEntity> testSubscriber = TestSubscriber.create();

        networkDataSource.fetchPointOfInterestDetail(0).subscribe(testSubscriber);

        testSubscriber.assertNoErrors();
        List<PointOfInterestDetailEntity> entities = testSubscriber.getOnNextEvents();
        Assert.assertNotNull(entities);
        Assert.assertFalse(entities.isEmpty());

        PointOfInterestDetailEntity pointsOfInterestDetail = entities.get(0);
        Assert.assertNotNull(pointsOfInterestDetail);
        Assert.assertEquals(FAKE_ID_STRING, pointsOfInterestDetail.getId());
        Assert.assertEquals(FAKE_TITLE, pointsOfInterestDetail.getTitle());
    }
}
