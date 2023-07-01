package sde.sheet.practice.datastructures.binarytree;

public class IsIdenticalTree {
    public static void main(String[] args) {
        Node node1 = TreeInitializor.buildTree();
        Node node2 = TreeInitializor.buildTree();
        Boolean areIdentical = isIdentical(node1, node2);
        System.out.println(areIdentical);
    }

    private static Boolean isIdentical(Node node1, Node node2) {
        if (node1 == null && node2 == null) {
            return true;
        } else if (node1 == null || node2 == null) {
            return false;
        }
        return node1.value == node2.value && isIdentical(node1.left, node2.left) && isIdentical(node1.right, node2.right);
    }
}
