package designs.lrucache.v2;

import java.util.HashMap;
import java.util.LinkedList;

public class FasterLRUCache {

    /***
     * Using Hashmap for faster search
     * +
     * we will use doubly linked list to ensure faster eviction without any sorting or searching
     * For removal always remove tail of linkedlist
     */
    HashMap<Object, Node> nodeMap = new HashMap<>();

    LinkedList<Node> nodeList = new LinkedList<>();

    private static final Integer CACHE_SIZE = 5;

    public void put(Object o) {
        /***
         * 1. Check for full
         * 2. Evict if needed
         * 3. If existing,
         *      - move to top of linkedlist
         *      - return
         * 4. else, Create node
         *      - add to linkedlist
         *      - add to map
         */

        if(nodeList.size() == CACHE_SIZE)
        {
            //evict old entry in cache
            Node evictedNode = nodeList.removeFirst();
            nodeMap.remove(evictedNode);
        }

        Node existingNode = nodeMap.get(o);

        if(null != existingNode) {
            // move to top in linkedlist
            //detach the node
            existingNode.prev.next = existingNode.next;
            existingNode.next.prev = existingNode.prev;

            updateLinks(existingNode);

        } else {
            Node newNode = new Node(o);
            nodeMap.put(o, newNode);

            updateLinks(newNode);
        }
    }

    private void updateLinks(Node newNode) {
        //set pointers
        Node lastNode = nodeList.size() > 0 ? nodeList.getLast() : null;

        if(null != lastNode) {
            lastNode.next = newNode;
            newNode.prev = lastNode;
            newNode.next = null;
        } else {
            newNode.prev = null;
            newNode.next = null;
        }

        nodeList.add(newNode);
    }

    public void showEntries() {
        nodeList.stream().forEach(node -> System.out.println(node.item));
    }


    private static class Node<E> {
        E item;
        Node<E> prev;
        Node<E> next;

        public Node(E item) {
            this.item = item;
        }
    }
}
