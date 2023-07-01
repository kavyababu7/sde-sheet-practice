package sde.sheet.practice.datastructures.binarytree;

import java.util.LinkedList;
import java.util.Queue;


public class HeightOfBT {
    public static void main(String[] args) {
        Node node = TreeInitializor.buildTree();
//        int height = heightOfBT(node);
        int height = heightOfBTRecursive(node);
        System.out.println(height);
    }

    private static int heightOfBTRecursive(Node node) {
        if (node == null) {
            return 0;
        }
        return 1+Math.max(heightOfBTRecursive(node.right),heightOfBTRecursive(node.left));
    }

    private static int heightOfBT(Node node) {
        Queue<Node> nodeQueue = new LinkedList();
        nodeQueue.add(node);
        int level = 0;
        while (!nodeQueue.isEmpty()) {
            int queueSize = nodeQueue.size();
            while (queueSize > 0) {
                Node pop = nodeQueue.remove();
                if (pop.left != null) {
                    nodeQueue.add(pop.left);
                }
                if (pop.right != null) {
                    nodeQueue.add(pop.right);
                }
                queueSize--;
            }
            level++;
        }
        return level;
    }
}
