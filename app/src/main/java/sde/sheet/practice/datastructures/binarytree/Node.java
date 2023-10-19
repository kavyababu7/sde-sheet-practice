package sde.sheet.practice.datastructures.binarytree;

import java.util.Objects;

public class Node {
    public int value;
    public Node left;
    public Node right;

    public Node(int value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node node = (Node) o;
        return value == node.value && Objects.equals(left, node.left) && Objects.equals(right, node.right);
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                ", left=" + left +
                ", right=" + right +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, left, right);
    }
}
