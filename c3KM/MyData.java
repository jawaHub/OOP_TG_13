package c3KM;

public class MyData {
    @Override
    public String toString() {
        return "MyData [xWert=" + xWert + ", yWert=" + yWert + ", cluster=" + cluster + "]";
    }

    private int xWert, yWert;
    private MyCluster cluster;

    public MyData(int xWert, int yWert) {
        this.xWert = xWert;
        this.yWert = yWert;
        this.cluster = null;
    }

    public int getxWert() {
        return xWert;
    }

    public void setxWert(int xWert) {
        this.xWert = xWert;
    }

    public int getyWert() {
        return yWert;
    }

    public void setyWert(int yWert) {
        this.yWert = yWert;
    }

    public MyCluster getCluster() {
        return cluster;
    }

    public void setCluster(MyCluster cluster) {
        this.cluster = cluster;
    }
    
}
