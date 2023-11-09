package sde.sheet.practice.datastructures.trie;

public class Node {
    private Node[] links = new Node[26];
    protected boolean flag;

    public Node() {
    }

    boolean containsKey(char ch) {
        return links[ch-'a'] != null;
    }

    Node get(char ch) {
        return links[ch-'a'];
    }

    void put(char ch, Node node) {
        links[ch-'a'] = node;
    }
}
