package es.polgomez.data.repository.cache.list;

import java.util.List;

import es.polgomez.data.repository.cache.CachePolicy;

/**
 * An implementation of a simple Cache policy for list collections
 */
public class ListCachePolicy<T> implements CachePolicy<List<T>> {

    private final CachePolicy<T> itemCachePolicy;

    public ListCachePolicy(CachePolicy<T> cachePolicy) {
        itemCachePolicy = cachePolicy;
    }

    @Override
    public boolean isValid(List<T> data) {
        if (data == null || data.isEmpty()) {
            return false;
        }

        for (T item : data) {
            if (!isValidItem(item)) {
                return false;
            }
        }

        return true;
    }

    private boolean isValidItem(T item) {
        return itemCachePolicy.isValid(item);
    }
}
