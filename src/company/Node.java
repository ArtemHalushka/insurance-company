package company;

import people.Person;

public class Node {

    Node next;
    Person value;

    public Node(Person valueNode) {
        value = valueNode;
        next = null;
    }
}