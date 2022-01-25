package com.tyler.lesson06;

public class BinarySearchTree {
    private Node root;

    public BinarySearchTree(Node node) {
        root = node;
    }

    public BinarySearchTree() {}

    public Node insert(int value) {
        return insertHelper(root, value);
    }

    public Node delete(int value) {
        return deleteHelper(root, value);
    }

    private Node insertHelper(Node node, int value) {
        if (node == null) {
            return new Node(value);
        }

        if (value < node.getValue()) {
            Node leftChild = insertHelper(node.getLeftChild(), value);
            node.setLeftChild(leftChild);
            leftChild.setParent(node);
        }

        if (value >= node.getValue()) {
            Node rightChild = insertHelper(node.getRightChild(), value);
            node.setRightChild(rightChild);
            rightChild.setParent(node);
        }

        return node;
    }

    private Node deleteHelper(Node node, int value) {
        if (node == null) {
            return node;
        }

        if (value < node.getValue()) {
            deleteHelper(node.getLeftChild(), value);
        } else if (value > node.getValue()) {
            deleteHelper(node.getRightChild(), value);
        } else {
            if (hasNoChildren(node)) {
                removeLeafNode(node, value);
            }

            if (hasOneChild(node)) {
                replaceNodeWithChildNode(node);
            }

            if (hasTwoChildren(node)) {
                Node successor = getInorderSuccessor(node.getRightChild());
                node.setValue(successor.getValue());
                deleteHelper(node.getRightChild(), node.getValue());
            }
        }

        return node;
    }

    private boolean hasNoChildren(Node node) {
        if (node.getLeftChild() == null && node.getRightChild() == null) {
            return true;
        }

        return false;
    }

    private boolean hasOneChild(Node node) {
        if ((node.getLeftChild() != null && node.getRightChild() == null) || (node.getLeftChild() == null && node.getRightChild() != null)) {
            return true;
        }

        return false;
    }

    private boolean hasTwoChildren(Node node) {
        if (node.getLeftChild() != null && node.getRightChild() != null) {
            return true;
        }

        return false;
    }

    private void removeLeafNode(Node node, int value) {
        Node parentNode;

        if (node.getParent() != null) {
            parentNode = node.getParent();
        } else {
            parentNode = node;
        }

        if (parentNode.getLeftChild().getValue() == value) {
            parentNode.setLeftChild(null);
        } else {
            parentNode.setRightChild(null);
        }
    }

    private void replaceNodeWithChildNode(Node node) {
        Node child = (node.getLeftChild() != null ? node.getLeftChild() : node.getRightChild());

        if (child != null) {
            child.setParent(node.getParent());
        }

        if (node == root) {
            root = child;
        } else {
            Node parent = node.getParent();

            if (node == parent.getLeftChild()) {
                parent.setLeftChild(child);
            } else {
                parent.setRightChild(child);
            }
        }
    }

    private Node getInorderSuccessor(Node node) {
        while (node.getLeftChild() != null) {
            node = node.getLeftChild();
        }

        return node;
    }

    public int height(Node node) {
        if (node == null) {
            return -1;
        }

        return 1 + Math.max(height(node.getLeftChild()), height(node.getRightChild()));
    }

    public int depth(Node node) {
        if (node == root) {
            return 0;
        } else {
            return 1 + depth(node.getParent());
        }
    }

    public void inorder(Node node) {
        if (node != null) {
            inorder(node.getLeftChild());
            System.out.print(node.getValue() + " ");
            inorder(node.getRightChild());
        }
    }

    public void preorder(Node node) {
        if (node != null) {
            System.out.print(node.getValue() + " ");
            preorder(node.getLeftChild());
            preorder(node.getRightChild());
        }
    }

    public void postorder(Node node) {
        if (node != null) {
            postorder(node.getLeftChild());
            postorder(node.getRightChild());
            System.out.print(node.getValue() + " ");
        }
    }
}
