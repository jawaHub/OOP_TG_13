package c3KM;

import java.util.ArrayList;
import java.util.List;

public class MyCluster {
    private int xWert, yWert;
    private ArrayList<MyData> objects ;
    private String name;
    
    @Override
    public String toString() {
        return "MyCluster [xWert=" + xWert + ", yWert=" + yWert + ", objects=" + objects + ", name=" + name + "]";
    }
    public MyCluster(int xWert, int yWert, String name) {
        this.xWert = xWert;
        this.yWert = yWert;
        this.name = name;
        objects = new ArrayList<>();
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
    public List<MyData> getObjects() {
        return objects;
    }
    public void addObject(MyData data){
        objects.add(data);
    }
    public void removeObject(MyData data){
        objects.remove(data);
    }
    public void clearObjects(){
        objects.clear();
    }
    public void setObjects(List<MyData> ojects) {
        this.objects = objects;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    
}
