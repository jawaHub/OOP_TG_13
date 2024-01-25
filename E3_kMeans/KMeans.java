import java.util.ArrayList;
import java.util.List;

class KMeans {
    public static void main(String[] args) {
        //Konsole löschen
        System.out.print("\033[H\033[2J");
        System.out.flush();

        // Dataset initialisieren
        List<MyData> data = initData();

        // Zufällige Clusterzentren setzen
        List<MyCluster> cluster = initClusters();
       
        
        double delta = 0.0;
        do {
           
            // Bestimme für jedes Datenobjekt das nächste Center
            for (MyData o : data) {
                double minDistance = Double.MAX_VALUE;
                for (MyCluster c : cluster) {
                    c.removeAllDataObjects();
                    if (getDistance(c, o) <= minDistance) {
                        minDistance = getDistance(c, o);
                        o.setMyCluster(c);
                    }
                }
            }

            // Den Clustern Ihre Datenobjekte neu zuordnen
            for (MyData o : data) {
                MyCluster c = o.getMyCluster();
                c.addDataObject(o);
            }

            // Für jedes Cluster die neue Position bestimmen
            double sumX, sumY, xNeu, yNeu;
            for (MyCluster c : cluster) {
                
                sumX=0;
                sumY=0;
                List<MyData> temp = c.getDataObjects();
    
                for (MyData tData : temp) {
                    sumX = sumX + tData.getX();
                    sumY = sumY + tData.getY();
                }

                //Mittelwerte aller Datenpunkte bestimmen
                xNeu = sumX / temp.size();
                yNeu = sumY / temp.size();

                //Prüfen ob der neue Mittelwert sich verändert hat
                delta = Math.abs(c.getX()-xNeu) + Math.abs(c.getY()-yNeu);

                //Den Center auf neue Position verschieben
                c.setX(xNeu);
                c.setY(yNeu);
              }

        } while (delta > 0);


        //Ausgabe
        for (MyCluster c : cluster) {
            System.out.println(c);
            System.out.println("-----------------");
        }
 
    }

    private static List<MyCluster> initClusters() {
        List<MyCluster> cluster = new ArrayList<MyCluster>();
        cluster.add(new MyCluster("A", 1, 5));
        cluster.add(new MyCluster("B", 2, 14));
        cluster.add(new MyCluster("C", 4, 9));
        return cluster;
    }

    private static List<MyData> initData() {
        List<MyData> data = new ArrayList<MyData>();
        data.add(new MyData(3, 4));
        data.add(new MyData(15, 4));
        data.add(new MyData(6, 1));
        data.add(new MyData(3, 8));
        data.add(new MyData(7, 9));
        data.add(new MyData(1, 11));
        data.add(new MyData(1, 4));
        data.add(new MyData(2, 2));
        data.add(new MyData(4, 4));
        data.add(new MyData(6, 3));
        data.add(new MyData(18, 1));
        return data;
    }

    public static double getDistance(MyCluster c, MyData o) {
        return Math.sqrt((c.getX() - o.getX()) * (c.getX() - o.getX()) + (c.getY() - o.getY()) * (c.getY() - o.getY()));
    }

}