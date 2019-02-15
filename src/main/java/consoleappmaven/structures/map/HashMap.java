package consoleappmaven.structures.map;

import java.util.Objects;

/**
 * @author atsikhamirau on 15.02.2019
 */
public class HashMap<K, V> implements Map<K, V> {

    private static final int DEFAULT_BUCKET_SIZE = 16;

    private Node[] buckets = new Node[DEFAULT_BUCKET_SIZE];

    @Override
    public V get(Object key) {
        Node<K, V> node;
        return (node = getNode(key)) == null ? null : node.getValue();
    }

    @Override
    public void put(K key, V value) {
        int hash = hash(key);
        int index = (buckets.length - 1) & hash;
        if (buckets[index] == null) {
            buckets[index] = new Node<>(hash, key, value, null);
        } else {
            Node<K, V> node = new Node<>(hash, key, value, buckets[index]);
            buckets[index] = node;
        }
    }

    private Node<K, V> getNode(Object key) {
        int hash = hash(key);
        int index = (buckets.length - 1) & hash;

        Node<K, V> node = buckets[index];

        if (node != null) {
            do {
                if (node.getHash() == hash &&
                        node.getKey().equals(key)) {
                    return node;
                }
                node = node.getNext();
            } while (node.getNext() != null);
        }

        return null;
    }

    private int hash(Object key) {
        int hash;
        return (key == null) ? 0 : (hash = key.hashCode()) ^ (hash >>> 16);
    }

    class Node<K, V> {
        private int hash;
        private K key;
        private V value;

        Node<K, V> next;

        public Node(int hash, K key, V value, Node<K, V> next) {
            this.hash = hash;
            this.key = key;
            this.value = value;
            this.next = next;
        }

        public int getHash() {
            return hash;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        public Node<K, V> getNext() {
            return next;
        }

        public boolean equals(Object o) {
            if (o == this) return true;
            if (o instanceof Node) {
                Node<?, ?> node = (Node<?, ?>) o;
                if (Objects.equals(this.hash, node.getHash()) &&
                    Objects.equals(this.key, node.getKey())) {
                        return true;
                }
            }
            return false;
        }

    }
}
