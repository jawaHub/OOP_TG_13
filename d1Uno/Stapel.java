import java.util.LinkedList;

public class Stapel {
    LinkedList<Karte> stapel = new LinkedList<>();

    public void addKarte(Karte karte){
        stapel.add(karte);
    }

    public void clear(){
        stapel.clear();
    }

    public int size(){
        return stapel.size();
    }

    public Karte get(int i){
        return stapel.get(i);
    }

    public Karte getRemove(int i){
        return stapel.pop();
    }

    public Karte getFirst(){
        return stapel.getFirst();
    }
}