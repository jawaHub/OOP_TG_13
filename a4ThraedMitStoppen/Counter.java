package a4ThradMitStoppen;

import java.util.Scanner;

//TODO funktioniert nicht
public class Counter implements Runnable{

    private static volatile boolean schouldRun = true;

    public static void main(String args[]){
        new Thread(() -> new Counter()).start();
        System.out.println("a");
        Scanner sc = new Scanner(System.in);
        while(sc.nextLine().toLowerCase().startsWith("q")){
            schouldRun = false;
        }

    }

    @Override
    public void run() {
        while(schouldRun){
            Thread.sleep(100);
        }
    }
}