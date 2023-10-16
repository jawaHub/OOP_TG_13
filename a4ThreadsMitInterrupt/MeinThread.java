package a4ThreadsMitInterrupt;

public class MeinThread implements Runnable {
    String name;
    Thread thread;
    int wait;

    public MeinThread(String name) {
        this.name = name;
        thread = new Thread(this);
        System.out.print("Ich arbeite");
        wait = 2000;
    }

    @Override
    public void run() {
        while(true){
            System.out.print(".");
            try {
                Thread.sleep(wait);
            } catch (InterruptedException e) {
                e.printStackTrace();
                return;
            }
        }
    }

    public void start() {
        thread.start();
    }

    public void interrupt() {
        System.out.println();
        System.out.println("Thread abgebrochen.");
        thread.interrupt();
    }
}
