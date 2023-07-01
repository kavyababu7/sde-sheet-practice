package sde.sheet.practice.datastructures.linkedlist;

public class InsertToEndOfLL {
    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1, null);
        ListNode listNode2 = new ListNode(2, null);
        ListNode listNode3 = new ListNode(3, null);
        ListNode listNode4 = new ListNode(4, null);
        ListNode.build(listNode1, listNode2, listNode3, listNode4);
        //O(n)
        insertToEnd(listNode1, 10);
        insertToEnd(listNode1, 10);
    }

    private static void insertToEnd(ListNode head, int toBeInserted) {
        //find end
        while (head.next != null) {
            head = head.next;
        }
        ListNode newNode = new ListNode(toBeInserted, null);
        head.next = newNode;
    }


}
