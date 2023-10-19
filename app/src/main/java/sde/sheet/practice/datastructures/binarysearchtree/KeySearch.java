package sde.sheet.practice.datastructures.binarysearchtree;

import sde.sheet.practice.datastructures.binarytree.Node;

public class KeySearch {
    public static void main(String[] args) {
        int key = 2;
        Node root = new Node(4);
        root.left = new Node(2);
        root.right = new Node(7);
        root.left.left = new Node(1);
        root.left.right = new Node(3);
        System.out.println(search(root, key));
    }

    private static Node search(Node node, int key) {
        if (node == null) {
            return null;
        }
        if (key == node.value) {
            return node;
        }
        return key > node.value ? search(node.right, key) : search(node.left, key);
    }
}
