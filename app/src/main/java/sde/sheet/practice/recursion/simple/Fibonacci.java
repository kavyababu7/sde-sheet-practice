package sde.sheet.practice.recursion.simple;

public class Fibonacci {
    public static void main(String[] args) {
       int n = fibonacciByRecursion(6);
        System.out.println(n);
    }

    private static int fibonacciByRecursion(int num) {
        if (num <= 1 ) {
            return 0;
        }
        if ( num == 2) {
            return 1;
        }

        return fibonacciByRecursion(num-1) + fibonacciByRecursion(num - 2);
    }
}
