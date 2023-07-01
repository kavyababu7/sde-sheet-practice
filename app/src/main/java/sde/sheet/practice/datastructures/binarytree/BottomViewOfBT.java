package sde.sheet.practice.datastructures.binarytree;

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

public class BottomViewOfBT {
    public static void main(String[] args) {
        Node tree = TreeInitializor.buildTree();
        topViewOfTree(tree);
    }

    private static void topViewOfTree(Node node) {
        Queue<Pair> nodeDetailQueue = new LinkedList<>();
        nodeDetailQueue.add(new Pair(0, node));
        TreeMap<Integer, Integer> topViewMap = new TreeMap<>();
        while (!nodeDetailQueue.isEmpty()) {
            Pair nodeDetail = nodeDetailQueue.remove();
            int currentNodeLevel = nodeDetail.level;
            Node currentNode = nodeDetail.node;
            topViewMap.put(currentNodeLevel, currentNode.value);
            if (currentNode.left != null) {
                nodeDetailQueue.add(new Pair(currentNodeLevel - 1, currentNode.left));
            }
            if (currentNode.right != null) {
                nodeDetailQueue.add(new Pair(currentNodeLevel + 1, currentNode.right));
            }
        }
        for (Map.Entry<Integer, Integer> nodeSet: topViewMap.entrySet()) {
            System.out.println(nodeSet.getValue());
        }
    }
}
