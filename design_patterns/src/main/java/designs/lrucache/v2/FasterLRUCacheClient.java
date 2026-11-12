package designs.lrucache.v2;

public class FasterLRUCacheClient {

    public static void main(String[] args) {
        IFastLRUCache fastLRUCache = new FastLRUCacheImpl<Integer, String>();
        fastLRUCache.set(1, "Vijay");
        fastLRUCache.set(2, "Kapil");
        fastLRUCache.set(3, "Ashish");
        fastLRUCache.set(4, "Nathan");

        System.out.println("Cache entries ==================== " +  fastLRUCache.size());
        System.out.println("Entry exist fr VIjay: " + fastLRUCache.get(1));
        fastLRUCache.set(5, "Tanvir");

        System.out.println("Cache entries ==================== " +  fastLRUCache.size());
        System.out.println("Entry empty fr VIjay: " + fastLRUCache.get(1).isEmpty());
        System.out.println("Entry empty fr Kapil: " + fastLRUCache.get(2).isEmpty());



//        FasterLRUCache fasterLRUCache = new FasterLRUCache();
//        fasterLRUCache.put("Varun");
//        fasterLRUCache.put("Kapil");
//        fasterLRUCache.put("Neha");
//        fasterLRUCache.put("Sanjeev");
//        fasterLRUCache.put("Aman");
//
//        System.out.println("Cache entries ==================== \n");
//        fasterLRUCache.showEntries();
//
//        fasterLRUCache.put("Rihan");
//        System.out.println("Cache entries after adding 1 more ==================== \n");
//        fasterLRUCache.showEntries();
    }
}
