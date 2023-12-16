package sde.sheet.practice.datastructures.arrays;

public class Rotate {
    public static void main(String[] args) {
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        rotate(matrix);
        System.out.println(matrix);
    }

    private static void rotate(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] tMatrix = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                tMatrix[j][i] = matrix[i][j];
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = tMatrix[i][n-j-1];
            }
        }

    }
}
