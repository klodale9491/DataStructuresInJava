package com.unipa.ads.singlelinkedlists;


public class Node {

    // Variables
    private int value;
    private Node next;


    // Constructors
    public Node(int value) {
        this.value = value;
    }


    // Getter and Setters
    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}
