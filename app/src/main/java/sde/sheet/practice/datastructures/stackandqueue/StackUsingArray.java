package sde.sheet.practice.datastructures.stackandqueue;

public class StackUsingArray {

    public static void main(String[] args) {
        Stack stack = new Stack();
        System.out.println(stack.pop());
        System.out.println("size = "+stack.size());
        stack.push(1);
        System.out.println(stack.top());
        System.out.println("size = "+stack.size());
        stack.push(2);
        System.out.println(stack.top());
        System.out.println("size = "+stack.size());
        stack.push(3);
        System.out.println(stack.top());
        System.out.println("size = "+stack.size());
        stack.push(4);
        System.out.println(stack.top());
        System.out.println("size = "+stack.size());
        stack.push(5);
        System.out.println(stack.top());
        System.out.println("size = "+stack.size());
        stack.push(6);
        System.out.println(stack.top());
        System.out.println("size = "+stack.size());
        stack.push(7);
        System.out.println(stack.top());
        System.out.println("size = "+stack.size());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println("size = "+stack.size());

    }

    private static class Stack {
        int[] arr = new int[6];
        private int end = -1;

        void push (int val) {
            if (end == arr.length - 1) {
                System.out.println("array full");
                return;
            }
            end++;
            arr[end] = val;
        }

        int pop () {
            int value = -1;
            if (end > -1){
                value = arr[end];
                end--;
            }
            System.out.println("popping " + value);
            return value;
        }

        int top() {
            int value = -1;
            if (end > -1) {
                value = arr[end];
            }
            System.out.println("top " + value);
            return value;
        }

        int size () {
            return end+1;
        }
    }
}
