import java.util.ArrayList;

public class ArrayListSample {
    public static void main(String[] args) {

        // ArrayList erstellen
        ArrayList<String> name = new ArrayList<>();

        // Werte hinzufügen
        name.add("Peter");
        name.add("Paul");
        name.add("Phillip");

        // Wert löschen
        name.remove(1);
        name.remove("Phillip");

        //Differenzieren zwischen Index und Wert (nur beim Typ Integer,...)
        ArrayList<Integer> a = new ArrayList<>();
        a.add(1);
        a.add(2);
        a.add(3);
        a.add(4);

        a.remove(3);
        a.remove(Integer.valueOf(1));

        System.out.println(a);;
        // ArrayList ausgeben
        System.out.println(name);

        // Prüfen ob Wet in Liste
        System.out.println(name.contains("Phillip"));
        System.out.println(name.contains("Peter"));
    }
}