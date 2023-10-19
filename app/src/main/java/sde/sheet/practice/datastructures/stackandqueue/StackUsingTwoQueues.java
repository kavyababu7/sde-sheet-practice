package sde.sheet.practice.datastructures.stackandqueue;

import java.util.LinkedList;
import java.util.Queue;

public class StackUsingTwoQueues {
    public static void main(String[] args) {
        Stack stack = new Stack();
        stack.pop();
        stack.size();
        stack.push(1);
        stack.push(2);
        stack.size();
        stack.top();
        stack.push(3);
        stack.top();
        stack.size();
        stack.push(4);
        stack.top();
        stack.size();
        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();

    }

    static class Stack {
        private Queue<Integer> q1 = new LinkedList<>();
        private Queue<Integer> q2 = new LinkedList<>();

        void push(int val) {
            System.out.println("pushing " + val);
            q2.add(val);
            while (!q1.isEmpty()) {
                q2.add(q1.remove());
            }
            Queue temp = q1;
            q1 = q2;
            q2 = temp;
        }

        int pop() {
            Integer pop = -1;
            if (!q1.isEmpty()) pop = q1.remove();
            System.out.println("pop = " + pop);
            return pop;
        }

        int top() {
            Integer top = -1;
            if (!q1.isEmpty()) top = q1.peek();
            System.out.println("top = " + top);
            return top;
        }

        int size() {
            int size = q1.size();
            System.out.println("size = "+ size);
            return size;
        }
    }
}
