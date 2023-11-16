package company;

public class CustomLinkedList<T> {

    private Node head;

    public void insert(T person) {
        Node<T> newNode = new Node<>(person);
        newNode.next = null;

        if (head == null) {
            head = newNode;
        } else {
            Node<T> last = head;
            while (last.next != null) {
                last = last.next;
            }
            last.next = newNode;
        }
    }

    public void remove(T person) {
        if (head.value.equals(person)) {
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