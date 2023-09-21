package a3AmpelMitThreads;

public class Ampel implements Runnable {

    // Konstanten
    private static final int ROT = 0;
    private static final int ROTGELB = 1;
    private static final int GELB = 2;
    private static final int GRUEN = 3;

    private static final String[] farben = {"ROT", "ROTGELB", "GELB", "GRUEN"};

    // Variablen
    int aktZustand;
    int wait = 0;
    String name;
    Thread t;

    // Konstruktor
    public Ampel(String name, int wait) {
        t = new Thread(this);
        this.wait = wait;
        this.name = name;
        aktZustand = ROT;
    }

    // Threadverwaltung
    public void start() {
        t.start();
    }

    // Wartefunktion
    public void warte() {
        try {
            t.sleep(wait);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    // nebenläufiger Zustandswechsel der Ampel
    @Override
    public void run() {
        while (true) {
            switch (aktZustand) {
                case ROT:
                    System.out.println(name + " Zustand: " + farben[aktZustand]);
                    warte();
                    wechsleZustandZu(ROTGELB);
                    break;
                case ROTGELB:
                    System.out.println(name + " Zustand: " + farben[aktZustand]);
                    warte();
                    wechsleZustandZu(GELB);;
                    break;
                case GELB:
                    System.out.println(name + " Zustand: " + farben[aktZustand]);
                    warte();
                    wechsleZustandZu(GRUEN);
                    break;
                case GRUEN:
                    System.out.println(name + " Zustand: " + farben[aktZustand]);
                    warte();
                    wechsleZustandZu(ROT);
                    break;
                default:
            }
        }
    }

    private void wechsleZustandZu(int neuerZustand) {
        aktZustand = neuerZustand;
    }
}