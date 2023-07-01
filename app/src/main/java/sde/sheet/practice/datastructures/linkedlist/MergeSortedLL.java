package sde.sheet.practice.datastructures.linkedlist;

public class MergeSortedLL {
    public static void main(String[] args) {
        ListNode head1 = new ListNode(1, null);
        ListNode.build(head1, new ListNode(3, null), new ListNode(5, null), new ListNode(7, null));
        ListNode head2 = new ListNode(2, null);
        ListNode.build(head2, new ListNode(4, null), new ListNode(6, null), new ListNode(8, null));
        //System.out.println(merge(head2, head1));
        System.out.println(mergeInPlace(head2, head1));
    }

    private static ListNode mergeInPlace(ListNode head1, ListNode head2) {
        if (head1 == null) {
            return head2;
        }
        if (head2 == null) {
            return head1;
        }
        //swap to make h1 as smaller
        if (head1.value > head2.value) {
            ListNode temp = head1;
            head1 = head2;
            head2 = temp;
        }
        ListNode result = head1;
        while (head1 != null && head2 != null) {
            ListNode temp = null;
            while (head1 != null && head1.value < head2.value) {
                temp = head1;
                head1 = head1.next;
            }
            temp.next = head2;

            //swap
            ListNode dummy = head1;
            head1 = head2;
            head2 = dummy;
        }
        return result;
    }

    private static void swap(ListNode head1, ListNode head2) {
        ListNode temp = head1;
        head1 = head2;
        head2 = temp;
    }

    private static ListNode merge(ListNode head1, ListNode head2) {
        ListNode dummyNode = new ListNode(0, null);
        if (head1 == null) {
            return head2;
        }
        if (head2 == null) {
            return head1;
        }
        ListNode resultHead = dummyNode;
        while (head1 != null && head2 != null) {
            if (head1.value <= head2.value) {
                dummyNode.next = head1;
                head1 = head1.next;
            } else {
                dummyNode.next = head2;
                head2 = head2.next;
            }
            dummyNode = dummyNode.next;
        }
        if (head1 != null) {
            dummyNode.next = head1;
        }
        if (head2 != null) {
            dummyNode.next = head2;
        }

        return resultHead;
    }
}
