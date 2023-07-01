package sde.sheet.practice.datastructures.binarytree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import static sde.sheet.practice.datastructures.binarytree.TreeInitializor.buildTree;

public class PostOrderTraversal {
    public static void main(String[] args) {
        Node root = buildTree();
        postOrderTraversal(root);
        postOrderTraversalIterative(root);
    }

    private static void postOrderTraversalIterative(Node node) {
        Stack<Node> stack1 = new Stack<>();
        Stack<Node> stack2 = new Stack<>();
        List<Integer> nums = new ArrayList<>();
        stack1.push(node);
        while (!stack1.isEmpty()) {
            Node poppedNode = stack1.pop();
            stack2.push(poppedNode);
            if (poppedNode.left != null) {
                stack1.push(poppedNode.left);
            }
            if (poppedNode.right != null) {
                stack1.push(poppedNode.right);
            }
        }
        while (!stack2.isEmpty()) {
            Node pop = stack2.pop();
            nums.add(pop.value);
        }
        System.out.println(nums);
    }

    private static void postOrderTraversal(Node root) {
        if (root == null) {
            return;
        }
        postOrderTraversal(root.left);
        postOrderTraversal(root.right);
        System.out.println(root.value);
    }
}
