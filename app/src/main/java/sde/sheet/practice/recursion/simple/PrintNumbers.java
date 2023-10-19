package sde.sheet.practice.recursion.simple;

public class PrintNumbers {
    public static void main(String[] args) {
        printByRecursion(10);
    }

    private static void printByRecursion(int num) {
        if (num < 1) {
            return;
        }
        printByRecursion(num-1);
        System.out.println(num);
    }
}
