package com.tyler.lesson05;

public class LessonDeque {
    private Integer[] data;
    private Integer front = 0;
    private Integer size = 0;

    public LessonDeque(Integer capacity) {
        data = new Integer[capacity];
    }

    public Integer size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public Integer first() {
        if (isEmpty()) {
            return null;
        }

        return data[front];
    }

    public Integer last() {
        if (isEmpty()) {
            return null;
        }

        return data[(front + size - 1) % data.length];
    }

    public void addFirst(Integer element) {
        if (size == data.length) {
            System.out.println("Deque is full!");
            return;
        }

        if (front == 0 && isEmpty()) {
            data[front] = element;
        } else {
            front = (front - 1 + data.length) % data.length;
            data[front] = element;
        }

        size++;
    }

    public void addLast(Integer element) {
        if (size == data.length) {
            System.out.println("Deque is full!");
            return;
        }

        int nextAvailableIndex = (front + size) % data.length;
        data[nextAvailableIndex] = element;
        size++;
    }

    public Integer removeFirst() {
        if (isEmpty()) {
            return null;
        }

        Integer currentFrontElement = data[front];
        data[front] = null;
        front = (front + 1) % data.length;
        size--;

        return currentFrontElement;
    }

    public Integer removeLast() {
        if (isEmpty()) {
            return null;
        }

        Integer currentLastElement = data[size - 1];
        data[size - 1] = null;
        size--;

        return currentLastElement;
    }

    public void printQueue() {
        for (int i = 0; i < data.length; i++) {
            System.out.print("| " + data[i] + " ");
        }
        System.out.println("|");
    }
}
