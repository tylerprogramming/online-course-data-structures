package com.tyler.lesson03;

public class CircularlyLinkedList {

    private Node tail;
    private int size;

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public Integer first() {
        if (isEmpty()) {
            return null;
        }

        return tail.getNext().getValue();
    }

    public Integer last() {
        if (isEmpty()) {
            return null;
        }

        return tail.getValue();
    }

    public void rotate() {
        if (tail != null) {
            tail = tail.getNext();
        }
    }

    public void addFirst(Integer element) {
        if (isEmpty()) {
            tail = new Node(element, null);
            tail.setNext(tail);
        } else {
            Node newest = new Node(element, tail.getNext());
            tail.setNext(newest);
        }

        size++;
    }

    public void addLast(Integer element) {
        addFirst(element);
        tail = tail.getNext();
    }

    public Integer removeFirst() {
        if (isEmpty()) {
            return null;
        }

        Node head = tail.getNext();

        if (head == tail) {
            tail = null;
        } else {
            tail.setNext(head.getNext());
        }

        size--;

        return head.getValue();
    }

    public void printList() {
        if (isEmpty()) {
            System.out.println("List is empty.");
        } else {
            System.out.print("Traversing the Circularly Linked List: ");

            Node head = tail.getNext();

            for (int i = 0; i < size; i++) {
                System.out.print(" " + head.getValue());

                head = head.getNext();
            }
        }

        System.out.println();
    }

}

