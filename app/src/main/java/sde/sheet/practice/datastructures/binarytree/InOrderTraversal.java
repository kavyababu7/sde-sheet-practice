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
        Stack<Node> inorder = new Stack();
        while (true) {
            if (node != null) {
                inorder.push(node);
                node = node.left;
            } else {
                if (inorder.isEmpty()) {
                    break;
                }
                Node pop = inorder.pop();
                System.out.println(pop);
                node = pop.right;
            }
        }
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
