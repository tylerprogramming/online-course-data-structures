package com.tyler.lesson10;

public class AVLTree extends BalanceableTree{

    public AVLTree(int value) {
        super(value);
    }

    public int height(Node node) {
        if (node == null) {
            return 0;
        }

        return node.getHeightProperty();
    }

    public void recomputeHeight(Node node) {
        node.setHeightProperty(1 + Math.max(height(node.getLeftChild()), height(node.getRightChild())));
    }

    public boolean isBalanced(Node node) {
        return Math.abs(height(node.getLeftChild()) - height(node.getRightChild())) <= 1;
    }

    public Node tallerChild(Node node) {
        if (height(node.getLeftChild()) > height(node.getRightChild())) {
            return node.getLeftChild();
        }

        if (height(node.getLeftChild()) < height(node.getRightChild())) {
            return node.getRightChild();
        }

        if (node == getRoot()) {
            return node.getLeftChild();
        }

        if (node == node.getParent().getLeftChild()) {
            return node.getLeftChild();
        } else {
            return node.getRightChild();
        }
    }

    public void rebalance(Node node) {
        int oldHeight, newHeight;

        do {
            oldHeight = height(node);

            if (!isBalanced(node)) {
                node = restructure(tallerChild(tallerChild(node)));
                recomputeHeight(node.getLeftChild());
                recomputeHeight(node.getRightChild());
            }

            recomputeHeight(node);
            newHeight = height(node);
            node = node.getParent();
        } while (oldHeight != newHeight && node != null);
    }

    public void rebalanceInsert(Node node) {
        rebalance(node);
    }

    public void rebalanceDelete(Node node) {
        if (node != getRoot()) {
            rebalance(node.getParent());
        }
    }
}
