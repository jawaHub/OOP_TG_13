package c3KM;

import java.util.ArrayList;

public class Main {
    static int[] data = {9, 4, 13, 13, 10, 2, 10, 5, 4, 7, 8, 12, 16, 4, 8, 4, 10, 13, 8, 5};
    static ArrayList<Cluster> cluster = new ArrayList<>();
    static boolean isReady = false;
    public static void main(String[] args) {
        initCluster();

        System.out.println(cluster);
        do {
            clearCluster();
            addDataToCluster();
            calculateNewMeans();
            System.out.println(cluster);
        } while (!isReady);
    }

    private static void calculateNewMeans() {
        boolean ready = true;
        for (Cluster cluster2 : cluster) {
            if (ready) ready = cluster2.calculateNewMeans();
            else cluster2.calculateNewMeans();
        }
        isReady = ready;
    }

    private static void clearCluster() {
        for (Cluster cluster2 : cluster) {
            cluster2.clearValues();
        }
    }

    private static void addDataToCluster() {
        Double lowDist;
        Cluster nearstCluster = null;
        Double distance;
        for (int data2 : data) {
            lowDist = Double.MAX_VALUE;
            for (Cluster cluster2 : cluster) {
                distance = distance(cluster2.getMean(), (double) data2);
                if(distance < lowDist){
                    lowDist = distance;
                    nearstCluster = cluster2;
                }
            }
            nearstCluster.addObject(data2);
        }
    }

    private static void initCluster() {
        cluster.add(new Cluster(5, "A"));
        cluster.add(new Cluster(10, "B"));
        cluster.add(new Cluster(15, "C"));
    }

    private static Double distance(double a, double data2){
        return Math.abs(a - data2);
    }
}
