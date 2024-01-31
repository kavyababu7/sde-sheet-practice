package sde.sheet.practice.datastructures.stackandqueue;

import java.util.Stack;

public class MaxOfMinOfEveryWindow {
    public static void main(String[] args) {
        int[] arr = {1,3,-1,-3,5,3,6,7};
        System.out.println(maxSlidingWindow(arr, 3));
    }

    public static int maxSlidingWindow(int[] nums, int k) {
        Stack<Integer> stack = new Stack();
        int len = nums.length;
        int[] pse = new int[len];
        int[] nse = new int[len];
        for (int i = 0; i < len; i++) {
            while (!stack.isEmpty() && nums[i] <= nums[stack.peek()]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                pse[i] = -1;
            } else {
                pse[i] = stack.peek();
            }
            stack.push(i);
        }
        while (!stack.isEmpty()) {
            stack.pop();
        }
        for (int i = len-1; i >= 0; i--) {
            while (!stack.isEmpty() && nums[i] <= nums[stack.peek()]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                nse[i] = len;
            } else {
                nse[i] = stack.peek();
            }
            stack.push(i);
        }
        int[] ans = new int[len];
        for (int i = 0; i < len; i++) {
            int length = nse[i] - pse[i] - 1;

            // Update the answer
            ans[length - 1] = Math.max(ans[length - 1], nums[i]);
        }

        return ans[2];

    }
}
