public class main {

    public static void main(String[] args) {

        Mathe mult = (a,b) -> a*b;
        Mathe add = (a,b) -> a+b;
        Mathe div = (a,b) -> a/b;
        Mathe sub = (a,b) -> a-b;

        //Auch für ein Array verwendbar
        Mathe[] ops = new Mathe[4];
        ops[0] = (a,b) -> a+b;
        ops[1] = (a,b) -> a-b;
        ops[2] = (a,b) -> a*b;
        ops[3] = (a,b) -> a/b;

        for (Mathe fkt : ops) {
            System.out.println(fkt.fkt(5,10));
        }

        Kreis umfang = (a) -> Math.PI * a * a;
        System.out.println("Umfang: " + umfang.getArea(4.4));
    }

    /**
     * Mathe
     */
    public interface Mathe {
        double fkt(double a, double b);
    }

    public interface Kreis {
        double getArea(double radius);
    }
}