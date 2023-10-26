public class ArraySample {
    public static void main(String[] args) {

        // Array erstellen
        String[] name = new String[3];

        // Werte hinzufügen
        name[0] = "Peter";
        name[1] = "Paul";
        name[2] = "Phillip";

        // Wert löschen
        name[5] = null;

        // Array ausgeben
        for (String str : name) {
            System.out.println(str);
        }

        // Prüfen ob Wet in Liste
        for (String str : name) {
            if (str == null)
                System.out.println("Freie Stelle verfügbar");
        }

    }
}