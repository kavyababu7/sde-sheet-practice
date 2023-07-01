package sde.sheet.practice.datastructures.binarytree;

public class TreeInitializor {
    /**
            1
          /   \
         2     3
        / \   /  \
       4   5  6   7
     */
    public static Node buildTree() {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        Node node7 = new Node(7);
        node1.left = node2;
        node1.right = node3;
        node1.left.left = node4;
        node1.left.right = node5;
        node1.right.left = node6;
        node1.right.right = node7;
        return node1;
    }
}
