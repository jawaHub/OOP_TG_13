package b2Stacks;

public class Queue {
    Element first = null;

    public String pop() {
        if (first == null)
            return null;
        String ret = first.current;
        first = first.next;
        return ret;
    }

    public void push(String s) {
        if (first == null)
            first = new Element(s);
        else {
            Element iterator = first;
            while (iterator.next != null) {
                iterator = iterator.next;
            }
            iterator.next = new Element(s);
        }
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        Element iterator = first;

        if (iterator == null)
            return "null";

        builder.append(iterator.current).append(" ");

        while (iterator.next != null) {
            iterator = iterator.next;
            builder.append(iterator.current).append(" ");

        }
        return builder.toString();
    }
}