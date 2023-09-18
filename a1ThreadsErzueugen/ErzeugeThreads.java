package a1ThreadsErzueugen;
/**
 * ErzeugeThreads
 */
public class ErzeugeThreads {

    public static void main(String[] args) {
        System.out.println("Erzeuge Thread gestartet");

        // Objekte erzeugen
        MeinThread x = new MeinThread("x", 100);
        MeinThread y = new MeinThread("y", 10);

        // Threads starten
        x.start();
        y.start();

        System.out.println("Main Thread zu ende.");
    }
}