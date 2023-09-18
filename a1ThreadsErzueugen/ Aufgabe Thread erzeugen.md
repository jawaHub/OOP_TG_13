# Thread erzeugen

## Aufgabe
1. Erzeugen sie die Java Dateien `ErzeugeThread.java` und `MyThread`.
2. Fügen sie eine main-Methode in die Klasse `ErzeugeThread`.
````java
public class ErzeugeThreads {
    public static void main(String[] args) {
    }
}
````
3. Die Klasse `MyThread.java` soll von der Klasse `Thread.java` erben.
    ````java
    public class MyThread extends Thread{}
    ````
4. Beim Erzeugen des Threads soll die Wartezeit und der Name festgelegt sein. -> Konstruktor    
````java
public class MyThread extends Thread{    
    //...
    public MyThread(String name, int wait){
        this.name = name;
        this.wait = wait;
    }
}
````
5. Jeder Thread hat einen Namen und eine Wartezeit in ms und zählt von 1-100. Der Thread gibt diese Werte, nachdem er nebenläufig gestartet wurde auf der Konsole aus. Erweiter Sie die Thread Klasse und testen sie zwei Threads mit 30 und 100 Millisekunden Wartezeit.
````java
public class MyThread extends Thread{    
    //Obhjektvariablen
    String name;
    int wait;
    
    public MyThread(String name, int wait){
        this.name = name;
        this.wait = wait;
    }
    
    //run Methode erzeugen
    @Override
    public void run() {
        System.out.println("Name: " + name + " gestartet");
        for (int i = 0; i < 100; i++) {
            System.out.println(name + ": " + i);

            try {
                Thread.sleep(wait);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
}
````
6. Zeigen sie, dass der Main Thread vor den Zählthreads zuende ist, obwohl er zuerst gestartet wird.
````java
public class ErzeugeThreads {
    
    public static void main(String[] args) {
        System.out.println("Erzeuge Thread gestartet");

        //Objekte erzeugen
        MyThread x = new MyThread("x", 100);
        MyThread y = new MyThread("y", 10);

        //Threads starten
        x.start();
        y.start();

        System.out.println("Main Thread zu ende.");
    }
}
````