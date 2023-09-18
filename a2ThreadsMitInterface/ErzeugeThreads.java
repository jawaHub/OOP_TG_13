package a2ThreadsMitInterface;
public class ErzeugeThreads {
    public static void main(String[] args) {
        System.out.println("Erzeug Threads gestartet");

        //Objekte erzeugen
        MeinThread a = new MeinThread("a", 100);
        MeinThread b = new MeinThread("b", 20);
        a.start();
        b.start();
        System.out.println("Main Thread zuende.");
    }    
}