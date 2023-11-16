package company;

import people.Person;

public class PersonLinkedList {

    private Node head;

    public void insert(Person person) {
        Node new_node = new Node(person);
        new_node.next = null;

        if (head == null) {
            head = new_node;
        } else {
            Node last = head;
            while (last.next != null) {
                last = last.next;
            }
            last.next = new_node;
        }
    }

    public void remove(Person person) {
        if (head.value.equals(person)) {
            head = head.next;
        }

        Node current = head;
        Node prev = null;

        while (current != null && !current.value.equals(person)) {
            prev = current;
            current = current.next;
        }

        prev.next = current.next;
    }

    public String printList() {
        StringBuilder listString = new StringBuilder();
        Node currNode = head;
        while (currNode != null) {
            listString.append(currNode.value).append(" ");
            currNode = currNode.next;
        }
        return listString.toString().trim();
    }
}