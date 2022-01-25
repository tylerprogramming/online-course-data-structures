package com.tyler.datastructures;

import com.tyler.datastructures.lesson03.DoublyLinkedList;

public class Main {

    public static void main(String[] args) {
//        SkipListTester skipListTester = new SkipListTester();
////        skipListTester.run();
//        AVLTreeTester avlTreeTester = new AVLTreeTester();
//        avlTreeTester.run();
//        SplayTreeTester splayTreeTester = new SplayTreeTester();
//        splayTreeTester.run();
//        RedBlackTreeTester redBlackTreeTester = new RedBlackTreeTester();
//        redBlackTreeTester.run();
//        DequeArrayTester dequeArrayTester = new DequeArrayTester();
//        dequeArrayTester.run();
//        GraphTester graphTester = new GraphTester();
//        graphTester.run();


        DoublyLinkedList dll = new DoublyLinkedList();
        dll.addFirst(5);
        dll.addLast(20);
        dll.addLast(29);
        dll.addLast(2);
        dll.addLast(7);
        dll.printList();
        dll.removeElement(5);
        System.out.println(dll.printList());
    }
}
