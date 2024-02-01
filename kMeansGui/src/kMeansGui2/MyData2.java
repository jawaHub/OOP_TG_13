package kMeansGui.src.kMeansGui2;

import java.awt.Color;

public class MyData2 {

	int x;
	int y;
	Color color;
	MyCluster2 cluster;
	
	public MyData2(int x, int y, Color color) {
		super();
		this.x = x;
		this.y = y;
		this.color = color;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public Color getColor() {
		return color;
	}
	public void setCluster(MyCluster2 cluster) {
		this.cluster = cluster;
	}
	
	public MyCluster2 getCluster() {
		return cluster;
	}

	public void setColor(Color color2) {
		this.color = color2;
		
	}
}
