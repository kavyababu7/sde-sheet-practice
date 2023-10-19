package sde.sheet.practice.datastructures.linkedlist;

public class RotateLLByK {

    public static void main(String[] args) {

        int K = 3;
        ListNode listNode1 = new ListNode(1, null);
        ListNode listNode2 = new ListNode(2, null);
        ListNode listNode3 = new ListNode(3, null);
        ListNode listNode4 = new ListNode(4, null);
        ListNode listNode5 = new ListNode(5, null);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        ListNode node = rotateByKBrute(listNode1, K);
        PrintLL.printLL(node);
    }

    private static ListNode rotateByKBrute(ListNode head, int k) {
        if (head == null || head.next == null) return head;
        for (int i = 0; i < k; i++) {
            ListNode temp = head;
            while (temp.next.next != null) {
                temp = temp.next;
            }
            ListNode end = temp.next;
            end.next = head;
            temp.next = null;
            head = end;
        }
        return head;
    }
}


