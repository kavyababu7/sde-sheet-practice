package sde.sheet.practice.datastructures.linkedlist;

public class FlattenLinkedList {

    public static void main(String[] args) {
        FNode node11 = new FNode(5);
        FNode node12 = new FNode(7);
        FNode node13 = new FNode(8);
        FNode node14 = new FNode(30);
        FNode node21 = new FNode(10);
        FNode node22 = new FNode(20);
        FNode node31 = new FNode(19);
        FNode node32 = new FNode(22);
        FNode node33 = new FNode(50);
        FNode node41 = new FNode(28);
        FNode node42 = new FNode(35);
        FNode node43 = new FNode(40);
        FNode node44 = new FNode(45);
        node11.bottom = node12;
        node12.bottom = node13;
        node13.bottom = node14;
        node11.next = node21;
        node21.bottom = node22;
        node21.next = node31;
        node31.bottom = node32;
        node32.bottom = node33;
        node31.next = node41;
        node41.bottom = node42;
        node42.bottom = node43;
        node43.bottom = node44;
        FNode node = flatten(node11);
        while (node != null) {
            System.out.println(node.value);
            node = node.bottom;
        }
    }

    static FNode mergeTwoLinkedLists (FNode a, FNode b) {
        FNode temp = new FNode(0);
        FNode res = temp;
        while (a != null && b != null) {
            if (a.value < b.value) {
                temp.bottom = a;
                a = a.bottom;
                temp = temp.bottom;
            } else {
                temp.bottom = b;
                b = b.bottom;
                temp = temp.bottom;
            }
        }
        if (a != null) {
            temp.bottom = a;
        } else {
            temp.bottom = b;
        }
        return res.bottom;
    }

    static FNode flatten (FNode node) {
        if (node == null || node.next == null)
            return node;
        node.next = flatten(node.next);
        mergeTwoLinkedLists(node, node.next);
        return node;
    }
}

class FNode {
    int value;
    FNode next;
    FNode bottom;

    @Override
    public String toString() {
        return "FNode{" +
                "value=" + value +
                '}';
    }

    public FNode(int value) {
        this.value = value;
        this.next = null;
        this.bottom = null;



    }
}

