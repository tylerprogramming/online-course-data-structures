package com.tyler.lesson07;

public class HeapTester {
    public void run() {
        Heap heap = new Heap();
        heap.insert(11);
        heap.insert(5);
        heap.printHeap();
        heap.insert(12);
        heap.printHeap();
        heap.insert(3);
        heap.printHeap();
        heap.insert(1);
        heap.printHeap();
        heap.insert(2);
        heap.printHeap();
        heap.removeMin();
        heap.printHeap();
        heap.removeMin();
        heap.printHeap();
    }
}
