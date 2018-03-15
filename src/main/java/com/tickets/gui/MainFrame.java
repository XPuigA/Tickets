package com.tickets.gui;

import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MainFrame extends JFrame {
	DataIntroductionPanel dataIntroductionPanel;
	public MainFrame() {
		dataIntroductionPanel = new DataIntroductionPanel();
		this.add(dataIntroductionPanel);
		this.setTitle("Ticket combinator");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setExtendedState(this.getExtendedState() | JFrame.MAXIMIZED_BOTH);
		this.setVisible(true);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		pack();
		setSize(screenSize.width,screenSize.height);
	}

}
