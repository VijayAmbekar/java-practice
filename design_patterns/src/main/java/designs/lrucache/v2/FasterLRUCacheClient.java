package designs.lrucache.v2;

public class FasterLRUCacheClient {

    public static void main(String[] args) {
        FasterLRUCache fasterLRUCache = new FasterLRUCache();
        fasterLRUCache.put("Varun");
        fasterLRUCache.put("Kapil");
        fasterLRUCache.put("Neha");
        fasterLRUCache.put("Sanjeev");
        fasterLRUCache.put("Aman");

        System.out.println("Cache entries ==================== \n");
        fasterLRUCache.showEntries();

        fasterLRUCache.put("Rihan");
        System.out.println("Cache entries after adding 1 more ==================== \n");
        fasterLRUCache.showEntries();
    }
}
