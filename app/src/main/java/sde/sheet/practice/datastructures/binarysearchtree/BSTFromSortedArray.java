package sde.sheet.practice.datastructures.binarysearchtree;

import sde.sheet.practice.datastructures.binarytree.Node;

public class BSTFromSortedArray {
    public static void main(String[] args) {
        int arr[] = new int[] { 1, 2, 3, 4, 5, 6, 7 };
        Node node = buildBST(arr, 0, arr.length-1);
        preOrderPrint(node);
    }

    private static Node buildBST(int[] arr, int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = (start + end) / 2;
        Node node = new Node(arr[mid]);
        node.left = buildBST(arr, start, mid - 1);
        node.right = buildBST(arr, mid + 1, end);
        return node;
    }

    private static void preOrderPrint (Node root) {
        if (root == null) {
            return;
        }
        System.out.println(root.value);
        preOrderPrint(root.left);
        preOrderPrint(root.right);
    }
}
