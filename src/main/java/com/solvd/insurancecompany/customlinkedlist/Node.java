package com.solvd.insurancecompany.customlinkedlist;

public class Node<T> {

    protected Node next;
    protected T value;

    public Node(T valueNode) {
        value = valueNode;
        next = null;
    }
}