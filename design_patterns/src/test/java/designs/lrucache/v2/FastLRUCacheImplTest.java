package designs.lrucache.v2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FastLRUCacheImplTest {

    FastLRUCacheImpl fastLRUCache;
    public void setup() {
        fastLRUCache = new FastLRUCacheImpl<>();
    }

    @Test
    public void testLRUCache() {
        fastLRUCache.set(1, "Vijay");
        fastLRUCache.set(2, "Kapil");
        fastLRUCache.set(3, "Ashish");
        fastLRUCache.set(4, "Nathan");

        assertEquals(4, fastLRUCache.size());
        fastLRUCache.set(5, "Tanvir");

        assertEquals(4, fastLRUCache.size());
        assertEquals("Kapil",fastLRUCache.get(2));
        assertEquals("Ashish",fastLRUCache.get(3));
        assertEquals("Nathan",fastLRUCache.get(4));
        assertEquals("Tanvir",fastLRUCache.get(5));
    }
}