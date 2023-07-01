package sde.sheet.practice.datastructures.binarytree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import static sde.sheet.practice.datastructures.binarytree.TreeInitializor.buildTree;

public class PreOrderTraversal {
    public static void main(String[] args) {
        Node root = buildTree();
//        preOrderTraversal(root);
        preOrderTraversalIterative(root);
    }

    private static void preOrderTraversalIterative(Node node) {
        List<Integer> nums = new ArrayList<>();
        Stack<Node> nodeStack = new Stack<>();
        while (true) {
            if (node != null) {
                nums.add(node.value);
                nodeStack.push(node);
                node = node.left;
            } else {
                if (nodeStack.isEmpty()) break;
                node = nodeStack.pop();
                node = node.right;
            }
        }
        System.out.println(nums);
    }

    private static void preOrderTraversal(Node root) {
        if (root == null) {
            return;
        }
        System.out.println(root.value);
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
    }
}
