package a4ThreadsMitInterrupt;

import java.util.Scanner;

public class Hauptklasse {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Main gestartet.");

        MeinThread thread = new MeinThread("a");
        thread.start();
        String eingabe = sc.next();
        if (eingabe.equals("a"))thread.interrupt();
        sc.close();
        
        System.out.println("Main zuende.");
    }
}
