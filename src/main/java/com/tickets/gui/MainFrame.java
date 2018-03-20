package com.tickets.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.BoxLayout;
import javax.swing.JFrame;

public class MainFrame extends JFrame {
	DataIntroductionPanel dataIntroductionPanel;
	ResultsPanel resultsPanel;
	BorderLayout layout;
	
	public MainFrame() {
		layout = new BorderLayout();
		this.setLayout(layout);
		
		dataIntroductionPanel = new DataIntroductionPanel();
		this.add(dataIntroductionPanel, BorderLayout.PAGE_START);
		
		resultsPanel = new ResultsPanel();
		this.add(resultsPanel, BorderLayout.CENTER);
		
		this.setTitle("Ticket combinator");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setExtendedState(this.getExtendedState() | JFrame.MAXIMIZED_BOTH);
		this.setVisible(true);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		pack();
		setSize(screenSize.width,screenSize.height);
	}

}
