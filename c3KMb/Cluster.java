package c3KMb;

import java.util.ArrayList;

public class Cluster {
    private double mean;
    private ArrayList<Integer> objects ;
    private String name;

    public Cluster(double mean, String name) {
        this.mean = mean;
        this.name = name;
        objects = new ArrayList<>();
    }
    public double getMean() {
        return mean;
    }
    public void setMean(double mean) {
        this.mean = mean;
    }
    public ArrayList<Integer> getObjects() {
        return objects;
    }
    public void clearValues(){
        objects.clear();
    }
    public void addObject(int data){
        objects.add(data);
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public boolean calculateNewMeans(){
        double newMean;
        double sum = 0;
        double prevMean = mean;
        for (int data : objects) {
           sum += data;
        }

        newMean = sum/objects.size();
        mean = newMean;

        if (newMean == prevMean) return true;
        else return false;
    }
    @Override
    public String toString() {
        return "Cluster [mean=" + mean + ", objects=" + objects + ", name=" + name + "]";
    }

    
}
