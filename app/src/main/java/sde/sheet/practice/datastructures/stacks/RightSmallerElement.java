package sde.sheet.practice.datastructures.stacks;

import java.util.Arrays;
import java.util.Stack;

public class RightSmallerElement {
    public static void main(String[] args) {
//        int arr[] = {5, 7, 1, 2, 6, 0};
        int[] arr = {2, 1, 5, 6, 2, 3, 1};
        int arr2[] = rightSmallerElement(arr);
        System.out.println("The next greater elements are ");
        for (int i = 0; i < arr2.length; i++) {
            System.out.print(arr2[i] + " ");
        }
    }

    private static int[] rightSmallerElement(int[] heights) {

        int n = heights.length;
    Stack<Integer> rightStack = new Stack();
    Stack<Integer> leftStack = new Stack();
    int[] lse = new int[n];
        Arrays.fill(lse, 0);
    int[] rse = new int[n];
        Arrays.fill(rse, n-1);

        for(int i = 0; i < heights.length; i++) {
            while (!rightStack.isEmpty() && heights[n - i - 1] <= heights[rightStack.peek()]) {
                rightStack.pop();
            }
            while (!leftStack.isEmpty() && heights[i] <= heights[leftStack.peek()]) {
                leftStack.pop();
            }
            if (!rightStack.isEmpty()) {
                rse[n - i - 1] = rightStack.peek() - 1;
            }
            if (!leftStack.isEmpty()) {
                lse[i] = leftStack.peek() + 1;
            }
            rightStack.push(n - i - 1);
            leftStack.push(i);
        }
        return rse;
    }

}
