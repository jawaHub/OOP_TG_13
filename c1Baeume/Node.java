package c1Baeume;

public class Node {
    Node links;
    Node rechts;
    int value;

    public Node(int value) {
        this.value = value;
        links = null;
        rechts = null;
    }
}