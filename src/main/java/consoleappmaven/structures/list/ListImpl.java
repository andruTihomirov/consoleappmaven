package consoleappmaven.structures.list;

/**
 * @author atsikhamirau on 12.02.2019
 */
public class ListImpl<T> implements List<T> {

    private Node head;

    @Override
    public void append(T value) {
        if (head == null) {
            head = new Node(value);
            return;
        }

        Node currentNode = head;
        while (currentNode.getNext() != null) {
            currentNode = currentNode.getNext();
        }
        Node newNode = new Node(value);
        currentNode.setNext(newNode);
    }

    @Override
    public void prepend(T value) {
        Node newHead = new Node(value);
        newHead.setNext(head);
        head = newHead;
    }

    @Override
    public void delete(T value) {
        if (head == null) return;
        if (head.getValue().equals(value)) {
            head = head.getNext();
        }

        Node currentNode = head;
        while (currentNode.getNext() != null) {
            if (currentNode.getValue().equals(value)) {
                currentNode.setNext(currentNode.getNext().getNext());
                return;
            }
            currentNode = currentNode.getNext();
        }
    }

    class Node {

        private T value;

        private Node next;

        public Node(T value) {
            this.value = value;
        }

        public T getValue() {
            return value;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }
}
