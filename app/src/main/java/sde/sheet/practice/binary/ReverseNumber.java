package sde.sheet.practice.binary;

public class ReverseNumber {
    public static void main(String[] args) {
        System.out.println(reverse(1534236469));
    }

    private static int reverse(int x) {
        int reverse = 0;

        while ( x != 0) {
            int pop = x % 10;
            System.out.println("pop="+pop);
            System.out.println("reverse="+reverse);
            if(reverse >= Integer.MAX_VALUE/10 && pop > 7 ) {
                return 0;
            } else if(reverse <= Integer.MIN_VALUE/10 && pop < -8 ) {//-2147483648
                return 0;
            }
            int count = 0;
            count = pop%2 == 1 ? count + 1 : 0;
            reverse = (reverse * 10) + pop;
            x = x / 10;
        }
        return reverse;
    }
}
