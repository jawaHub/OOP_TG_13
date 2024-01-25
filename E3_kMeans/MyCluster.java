import java.util.ArrayList;
import java.util.List;

public class MyCluster {

    private String name;
    private double x;
    private double y;
    private List<MyData> dataobjects;

    public MyCluster(String name, double x, double y) {
        this.name = name;
        this.x = x;
        this.y = y;
        this.dataobjects = new ArrayList<MyData>();
    }

    public void addDataObject(MyData o) {
        dataobjects.add(o);
    }

    public void removeDataObject(MyData o) {
        dataobjects.remove(o);
    }

    public void removeAllDataObjects() {
        dataobjects.clear();
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

    public List<MyData> getDataObjects() {
        return dataobjects;
    }

    public void setDataObjects(List<MyData> dataobjects) {
        this.dataobjects = dataobjects;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "\nCluster name=" + name + ", x=" + x + ", y=" + y + "\n"+dataobjects;
    }

    public void setName(String name) {
        this.name = name;
    }

}
