package sde.sheet.practice.binary;

public class CountOnes {
    public static void main(String[] args) {
        System.out.println(hammingWeight(00000000000000000000010010000000));
    }

    private static int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            if (n%2 == 1) {
                count++;
            }
            n = n >> 1;
        }
        return count;
    }
}
