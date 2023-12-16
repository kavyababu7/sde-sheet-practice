package sde.sheet.practice.datastructures.binarytree;

import java.util.LinkedList;
import java.util.Queue;

public class WidthOfBT {
    public static void main(String[] args) {
        Node root = TreeInitializor.buildTree();
        int width = width(root);
        System.out.println(width);
    }

    private static int width(Node node) {
        int width = Integer.MIN_VALUE;
        Queue<Object[]> queue = new LinkedList();
        queue.add(new Object[]{node, 0});
        while (!queue.isEmpty()) {
            int size = queue.size();
            int minVal = (int)queue.peek()[1];
            int first = 0;
            int last = 0;
            for (int i = 0; i < size; i++) {
                Object[] items = queue.remove();
                int val = (int)items[1];
                Node levelNode = (Node) items[0];
                int currentVal = val-minVal;
                if (i == 0) {
                    first = currentVal;
                } else if (i == size-1) {
                    last = currentVal;
                }
                if (levelNode.left != null) {
                    queue.add(new Object[]{levelNode.left, (currentVal*2) + 1});
                }
                if (levelNode.right != null) {
                    queue.add(new Object[]{levelNode.right, (currentVal*2) + 2});
                }
            }
            width = Math.max(width, last-first+1);
        }
        return width;
    }
}
