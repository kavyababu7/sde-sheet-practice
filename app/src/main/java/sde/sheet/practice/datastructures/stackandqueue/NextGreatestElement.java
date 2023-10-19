package sde.sheet.practice.datastructures.stackandqueue;

import java.util.Arrays;
import java.util.Stack;

public class NextGreatestElement {
    public static void main(String[] args) {
        int[] arr = {3, 10, 4, 2, 1, 2, 6, 1, 7, 2, 9};
        int n = arr.length;
        int[] nge = new int[n];
        Stack<Integer> stack = new Stack<>();
        for (int i = (2 * n) - 1; i >= 0; i--) {
            int element = arr[i%n];
            while (!stack.isEmpty() && stack.peek() <= element) {
                stack.pop();
            }
            if (i < n) {
                if (stack.isEmpty()) {
                    nge[i] = -1;
                } else {
                    nge[i] = stack.peek();
                }
            }
            stack.push(element);
        }
        System.out.println(Arrays.toString(nge));
    }
}
