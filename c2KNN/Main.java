package c2KNN;

import java.util.ArrayList;

public class Main {
    public static int k;
    public static void main(String[] args) {
        k = 5;
        ArrayList<DataObjects> objs = new ArrayList<>();

        /*
        DataObjects o = new DataObjects(6, 1);
        objs.add(new DataObjects(1, 6, 0));
        objs.add(new DataObjects(2, 5, 0));
        objs.add(new DataObjects(3, 4, 0));
        objs.add(new DataObjects(4, 3,1));
        objs.add(new DataObjects(5, 2,1));
        objs.add(new DataObjects(6, 1,1));
        System.out.println(kNN(o,objs));
        */

        DataObjects o = new DataObjects(80, 15);
        //Punkte: 
        objs.add(new DataObjects(89,12,0));   
        objs.add(new DataObjects(94,6,0));   
        objs.add(new DataObjects(96,3,0));   
        objs.add(new DataObjects(97,2,0));   

        //Dreiecke:
        objs.add(new DataObjects(77, 7,1));
        objs.add(new DataObjects(84, 10,1));
        objs.add(new DataObjects(86, 14,1));
        objs.add(new DataObjects(91, 2,1));
        objs.add(new DataObjects(94, 16,1));
        objs.add(new DataObjects(92, 10,1));
        objs.add(new DataObjects(85, 14,1));

        //Kreuze:
        objs.add(new DataObjects(75, 25, 2));
        objs.add(new DataObjects(77, 11, 2));
        objs.add(new DataObjects(80, 16, 2));
        objs.add(new DataObjects(87, 15, 2));
        
        System.out.println(kNN(o,objs));
    }

    private static int kNN(DataObjects o, ArrayList<DataObjects> objs) {
        int[] indices = new int[k];
		double[] mins = new double[k];
		for (int i = 0; i < k; i++) {
			mins[i] = Double.MAX_VALUE;
		}

		for (int i = 0; i < objs.size(); i++) {
			double dist = distance(o, objs.get(i));
			double max = Double.MIN_VALUE;
			int maxIdx = 0;
			for (int j = 0; j < k; j++) {
				if (max < mins[j]) {
					max = mins[j];
					maxIdx = j;
				}
			}
			if (mins[maxIdx] > dist) {
				mins[maxIdx] = dist;
				indices[maxIdx] = i;
			}
		}
        int a = 0;
        int b = 0;
        int c = 0;

        for (int i = 0; i < k; i++) {
            System.out.println("obj"+i+" Klasse: " + objs.get(indices[i]).getKlasse() + "x: " + objs.get(indices[i]).getX() + "y: " + objs.get(indices[i]).getY());
            if (objs.get(indices[i]).getKlasse() == 0) a++;
            else if(objs.get(indices[i]).getKlasse() == 1) b++;
            else c++;
        }
        System.out.println("a: " + a);
        System.out.println("b: " + b);
        System.out.println("c: " + c);
        if(a>b && a>c){
            System.out.println("a");
            return 0;
        } 
        else if(b>a && b>c){
            System.out.println("b");
            return 1;
        } 
        else{
            System.out.println("c");
            return 2;
        }
    }


    private static double[] intiMins(double[] mins) {
        for (int i = 0; i < k; i++) {
            mins[i] = Double.MAX_VALUE;
        }
        return mins;
    }

    private static double distance(DataObjects o, DataObjects ref) {
        return Math.sqrt(Math.pow(o.getX() - ref.getX(),2) + Math.pow(o.getY() - ref.getY(), 2));
    }
}
