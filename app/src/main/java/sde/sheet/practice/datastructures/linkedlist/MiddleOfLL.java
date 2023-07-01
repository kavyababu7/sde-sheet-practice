package sde.sheet.practice.datastructures.linkedlist;

public class MiddleOfLL {
    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1, null);
        ListNode listNode2 = new ListNode(2, null);
        ListNode listNode3 = new ListNode(3, null);
        ListNode listNode4 = new ListNode(4, null);
        ListNode listNode5 = new ListNode(5, null);
        ListNode.build(listNode1, listNode2, listNode3, listNode4, listNode5);
        System.out.println(middleOfLL(listNode1));
    }

    private static ListNode middleOfLL(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}
