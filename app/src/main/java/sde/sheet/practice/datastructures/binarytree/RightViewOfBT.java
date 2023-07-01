package sde.sheet.practice.datastructures.binarytree;

import java.util.ArrayList;
import java.util.List;

public class RightViewOfBT {
    public static void main(String[] args) {
        Node tree = TreeInitializor.buildTree();
        List<Integer> nodes = new ArrayList<>();
        rightViewOfTree(tree, 0, nodes);
        System.out.println(nodes);
    }

    private static void rightViewOfTree(Node node, int level, List<Integer> nodes) {
        if (node == null) {
            return;
        }
        if (level == nodes.size()) {
            nodes.add(node.value);
        }
        rightViewOfTree(node.right, level+1, nodes);
        rightViewOfTree(node.left, level+1, nodes);
    }
}
