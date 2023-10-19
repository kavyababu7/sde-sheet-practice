package sde.sheet.practice.datastructures.binarytree;

import java.util.HashMap;

public class BTFromPreOrderAndInOrder {
    public static void main(String[] args) {
        int[] inorder = {40, 20, 50, 10, 60, 30};
        int[] preorder = {10, 20, 40, 50, 30, 60};
        HashMap<Integer, Integer> inorderMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }
        Node node = buildBT(inorderMap, 0, inorder.length-1, preorder, 0, inorder.length-1);
        System.out.println(node);
    }

    private static Node buildBT(HashMap<Integer, Integer> inorderMap, int inorderStart, int inorderEnd,
                                int[] preorder, int preorderStart, int preorderEnd) {
        if (preorderStart > preorderEnd || inorderStart > inorderEnd) return null;
        int inorderRootIndex = inorderMap.get(preorder[preorderStart]);
        int numberOfElements = inorderRootIndex - inorderStart;
        Node node =  new Node(preorder[preorderStart]);
        node.left = buildBT(inorderMap, inorderStart, inorderRootIndex-1, preorder, preorderStart+1, preorderStart+numberOfElements );
        node.right = buildBT(inorderMap, inorderRootIndex+1, inorderEnd, preorder, preorderStart+1+numberOfElements, preorderEnd);
        return node;
    }
}
