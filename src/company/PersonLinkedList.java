package company;

public class PersonLinkedList<T> {

    private Node head;

    public static class Node<T> {

        Node<T> next;
        T value;

        public Node(T valueNode) {
            value = valueNode;
            next = null;
        }
    }

    public void insert(T person) {
        Node<T> new_node = new Node<>(person);
        new_node.next = null;

        if (head == null) {
            head = new_node;
        } else {
            Node<T> last = head;
            while (last.next != null) {
                last = last.next;
            }
            last.next = new_node;
        }
    }

    public void remove(T person) {
        if(head.value.equals(person)) {
            head = head.next;
        }

        Node<T> current = head;
        Node<T> prev = null;

        while (current != null && !current.value.equals(person)) {
            prev = current;
            current = current.next;
        }

        prev.next = current.next;
    }

    public String printList() {
        StringBuilder listString = new StringBuilder();
        Node<T> currNode = head;
        while (currNode != null) {
            listString.append(currNode.value).append(" ");
            currNode = currNode.next;
        }
        return listString.toString().trim();
    }
}