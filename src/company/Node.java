package company;

public class Node<T> {

    Node next;
    T value;

    public Node(T valueNode) {
        value = valueNode;
        next = null;
    }
}