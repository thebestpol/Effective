package es.polgomez.data.repository.cache.item;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

public class ItemCachePolicyTest {

    private ItemCachePolicy<Object> objectCachePolicy;

    @Before
    public void setUp() {
        objectCachePolicy = new ItemCachePolicy<Object>();
    }

    @Test
    public void testCachePolicyShouldReturnTrueWhenValidObjectIsPast() {
        Assert.assertTrue(objectCachePolicy.isValid(new Object()));
    }

    @Test
    public void testCachePolicyShouldReturnFaleWhenInvalidObjectIsPast() {
        Assert.assertFalse(objectCachePolicy.isValid(null));
    }
}
