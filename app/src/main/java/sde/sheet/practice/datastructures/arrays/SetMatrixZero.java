package sde.sheet.practice.datastructures.arrays;

import java.util.Arrays;

public class SetMatrixZero {
    public static void main(String[] args) {
        int[][] matrix = {{1,1,1},{1,0,1},{1,1,1}};

        //O(n^3)
        //brute(matrix);

        System.out.println(Arrays.deepToString(matrix));

        optimized(matrix);

        System.out.println(Arrays.deepToString(matrix));
    }

    private static void brute(int[][] matrix) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (matrix[i][j] == 0) {
                    for (int k = 0; k < 3; k++) {
                        matrix[i][k] = -1;
                        matrix[k][j] = -1;
                    }
                }
            }
        }
    }

    private static void optimized(int[][] matrix) {
        int[] rows = new int[3];
        Arrays.fill(rows, -1);
        int[] cols = new int[3];
        Arrays.fill(cols, -1);
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (matrix[i][j] == 0) {
                    rows[i] = 0;
                    cols[j] = 0;
                }
            }
        }
        System.out.println(Arrays.toString(rows));
        System.out.println(Arrays.toString(cols));
        for (int i = 0; i < rows.length; i++) {
            if (rows[i] == 0) {
                for (int j = 0; j < 3; j++) {
                    matrix[i][j] = 0;
                }
            }
            if (cols[i] == 0) {
                for (int j = 0; j < 3; j++) {
                    matrix[j][i] = 0;
                }
            }
        }
    }
}
