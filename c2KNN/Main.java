package c2KNN;

import java.util.ArrayList;

public class Main {
    public static int k;
    public static void main(String[] args) {
        k = 5;
        ArrayList<DataObjects> objs = new ArrayList<>();
        DataObjects o = new DataObjects(6, 1);
        objs.add(new DataObjects(1, 6, 0));
        objs.add(new DataObjects(2, 5, 0));
        objs.add(new DataObjects(3, 4, 0));
        objs.add(new DataObjects(4, 3,1));
        objs.add(new DataObjects(5, 2,1));
        objs.add(new DataObjects(6, 1,1));
        System.out.println(kNN(o,objs));
    }

    private static int kNN(DataObjects o, ArrayList<DataObjects> objs) {
        int[] indices = new int[k];
        double [] mins = new double[k];
        mins = intiMins(mins);
        indices = getIndices(o, objs, indices, mins);

        int a = 0;
        int b = 0;

        for (int i = 0; i < k; i++) {
            if (objs.get(indices[i]).getKlasse() == 0) a++;
            else b++;
        }

        if(a>b) return 0;
        else return 1;
    }

    private static int[] getIndices(DataObjects o, ArrayList<DataObjects> objs, int[] indices, double[] mins) {
        for (int i = 0; i < objs.size(); i++) {
            double dist = distance(o, objs.get(i));
            double max = Double.MAX_VALUE;
            int maxIdx = 0;

            for (int j = 0; j < k; j++) {
                if(max < mins[j]){
                    max = mins[j];
                    maxIdx = j;
                }
            }

            if (mins[maxIdx] > dist) {
                mins[maxIdx] = dist;
                indices[maxIdx] = i;
            }
        }

        return indices;
    }

    private static double[] intiMins(double[] mins) {
        for (int i = 0; i < k; i++) {
            mins[i] = Double.MAX_VALUE;
        }
        return mins;
    }
    private static double distance(DataObjects o, DataObjects ref) {
        return Math.sqrt(Math.pow(o.getX() - ref.getX(), o.getX() - ref.getX()) + Math.pow(o.getY() - ref.getY(), o.getY() - ref.getY()));
    }
}
