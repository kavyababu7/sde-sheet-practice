package sde.sheet.practice.datastructures.binarysearchtree;

import sde.sheet.practice.datastructures.binarytree.Node;
import sde.sheet.practice.datastructures.binarytree.TreeInitializor;

public class FloorOfBST {
    public static void main(String[] args) {
        Node node = TreeInitializor.buildBSTree();
        int key = 7;
        System.out.println(floorOfBST(node, key));
    }

    private static int floorOfBST(Node node, int key) {
        if (node == null) {
            return Integer.MAX_VALUE;
        }
        int floor = 0;
        while (node != null) {
            if (node.value > key) {
                node = node.left;
            } else {
                floor = node.value;
                node = node.right;
            }
        }
        return floor;
    }
}
