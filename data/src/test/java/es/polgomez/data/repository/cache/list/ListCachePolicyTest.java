package es.polgomez.data.repository.cache.list;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import es.polgomez.data.repository.cache.item.ItemCachePolicy;

public class ListCachePolicyTest {

    private ListCachePolicy<Object> listCachePolicy;

    @Before
    public void setUp() {
        ItemCachePolicy<Object> itemCachePolicy = new ItemCachePolicy<Object>();
        listCachePolicy = new ListCachePolicy<Object>(itemCachePolicy);
    }

    @Test
    public void testListCachePolicyShouldReturnFalseWhenIsPastNull() {
        boolean isValid = listCachePolicy.isValid(null);

        Assert.assertFalse(isValid);
    }

    @Test
    public void testListCachePolicyShouldReturnTrueWhenIsPastEmptyList() {
        boolean isValid = listCachePolicy.isValid(new ArrayList<>());

        Assert.assertTrue(isValid);
    }

    @Test
    public void testListCachePolicyShouldReturnFalseWhenIsPastListWithInvalidItem() {
        ArrayList<Object> list = new ArrayList<>();
        list.add(null);

        boolean isValid = listCachePolicy.isValid(list);

        Assert.assertFalse(isValid);
    }

    @Test
    public void testListCachePolicyShouldReturnTrueWhenIsPastListWithValidItem() {
        ArrayList<Object> list = new ArrayList<>();
        list.add(new Object());

        boolean isValid = listCachePolicy.isValid(list);

        Assert.assertTrue(isValid);
    }
}
