package sde.sheet.practice.datastructures.linkedlist;

public class SumAsLinkedList {
    public static void main(String[] args) {
        ListNode firstNumber1 = new ListNode(2, null);
        ListNode firstNumber2 = new ListNode(4, null);
        ListNode firstNumber3 = new ListNode(3, null);
        ListNode.build(firstNumber1, firstNumber2, firstNumber3);
        ListNode secondNumber1 = new ListNode(5, null);
        ListNode secondNumber2 = new ListNode(6, null);
        ListNode secondNumber3 = new ListNode(7, null);
        ListNode secondNumber4 = new ListNode(9, null);
        ListNode.build(secondNumber1, secondNumber2, secondNumber3, secondNumber4);
        System.out.println(sumAsLL(firstNumber1, secondNumber1));
    }

    private static ListNode sumAsLL(ListNode firstNumber1, ListNode secondNumber1) {
        int carry = 0;
        ListNode dummyNode = new ListNode(0, null);
        ListNode temp = dummyNode;
        while (firstNumber1 != null || secondNumber1 != null || carry > 0) {
            int sum = carry;
            if (firstNumber1 != null) {
                sum += firstNumber1.value;
                firstNumber1 = firstNumber1.next;
            }
            if (secondNumber1 != null) {
                sum += secondNumber1.value;
                secondNumber1 = secondNumber1.next;
            }

            carry = sum / 10;

            temp.next = new ListNode(sum % 10, null);
            temp = temp.next;
        }
        return dummyNode.next;
    }
}
