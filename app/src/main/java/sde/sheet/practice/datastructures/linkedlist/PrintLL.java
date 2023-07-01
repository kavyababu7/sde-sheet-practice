package sde.sheet.practice.datastructures.linkedlist;

public class PrintLL {
    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(10, null);
        ListNode listNode2 = new ListNode(4, null);
        ListNode listNode3 = new ListNode(20, null);
        ListNode listNode4 = new ListNode(8, null);
        ListNode.build(listNode1, listNode2, listNode3, listNode4);
        printLL(listNode1);
    }

    public static void printLL(ListNode head) {
        while (null != head) {
            System.out.println(head.value);
            head = head.next;
        }
    }
}
