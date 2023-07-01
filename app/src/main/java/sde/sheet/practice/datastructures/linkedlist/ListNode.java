package sde.sheet.practice.datastructures.linkedlist;

import java.util.Objects;

public class ListNode {
    int value;
    ListNode next;

    public ListNode(int value, ListNode next) {
        this.value = value;
        this.next = next;
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "value=" + value +
                ", next=" + next +
                '}';
    }

   public static ListNode build(ListNode... args) {
       for (int i = 0; i < args.length - 1; i++) {
           args[i].next = args[i+1];
       }
       return args[0];
   }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ListNode listNode = (ListNode) o;
        return value == listNode.value && Objects.equals(next, listNode.next);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, next);
    }
}
