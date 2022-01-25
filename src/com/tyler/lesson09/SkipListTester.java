package com.tyler.lesson09;

public class SkipListTester {

    public void run() {
        SkipList sl = new SkipList();
        sl.skipInsert(5);
        sl.skipInsert(3);
        sl.skipInsert(7);
        sl.skipInsert(9);
        sl.skipInsert(1);
        sl.printSkipList();
        sl.remove(3);
        sl.printSkipList();
        sl.remove(9);
        sl.printSkipList();
    }
}
