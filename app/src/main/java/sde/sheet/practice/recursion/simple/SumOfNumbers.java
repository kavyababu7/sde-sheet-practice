package sde.sheet.practice.recursion.simple;

public class SumOfNumbers {
    public static void main(String[] args) {
        int sum = sumByRecursion(10);
        System.out.println(sum);
    }

    private static int sumByRecursion(int num) {
        if (num < 1) {
            return 0;
        }
        return num + sumByRecursion(num-1);
    }


}
