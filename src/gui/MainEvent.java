package gui;

import java.awt.BorderLayout;

import javax.swing.JPanel;

import media.CommentManager;
import media.MediaManager;

public class MainEvent extends JPanel{
	/*
	 * 리뷰/평점 클래스입니다.
	 */
	JPanel panel1;
	TableSelectionDemo mediaPane_1;
	public MainEvent() {
		setLayout(null);
		panel1 = new JPanel();
		panel1.setBounds(0,0,1330, 980);
		add(panel1);
		tableCreate("");
	}
	
	public void tableCreate(String kwd) {
		mediaPane_1 = new TableSelectionDemo();
		mediaPane_1.addComponentsToPane(CommentManager.getInstance());
		mediaPane_1.tableController.loadData(kwd);
		panel1.setLayout(new BorderLayout());
		panel1.add(mediaPane_1, BorderLayout.CENTER);
	}
	
	public void clearTable() {
		panel1.removeAll();
	}
}
