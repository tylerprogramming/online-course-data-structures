package com.tyler.lesson03;

public class SinglyLinkedList {

    private Node head;
    private Node tail;
    private int size;

    public SinglyLinkedList() {}

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

        return head.getValue();
    }

    public Integer last() {
        if (isEmpty()) {
            return null;
        }

        return tail.getValue();
    }

    public void addFirst(Integer element) {
        head = new Node(element, head);

        if (size == 0) {
            tail = head;
        }

        size++;
    }

    public void addLast(Integer element) {
        Node newest = new Node(element, null);

        if (isEmpty()) {
            head = newest;
        } else {
            tail.setNext(newest);
        }

        tail = newest;
        size++;
    }

    public Integer removeFirst() {
        if (isEmpty()) {
            return null;
        }

        Integer currentHeadValue = head.getValue();
        head = head.getNext();
        size--;

        if (size == 0) {
            tail = null;
        }

        return currentHeadValue;
    }

    public void printList() {
        if (isEmpty()) {
            System.out.println("List is empty!");
        } else {
            System.out.print("Traversing the Singly Linked List: ");

            Node start = head;

            while(start != null) {
                System.out.print(start.getValue() + " ");

                start = start.getNext();
            }

            System.out.println("\nThe size of the list: " + size);
        }
    }
}

