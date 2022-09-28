package org.drout.das.tree.ex11;

public class Node {

    public Integer data;
    public Node left, right;

    // Node WITH VALUE
    public Node(Integer value) {
        this.data = value;
        this.left = null;
        this.right = null;
    }

    // BLANK EMPTY Node
    public Node() {
        this.data = null;
        this.left = null;
        this.right = null;
    }
}
