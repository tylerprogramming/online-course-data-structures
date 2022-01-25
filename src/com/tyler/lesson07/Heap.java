package com.tyler.lesson07;

public class Heap {
    private static final int CAPACITY = 50;
    private int[] data;
    private int size;

    public Heap(int capacity) {
        data = new int[capacity];
    }

    public Heap() {
        this(CAPACITY);
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private int left(int i) {
        return 2 * i + 1;
    }

    private int right(int i) {
        return 2 * i + 2;
    }

    private int parent(int i) {
        return (i - 1) / 2;
    }

    private boolean hasLeftChild(int i) {
        return left(i) < size;
    }

    private boolean hasRightChild(int i) {
        return right(i) < size;
    }

    private void swap(int i, int j) {
        int temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }

    public void insert(int num) {
        if (size == data.length) {
            throw new IllegalStateException("Heap is full.");
        }

        data[size++] = num;
        upheap(size - 1);
    }

    public void upheap(int i) {
        while (i > 0) {
            int parentIndex = parent(i);

            if (data[i] >= data[parentIndex]) {
                break;
            }

            swap(i, parentIndex);
            i = parentIndex;
        }
    }

    public int removeMin() {
        if (isEmpty()) {
            return -1;
        }

        int rootValue = data[0];
        swap(0, size - 1);
        data[size - 1] = -1;
        size--;
        downheap(0);
        return rootValue;
    }

    public void downheap(int i) {
        while (hasLeftChild(i)) {
            int leftIndex = left(i);
            int smallestChildIndex = leftIndex;

            if (hasRightChild(i)) {
                int rightIndex = right(i);
                if (data[leftIndex] > data[rightIndex]) {
                    smallestChildIndex = rightIndex;
                }
            }

            if (data[smallestChildIndex] >= data[i]) {
                break;
            }

            swap(i, smallestChildIndex);
            i = smallestChildIndex;
        }
    }

    public void printHeap() {
        for (int i = 0; i < size; i++) {
            System.out.print(data[i] + " ");
        }
        System.out.println();
    }
}
