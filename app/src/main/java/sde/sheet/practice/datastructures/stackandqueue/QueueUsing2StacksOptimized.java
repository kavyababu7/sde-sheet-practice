package sde.sheet.practice.datastructures.stackandqueue;

import java.util.Stack;

public class QueueUsing2StacksOptimized {
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
            s1.push(val);

        }

        int pop() {
            Integer pop = -1;
            if (s2.isEmpty()) {
                while (!s1.isEmpty()) {
                    s2.push(s1.pop());
                }
            }
            if (!s2.isEmpty()) {
                pop = s2.pop();
            }
            System.out.println("popped " + pop);
            return pop;
        }

        int top() {
            Integer top = -1;
            if (s2.isEmpty()) {
                while (!s1.isEmpty()) {
                    s2.push(s1.pop());
                }
            }
            if (!s2.isEmpty()) top = s2.peek();
            System.out.println("top " + top);
            return top;
        }

        int size() {
            int size = s1.size() + s2.size();
            System.out.println("size = " + size);
            return size;
        }
    }
}

