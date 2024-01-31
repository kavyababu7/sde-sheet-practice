package sde.sheet.practice.datastructures.linkedlist;

public class ReverseLL {
    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1, null);
        ListNode listNode2 = new ListNode(2, null);
        ListNode listNode3 = new ListNode(3, null);
        ListNode listNode4 = new ListNode(4, null);
        ListNode listNode5 = new ListNode(5, null);
        listNode1.next = listNode2;
        listNode1.next.next = listNode3;
        listNode1.next.next.next = listNode4;
        listNode1.next.next.next.next = listNode5;
        System.out.println(listNode1);
        System.out.println(reverseLinkedList(listNode1));
    }

    private static ListNode reverseLinkedList(ListNode head) {
       if (head == null || head.next == null) {
           return head;
       }
       ListNode rest = reverseLinkedList(head.next);
       head.next.next = head;
       head.next = null;
       return rest;
    }
}
