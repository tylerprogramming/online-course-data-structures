package com.tyler.lesson11;

import com.tyler.lesson10.BalanceableTree;
import com.tyler.lesson10.Node;

public class SplayTree extends BalanceableTree {

    public SplayTree(int value) {
        super(value);
    }

    private void splay(Node node) {
        while (node != this.getRoot()) {
            Node parent = node.getParent();
            Node grandparent = parent.getParent();

            if (grandparent == null) {
                rotate(node);
            } else if ((parent == grandparent.getLeftChild()) == (node == parent.getLeftChild())) {
                rotate(parent);
                rotate(node);
            } else {
                rotate(node);
                rotate(node);
            }
        }
    }

    public void rebalanceInsert(Node node) {
        splay(node);
    }

    public void rebalanceAccess(Node node) {
        if (node != null) {
            splay(node);
        }
    }

    public void rebalanceDelete(Node node) {
        if (node != getRoot()) {
            splay(node.getParent());
        }
    }









}
