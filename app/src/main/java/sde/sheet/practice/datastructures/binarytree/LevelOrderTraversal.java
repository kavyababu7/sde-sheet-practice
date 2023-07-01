package sde.sheet.practice.datastructures.binarytree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderTraversal {
    public static void main(String[] args) {
        Node node = TreeInitializor.buildTree();
        List<Integer> list = new ArrayList<>();
        levelOrderTraversal(node);
    }

    private static void levelOrderTraversal(Node node) {
        Queue<Node> nodeQueue = new LinkedList<>();
        List<Integer> levelTraversal = new ArrayList<>();
        nodeQueue.add( node);
        while (!nodeQueue.isEmpty()) {
            Node pop = nodeQueue.remove();
            if (pop.left != null) {
                nodeQueue.add(pop.left);
            }
            if (pop.right != null) {
                nodeQueue.add(pop.right);
            }
            levelTraversal.add(pop.value);
        }
        System.out.println(levelTraversal);
    }
}
