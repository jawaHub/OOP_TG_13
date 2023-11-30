package b4Maps;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {
        //HashMap
        //Einfache Map, in der größere String in kleiner umgewandelt werden, 
        //dadurch kann man die Map schneller durchsuchen, Werte löschen und hinzufügen
        Map<Integer, String> map1 = new HashMap<Integer, String>();

        //LinkedHashMap
        //HashMap, in der die Strings nicht umgewandelt werden
        //dafür wird die Reihenfolge bewahrt
        Map<Integer, String> map2 = new LinkedHashMap<>();
        
        //TreeMap
        Map<Integer, String> map3 = new TreeMap<>();

        //Map leeren
        map1.clear();

        //Werte der Map hinzufügen
        map1.put(0, "erster Wert");
        map1.put(1, "zweiter Wert");
        map1.put(2, "dritter Wert");
        map1.put(3, "vierter Wert");
        
        map2.put(0, "erster Wert");
        map2.put(1, "zweiter Wert");
        map2.put(2, "dritter Wert");
        map2.put(3, "vierter Wert");
        //Über eine Map iterieren
        //in map.entrySet ist ein Schlüssel und dessen Wert enthalten
        System.out.println("Map1: ");
        for (Map.Entry<Integer, String> entry : map1.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        //man könnte auch map.keySet() verwenden, dann bekommt man nur den Schlüssel
        for (Integer key : map2.keySet()) {
            System.out.println(key + ":" + map2.get(key));
        }

        //und mit map.values() bekommt man die Werte
        for(String value : map1.values()) {
            System.out.println(value);
        }
    }
}