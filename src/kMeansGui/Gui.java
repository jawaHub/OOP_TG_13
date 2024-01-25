package kMeansGui;

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
import java.awt.event.ActionEvent;

public class Gui extends JFrame implements MouseListener{

	private static final long serialVersionUID = 1L;
	private JPanel kMeans;
	private DataPanel dataPanel;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Gui frame = new Gui();
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
	public Gui() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		kMeans = new JPanel();
		kMeans.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(kMeans);
		kMeans.setLayout(new BorderLayout(0, 0));
		
		dataPanel = new DataPanel();
		dataPanel.addMouseListener(this);
		kMeans.add(dataPanel);
		
		JPanel btnPanel = new JPanel();
		kMeans.add(btnPanel, BorderLayout.SOUTH);
		
		JButton btLoeschen = new JButton("Löschen");
		btLoeschen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnPanel.add(btLoeschen);
		
		JButton btHinzufuegen = new JButton("Hinzufügen");
		btHinzufuegen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnPanel.add(btHinzufuegen);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		dataPanel.addDatenpunkt(e.getX(),e.getY(), Color.green);
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
