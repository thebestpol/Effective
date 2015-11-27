package es.polgomez.data.repository.cache.item;

import es.polgomez.data.repository.cache.CachePolicy;

/**
 * An implementation of a cache policy for an item
 */
public class ItemCachePolicy<T> implements CachePolicy<T> {

    @Override
    public boolean isValid(T data) {
        return data != null;
    }
}
