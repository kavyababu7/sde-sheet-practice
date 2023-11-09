package sde.sheet.practice.datastructures.stacks;

import java.util.Arrays;
import java.util.Stack;

public class LeftSmallerElement {
    public static void main(String[] args) {
//        int arr[] = {5, 7, 1, 2, 6, 0};
        int[] arr = {2, 1, 5, 6, 2, 3, 1};
        int arr2[] = leftSmallerElement(arr);
        System.out.println("The next greater elements are ");
        for (int i = 0; i < arr2.length; i++) {
            System.out.print(arr2[i] + " ");
        }
    }

    private static int[] leftSmallerElement(int[] arr) {
        int n = arr.length;
        int[] lse = new int[n];
        Arrays.fill(lse, 0);
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && arr[i] <= arr[stack.peek()]) {
                stack.pop();
            }
            if (!stack.isEmpty()) {
                lse[i] = stack.peek()+1;
            }
            stack.push(i);
        }
        return lse;
    }
}
