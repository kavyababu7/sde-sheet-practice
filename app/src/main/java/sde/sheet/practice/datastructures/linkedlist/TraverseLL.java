package sde.sheet.practice.datastructures.linkedlist;

public class TraverseLL {
    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1, null);
        ListNode listNode2 = new ListNode(2, null);
        ListNode listNode3 = new ListNode(3, null);
        ListNode listNode4 = new ListNode(4, null);
        ListNode.build(listNode1, listNode2, listNode3, listNode4);
        System.out.println("nodes = " + countLL(listNode1));
    }

    private static int countLL(ListNode head) {
        int count = 0;
        while (head != null) {
            count++;
            head = head.next;
        }
        return count;
    }
}
