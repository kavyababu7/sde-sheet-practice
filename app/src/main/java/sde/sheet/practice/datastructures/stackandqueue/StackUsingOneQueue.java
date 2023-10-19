package sde.sheet.practice.datastructures.stackandqueue;

import java.util.LinkedList;
import java.util.Queue;

public class StackUsingOneQueue {
    public static void main(String[] args) {
        StackUsingOneQueue.Stack stack = new StackUsingOneQueue.Stack();
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

        void push(int val) {
            System.out.println("pushing " + val);
            q1.add(val);
            for (int i = 0; i < q1.size() - 1; i++) {
                Integer remove = q1.remove();
                q1.add(remove);
            }
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
