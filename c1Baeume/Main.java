package c1Baeume;

public class Main {

    public static void main(String[] args) {
        Tree tree = new Tree();
        tree.insert(9);
        tree.insert(10);
        tree.insert(17);
        tree.insert(5);
        tree.insert(2);
        tree.insert(1);
        tree.insert(0);

        System.out.println("\33{H\033[2J");
        System.out.flush();
        System.out.println("Amount nodes: " + tree.getAmountNodes());
    }
}