package sde.sheet.practice.datastructures.linkedlist;

public class DeleteNodeLL {
    public static void main (String[] args) {
        ListNode listNode1 = new ListNode(1, null);
        ListNode listNode2 = new ListNode(2, null);
        ListNode listNode3 = new ListNode(3, null);
        ListNode listNode4 = new ListNode(4, null);
        ListNode listNode5 = new ListNode(5, null);
        ListNode.build(listNode1, listNode2, listNode3, listNode4, listNode5);
        System.out.println(deleteNode(3, listNode1));
    }

    private static ListNode deleteNode(int node, ListNode head) {
        ListNode dummyNode = head;
        ListNode location = locateNode(node, head);
        if (location == null) {
            return head;
        }
        location.value=location.next.value;
        location.next = location.next.next;
        return dummyNode;
    }

    private static ListNode locateNode(int node, ListNode head) {
        while (head != null) {
            if (head.value == node) {
                return head;
            }
            head = head.next;
        }
        return null;
    }
}
