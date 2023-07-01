package sde.sheet.practice.datastructures.binarytree;

import java.util.ArrayList;
import java.util.List;

public class TraceANodePath {
    public static void main(String[] args) {
        Node node = TreeInitializor.buildTree();
        List<Integer> path = new ArrayList<>();
        traceTheNode(5, node, path);
        System.out.println(path);
    }

    private static boolean traceTheNode(int item, Node node, List<Integer> path) {
        if (node == null) {
            return false;
        }
        path.add(node.value);
        if (node.value == item) {
            return true;
        }

        if (traceTheNode(item, node.left, path) || traceTheNode(item, node.right, path)) {
            return true;
        }

        path.remove(path.size()-1);
        return false;
    }
}
