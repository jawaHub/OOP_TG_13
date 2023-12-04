import java.util.ArrayList;
import java.util.Random;

public class Spiel implements Werte {
    static Stapel nachziehStapel;
    static Stapel ablageStapel;
    static ArrayList<Karte> allKarten;
    static ArrayList<Spieler> spieler;

    public Spiel(){
        initStapel();
        initSpieler(2);
    }

    public void start(){
        
    }

    private void initSpieler(int anzahl) {
        spieler = new ArrayList<>();
        for (int i = 0; i < anzahl; i++) {
            spieler.add(new Spieler("Spieler"+ (i+1)));
        }
    }

    private void initStapel() {
        initAllKarten();
        nachziehStapel = new Stapel();
        initNachziehStapel();
    }

    private void initNachziehStapel() {
        mixNachziehstapel();
    }

    private void mixNachziehstapel() {
    ArrayList<Karte> tempStapel = (ArrayList<Karte>) allKarten.clone();
        int zufall;
        int size = tempStapel.size();
        for (int i = 0; i < size; i++) {
            zufall = new Random().nextInt(tempStapel.size());
            nachziehStapel.addKarte(tempStapel.get(zufall));
            tempStapel.remove(zufall);
        }
    }

    private void initAllKarten() {
        allKarten = new ArrayList<>();
        int[] farben = {ROT, GELB, GRUEN, BLAU};
        for (int farbe : farben) {
            for (int j = 0; j < ANZAHLPROZAHLFRABE; j++) {
                allKarten.add(new Karte(NULL, farbe));
                allKarten.add(new Karte(EINS, farbe));
                allKarten.add(new Karte(ZWEI, farbe));
                allKarten.add(new Karte(DREI, farbe));
                allKarten.add(new Karte(VIER, farbe));
                allKarten.add(new Karte(FUENF, farbe));
                allKarten.add(new Karte(SECHS, farbe));
                allKarten.add(new Karte(SIEBEN, farbe));
                allKarten.add(new Karte(ACHT, farbe));
                allKarten.add(new Karte(NEUN, farbe));
                allKarten.add(new Karte(RICHTUNGSWECHSEL, farbe));
                allKarten.add(new Karte(AUSSETZTEN, farbe));
                allKarten.add(new Karte(PLUSZWEI, farbe));
            }
        }

        for (int index = 0; index < ANZAHLFARBWUSCH; index++) {
            allKarten.add(new Karte(FARBWUNSCH,SCHWARZ));
        }

        for (int index = 0; index < ANZAHLPLUSVIERFARBWUNSCH; index++) {
            allKarten.add(new Karte(PLUSVEIRFARBWUNSCH,SCHWARZ));
        }
    }
}