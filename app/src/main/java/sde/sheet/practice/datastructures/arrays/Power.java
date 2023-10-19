package sde.sheet.practice.datastructures.arrays;

public class Power {
    public static void main(String[] args) {
        int x = 2;
        int n = 10;
        System.out.println(powBrute(x,n));
        System.out.println(powBinaryExponential(x,n));
    }

    private static double powBinaryExponential(int x, int n) {
        double result = 1D;
        while (n > 0) {
            if (n%2 == 0) {
                x *= x;
                n = n/2;
            } else {
                result *= x;
                n = n-1;
            }
        }
        return result;
    }

    private static double powBrute(int x, int n) {
        double result = 1D;
        int i = 0;
        while (i < n) {
            result *= x;
            i++;
        }
        return result;
    }
}
