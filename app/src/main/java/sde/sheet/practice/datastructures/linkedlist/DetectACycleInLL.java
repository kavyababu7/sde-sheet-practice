package sde.sheet.practice.datastructures.linkedlist;

import java.util.HashSet;

public class DetectACycleInLL {
    public static void main(String[] args) {
        ListNode firstListNode1 = new ListNode(1, null);
        ListNode firstListNode2 = new ListNode(2, null);
        ListNode firstListNode3 = new ListNode(3, null);
        ListNode firstListNode4 = new ListNode(4, null);
        ListNode firstListNode5 = new ListNode(5, null);
        firstListNode1.next = firstListNode2;
        firstListNode1.next.next = firstListNode3;
        firstListNode1.next.next.next = firstListNode4;
        firstListNode1.next.next.next.next = firstListNode5;
        firstListNode5.next = firstListNode3;
//        System.out.println(hashingCycleCheck(firstListNode1));
        System.out.println(twoPointerCycleCheck(firstListNode1));
    }

    private static boolean twoPointerCycleCheck(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (slow==fast) {
                return true;
            }
        }
        return false;
    }

    private static boolean hashingCycleCheck(ListNode head) {
        HashSet<ListNode> listNodes = new HashSet<>();
        while (head != null) {
            if (listNodes.contains(head)) {
                return true;
            }
            listNodes.add(head);
            head = head.next;
        }
        return false;
    }
}
