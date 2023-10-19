package sde.sheet.practice.datastructures.stackandqueue;

public class QueueUsingArray {

    public static void main(String[] args) {
        Queue queue = new Queue();
        queue.pop();
        queue.size();
        queue.print();
        queue.push(1);
        queue.top();
        queue.size();
        queue.print();
        queue.push(2);
        queue.top();
        queue.size();
        queue.print();
        queue.push(3);
        queue.top();
        queue.size();
        queue.print();
        queue.push(4);
        queue.top();
        queue.size();
        queue.print();
        queue.push(5);
        queue.top();
        queue.size();
        queue.print();
        queue.push(6);
        queue.top();
        queue.size();
        queue.print();
        queue.pop();
        queue.size();
        queue.print();
        queue.push(7);
        queue.top();
        queue.size();
        queue.print();
        queue.pop();
        queue.size();
        queue.print();
        queue.pop();
        queue.size();
        queue.print();
        queue.pop();
        queue.size();
        queue.print();
        queue.pop();
        queue.size();
        queue.print();
        queue.pop();
        queue.size();
        queue.print();
        queue.pop();
        queue.size();
        queue.print();
        queue.pop();
        queue.size();
        queue.print();

    }

    private static class Queue {
        int[] arr = new int[6];
        private int end = -1;
        private int start = -1;
        private int size = 0;

        void push (int val) {
            if (size == arr.length) {
                System.out.println("array full");
                return;
            }
            if (size == 0) {
                start++;
            }
            end++;
            size++;
            System.out.println("pushing " + val);
            arr[end%arr.length] = val;
        }

        int pop () {
            int value = -1;
            if (size > 0) {
                value = arr[start%arr.length];
                arr[start%arr.length] = 0;
                start++;
                size--;
            }
            System.out.println("popping " + value);
            return value;
        }

        int top() {
            int value = -1;
            if (size > 0) {
                value = arr[start%arr.length];
            }
            System.out.println("top = " + value);
            return value;
        }

        int size () {
            System.out.println("size = " + size);
            return size;
        }

        void print () {
            for (int i = 0; i < arr.length; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
        }
    }
}
