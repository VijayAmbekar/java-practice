package designs.lrucache;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class TestClient {

    // HashMap - Integer, String
    // few entries - 1, "Vijay" 2,"Kapil", 3,"Ramesh"
    // sort by values

    public static void main(String[] args) {
        HashMap<Integer, String> namesMap = new HashMap<>();
        namesMap.put(1, "Vijay");
        namesMap.put(2, "Kapil");
        namesMap.put(3, "Ramesh");
        namesMap.put(4, "Swati");

        System.out.println("Sorting of names:");
        sortMap(namesMap);

        //LRUCache
//        CustomLRUCache cache = new CustomLRUCache();
//        cache.put("Vijay");
//        cache.put("Akash");
//        cache.put("Rajesh");
//        cache.put("Vishal");
//        cache.put("Varun");
//
//        cache.printEntries();
//
//        cache.put("Kapil");
//
//        cache.printEntries();

    }

    public static void sortMap(HashMap<Integer,String> map) {
        Collection<String> valueCollection = map.values();

        List<String> names = valueCollection.stream().sorted().collect(Collectors.toList());

        names.forEach(System.out::println);

//        HashMap<Integer,String> mapoutput = map.entrySet().stream()
//                .sorted((o1, o2) ->  o1.getValue().compareTo(o2.getValue()))
//                .collect(Collectors.toMap(o -> o.getKey(), o -> o.));
//
//
//        mapoutput.entrySet().forEach(e -> System.out.println(e.getKey() + ": " + e.getValue()));
    }
}
