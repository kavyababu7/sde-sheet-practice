package sde.sheet.practice.datastructures.binarytree;

import java.util.ArrayList;
import java.util.List;

public class LeftViewOfBT {
    public static void main(String[] args) {
        Node tree = TreeInitializor.buildTree();
        List<Integer> nodes = new ArrayList<>();
        leftViewOfTree(tree, 0, nodes);
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
}
