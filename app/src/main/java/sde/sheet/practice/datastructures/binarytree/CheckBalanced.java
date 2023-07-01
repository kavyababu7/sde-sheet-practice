package sde.sheet.practice.datastructures.binarytree;

import com.sun.source.tree.Tree;

public class CheckBalanced {
    public static void main(String[] args) {
        Node imbalancedTree = TreeInitializor.buildTree();
        imbalancedTree.left.left.left = new Node(10);
        imbalancedTree.left.left.left.left = new Node(11);
//        Boolean imBalanced = isBalanced(imbalancedTree);
        Boolean imBalanced = isBalancedOptimized(imbalancedTree);
        System.out.println(imBalanced);
        Node balancedTree = TreeInitializor.buildTree();
//        Boolean balanced = isBalanced(balancedTree);
        Boolean balanced = isBalancedOptimized(balancedTree);
        System.out.println(balanced);
    }

    private static Boolean isBalancedOptimized(Node node) {
        return heightBalanced(node) != -1;
    }

    private static int heightBalanced(Node node) {
        if (node == null) {
            return 0;
        }
        int leftHt = heightBalanced(node.right);
        if(leftHt == -1 ) return -1;
        int rightHt = heightBalanced(node.left);
        if(rightHt == -1) return -1;
        if (Math.abs(leftHt - rightHt) > 1) return -1;
        return Math.abs(leftHt - rightHt) + 1;
    }

    private static Boolean isBalanced(Node node) {
        if (node == null) {
            return true;
        }
        return Math.abs(height(node.left) - height(node.right)) <= 1;
    }

    private static int height(Node node) {
        if (node == null) {
            return 0;
        }
        return 1 + Math.max(height(node.left), height(node.right));
    }
}
