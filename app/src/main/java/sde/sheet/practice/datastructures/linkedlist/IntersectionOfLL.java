package sde.sheet.practice.datastructures.linkedlist;

import java.util.HashSet;
import java.util.Set;

public class IntersectionOfLL {
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

        ListNode secondListNode1 = new ListNode(2, null);
        ListNode secondListNode2 = new ListNode(4, null);
        ListNode secondListNode3 = new ListNode(5, null);
        secondListNode1.next = secondListNode2;
        secondListNode1.next.next = secondListNode3;

//        System.out.println(bruteForceIntersectionOf(firstListNode1, secondListNode1));
//        System.out.println(hashingIntersectionOfLL(firstListNode1, secondListNode1));
        System.out.println(diffInLengthIntersectionOfLL(firstListNode1, secondListNode1));
    }

    private static ListNode bruteForceIntersectionOf(ListNode firstListNodeHead, ListNode secondListNodeHead) {
        while (firstListNodeHead != null) {
            ListNode temp = secondListNodeHead;
            while (temp != null) {
                if (temp.equals(firstListNodeHead)) {
                    return firstListNodeHead;
                }
                temp = temp.next;
            }
            firstListNodeHead = firstListNodeHead.next;
        }
       return null;
    }

    private static ListNode hashingIntersectionOfLL(ListNode firstHead, ListNode secondHead) {
        Set<ListNode> headNodeSet = new HashSet<>();
        while (firstHead != null) {
            headNodeSet.add(firstHead);
            firstHead = firstHead.next;
        }
        while (secondHead != null) {
            if (headNodeSet.contains(secondHead)) {
                return secondHead;
            }
            secondHead = secondHead.next;
        }
        return null;
    }

    private static ListNode diffInLengthIntersectionOfLL(ListNode firstHead, ListNode secondHead) {
        //traverse to find diff in length
        int l1 = 0;
        int l2 = 0;
        ListNode temp1 = firstHead;
        ListNode temp2 = secondHead;
        int diff = getDifference(firstHead, secondHead, l1, l2);
        if (diff > 0) { //first LL bigger
            while (diff-- > 0) {
                temp1 = temp1.next;
            }
        } else { //second LL bigger
            while (diff++ < 0) {
                temp2 = temp2.next;
            }
        }
        while (temp1 != null) {
            if (temp1.equals(temp2)) {
                return temp1;
            }
            temp1 = temp1.next;
            temp2 = temp2.next;
        }
        return null;
    }

    private static int getDifference(ListNode firstHead, ListNode secondHead, int l1, int l2) {
        while (firstHead != null || secondHead != null) {
            if (firstHead != null) {
                l1++;
                firstHead = firstHead.next;
            }
            if (secondHead != null) {
                l2++;
                secondHead = secondHead.next;
            }
        }
        int diff = l1 - l2;
        return diff;
    }
}
