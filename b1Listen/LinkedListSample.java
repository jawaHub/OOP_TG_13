import java.text.Collator;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * 
 */
public class LinkedListSample {
    public static void main(String[] args) {
        LinkedList<String> linkedList = new LinkedList<>();

        Scanner sc = new Scanner(System.in);
        System.out.flush();

        linkedList.add("Melone");
        linkedList.add("Regenschirm");
        linkedList.add("Nicer Dicer");

        boolean fertig = false;

        String bereitsInDerEinkausliste = "Das befindet sich breits in deiner Einkaufsliste";
        String nichtInDerEinkausliste = "Das befindet sich nicht in deiner Einkaufsliste";
        String nichtVerstanden = "Das habe ich nicht verstanden, bitte erneut probieren.";
        String einkaufsliste = "Einkaufsliste: " + linkedList;
        String wasDenn = "Was denn?";

        String a;
        do {
            linkedList.sort((o1, o2) -> Collator.getInstance().compare(o1, o2));
            System.out.println(einkaufsliste);
            System.out.println("Fertig, etwas hinzufügen oder löschen?");
            System.out.println("(f/h/l)");
            String s = sc.next();
            switch (s.toLowerCase()) {
                case "hinzufügen":
                case "h":
                    System.out.println(wasDenn);
                    a = sc.next();
                    if (!linkedList.contains(a)) linkedList.add(a);
                    else
                        System.out.println(bereitsInDerEinkausliste);
                    break;
                case "löschen":
                case "l":
                    System.out.println(wasDenn);
                    a = sc.next();
                    if (!linkedList.remove(a))
                        System.out.println(nichtInDerEinkausliste);
                    break;
                case "fertig":
                case "f":
                    fertig = true;
                    break;
                default:
                    System.out.println(nichtVerstanden);
                    break;
            }
        } while (!fertig);

        System.out.println("Deine fertige " + einkaufsliste);
        sc.close();
    }
}
