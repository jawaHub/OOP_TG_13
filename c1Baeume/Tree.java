package c1Baeume;

import java.util.ArrayList;

public class Tree {
    Node rootNode = null;

    public void insert(int value) {
        if (rootNode == null)
            rootNode = new Node(value);
        else
            insert(rootNode, value);
    }

    private void insert(Node parent, int value) {
        if (value <= parent.value) {
            if (parent.links == null)
                parent.links = new Node(value);
            else
                insert(parent.links, value);
        } else {
            if (parent.rechts == null)
                parent.rechts = new Node(value);
            else
                insert(parent.rechts, value);
        }
    }

    public int getAmountNodes() {
        if (rootNode == null)
            return 0;
        else
            return 1 + getAmountNodes(rootNode.rechts) + getAmountNodes(rootNode.links);
    }

    private int getAmountNodes(Node parent) {
        if (parent == null)
            return 0;
        else
            return 1 + getAmountNodes(parent.rechts) + getAmountNodes(parent.links);
    }
}