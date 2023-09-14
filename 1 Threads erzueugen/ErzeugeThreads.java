/**
 * ErzeugeThreads
 */
public class ErzeugeThreads {
    
    public static void main(String[] args) {
        System.out.println("Erzeuge Thread gestartet");

        //Objekte erzeugen
        MyThread x = new MyThread("x", 100);
        MyThread y = new MyThread("y", 10);

        //Threads starten
        x.start();
        y.start();

        System.out.println("Main Thread zu ende.");
    }
}