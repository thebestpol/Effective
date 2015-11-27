package es.polgomez.data.repository.cache;

/**
 * Cache policy
 */
public interface CachePolicy<T> {

    boolean isValid(T data);
}
