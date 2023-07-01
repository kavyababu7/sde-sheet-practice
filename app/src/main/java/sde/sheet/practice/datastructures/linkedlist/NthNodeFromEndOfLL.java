package sde.sheet.practice.datastructures.linkedlist;

public class NthNodeFromEndOfLL {
    public static void main(String[] args) {
        int n = 2;
        ListNode listNode1 = new ListNode(1, null);
        ListNode listNode2 = new ListNode(2, null);
        ListNode listNode3 = new ListNode(3, null);
        ListNode listNode4 = new ListNode(4, null);
        ListNode listNode5 = new ListNode(5, null);
        ListNode.build(listNode1, listNode2, listNode3, listNode4, listNode5);
        System.out.println(nthFromEndOfLL(listNode1, n));
    }

    private static ListNode nthFromEndOfLL(ListNode head, int n) {
        ListNode slow = head;
        ListNode fast = head;
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
}
