package sde.sheet.practice.datastructures.binarytree;

import java.util.ArrayList;
import java.util.List;

public class MorrisInOrderTraversal {
    public static void main(String[] args) {
        Node root = TreeInitializor.buildTree();
        morrisInOrderTraversal(root);
    }

    private static void morrisInOrderTraversal(Node root) {
        Node current = root;
        List<Integer> nodes = new ArrayList<>();
        while (current != null) {
            //if left is null print and go right
            if (current.left == null) {
                nodes.add(current.value);
                current = current.right;
            } else {
                Node previous = current.left;
                //go till right most end of left
                while (previous.right != null && previous.right != current) {
                    previous = previous.right;
                }
                //if right is null, make it point to current
                if (previous.right == null) {
                    previous.right = current;
                    current = current.left;
                } else {
                    previous.right = null;
                    nodes.add(current.value);
                    current = current.right;
                }
            }
        }
        System.out.println(nodes);
    }
}
