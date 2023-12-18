package c3KM;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<MyCluster> clusters = new ArrayList<>();
        clusters.add(new MyCluster(1, 1, "A"));
        clusters.add(new MyCluster(1, 2, "B"));

        ArrayList<MyData> objects = new ArrayList<>();
        objects.add(new MyData(1, 1));
        objects.add(new MyData(2, 2));
        objects.add(new MyData(3, 3));
        objects.add(new MyData(4, 4));
        objects.add(new MyData(5, 5));
        objects.add(new MyData(6, 6));
        objects.add(new MyData(7, 7));
        objects.add(new MyData(8, 8));
        objects.add(new MyData(9, 9));
        objects.add(new MyData(10, 10));
        objects.add(new MyData(11, 11));
        objects.add(new MyData(12, 12));
        objects.add(new MyData(13, 13));
        objects.add(new MyData(14, 14));

        double delta = 0.0;
        int sumX;
        int sumY;
        do {
            //Werte zu den Cluster zuordnen
            for (MyData myData : objects) {
                double distance = 0;
                MyCluster tempCluster = clusters.get(0);
                for (MyCluster cluster : clusters) {
                    if(distance(cluster, myData) < distance){
                        distance = distance(cluster, myData);
                        tempCluster = cluster;
                    } 
                }
                myData.setCluster(tempCluster);
                for (MyCluster cluster : clusters) {
                    if (cluster.getName() == tempCluster.getName()) cluster.addObject(myData);
                }
            }
            //Cluster Mittelpunkt berechnen 
            for (MyCluster cluster : clusters) {
                sumX = 0;
                sumY = 0;
                for (MyData myData : cluster.getObjects()) {
                    sumX += myData.getxWert();
                    sumY += myData.getyWert();
                }
                sumX /= cluster.getObjects().size();
                sumY /= cluster.getObjects().size();

                //Abstand zum vorherigen Mittelpunkt
                delta = distance(cluster, new MyData(sumX, sumY));

                cluster.setxWert(sumX);
                cluster.setyWert(sumY);
            }
        } while (delta >= 0);

        for (MyCluster cluster : clusters) {
            System.out.println(cluster.toString());            
        }
    }

    private static double distance(MyCluster cluster, MyData myData) {
        return Math.sqrt(Math.pow(cluster.getxWert() - myData.getxWert(),2) + Math.pow(cluster.getyWert() - myData.getyWert(), 2));
    }
}
