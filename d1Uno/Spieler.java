import java.util.ArrayList;

public class Spieler {
    private ArrayList<Karte> karten;
    private String name;
    public Spieler(String name){
        karten = new ArrayList<>();
        this.name = name;
    }

    public void addKarte(Karte karte){
        karten.add(karte);
    }

    public void removeKarte(Karte karte){
        karten.remove(karte);
    }

    public String getName(){
        return name;
    }
}
