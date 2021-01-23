package gui;

import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.ScrollPaneConstants;
import javax.swing.Timer;
import javax.swing.plaf.basic.BasicScrollBarUI;

import facade.DataEngineInterface;
import gui.SideMenuLeftPane.MyActionListener;
import main.Main;
import manage.Manageable;
import media.CommentManager;
import media.Media;
import media.MediaManager;
import store.Goods;

import javax.swing.JTree;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Rectangle;
import java.awt.RenderingHints;

import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTable;

public class MainMedia extends JPanel{
	JPanel panel1, mainPanel;
	JScrollPane scroll, scroll2, scroll3, scroll4, scroll5, scroll6, scroll7, scroll8, mainScroll;
	String kwd;
	RoundedButton btnNewButton, btnNewButton2;
	JLabel lblNewLabel;
	public Media media;
	public MainMedia(){
		setLayout(null);
		setBounds(0,0,1340, 980);
		
		panel1 = new JPanel();
		
		mainScroll = new JScrollPane();
		mainScroll.setViewportView(panel1);
		mainScroll.setBounds(0,0,1340,980);
		mainScroll.getViewport().getView().setBackground(Color.WHITE);
		add(mainScroll);
		panel1.setLayout(null);
		
		//상단에 있는 제목 설정
		lblNewLabel = new JLabel("전체");
		lblNewLabel.setBounds(586, 5, 400, 30);
		lblNewLabel.setFont(new Font ("HY견고딕", Font.PLAIN, 25));
		panel1.add(lblNewLabel);
		
		pageControllerButtons();//상단에 있는 <<>>버튼 생성

		ArrayList<String> arr = new ArrayList<String>();
		arr.addAll(Main.mediaMgr.titles);
		
		int num = 0;
		if((arr.size()%4) == 0) {
			num = arr.size()/4;
			}
		else {
			num = arr.size()/4;
			num+=1;
			}
		
		JPanel panel = new JPanel(new GridLayout(num+1,4,2,3));
		panel.setBounds(0, 40, 1330, 900);
		
		scroll = new JScrollPane();
		scroll.setBounds(0, 40, 1330, 900);
		scroll.setViewportView(panel);
		scroll.getViewport().getView().setBackground(Color.WHITE);
		panel1.add(scroll);
		createLabel(num, arr, panel);
		createGenre();

		
	}
	public void pageControllerButtons() {
		btnNewButton = new RoundedButton(">>");
		btnNewButton.setBounds(1230, 10, 97, 23);
		panel1.add(btnNewButton);
		
		btnNewButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				String b = lblNewLabel.getText(); 
				if(b.equals("전체")) {
					lblNewLabel.setText("선호장르( "+LogIn.user.getGenre()+")");
					panel1.setVisible(false);
					panel1.remove(scroll);
					panel1.add(scroll2);
					panel1.setVisible(true);
				}
				else if(b.equals("선호장르( "+LogIn.user.getGenre()+")")) {
					lblNewLabel.setText("액션");
					panel1.setVisible(false);
					panel1.remove(scroll2);
					panel1.add(scroll3);
					panel1.setVisible(true);
				}
				else if(b.equals("액션")) {
					lblNewLabel.setText("공포/스릴러");
					panel1.setVisible(false);
					panel1.remove(scroll3);
					panel1.add(scroll4);
					panel1.setVisible(true);
				}
				else if(b.equals("공포/스릴러")) {
					lblNewLabel.setText("코미디");
					panel1.setVisible(false);
					panel1.remove(scroll4);
					panel1.add(scroll5);
					panel1.setVisible(true);
				}
				else if(b.equals("코미디")) {
					lblNewLabel.setText("SF/미스터리");
					panel1.setVisible(false);
					panel1.remove(scroll5);
					panel1.add(scroll6);
					panel1.setVisible(true);
				}
				else if(b.equals("SF/미스터리")) {
					lblNewLabel.setText("드라마");
					panel1.setVisible(false);
					panel1.remove(scroll6);
					panel1.add(scroll7);
					panel1.setVisible(true);
				}
				else if(b.equals("드라마")) {
					lblNewLabel.setText("멜로/로맨스");
					panel1.setVisible(false);
					panel1.remove(scroll7);
					panel1.add(scroll8);
					panel1.setVisible(true);
				}
				else if(b.equals("멜로/로맨스")) {
					lblNewLabel.setText("전체");
					panel1.setVisible(false);
					panel1.remove(scroll8);
					panel1.add(scroll);
					panel1.setVisible(true);
				}
			}
		});
		
		btnNewButton2 = new RoundedButton("<<");
		btnNewButton2.setBounds(10, 10, 97, 23);
		panel1.add(btnNewButton2);
		
		btnNewButton2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				String b = lblNewLabel.getText();
				if(b.equals("전체")) {
					lblNewLabel.setText("멜로/로맨스");
					panel1.setVisible(false);
					panel1.remove(scroll);
					panel1.add(scroll8);
					panel1.setVisible(true);
				}
				else if(b.equals("선호장르( "+LogIn.user.getGenre()+")")) {
					lblNewLabel.setText("전체");
					panel1.setVisible(false);
					panel1.remove(scroll2);
					panel1.add(scroll);
					panel1.setVisible(true);
				}
				else if(b.equals("액션")) {
					lblNewLabel.setText("선호장르( "+LogIn.user.getGenre()+")");
					panel1.setVisible(false);
					panel1.remove(scroll3);
					panel1.add(scroll2);
					panel1.setVisible(true);
				}
				else if(b.equals("공포/스릴러")) {
					lblNewLabel.setText("액션");
					panel1.setVisible(false);
					panel1.remove(scroll4);
					panel1.add(scroll3);
					panel1.setVisible(true);
				}
				else if(b.equals("코미디")) {
					lblNewLabel.setText("공포/스릴러");
					panel1.setVisible(false);
					panel1.remove(scroll5);
					panel1.add(scroll4);
					panel1.setVisible(true);
				}
				else if(b.equals("SF/미스터리")) {
					lblNewLabel.setText("코미디");
					panel1.setVisible(false);
					panel1.remove(scroll6);
					panel1.add(scroll5);
					panel1.setVisible(true);
				}
				else if(b.equals("드라마")) {
					lblNewLabel.setText("SF/미스터리");
					panel1.setVisible(false);
					panel1.remove(scroll7);
					panel1.add(scroll6);
					panel1.setVisible(true);
				}
				else if(b.equals("멜로/로맨스")) {
					lblNewLabel.setText("드라마");
					panel1.setVisible(false);
					panel1.remove(scroll8);
					panel1.add(scroll7);
					panel1.setVisible(true);
				}
			}
		});
		
	}
	
	public void createLabel(int num, ArrayList<String> arr, JPanel panel) {
		
	
		JLabel labels[] = new JLabel[(4*num)];
		for (int i =  0; i < 4*num; i++)
		{
			int overlap = 0;
			if(i == arr.size()) {
				break;
			}
			Media m = null;
		    String title = arr.get(i);
		    for(int j = 0; j<i; j++) {
		    	String title2 = "";
		    	title2 = arr.get(j);
		    	if(title.equals(title2)) {
		    		overlap++;
		    		break;
		    	}
		    }
		    if(overlap!=0) {
		    	continue;
		    }
		    m = Main.mediaMgr.find(title);
		    String address_2 = "mediaImage/"+m.num+".jpg"; //이미지 경로를 String 형식으로 생성
			ImageIcon Icon = new ImageIcon(address_2); 
			Image img=Icon.getImage();
		    Image changeImg = img.getScaledInstance(250,300, Image.SCALE_SMOOTH); //이미지 크기 강제 조정
		    ImageIcon changeIcon = new ImageIcon(changeImg);
		      labels[i] = new JLabel(changeIcon);
		      labels[i].setText(arr.get(i));
		      labels[i].setHorizontalTextPosition(JLabel.CENTER);
		      labels[i].setVerticalTextPosition(JLabel.BOTTOM);
		      labels[i].addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					clickEvent(e, null); // 메소드로 요청
				}
		      });
		      panel.add(labels[i]);
		}
	}
	
	public void panel_2() {
		ArrayList<String> arr = new ArrayList<String>();
		
		for(String genre : LogIn.user.genreList) {
			if(genre.contains("공포")) {
				arr.addAll(Main.mediaMgr.fearTitles);
			}
			else if(genre.contains("스릴러")) {
				arr.addAll(Main.mediaMgr.thrillerTitles);
			}
			else if(genre.contains("액션")) {
				arr.addAll(Main.mediaMgr.actionTitles);
			}
			else if(genre.contains("코미디")) {
				arr.addAll(Main.mediaMgr.comedyTitles);
			}
			else if(genre.contains("SF")) {
				arr.addAll(Main.mediaMgr.sfTitles);
			}
			else if(genre.contains("미스터리")) {
				arr.addAll(Main.mediaMgr.mysteryTitles);
			}
			else if(genre.contains("드라마")) {
				arr.addAll(Main.mediaMgr.dramaTitles);
			}
			else if(genre.contains("멜로")) {
				arr.addAll(Main.mediaMgr.meloTitles);
			}
			else if(genre.contains("로맨스")) {
				arr.addAll(Main.mediaMgr.romanceTitles);
			}
		}
		
		int num = 0;
		
		if((arr.size()%4) == 0) {
			num = arr.size()/4;
		}
		else {
			num = arr.size()/4;
			num+=1;
		}
		
		JPanel panel2 = new JPanel(new GridLayout(num+1,4,2,3));
		panel2.setBounds(0, 40, 1330, 900);
		
		scroll2 = new JScrollPane();
		scroll2.setBounds(0, 40, 1330, 900);
		scroll2.setViewportView(panel2);
		
		createLabel(num, arr, panel2);
		
	}
	public void panel_3() {
		ArrayList<String> arr = new ArrayList<String>();
		arr.addAll(Main.mediaMgr.actionTitles);
		
		int num = 0;
		
		if((arr.size()%4) == 0) {
			num = arr.size()/4;
		}
		else {
			num = arr.size()/4;
			num+=1;
		}
		
		JPanel panel3 = new JPanel(new GridLayout(num+1,4,2,3));
		panel3.setBounds(0, 40, 1330, 900);
		
		scroll3 = new JScrollPane();
		scroll3.setBounds(0, 40, 1330, 900);
		scroll3.setViewportView(panel3);
		
		createLabel(num, arr, panel3);
	}
	
	public void panel_4() {
		ArrayList<String> arr = new ArrayList<>();
		arr.addAll(Main.mediaMgr.fearTitles);
		arr.addAll(Main.mediaMgr.thrillerTitles);
		int num = 0;
		
		if((arr.size()%4) == 0) {
			num = arr.size()/4;
		}
		else {
			num = arr.size()/4;
			num+=1;
		}
		
		JPanel panel4 = new JPanel(new GridLayout(num+1,4,2,3));
		panel4.setBounds(0, 40, 1330, 900);
		
		scroll4 = new JScrollPane();
		scroll4.setBounds(0, 40, 1330, 900);
		scroll4.setViewportView(panel4);
		
		
		createLabel(num, arr, panel4);
		
		
	}
	
	public void panel_5() {
		ArrayList<String> arr = new ArrayList<>();
		arr.addAll(Main.mediaMgr.comedyTitles);
		
		int num = 0;
		
		if((arr.size()%4) == 0) {
			num = arr.size()/4;
		}
		else {
			num = arr.size()/4;
			num+=1;
		}
		
		JPanel panel5 = new JPanel(new GridLayout(num+1,4,2,3));
		panel5.setBounds(0, 40, 1330, 900);
		
		scroll5 = new JScrollPane();
		scroll5.setBounds(0, 40, 1330, 900);
		scroll5.setViewportView(panel5);
		
		
		createLabel(num, arr, panel5);
	}
	
	public void panel_6() {
		ArrayList<String> arr = new ArrayList<>();
		arr.addAll(Main.mediaMgr.sfTitles);
		arr.addAll(Main.mediaMgr.mysteryTitles);
		int num = 0;
		
		if((arr.size()%4) == 0) {
			num = arr.size()/4;
		}
		else {
			num = arr.size()/4;
			num+=1;
		}
		
		JPanel panel6 = new JPanel(new GridLayout(num+1,4,2,3));
		panel6.setBounds(0, 40, 1330, 900);
		
		scroll6 = new JScrollPane();
		scroll6.setBounds(0, 40, 1330, 900);
		scroll6.setViewportView(panel6);
		
		
		createLabel(num, arr, panel6);
	}
	
	public void panel_7() {
		ArrayList<String> arr = new ArrayList<>();
		arr.addAll(Main.mediaMgr.dramaTitles);
		
		int num = 0;
		
		if((arr.size()%4) == 0) {
			num = arr.size()/4;
		}
		else {
			num = arr.size()/4;
			num+=1;
		}
		
		JPanel panel7 = new JPanel(new GridLayout(num+1,4,2,3));
		panel7.setBounds(0, 40, 1330, 900);
		
		scroll7 = new JScrollPane();
		scroll7.setBounds(0, 40, 1330, 900);
		scroll7.setViewportView(panel7);
		
		
		createLabel(num, arr, panel7);
	}
	
	public void panel_8() {
		ArrayList<String> arr = new ArrayList<>();
		arr.addAll(Main.mediaMgr.meloTitles);
		arr.addAll(Main.mediaMgr.romanceTitles);
		
		int num = 0;
		
		if((arr.size()%4) == 0) {
			num = arr.size()/4;
		}
		else {
			num = arr.size()/4;
			num+=1;
		}
		
		JPanel panel8 = new JPanel(new GridLayout(num+1,4,2,3));
		panel8.setBounds(0, 40, 1330, 900);
		
		scroll8 = new JScrollPane();
		scroll8.setBounds(0, 40, 1330, 900);
		scroll8.setViewportView(panel8);
		
		
		createLabel(num, arr, panel8);
	}
	
	public void createGenre() {
		panel_2();
		panel_3();
		panel_4();
		panel_5();
		panel_6();
		panel_7();
		panel_8();
	}
	
	public void clickEvent(MouseEvent e, Media m) {
		MainMenu.mainMedia.setVisible(false);//기존 화면 off
		for(JLabel label : MainMenu.mainMediaInfo.goodsCode) {
			MainMenu.mainMediaInfo.panel2.remove(label);
		}
		media = null;
		if(m == null) {
			JLabel name = (JLabel)e.getSource();
			String title = name.getText();
			media = (Media)Main.mediaMgr.find(title);//제목과 일치하는 media 불러오기
		} else {
			media = m;
		}
		
		MainMediaInfo.seletedMedia = media; // 선택된 media의 결제를 위해 
		String genre = ""; //genre String 생성
		for(String g : media.genreList) {
			genre+=g+" ";
		}
		String country = ""; //country String 생성
		for(String c : media.countryList) {
			country+=c+" ";
		}
		//panelLeftUp 제어 관련
		int age = media.age;
		String s = "";
		if(age == 0) {
			s = "전체관람가";
		} 
		else if(age == 19){
			s = "청소년관람불가";
		}	
	    else {
	    	s = age+"세관람가";
		}
		MainMenu.mainMediaInfo.lblNewLabel_1.setText("<html><h1>"+media.title+"("+media.year+")</h1><br/>"+
		"● 평점 : "+media.rate+"점(조회수 "+media.view+"회)<br/>● 가격: "+media.price+"원<br/>● 등급: "+s+"<br/>"+"● 장르: "+genre+" ● 국가: "+country+
		"<br/>● 제작사: "+media.company+" ● 감독: "+media.director+"<br/>● 내용: "+media.information+"<br/><html/>");
		JLabel lblNewLabel_2 = new JLabel("연관 상품: ");
		lblNewLabel_2.setBounds(32, 250, 76, 29);
		MainMenu.mainMediaInfo.panel2.add(lblNewLabel_2);
		
		MainMenu.mainMediaInfo.goodsCode = new JLabel[media.goodsList.size()];
		for(int i = 0; i<media.goodsList.size(); i++) {
			String num = ""+media.goodsList.get(i);//클릭된 영상의 고유번호를 String으로 변환
			String address="goodsImage/"+num+".jpg";//이미지 경로를 String 형식으로 생성
			ImageIcon icon = new ImageIcon(address);
		    Image img=icon.getImage();
		    Image changeImg = img.getScaledInstance(90, 90, Image.SCALE_SMOOTH);
		    ImageIcon changeIcon = new ImageIcon(changeImg);
		    MainMenu.mainMediaInfo.goodsCode[i] = new JLabel(changeIcon);
		    MainMenu.mainMediaInfo.goodsCode[i].setText(num);
		    MainMenu.mainMediaInfo.goodsCode[i].setHorizontalTextPosition(JLabel.CENTER);
		    MainMenu.mainMediaInfo.goodsCode[i].setVerticalTextPosition(JLabel.BOTTOM);
			MainMenu.mainMediaInfo.goodsCode[i].setBounds(32+((i+1)*95), 250, 90, 80);
			MainMenu.mainMediaInfo.goodsCode[i].addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					MainMenu.mainMediaInfo.setVisible(false);
					MainMenu.mainStore.clickEvent(e);
				}
		      });
			MainMenu.mainMediaInfo.panel2.add(MainMenu.mainMediaInfo.goodsCode[i]);
		}
		
		//panelLeftDown 제어 관련 (수정필요)
		MainMenu.mainMediaInfo.clearTable();
		MainMenu.mainMediaInfo.setVisible(false);
		MainMenu.mainMediaInfo.tableCreate(media.num);
		MainMenu.mainMediaInfo.setVisible(true);
		
		//panelRight 제어 관련
		String num = Integer.toString(media.num);//클릭된 영상의 고유번호를 String으로 변환
		String address="mediaImage/"+num+".jpg";//이미지 경로를 String 형식으로 생성
		ImageIcon icon = new ImageIcon(address);
	    Image img=icon.getImage();
	    Image changeImg = img.getScaledInstance(400,600, Image.SCALE_SMOOTH);
	    ImageIcon changeIcon = new ImageIcon(changeImg);
	    MainMenu.mainMediaInfo.lblNewLabel.setIcon(changeIcon);
		MainMenu.mainMediaInfo.setVisible(true);
	}
	
	//버튼 디자인
	public class RoundedButton extends JButton {
		public RoundedButton() { super(); decorate(); } 
		public RoundedButton(String text) { super(text); decorate(); } 
		public RoundedButton(Action action) { super(action); decorate(); } 
		public RoundedButton(Icon icon) { super(icon); decorate(); } 
		public RoundedButton(String text, Icon icon) { super(text, icon); decorate(); } 
		protected void decorate() { setBorderPainted(false); setOpaque(false); }
		@Override 
		protected void paintComponent(Graphics g) {
			Color c=new Color(249,172,25);
			int width = getWidth(); 
			int height = getHeight(); 
			Graphics2D graphics = (Graphics2D) g; 
			graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON); 
			if (getModel().isArmed()) { graphics.setColor(c.darker()); } 
			else if (getModel().isRollover()) { graphics.setColor(c.brighter()); } 
			else { graphics.setColor(c); } 
			graphics.fillRoundRect(0, 0, width, height, 10, 10); 
			FontMetrics fontMetrics = graphics.getFontMetrics(); 
			Rectangle stringBounds = fontMetrics.getStringBounds(this.getText(), graphics).getBounds(); 
			int textX = (width - stringBounds.width) / 2; 
			int textY = (height - stringBounds.height) / 2 + fontMetrics.getAscent(); 
			graphics.setColor(Color.white); 
			graphics.setFont(getFont()); 
			graphics.drawString(getText(), textX, textY); 
			graphics.dispose(); 
			super.paintComponent(g); 
			}
		}
}
