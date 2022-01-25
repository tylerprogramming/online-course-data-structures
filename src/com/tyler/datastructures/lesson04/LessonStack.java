package com.tyler.datastructures.lesson04;

public class LessonStack {
    private static final int CAPACITY = 100;
    private int[] data;
    private int size;

    public LessonStack(int capacity) {
        data = new int[capacity];
    }

    public LessonStack() {
        this(CAPACITY);
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int top() {
        if (isEmpty()) {
            return -1;
        }

        return data[size - 1];
    }

    public void push(int num) {
        if (size() == data.length) {
            throw new IllegalStateException("Stack is full.");
        }

        data[size++] = num;
    }

    public int pop() {
        if (isEmpty()) {
            return -1;
        }

        int answer = data[size - 1];
        data[size] = -1;
        size--;

        return answer;
    }

    public void print() {
        if (isEmpty()) {
            System.out.println("Stack is empty.");
        } else {
            for (int i = 0; i < size; i++) {
                System.out.print("| " + data[i] + " ");
            }
            System.out.println("|");
        }
    }
}
