package kMeansGui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import javax.swing.JPanel;

public class DataPanel extends JPanel implements Runnable{
	ArrayList<MyCluster> clusters;
	ArrayList<MyData> allData;
	int mode;
	final static int CLUSTER = 1;
	final static int DATA = 0;
	int anzahl = 0;
	Scanner sc;
	Thread t;

	public DataPanel() {
		super();
		clusters = new ArrayList<MyCluster>();
		mode = DATA;
		allData = new ArrayList<MyData>();
		sc = new Scanner(System.in);
		t = new Thread(this);
		setDoubleBuffered(true);
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D)g;

		 g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		for (MyCluster myCluster : clusters) {
			g.setColor(myCluster.getColor());
			g.fillRect(myCluster.getX(),myCluster.getY(), 50, 50);
			for (MyData mydata : myCluster.getData()) {
				g.setColor(mydata.getColor());
				g.fillOval(mydata.getX(),mydata.getY(), 30, 30);
			}
		}
		g.setColor(Color.black);
		g.drawString("anzahl: " + anzahl, 10, 10);
	}
	
	public void berechnendaten() {
        double delta = 0.0;
        double deltaMin = 0.0;
        double deltaPrev = 0.0;
        boolean end = false;
        do {
            // Bestimme für jedes Datenobjekt das nächste Center
            for (MyData myData : allData) {
                double minDistance = Double.MAX_VALUE;
                for (MyCluster cluster : clusters) {
                	cluster.clearData();
                    if (getDistance(cluster, myData) <= minDistance) {
                        minDistance = getDistance(cluster, myData);
                        myData.setCluster(cluster);
                    }
                }
            }

            // Den Clustern Ihre Datenobjekte neu zuordnen
            for (MyData myData : allData) {
                MyCluster cluster = myData.getCluster();
                myData.setColor(cluster.getColor());
                cluster.addDdata(myData);
            }

            // Für jedes Cluster die neue Position bestimmen
            double sumX, sumY, xNeu, yNeu;
            for (MyCluster cluster : clusters) {
                
                sumX=0;
                sumY=0;
                List<MyData> temp = cluster.getData();
    
                for (MyData tData : temp) {
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
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				t.interrupt();
			}
            if(deltaPrev == delta) deltaMin = delta + 1;
            else deltaPrev = delta;
            } while (delta > deltaMin);

        //Ausgabe
        /*
        for (MyCluster c : clusters) {
            System.out.println(c);
            System.out.println("-----------------");
        }
        */
        t.interrupt();
    }

    public static double getDistance(MyCluster c, MyData o) {
        return Math.sqrt((c.getX() - o.getX()) * (c.getX() - o.getX()) + (c.getY() - o.getY()) * (c.getY() - o.getY()));
    }

	public void addDatenpunkt(int x, int y, Color color) {
		if(clusters.size() == 0) clusters.add(new MyCluster("1", x, y, color));
		else {
			allData.add(new MyData(x, y, color));
			clusters.get(0).addDdata(new MyData(x, y, color));
		}
	}
	
	public void addCluster(int x, int y, Color color, String name) {
		clusters.add(new MyCluster(name, x, y, color));
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
		ArrayList<MyData> datab = new ArrayList<MyData>(allData);
		for (MyData myData : datab) {
			if(myData.getX() < 0 || myData.getY() < 0) allData.remove(myData);
		}		
	}
}