package kMeansGui.src.kMeansGui2;

import java.awt.Color;
import java.util.ArrayList;

public class MyCluster2 {
	
	ArrayList<MyData2> data;
	String name;
	int x;
	int y;
	Color color;
	
	public MyCluster2(String name, int x, int y, Color color) {
		this.name = name;
		this.x = x;
		this.y = y;
		data = new ArrayList<MyData2>();
		this.color = color;
	}
	public ArrayList<MyData2> getData() {
		return data;
	}
	public String getName() {
		return name;
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
	public void addDdata(MyData2 data) {
		this.data.add(data);
	}
	public void clearData() {
		this.data.clear();
	}
	public void setData(ArrayList<MyData2> data) {
		this.data = data;
	}
	public void setX(int x) {
		this.x = x;
	}
	public void setY(int y) {
		this.y = y;
	}
	
	
}
