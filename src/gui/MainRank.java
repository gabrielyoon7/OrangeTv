package gui;

import java.awt.*;
import javax.swing.*;

import media.MediaManager;

public class MainRank extends JPanel{
	JPanel panel;
	JPanel panel_1, panel_2, panel_3, panel_4, panel_5, panel_6, panel_7;
	JPanel titlePanel_1, titlePanel_2, titlePanel_3, titlePanel_4, titlePanel_5, titlePanel_6, titlePanel_7;
	JPanel media_1;
	JScrollPane scrollPane, scrollPane_1, scrollPane_2, scrollPane_3, scrollPane_4, scrollPane_5, scrollPane_6, scrollPane_7;
	private JTable table;
	TableController tableController;
	/*Timer tm;
    int x = 0;
    int w;
    int h;
    String[] list = {
        "C:\\Users\\HARITI\\Desktop\\sat.jpg",
        "C:\\Users\\HARITI\\Desktop\\mtab.jpg",
        "C:\\Users\\HARITI\\Desktop\\abc.jpg"
    };
    
    JLabel lblNewLabel = new JLabel();*/
	@SuppressWarnings("null")
	public MainRank() {//너무 길고 복잡해서 메소드로 나눠버렸습니다.
		setLayout(null);
		setBounds(0,0,1330, 980);
		panel1();//전체
		panel2();//드라마
		panel3();//애니
		panel4();//다큐시리즈
		panel5();//다큐영화
		panel6();//영화
		panel7();
	}
	public void panel1() {
		panel = new JPanel();
		//panel.setBounds(0,0,1520, 1420);
		//add(panel);
		
		scrollPane = new JScrollPane();
		scrollPane.setViewportView(panel);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		//scrollPane.getVerticalScrollBar().setUnitIncrement(1000);
		scrollPane.setBounds(0,0,1330,980);
		scrollPane.getViewport().getView().setBackground(Color.WHITE);
		add(scrollPane);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{50, 1155, 0};
		gbl_panel.rowHeights = new int[]{100, 210, 105, 210, 105, 210, 105, 215, 105, 215, 105, 230, 105, 215, 0};
		gbl_panel.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		titlePanel_1 = new JPanel();
		titlePanel_1.setLayout(null);
		titlePanel_1.setBackground(Color.white);
		GridBagConstraints gbc_titlePanel_1 = new GridBagConstraints();
		gbc_titlePanel_1.fill = GridBagConstraints.BOTH;
		gbc_titlePanel_1.insets = new Insets(0, 0, 5, 0);
		gbc_titlePanel_1.gridx = 1;
		gbc_titlePanel_1.gridy = 0;
		panel.add(titlePanel_1, gbc_titlePanel_1);
		
		JLabel lblNewLabel = new JLabel("전체");
		lblNewLabel.setBounds(0, 28, 122, 57);
		lblNewLabel.setFont(new Font("HY견고딕", Font.BOLD, 25));
		lblNewLabel.setOpaque(true);
		lblNewLabel.setBackground(Color.white);
		titlePanel_1.add(lblNewLabel);
		
		panel_1 = new JPanel();
		scrollPane_1 = new JScrollPane();
		scrollPane_1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane_1.setViewportView(panel_1);
		GridBagConstraints gbc_scrollPane_1 = new GridBagConstraints();
		gbc_scrollPane_1.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_1.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane_1.gridx = 1;
		gbc_scrollPane_1.gridy = 1;
		panel.add(scrollPane_1, gbc_scrollPane_1);
		
		TableSelectionDemo mediaPane_1 = new TableSelectionDemo();
		mediaPane_1.addComponentsToPane(MediaManager.getInstance());
		panel_1.setLayout(new BorderLayout());
		panel_1.add(mediaPane_1, BorderLayout.CENTER);
		
	}
	public void panel2() {
		panel_2 = new JPanel();
		panel_2.setLayout(null);
		
		titlePanel_2 = new JPanel();
		titlePanel_2.setLayout(null);
		titlePanel_2.setBackground(Color.white);
		GridBagConstraints gbc_titlePanel_2 = new GridBagConstraints();
		gbc_titlePanel_2.fill = GridBagConstraints.BOTH;
		gbc_titlePanel_2.insets = new Insets(0, 0, 5, 0);
		gbc_titlePanel_2.gridx = 1;
		gbc_titlePanel_2.gridy = 2;
		panel.add(titlePanel_2, gbc_titlePanel_2);
		
		JLabel lblNewLabel_2 = new JLabel("드라마");
		lblNewLabel_2.setBounds(0, 28, 122, 57);
		lblNewLabel_2.setFont(new Font("HY견고딕", Font.BOLD, 25));
		titlePanel_2.add(lblNewLabel_2);
		
		scrollPane_2 = new JScrollPane();
		scrollPane_2.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane_2.setViewportView(panel_2);
		GridBagConstraints gbc_scrollPane_2 = new GridBagConstraints();
		gbc_scrollPane_2.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_2.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane_2.gridx = 1;
		gbc_scrollPane_2.gridy = 3;
		panel.add(scrollPane_2, gbc_scrollPane_2);
		
		TableSelectionDemo mediaPane_2 = new TableSelectionDemo();
		mediaPane_2.addComponentsToPane(MediaManager.getInstance());
		mediaPane_2.tableController.loadData(""+1);
		panel_2.setLayout(new BorderLayout());
		panel_2.add(mediaPane_2, BorderLayout.CENTER);
	}
	public void panel3() {
		panel_3 = new JPanel();
		panel_3.setLayout(null);
		
		titlePanel_3 = new JPanel();
		titlePanel_3.setLayout(null);
		titlePanel_3.setBackground(Color.white);
		GridBagConstraints gbc_titlePanel_3 = new GridBagConstraints();
		gbc_titlePanel_3.fill = GridBagConstraints.BOTH;
		gbc_titlePanel_3.insets = new Insets(0, 0, 5, 0);
		gbc_titlePanel_3.gridx = 1;
		gbc_titlePanel_3.gridy = 4;
		panel.add(titlePanel_3, gbc_titlePanel_3);
		
		JLabel lblNewLabel_3 = new JLabel("애니메이션");
		lblNewLabel_3.setBounds(0, 28, 190, 57);
		lblNewLabel_3.setFont(new Font("HY견고딕", Font.BOLD, 25));
		titlePanel_3.add(lblNewLabel_3);
		
		scrollPane_3 = new JScrollPane();
		scrollPane_3.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane_3.setViewportView(panel_3);
		GridBagConstraints gbc_scrollPane_3 = new GridBagConstraints();
		gbc_scrollPane_3.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_3.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane_3.gridx = 1;
		gbc_scrollPane_3.gridy = 5;
		panel.add(scrollPane_3, gbc_scrollPane_3);
		
		TableSelectionDemo mediaPane_3 = new TableSelectionDemo();
		mediaPane_3.addComponentsToPane(MediaManager.getInstance());
		mediaPane_3.tableController.loadData(""+2);
		panel_3.setLayout(new BorderLayout());
		panel_3.add(mediaPane_3, BorderLayout.CENTER);
	}
	public void panel4() {
		panel_4 = new JPanel();
		panel_4.setLayout(null);
		
		titlePanel_4 = new JPanel();
		titlePanel_4.setLayout(null);
		titlePanel_4.setBackground(Color.white);
		GridBagConstraints gbc_titlePanel_4 = new GridBagConstraints();
		gbc_titlePanel_4.fill = GridBagConstraints.BOTH;
		gbc_titlePanel_4.insets = new Insets(0, 0, 5, 0);
		gbc_titlePanel_4.gridx = 1;
		gbc_titlePanel_4.gridy = 6;
		panel.add(titlePanel_4, gbc_titlePanel_4);
		
		JLabel lblNewLabel_4 = new JLabel("버라이어티");
		lblNewLabel_4.setBounds(0, 28, 190, 57);
		lblNewLabel_4.setFont(new Font("HY견고딕", Font.BOLD, 25));
		titlePanel_4.add(lblNewLabel_4);
		
		scrollPane_4 = new JScrollPane();
		scrollPane_4.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane_4.setViewportView(panel_4);
		GridBagConstraints gbc_scrollPane_4 = new GridBagConstraints();
		gbc_scrollPane_4.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_4.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane_4.gridx = 1;
		gbc_scrollPane_4.gridy = 7;
		panel.add(scrollPane_4, gbc_scrollPane_4);
		
		TableSelectionDemo mediaPane_4 = new TableSelectionDemo();
		mediaPane_4.addComponentsToPane(MediaManager.getInstance());
		mediaPane_4.tableController.loadData(""+3);
		panel_4.setLayout(new BorderLayout());
		panel_4.add(mediaPane_4, BorderLayout.CENTER);
	}
	public void panel5() {
		panel_5 = new JPanel();
		panel_5.setLayout(null);
		
		titlePanel_5 = new JPanel();
		titlePanel_5.setLayout(null);
		titlePanel_5.setBackground(Color.white);
		GridBagConstraints gbc_titlePanel_5 = new GridBagConstraints();
		gbc_titlePanel_5.fill = GridBagConstraints.BOTH;
		gbc_titlePanel_5.insets = new Insets(0, 0, 5, 0);
		gbc_titlePanel_5.gridx = 1;
		gbc_titlePanel_5.gridy = 8;
		panel.add(titlePanel_5, gbc_titlePanel_5);
		
		JLabel lblNewLabel_5 = new JLabel("다큐시리즈");
		lblNewLabel_5.setBounds(0, 28, 190, 57);
		lblNewLabel_5.setFont(new Font("HY견고딕", Font.BOLD, 25));
		titlePanel_5.add(lblNewLabel_5);
		
		scrollPane_5 = new JScrollPane();
		scrollPane_5.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane_5.setViewportView(panel_5);
		GridBagConstraints gbc_scrollPane_5 = new GridBagConstraints();
		gbc_scrollPane_5.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_5.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane_5.gridx = 1;
		gbc_scrollPane_5.gridy = 9;
		panel.add(scrollPane_5, gbc_scrollPane_5);
		
		TableSelectionDemo mediaPane_5 = new TableSelectionDemo();
		mediaPane_5.addComponentsToPane(MediaManager.getInstance());
		mediaPane_5.tableController.loadData(""+4);
		panel_5.setLayout(new BorderLayout());
		panel_5.add(mediaPane_5, BorderLayout.CENTER);
	}
	public void panel6() {
		panel_6 = new JPanel();
		panel_6.setLayout(null);
		
		titlePanel_6 = new JPanel();
		titlePanel_6.setLayout(null);
		titlePanel_6.setBackground(Color.white);
		GridBagConstraints gbc_titlePanel_6 = new GridBagConstraints();
		gbc_titlePanel_6.fill = GridBagConstraints.BOTH;
		gbc_titlePanel_6.insets = new Insets(0, 0, 5, 0);
		gbc_titlePanel_6.gridx = 1;
		gbc_titlePanel_6.gridy = 10;
		panel.add(titlePanel_6, gbc_titlePanel_6);
		
		JLabel lblNewLabel_6 = new JLabel("다큐영화");
		lblNewLabel_6.setBounds(0, 28, 190, 57);
		lblNewLabel_6.setFont(new Font("HY견고딕", Font.BOLD, 25));
		titlePanel_6.add(lblNewLabel_6);
		
		scrollPane_6 = new JScrollPane();
		scrollPane_6.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane_6.setViewportView(panel_6);
		GridBagConstraints gbc_scrollPane_6 = new GridBagConstraints();
		gbc_scrollPane_6.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_6.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane_6.gridx = 1;
		gbc_scrollPane_6.gridy = 11;
		panel.add(scrollPane_6, gbc_scrollPane_6);
		
		TableSelectionDemo mediaPane_6 = new TableSelectionDemo();
		mediaPane_6.addComponentsToPane(MediaManager.getInstance());
		mediaPane_6.tableController.loadData(""+5);
		panel_6.setLayout(new BorderLayout());
		panel_6.add(mediaPane_6, BorderLayout.CENTER);
	}
	public void panel7() {
		panel_7 = new JPanel();
		panel_7.setLayout(null);
		
		titlePanel_7 = new JPanel();
		titlePanel_7.setLayout(null);
		titlePanel_7.setBackground(Color.white);
		
		GridBagConstraints gbc_titlePanel_7 = new GridBagConstraints();
		gbc_titlePanel_7.fill = GridBagConstraints.BOTH;
		gbc_titlePanel_7.insets = new Insets(0, 0, 5, 0);
		gbc_titlePanel_7.gridx = 1;
		gbc_titlePanel_7.gridy = 12;
		panel.add(titlePanel_7, gbc_titlePanel_7);
		
		JLabel lblNewLabel_7 = new JLabel("영화");
		lblNewLabel_7.setBounds(0, 28, 190, 57);
		lblNewLabel_7.setFont(new Font("HY견고딕", Font.BOLD, 25));
		titlePanel_7.add(lblNewLabel_7);
		
		scrollPane_7 = new JScrollPane();
		scrollPane_7.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane_7.setViewportView(panel_7);
		GridBagConstraints gbc_scrollPane_7 = new GridBagConstraints();
		gbc_scrollPane_7.anchor = GridBagConstraints.NORTH;
		gbc_scrollPane_7.fill = GridBagConstraints.HORIZONTAL;
		gbc_scrollPane_7.gridx = 1;
		gbc_scrollPane_7.gridy = 13;
		panel.add(scrollPane_7, gbc_scrollPane_7);
		
		TableSelectionDemo mediaPane_7 = new TableSelectionDemo();
		mediaPane_7.addComponentsToPane(MediaManager.getInstance());
		mediaPane_7.tableController.loadData(""+6);
		panel_7.setLayout(new BorderLayout());
		panel_7.add(mediaPane_7, BorderLayout.CENTER);
	}
}