package com.tyler.datastructures.lesson05;

public class LessonQueue {
    private Integer[] data;
    private Integer front = 0;
    private Integer size = 0;

    public LessonQueue(Integer capacity) {
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

    public void enqueue(Integer element) {
        if (size == data.length) {
            System.out.println("Queue is full!");
            return;
        }

        int nextAvailableIndex = (front + size) % data.length;
        data[nextAvailableIndex] = element;
        size++;
    }

    public Integer dequeue() {
        if (isEmpty()) {
            return null;
        }

        Integer currentFrontElement = data[front];
        data[front] = null;
        front = (front + 1) % data.length;
        size--;

        return currentFrontElement;
    }

    public void printQueue() {
        for (int i = 0; i < data.length; i++) {
            System.out.print("| " + data[i] + " ");
        }
        System.out.println("|");
    }
}
