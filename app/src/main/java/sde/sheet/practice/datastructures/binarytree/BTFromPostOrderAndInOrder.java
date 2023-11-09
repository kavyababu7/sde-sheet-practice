package sde.sheet.practice.datastructures.binarytree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.BlockingDeque;
import java.util.stream.Collectors;

public class BTFromPostOrderAndInOrder {
    public static void main(String[] args) {
        int[] inorder = {40, 20, 50, 10, 60, 30};
        int[] postorder = {40, 50, 20, 30, 60, 10};
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        Node node = buildBT(map, 0, inorder.length-1, postorder, 0, inorder.length-1);
        System.out.println(node);
    }

    private static Node buildBT(Map<Integer, Integer> map, int inorderStart, int inorderEnd, int[] postorder, int postOrderStart, int postOrderEnd) {
        if (inorderEnd < inorderStart || postOrderEnd < postOrderStart) {
            return null;
        }
        Integer inOrderRoot = map.get(postorder[postOrderEnd]);
        Integer noOfItems = inOrderRoot - inorderStart;
        Node node = new Node(postorder[postOrderEnd]);
        node.left = buildBT(map, inorderStart, inOrderRoot-1, postorder, postOrderStart, postOrderStart + noOfItems-1);
        node.right = buildBT(map, inOrderRoot+1, inorderEnd, postorder, postOrderStart + noOfItems, postOrderEnd-1);
        return node;
    }
}
