package designs.lrucache;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CustomLRUCache {

    List<CacheEntry> cacheEntries = new ArrayList<>();

    Map<Object, Date> cacheMap = new HashMap<>();
    Integer cacheSize = 5;

    public CacheEntry put(Object object) {
        CacheEntry cacheEntry;
        // check cache if exist

        // if cache is full then evice based on oldest entry
        if (cacheEntries != null && cacheEntries.size() == cacheSize) {
            // evict oldest one
            CacheEntry old = cacheEntries.stream().sorted().findFirst().get();
            cacheEntries.remove(old);
        }

        if(cacheEntries.contains(object))
        {
            // update timestamp to now
            cacheEntry = cacheEntries.get(cacheEntries.indexOf(object));
            cacheEntry.setDate(new Date());
        } else {
             cacheEntry = new CacheEntry(object, new Date());
            cacheEntries.add(cacheEntry);
        }

        return cacheEntry;
    }

    public Object putObj(Object object) {
        // if cache is full then evice based on oldest entry
        if (cacheMap != null && cacheMap.size() == cacheSize) {
            // evict oldest one
            Object old = cacheMap.entrySet()
                    .stream()
                    .sorted((e1, e2) -> e1.getValue().compareTo(e2.getValue()))
                            .map(e -> e.getKey())
                                    .findFirst().get();
            cacheMap.remove(old);
        }

        cacheMap.put(object, new Date());

        return object;
    }

    public void printEntries() {
        cacheEntries.forEach(e -> System.out.println(e.object + ": " + e.getDate().toString()));

//        cacheMap.forEach(e -> System.out.println(e + ": " + e.getDate().toString()));
    }
}
