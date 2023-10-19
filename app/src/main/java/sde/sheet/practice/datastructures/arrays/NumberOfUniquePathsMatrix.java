package sde.sheet.practice.datastructures.arrays;

public class NumberOfUniquePathsMatrix {
    public static void main(String[] args) {
        int rows = 3;
        int cols= 7;
        int numberOfUniquePaths = uniquePaths(0,0,rows, cols);
        System.out.println(numberOfUniquePaths);
    }

    private static int uniquePaths(int i, int j, int rows, int cols) {
        if (i == rows-1 && j == cols-1) {
            return 1;
        }
        if (i >= rows || j >= cols) {
            return 0;
        }
        return uniquePaths(i+1, j, rows, cols) + uniquePaths(i, j+1, rows, cols);
    }
}
