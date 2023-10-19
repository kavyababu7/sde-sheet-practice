package sde.sheet.practice.datastructures.binarysearchtree;

import sde.sheet.practice.datastructures.binarytree.Node;

public class BSTFromPreOrder {
    public static void main(String[] args) {
        int[] preorder = {8,5,1,7,10,12};
        Node node = buildBST(null, preorder, 0, preorder.length);
        System.out.println(node);
    }

    private static Node buildBST(Node node, int[] preorder, int index, int length) {
        if (index > length-1) {
            return null;
        }
//        if (node == null) {
//            node = new Node(preorder[index]);
//        }
//        if (preorder[index+1] > node.value) {
//            buildBST(preorder, index+1, length);
//        } else {
//            node.left = buildBST(preorder, index+1, length);
//        }
        return node;
    }
}
