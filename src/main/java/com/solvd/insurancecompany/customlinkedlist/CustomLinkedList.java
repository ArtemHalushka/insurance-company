package com.solvd.insurancecompany.customlinkedlist;

import java.util.function.Consumer;

public class CustomLinkedList<T> {

    private Node head;
    private static int sizeCounter;

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
        incrementSize();
    }

    public void forEach(Consumer<T> action) {
        Node<T> current = head;

        while (current != null) {
            action.accept(current.value);
            current = current.next;
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
        decrementSize();
    }

    public void incrementSize() {
        sizeCounter++;
    }

    public void decrementSize() {
        sizeCounter--;
    }

    public int size() {
        return sizeCounter;
    }

    public T getValueByIndex(int index) {
        if (index < 0) {
            return null;
        }
        Node<T> current = head;
        int currentIndex = 0;

        while (current != null) {
            if (currentIndex == index) {
                return current.value;
            }
            current = current.next;
            currentIndex++;
        }
        return null;
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