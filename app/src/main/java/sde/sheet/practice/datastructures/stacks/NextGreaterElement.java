package sde.sheet.practice.datastructures.stacks;

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElement {
    public static void main(String[] args) {
        int arr[] = {5, 7, 1, 2, 6, 0};

        int arr2[] = nextGreaterElements(arr);
        System.out.println("The next greater elements are ");
        for (int i = 0; i < arr2.length; i++) {
            System.out.print(arr2[i] + " ");
        }
    }

    private static int[] nextGreaterElements(int[] arr) {
        int n = arr.length;
        int[] nge=new int[arr.length];
        Arrays.fill(nge,-1);
        Stack<Integer> stack = new Stack<>();
        for (int i = 2*n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() <= arr[i%n]) {
                stack.pop();
            }
            if (!stack.isEmpty()) {
                nge[i%n] = stack.peek();
            }
            stack.push(arr[i%n]);
        }
        return nge;
    }
}
