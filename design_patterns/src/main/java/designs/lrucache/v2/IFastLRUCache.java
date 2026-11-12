package designs.lrucache.v2;

import java.util.Optional;

public interface IFastLRUCache<K, V> {
    boolean set(K key, V value);
    Optional<V> get(K key);
    int size();
    boolean isEmpty();
    void clear();
}
