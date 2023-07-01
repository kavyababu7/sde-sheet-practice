package sde.sheet.practice.datastructures.binarytree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

public class VerticalTraversalOfBT {
    public static void main(String[] args) {
        Node tree = TreeInitializor.buildTree();
        verticalTraversal(tree);
    }

    private static void verticalTraversal(Node node) {
        Queue<Pair> nodeDetailQueue = new LinkedList<>();
        nodeDetailQueue.add(new Pair(0, node));
        TreeMap<Integer, List<Integer>> verticalViewMap = new TreeMap<>();
        while (!nodeDetailQueue.isEmpty()) {
            Pair nodeDetail = nodeDetailQueue.remove();
            int currentNodeLevel = nodeDetail.level;
            Node currentNode = nodeDetail.node;
            if (verticalViewMap.containsKey(currentNodeLevel)) {
                verticalViewMap.get(currentNodeLevel).add(currentNode.value);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(currentNode.value);
                verticalViewMap.put(currentNodeLevel, list);
            }
            if (currentNode.left != null) {
                nodeDetailQueue.add(new Pair(currentNodeLevel - 1, currentNode.left));
            }
            if (currentNode.right != null) {
                nodeDetailQueue.add(new Pair(currentNodeLevel + 1, currentNode.right));
            }
        }
        for (Map.Entry<Integer, List<Integer>> nodeSet: verticalViewMap.entrySet()) {
            System.out.println(nodeSet.getValue());
        }
    }
}
