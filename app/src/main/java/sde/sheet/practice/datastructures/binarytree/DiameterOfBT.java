package sde.sheet.practice.datastructures.binarytree;


public class DiameterOfBT {
    public static void main(String[] args) {
        Node node = TreeInitializor.buildTree();
//        System.out.println(diameterBruteForce(node));
        int[] dia = {Integer.MIN_VALUE};
        diameter(node, dia);
        System.out.println(dia[0]);
    }

    private static int diameterBruteForce(Node node) {
        if (node == null){
            return 0;
        }
        int leftHeight = height(node.left);
        int rightHeight = height(node.right);

        int leftDia = diameterBruteForce(node.left);
        int rightDia = diameterBruteForce(node.right);

        return Math.max(leftHeight + rightHeight, Math.max(leftDia, rightDia));
    }

    private static int diameter (Node node, int[] dia) {
        if (node == null) {
            return 0;
        }
        int leftHeight = diameter(node.left, dia);
        int rightHeight = diameter(node.right, dia);
        dia[0] = Math.max(dia[0], leftHeight+rightHeight);
        return 1 + Math.max(leftHeight, rightHeight);
    }

    private static int height(Node node) {
        if (node == null)
            return 0;
        return 1 + Math.max(height(node.right), height(node.left)) ;
    }
}
