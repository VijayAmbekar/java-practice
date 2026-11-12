package designs.lrucache.v2;

import java.util.*;

public class FastLRUCacheImpl<K, V> implements IFastLRUCache<K, V> {

    //Cache limiting via doubly LinkedList
    //Fast retrieval via HashMap
    // Store data as Wrapped Object - CacheELement
    private static final int CACHE_SIZE = 4;
    private Map<K, Node<CacheElement<K, V>>> cacheMap;
    private Node<CacheElement<K, V>> head, tail;

    private static class Node<E> {
        E item;
        FastLRUCacheImpl.Node<E> prev;
        FastLRUCacheImpl.Node<E> next;

        public Node(E item) {
            this.item = item;
        }
    }

    public FastLRUCacheImpl() {
        cacheMap = new HashMap<>();
        head = null;
        tail = null;
    }

    private void remove(Node node) {
        var prev = node.prev;
        var next = node.next;
        if (Objects.nonNull(prev)) {
            prev.next = next;
        }

        if (Objects.nonNull(next)) {
            next.prev = prev;
        }

        //set tail to something else if this is tail node
        if(Objects.nonNull(tail) && tail.equals(node)) {
            tail = node.prev;
        }
    }

    private void evict() {
        if (Objects.nonNull(tail)) {
            cacheMap.remove(tail.item.key);
            tail = tail.prev;
        }
    }

    private Node insert(CacheElement<K, V> cacheElement) {
        Node newNode = new Node<>(cacheElement);

        newNode.next = head;

        if (Objects.nonNull(head)) {
            head.prev = newNode;
        } else {
            // first node
            tail = newNode;
        }

        head = newNode;
        return newNode;
    }

    /***
     * 1. Check if already exist
     *      - Move the entry to head of the queue
     *      - update cachemap to point to node
     * 2. Check if Size is full
     *   - Evict last element from list and map
     *   - insert new node in both list and map at head
     *   Else
     *      - insert new node in both list and map at head
     * @param key
     * @param value
     * @return
     */
    @Override
    public boolean set(K key, V value) {
        if (cacheMap.containsKey(key)) {
            Node node = cacheMap.get(key);
            remove(node);
        } else {
            if (cacheMap.size() == CACHE_SIZE) {
                evict(); //evicts tail
            }
        }

        Node insertedNode = insert(new CacheElement<>(key, value));
        cacheMap.put(key, insertedNode);
        return true;
    }

    /***
     * If value fetched, put it back at the head position
     * @param key
     * @return
     */
    @Override
    public Optional<V> get(K key) {
        if (cacheMap.containsKey(key)) {
            Node node = cacheMap.get(key);
            CacheElement cacheElement = (CacheElement) node.item;
            remove(node);
            insert(cacheElement);

            return (Optional<V>) Optional.of(cacheElement.getValue());
        }

        return Optional.empty();
    }

    @Override
    public int size() {
        return cacheMap.size();
    }

    @Override
    public boolean isEmpty() {
        return cacheMap.isEmpty();
    }

    @Override
    public void clear() {
        cacheMap.clear();
        head = null;
        tail = null;
    }
}
