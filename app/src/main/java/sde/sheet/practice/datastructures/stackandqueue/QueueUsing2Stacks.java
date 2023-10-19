package sde.sheet.practice.datastructures.stackandqueue;

import java.util.Stack;

public class QueueUsing2Stacks {
    public static void main(String[] args) {
        Queue queue = new Queue();
        queue.pop();
        queue.size();
        queue.push(1);
        queue.push(2);
        queue.size();
        queue.top();
        queue.push(3);
        queue.top();
        queue.size();
        queue.push(4);
        queue.top();
        queue.size();
        queue.pop();
        queue.pop();
        queue.pop();
        queue.pop();
    }

    static class Queue {
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();

        void push(int val) {
            System.out.println("pushing " + val);
            while (!s1.isEmpty()) {
                s2.push(s1.pop());
            }
            s1.push(val);
            while (!s2.isEmpty()) {
                s1.push(s2.pop());
            }
        }

        int pop() {
            Integer pop = -1;
            if (!s1.isEmpty()) pop = s1.pop();
            System.out.println("pop = " + pop);
            return pop;
        }

        int top() {
            Integer top = -1;
            if (!s1.isEmpty()) top = s1.peek();
            System.out.println("top = " + top);
            return top;
        }

        int size() {
            int size = s1.size();
            System.out.println("size = "+ size);
            return size;
        }
    }
}

