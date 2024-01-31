package sde.sheet.practice.datastructures.binarytree;

import java.util.ArrayList;
import java.util.List;

public class LeavesOfBinaryTree {
    public static void main(String[] args) {
        Node tree = TreeInitializor.buildTree();
        List<Integer> leaves = new ArrayList<>();
        leavesOfBt(tree, leaves);
        System.out.println(leaves);
    }

    private static void leavesOfBt(Node node, List<Integer> leaves) {
        if (node == null) return;
        if (node.left == null && node.right == null) {
            leaves.add(node.value);
            return ;
        }
        leavesOfBt(node.left, leaves);
        leavesOfBt(node.right, leaves);
    }
}
