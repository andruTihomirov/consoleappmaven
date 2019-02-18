package consoleappmaven.cache;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author atsikhamirau on 15.02.2019
 */
public class LRUCache<K, V> {

    private static int priority;

    public PriorityQueue<Node> queue;

    public LRUCache(int capacity) {
        queue = new PriorityQueue<>(capacity, Comparator.comparingInt(Node::getPriority));
    }

    public V calculate(K key) {
        for (Node node : queue) {
            if (node.getKey().equals(key)) {
                node.setPriority(incrementPriority());
                System.out.println("returned value = " + node.getValue());
                System.out.println(queue);
                return (V) node.getValue();
            }
        }

        // calculate new value for key and put to cache
        Object value = "Calculated new value for key " + key;
        Node<K, V> node = new Node<>(key);
        node.setValue((V) value);
        node.setPriority(incrementPriority());
        queue.poll();
        queue.add(node);
        System.out.println(queue);

        return node.getValue();
    }


    public static int incrementPriority() {
        return ++priority;
    }

    public static void main(String[] args) {
        LRUCache<String, String> cache = new LRUCache<>(10);

        Node<String, String> node = new Node<>("1");
        node.setValue("one");
        node.setPriority(incrementPriority());
        cache.queue.add(node);

        node = new Node("2");
        node.setValue("two");
        node.setPriority(incrementPriority());
        cache.queue.add(node);

        node = new Node("3");
        node.setValue("three");
        node.setPriority(incrementPriority());
        cache.queue.add(node);

        System.out.println(cache.queue);
        cache.calculate("3");
        cache.calculate("7");
    }
}
