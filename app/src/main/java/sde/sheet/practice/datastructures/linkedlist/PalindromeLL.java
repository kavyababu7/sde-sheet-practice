package sde.sheet.practice.datastructures.linkedlist;

public class PalindromeLL {
    public static void main(String[] args) {
        ListNode firstListNode1 = new ListNode(1, null);
        ListNode firstListNode2 = new ListNode(2, null);
        ListNode firstListNode3 = new ListNode(3, null);
        ListNode firstListNode4 = new ListNode(2, null);
        ListNode firstListNode5 = new ListNode(1, null);
        firstListNode1.next = firstListNode2;
        firstListNode1.next.next = firstListNode3;
        firstListNode1.next.next.next = firstListNode4;
        firstListNode1.next.next.next.next = firstListNode5;
//        System.out.println(isPalindromeExtraSpace(firstListNode1));
        System.out.println(isPalindromeWithoutExtraSpace(firstListNode1));
    }

    private static boolean isPalindromeWithoutExtraSpace(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        ListNode middle = findMiddle(slow, fast);
        middle.next = reverseLL(middle.next);
        middle = middle.next;
        while (middle != null) {
            if (middle.value != head.value) {
                return false;
            }
            middle = middle.next;
            head = head.next;
        }
        return true;
    }

    private static ListNode reverseLL(ListNode head) {
        ListNode prev = null;
        ListNode next;
        while (head != null) {
            next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }
    private static ListNode findMiddle(ListNode slow, ListNode fast) {
        while (fast.next != null) {
            slow =slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private static boolean isPalindromeExtraSpace(ListNode head) {
        String sequence = "";
        while (head != null) {
            sequence += head.value;
            head = head.next;
        }
        return isPalindrome(sequence, 0, sequence.length()-1);
    }

    private static boolean isPalindrome(String word, int start, int end) {
        if (end - start < 1) {
            return true;
        }
        return word.charAt(start) == word.charAt(end) && isPalindrome(word, start+1, end-1);
    }
}
