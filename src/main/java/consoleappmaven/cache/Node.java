package consoleappmaven.cache;

/**
 * @author atsikhamirau on 18.02.2019
 */
public class Node<K, V> {

    private K key;

    private V value;

    private int priority;

    public Node(K key) {
        this.key = key;
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

    public void setPriority(int priority) {
        this.priority = priority;
    }

    @Override
    public String toString() {
        return "key = " + key + ", value = " + value + ", priority = " + priority;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (obj == this) return true;
        if (obj instanceof Node) {
            Node node = (Node) obj;
            if (node.getKey().equals(this.getKey())) {
                return true;
            }
        }
        return false;
    }
}
