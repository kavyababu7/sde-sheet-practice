package sde.sheet.practice.datastructures.linkedlist;

public class ReverseInGroupOfK {


    public static void main(String[] args) {

        Node listNode1 = new Node(1, null);
        Node listNode2 = new Node(2, null);
        Node listNode3 = new Node(3, null);
        Node listNode4 = new Node(4, null);
        Node listNode5 = new Node(5, null);
        Node listNode6 = new Node(6, null);
        Node listNode7 = new Node(7, null);
        Node listNode8 = new Node(8, null);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        listNode5.next = listNode6;
        listNode6.next = listNode7;
        listNode7.next = listNode8;
//        print(reverseInGroupOfK(listNode1, 3));
        print(reverseKGroup(listNode1, 3));
    }

    /**
     * Definition for singly-linked list.
     * public class Node {
     * int val;
     * Node next;
     * Node() {}
     * Node(int val) { this.val = val; }
     * Node(int val, Node next) { this.val = val; this.next = next; }
     * }
     */

    public static Node reverseKGroup(Node head, int k) {
        Node dummy = new Node(0, head);
        Node groupPrevious = dummy;
        while (true) {
            Node kth = kth(groupPrevious, k);
            if (kth == null) break;
            Node groupNext = kth.next;
            Node curr = groupPrevious.next;
            Node prev = kth.next;
            while (curr != null) {
                Node temp = curr.next;
                curr.next = prev;
                prev = curr;
                curr = temp;
            }
            Node temp = groupPrevious.next;
            groupPrevious.next = kth;
            groupPrevious = temp;
        }
        return dummy.next;
    }

    private static Node kth(Node head, int k) {
        while (head != null && k > 0) {
            head = head.next;
            k--;
        }
        return head;
    }


    private static Node reverseInGroupOfK(Node head, int K) {
        Node dummy = new Node(0, null);
        dummy.next = head;
        Node prev = dummy;
        Node curr;
        Node next;
        int length = lengthOfLL(head);
        while (length >= K) {
            curr = prev.next;
            next = curr.next;
            for (int i = 1; i < K; i++) {
                curr.next = next.next;
                next.next = prev.next;
                prev.next = next;
                next = curr.next;
            }
            prev = curr;
            length -= K;
        }
        return dummy.next;
    }

    static int lengthOfLL(Node head) {
        int len = 0;
        while (head != null) {
            len++;
            head = head.next;
        }
        return len;
    }

    static void print(Node node) {
        while (node != null) {
            System.out.printf(node.value + " ");
            node = node.next;
        }
    }
}

class Node {
    int value;
    Node next;

    Node(int value, Node node) {
        this.value = value;
        this.next = node;
    }
}
