package designs.lrucache.v2;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class CacheElement<K, V> {
    K key;
    V value;
}
