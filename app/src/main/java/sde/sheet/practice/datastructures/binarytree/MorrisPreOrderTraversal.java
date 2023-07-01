package sde.sheet.practice.datastructures.binarytree;

import java.util.ArrayList;
import java.util.List;

import static sde.sheet.practice.datastructures.binarytree.TreeInitializor.buildTree;

public class MorrisPreOrderTraversal {
    public static void main(String[] args) {
        Node root = buildTree();
        preOrderMorris(root);
    }

    private static void preOrderMorris(Node root) {
        Node current = root;
        List<Integer> nodes = new ArrayList<>();
        while (current != null) {
            if (current.left == null) {
                nodes.add(current.value);
                current = current.right;
            } else {
                Node previous = current.left;
                //go to right most node
                while (previous.right != null && previous.right != current) {
                    previous = previous.right;
                }
                if (previous.right == null) {
                    previous.right = current;
                    nodes.add(current.value);
                    current = current.left;
                } else {
                    previous.right = null;
                    current = current.right;
                }
            }
        }
        System.out.println(nodes);
    }
}
