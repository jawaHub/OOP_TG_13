package kMeansGui;

import java.awt.Color;

public class MyData {

	int x;
	int y;
	Color color;
	MyCluster cluster;
	
	public MyData(int x, int y, Color color) {
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
	public void setCluster(MyCluster cluster) {
		this.cluster = cluster;
	}
	
	public MyCluster getCluster() {
		return cluster;
	}
}
