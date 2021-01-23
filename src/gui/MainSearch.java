package gui;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.*;

import media.MediaManager;

public class MainSearch extends JPanel {
	JPanel panel1;
	//private JTable table;
	//TableController tableController;
	//JScrollPane scroll;
	String kwd;
	TableSelectionDemo mediaPane_1;
	public MainSearch() {
		setLayout(null);
		panel1 = new JPanel();
		panel1.setBounds(0,0,1330, 980);
		add(panel1);
		//setLayout(null);
		/*mainPanel = new JPanel();
		setBounds(0,0,1620, 980);
		add(mainPanel);*/
		
		/*GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{1496, 0};
		gbl_panel.rowHeights = new int[]{315, 315, 315, 320, 335, 0};
		gbl_panel.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		mainPanel.setLayout(gbl_panel);*/
		
		//panel1 = new JPanel();
		//scroll = new JScrollPane();
		//scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		//scroll.setViewportView(panel1);
		//GridBagConstraints gbc_scrollPane_1 = new GridBagConstraints();
		//gbc_scrollPane_1.fill = GridBagConstraints.BOTH;
		//gbc_scrollPane_1.insets = new Insets(0, 0, 5, 0);
		//gbc_scrollPane_1.gridx = 0;
		//gbc_scrollPane_1.gridy = 0;
		//mainPanel.add(scroll, gbc_scrollPane_1);
	}
	
	public void tableCreate(String kwd) {
		mediaPane_1 = new TableSelectionDemo();
		mediaPane_1.addComponentsToPane(MediaManager.getInstance());
		mediaPane_1.tableController.loadData(kwd);
		panel1.setLayout(new BorderLayout());
		panel1.add(mediaPane_1, BorderLayout.CENTER);
	}
	
	public void clearTable() {
		panel1.removeAll();
	}

}
