# Thread erzeugen

## Aufgabe
1. Erzeugen sie die Java Dateien `ErzeugeThread.java` und `MyThread`.
2. Fügen sie eine main-Methode in die Klasse `ErzeugeThread`.
3. Die Klasse `MyThread.java` soll von der Klasse `Thread.java` erben.
4. Jeder Thread hat einen Namen und eine Wartezeit in ms und zählt von 1-100. Der Thread gibt diese Werte, nachdem er nebenläufig gestartet wurde auf der Konsole aus. Erweiter Sie die Thread Klasse und testen sie zwei Threads mit 30 und 100 Millisekunden Wartezeit.
5. Beim Erzeugen des Threads soll die Wartezeit und der Name festgelegt sein. -> Konstruktor
6. Zeigen sie, dass der Main Thread vor den Zählthreads zuende ist, obwohl er zuerst gestartet wird.