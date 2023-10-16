package a1ThreadsErzueugenMitVererbung;
/**
 * MyThread
 */

public class MeinThread extends Thread {
    // Obhjektvariablen
    String name;
    int wait;

    public MeinThread(String name, int wait) {
        this.name = name;
        this.wait = wait;
    }

    // run Methode erzeugen
    @Override
    public void run() {
        System.out.println("Name: " + name + " gestartet");
        for (int i = 0; i < 100; i++) {
            System.out.println(name + ": " + i);

            try {
                Thread.sleep(wait);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
}