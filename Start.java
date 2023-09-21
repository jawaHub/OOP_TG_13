package a3AmpelMitThreads;

public class Start{
    public static void main(String[] args) {
        Ampel a = new Ampel("a", 2000);
        a.start();
    }
}