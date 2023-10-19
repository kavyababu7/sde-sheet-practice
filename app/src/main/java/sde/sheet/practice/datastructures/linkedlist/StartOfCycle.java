package sde.sheet.practice.datastructures.linkedlist;

public class StartOfCycle {
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
        ListNode node = detectCycleStart(firstListNode1);
        System.out.println(node.value);
    }

    private static ListNode detectCycleStart(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        ListNode entry = head;
        while (fast.next != null && fast.next.next!=null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast.equals(slow)) {
                while (slow != entry) {
                    slow = slow.next;
                    entry = entry.next;
                }
                return entry;
            }
        }
        return null;
    }
}
