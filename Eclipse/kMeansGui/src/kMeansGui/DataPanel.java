package kMeansGui;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.JPanel;

public class DataPanel extends JPanel implements Runnable {
	ArrayList<MyCluster> clusters;
	ArrayList<MyData> allData;
	int mode;
	final static int CLUSTER = 1;
	final static int DATA = 0;
	int anzahl = 0;
	Thread t;
	
	public DataPanel() {
		super();
		clusters = new ArrayList<MyCluster>();
		mode = DATA;
		allData = new ArrayList<MyData>();
		t = new Thread(this);
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		for (MyCluster myCluster : clusters) {
			g.setColor(myCluster.getColor());
			g.fillRect(myCluster.getX(),myCluster.getY(), 50, 50);
			for (MyData mydata : myCluster.getData()) {
				g.fillOval(mydata.getX(),mydata.getY(), 30, 30);
			}
		}
		g.drawString("anzahl: " + anzahl, 10, 10);

	}
	
	public void berechnendaten() {
		
       
        double delta = 0.0;
        do {
           
            // Bestimme für jedes Datenobjekt das nächste Center
            for (MyData o : allData) {
                double minDistance = Double.MAX_VALUE;
                for (MyCluster c : clusters) {
                    c.clearData();
                    if (getDistance(c, o) <= minDistance) {
                        minDistance = getDistance(c, o);
                        o.setCluster(c);
                    }
                }
            }

            // Den Clustern Ihre Datenobjekte neu zuordnen
            for (MyData o : allData) {
                MyCluster c = o.getCluster();
                c.addDdata(o);
            }

            // Für jedes Cluster die neue Position bestimmen
            double sumX, sumY, xNeu, yNeu;
            for (MyCluster c : clusters) {
                
                sumX=0;
                sumY=0;
                List<MyData> temp = c.getData();
    
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
                c.setX((int)xNeu);
                c.setY((int)yNeu);
              }
            
         
            try {
        
				Thread.sleep(1000);
				revalidate();
                repaint();
                anzahl++;
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            
            
            } while (delta > 1);


        //Ausgabe
        for (MyCluster c : clusters) {
            System.out.println(c);
            System.out.println("-----------------");
        }
 
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
		
	}

	@Override
	public void run() {
		berechnendaten();
		
	}
	
	public void start() {
		t.start();
	}
}