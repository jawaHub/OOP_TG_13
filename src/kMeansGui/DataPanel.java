package kMeansGui;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class DataPanel extends JPanel {

	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		g.setColor(Color.CYAN);
		g.drawLine(0, 0, 20, 200);
	}

	public void addDatenpunkt(int x, int y, Color color) {
		System.out.println("DatenPunkt: " + x + " " + y + " " + color);
	}

}