package consoleappmaven.cache;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author atsikhamirau on 15.02.2019
 */
public class LRUCache<K, V> {

    private PriorityQueue<Node> queue;

    public LRUCache(int capacity) {
        queue = new PriorityQueue<>(capacity, Comparator.comparingInt(Node::getPriority));
    }

    public V calculate(K key) {
        for (Node node : queue) {
            if (node.getKey().equals(key)) {
                node.incrementPriority();
                return (V) node.getValue();
            }
        }

        // calculate and put ot cache

        return null;
    }

    class Node<K, V> {

        private K key;

        private V value;

        private int priority;

        public void incrementPriority() {
            priority++;
        }

        public K getKey() {
            return key;
        }

        public void setKey(K key) {
            this.key = key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }

        public int getPriority() {
            return priority;
        }
    }

    public static void main(String[] args) {
        LRUCache<String, String> cache = new LRUCache<>(10);
        System.out.println();
    }

}
