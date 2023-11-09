package sde.sheet.practice.datastructures.binarytree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class LeftViewOfBT {
    public static void main(String[] args) {
        Node tree = TreeInitializor.buildTree();
        List<Integer> nodes = new ArrayList<>();
        leftViewOfTree(tree, 0, nodes);
        tree = TreeInitializor.buildTree();
        leftViewOfTreeIterative(tree);
        System.out.println(nodes);
    }

    private static void leftViewOfTree(Node node, int level, List<Integer> nodes) {
        if (node == null) {
            return;
        }
        if (level == nodes.size()) {
            nodes.add(node.value);
        }
        leftViewOfTree(node.left, level+1, nodes);
        leftViewOfTree(node.right, level+1, nodes);
    }

    private static List<Integer> leftViewOfTreeIterative(Node node) {
        List<Integer> lefties = new ArrayList<>();
        Queue<ViewPair> queue = new LinkedList<>();
        queue.add(new ViewPair(node, 0));
        while (!queue.isEmpty()) {
            ViewPair currentNodeViewPair = queue.remove();
            int level = currentNodeViewPair.level;
            if (lefties.size() == level) {
                lefties.add(currentNodeViewPair.node.value);
            }
            if (currentNodeViewPair.node.left != null) {
                queue.add(new ViewPair(currentNodeViewPair.node.left, level + 1));
            }
            if (currentNodeViewPair.node.right != null) {
                queue.add(new ViewPair(currentNodeViewPair.node.right, level + 1));
            }
        }
        return lefties;
    }
}

class ViewPair {
    Node node;
    int level;

    public ViewPair(Node node, int level) {
        this.node = node;
        this.level = level;
    }
}
