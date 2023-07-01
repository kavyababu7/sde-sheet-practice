package sde.sheet.practice.datastructures.binarytree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import static sde.sheet.practice.datastructures.binarytree.TreeInitializor.buildTree;

public class InOrderTraversal {
    public static void main(String[] args) {
        Node root = buildTree();
//        inOrderTraversal(root);
        inOrderTraversalIterative(root);
    }

    private static void inOrderTraversalIterative(Node node) {
        Stack<Node> nodeStack = new Stack<>();
        List<Integer> nums = new ArrayList<>();
        while (true) {
            if (node != null) {
                nodeStack.push(node);
                node = node.left;
            } else {
                if (nodeStack.isEmpty()) break;
                Node current = nodeStack.peek();
                nums.add(current.value);
                nodeStack.pop();
                node = current.right;
            }
        }
        System.out.println(nums);
    }

    private static void inOrderTraversal(Node root) {
        if (root == null) {
            return;
        }
        inOrderTraversal(root.left);
        System.out.println(root.value);
        inOrderTraversal(root.right);
    }
}
