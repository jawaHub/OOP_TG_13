package kMeansGui.src.kMeansGui2;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;
import java.awt.event.ActionEvent;

public class Gui2 extends JFrame implements MouseListener{

	private static final long serialVersionUID = 1L;
	private JPanel kMeans;
	private DataPanel2 dataPanel;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Gui2 frame = new Gui2();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Gui2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		kMeans = new JPanel();
		kMeans.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(kMeans);
		kMeans.setLayout(new BorderLayout(0, 0));
		
		dataPanel = new DataPanel2();
		dataPanel.addMouseListener(this);
		kMeans.add(dataPanel);
		
		JPanel btnPanel = new JPanel();
		kMeans.add(btnPanel, BorderLayout.SOUTH);
		
		JButton btLoeschen = new JButton("Löschen");
		btLoeschen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dataPanel.loeschen();
				dataPanel.repaint();
			}
		});
		btnPanel.add(btLoeschen);
		
		JButton btnData = new JButton("Data");
		btnData.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dataPanel.aktivateData();
			}
		});
		btnPanel.add(btnData);
		
		JButton btnCluster = new JButton("Cluster");
		btnCluster.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dataPanel.aktivateCluster();
			}
		});
		btnPanel.add(btnCluster);
		
		JButton btnBerechnen = new JButton("Berechnen");
		btnBerechnen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dataPanel.start();
				dataPanel.repaint();
			}
		});
		btnPanel.add(btnBerechnen);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		Random rand = new Random();
		if(dataPanel.mode == dataPanel.CLUSTER)dataPanel.add(e.getX(),e.getY(), Color.BLACK);
		else {
			dataPanel.add(e.getX(), e.getY(), Color.BLACK);
			for (int i = 5; i < 30; i++) {
				int a = i * 10 + 20;
				dataPanel.add(e.getX() + rand.nextInt(a),e.getY() + rand.nextInt(a), Color.BLACK);
				dataPanel.add(e.getX() - rand.nextInt(a),e.getY() + rand.nextInt(a), Color.BLACK);
				dataPanel.add(e.getX() - rand.nextInt(a),e.getY() - rand.nextInt(a), Color.BLACK);
				dataPanel.add(e.getX() + rand.nextInt(a),e.getY() - rand.nextInt(a), Color.BLACK);
			}
		}
		dataPanel.eliminateWrongData();
		dataPanel.repaint();
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
