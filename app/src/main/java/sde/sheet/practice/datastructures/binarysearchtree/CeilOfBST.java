package sde.sheet.practice.datastructures.binarysearchtree;

import sde.sheet.practice.datastructures.binarytree.Node;
import sde.sheet.practice.datastructures.binarytree.TreeInitializor;

public class CeilOfBST {
    public static void main(String[] args) {
        Node node = TreeInitializor.buildBSTree();
        int key = 11;
        System.out.println(floorOfBST(node, key));
    }

    private static int floorOfBST(Node node, int key) {
        int ceil = Integer.MAX_VALUE;
        while (node != null) {
            if (key > node.value) {
                node = node.right;
            } else {
                ceil = Math.min(ceil, node.value);
                node = node.left;
            }
        }
        return ceil;
    }
}
