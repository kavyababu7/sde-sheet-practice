package sde.sheet.practice.datastructures.arrays;

public class Search2DMatrix {
    public static void main(String[] args) {
        int[][] matrix = {{1, 3, 5, 7},
                          {10, 11, 16, 20},
                          {23, 30, 34, 60}};
        int target = 7;
        boolean foundByBruteForce = brute(matrix, target);
        System.out.println(foundByBruteForce);
        boolean foundByBinarySearch = bs(matrix, target);
        System.out.println(foundByBinarySearch);
    }

    private static boolean bs(int[][] matrix, int target) {
        int start = 0;
        int rows = matrix.length;
        int cols = matrix[0].length;
        int end = rows * cols - 1;
        while (start <= end) {
            int mid = start + (end-start)/2;
            int midElement = matrix[mid / cols][mid % cols];
            if (midElement == target) {
                return true;
            } else if (target > midElement) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return false;
    }

    private static boolean brute(int[][] matrix, int target) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == target) {
                    return true;
                }
            }
        }
        return false;
    }
}
