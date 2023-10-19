package sde.sheet.practice.datastructures.arrays;

public class PascalTriangle {
    public static void main(String[] args) {
        int row = 6;
        int col = 1;
        System.out.println(nthItemFromPascal(row, col));
        nthRowOfPascal(row);
    }

    private static void nthRowOfPascal(int row) {
        int result = 1;
        for (int i = 1; i <= row; i++) {
            System.out.print(result + " ");
            result *= (row-i);
            result /= i;
        }
    }

    private static int nthItemFromPascal(int row, int col) {
        int result = 1;
        for (int i = 1; i < col; i++) {
            result *= (row - i);
            result /= (i);
        }
        return result;
    }
}
