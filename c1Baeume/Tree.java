package c1Baeume;

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

    public int getHight() {
        int r = 0;
        int l = 0;
        if (rootNode == null)
            return 0;
        if (rootNode.links != null)
            l = getHight(rootNode.links) + 1;
        if (rootNode.rechts != null)
            r = getHight(rootNode.rechts) + 1;

        return Math.max(r, l) + 1;
    }

    private int getHight(Node parent) {
        int l = 0;
        int r = 0;
        if (parent.links != null)
            r = getHight(parent.links) + 1;
        if (parent.rechts != null)
            l = getHight(parent.rechts) + 1;
        return Math.max(l, r);
    }
}