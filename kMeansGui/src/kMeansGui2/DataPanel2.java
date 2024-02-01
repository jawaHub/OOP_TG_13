package kMeansGui.src.kMeansGui2;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import javax.swing.JPanel;

public class DataPanel2 extends JPanel implements Runnable{
	ArrayList<MyCluster2> clusters;
	ArrayList<MyData2> allData;
	public int mode;
	final static int CLUSTER = 1;
	final static int DATA = 0;
	int anzahl = 0;
	Scanner sc;
	Thread t;
	private long time;

	public DataPanel2() {
		super();
		clusters = new ArrayList<MyCluster2>();
		mode = DATA;
		allData = new ArrayList<MyData2>();
		sc = new Scanner(System.in);
		t = new Thread(this);
		time = 1500;
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		for (MyData2 data : allData) {
			g.setColor(data.getColor());
			g.fillOval(data.x, data.y, 30,30);
		}

		for (MyCluster2 myCluster : clusters) {
			g.setColor(myCluster.getColor());
			g.fillRect(myCluster.getX(),myCluster.getY(), 50, 50);
		}
		g.setColor(Color.black);
		g.drawString("anzahl: " + anzahl, 10, 10);
	}
	
	public void berechnendaten() {
		if (clusters.isEmpty())clusters.add(new MyCluster2("q",100,100,Color.DARK_GRAY));
        double delta = 0.0;
        double deltaMin = 0.0;
        double deltaPrev = 0.0;
        do {
            // Bestimme für jedes Datenobjekt das nächste Center
            for (MyData2 myData : allData) {
                double minDistance = Double.MAX_VALUE;
                for (MyCluster2 cluster : clusters) {
                	cluster.clearData();
                    if (getDistance(cluster, myData) <= minDistance) {
                        minDistance = getDistance(cluster, myData);
                        myData.setCluster(cluster);
                    }
                }
            }

            // Den Clustern Ihre Datenobjekte neu zuordnen
            for (MyData2 myData : allData) {
				MyCluster2 cluster = myData.getCluster();
                myData.setColor(cluster.getColor());
                cluster.addDdata(myData);
            }

            // Für jedes Cluster die neue Position bestimmen
            double sumX, sumY, xNeu, yNeu;
            for (MyCluster2 cluster : clusters) {
                
                sumX=0;
                sumY=0;
                List<MyData2> temp = cluster.getData();
    
                for (MyData2 tData : temp) {
                    sumX = sumX + tData.getX();
                    sumY = sumY + tData.getY();
                }

                //Mittelwerte aller Datenpunkte bestimmen
                xNeu = sumX / temp.size();
                yNeu = sumY / temp.size();

                //Prüfen ob der neue Mittelwert sich verändert hat
                delta = Math.abs(cluster.getX()-xNeu) + Math.abs(cluster.getY()-yNeu);

                //Den Center auf neue Position verschieben
                cluster.setX((int)xNeu);
                cluster.setY((int)yNeu);
              }
            
            update(getGraphics());
            
            anzahl++;
            try {
				Thread.sleep(time);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				t.interrupt();
			}
            System.out.println(delta);
            if(deltaPrev == delta) deltaMin = delta + 1;
            else deltaPrev = delta;
            } while (delta > deltaMin);

        //Ausgabe
        for (MyCluster2 c : clusters) {
            System.out.println(c);
            System.out.println("-----------------");
        }
        t.interrupt();
    }

    public static double getDistance(MyCluster2 c, MyData2 o) {
        return Math.sqrt((c.getX() - o.getX()) * (c.getX() - o.getX()) + (c.getY() - o.getY()) * (c.getY() - o.getY()));
    }

	public void addDatenpunkt(int x, int y, Color color) {
		allData.add(new MyData2(x, y, color));
	}
	
	public void addCluster(int x, int y, Color color, String name) {
		clusters.add(new MyCluster2(name, x, y, color));
	}

	public void add(int x, int y, Color color) {
		if(mode == DATA)addDatenpunkt(x, y, color);
		else if(mode == CLUSTER)addCluster(x, y, getRandomeColor(), clusters.size() + 1 + "");
	}

	private Color getRandomeColor() {
		Random rand = new Random();
		
		float r = rand.nextFloat();
		float g = rand.nextFloat();
		float b = rand.nextFloat();

		Color randomColor = new Color(r, g, b);
		return randomColor;
	}

	public void aktivateCluster() {
		mode = CLUSTER;
	}
	
	public void aktivateData() {
		mode = DATA;
	}

	public void loeschen() {
		allData.clear();
		clusters.clear();
		anzahl = 0;
	}

	@Override
	public void run() {
		System.out.println(1);
		berechnendaten();
	}
	
	public void start() {
		t.run();
	}

	public void eliminateWrongData() {
		ArrayList<MyData2> datab = new ArrayList<MyData2>(allData);
		for (MyData2 myData : datab) {
			if(myData.getX() < 0 || myData.getY() < 0) allData.remove(myData);
		}		
	}
}