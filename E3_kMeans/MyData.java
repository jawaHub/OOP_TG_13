
public class MyData {

    private double x;
    private double y;
    private MyCluster myCluster;

    // Alle Daten sind unklassifiziert
    public MyData(double x, double y) {
        this.x = x;
        this.y = y;
        myCluster=null;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "\nData x=" + x + "\ty=" + y;
    }

    public void setMyCluster(MyCluster c) {
        myCluster = c;

    }

    public MyCluster getMyCluster() {
        return myCluster;
    }

}
