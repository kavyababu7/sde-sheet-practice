package sde.sheet.practice.datastructures.binarytree;

public class LCA {
    public static void main(String[] args) {
        Node tree = TreeInitializor.buildTree();
        Node x = tree.left.left;
        Node y = tree.left.right;
        System.out.println(lca(tree, x, y));
    }

    private static Node lca(Node root, Node x, Node y) {
        if (root == null || x.equals(root) || y.equals(root)) {
            return root;
        }

        Node leftSubTree = lca(root.left, x, y);
        Node rightSubTree = lca(root.right, x, y);

        if (leftSubTree == null) {
            return rightSubTree;
        }
        if (rightSubTree == null) {
            return leftSubTree;
        }
        // both left and right are not null, so return the parent
        return root;
    }
}
