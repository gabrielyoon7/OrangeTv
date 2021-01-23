package gui;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Label;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

import javax.swing.Action;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class SideMenuLeftPane extends JPanel{
	MenuSwitch menuSwitch = new MenuSwitch();
	public SideMenuLeftPane(){
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.setBorder(BorderFactory.createEmptyBorder(10,10,10,10) );
		add(Box.createVerticalStrut(10));
		//setLayout(new FlowLayout(HEIGHT, 30, 30));
		RoundedButton [] buttonArray = new RoundedButton[5];
		buttonArray[0]=new RoundedButton("  메 인  ");
		buttonArray[1]=new RoundedButton("  순 위  ");
		buttonArray[2]=new RoundedButton(" 스토어 ");
		buttonArray[3]=new RoundedButton(" 내 영상 ");
		buttonArray[4]=new RoundedButton("평점/리뷰");
		for(int i=0; i<5; i++) {
			add(buttonArray[i]);
			buttonArray[i].setAlignmentX(LEFT_ALIGNMENT);
			//buttonArray[i].setAlignmentX(CENTER_ALIGNMENT);
			buttonArray[i].setSize(200, 170);
			buttonArray[i].setFont(new Font ("HY견고딕", Font.PLAIN, 40));
			buttonArray[i].addActionListener(new MyActionListener());
			add(Box.createVerticalStrut(30));
		}
		
	}
	class MyActionListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			//RoundedButton b =(RoundedButton)e.getSource();
			//menuSwitch.change(b.getText());
			// 버튼 액션 리스너 메소드 변경, change 메소드에 넣어서 돌려보니 오류떠서 리스너 메소드에 넣음.
			//버튼이 눌렸을 때 해당 버튼과 관련있는 것만 true로 하고 나머지는 전부 false로 처리함.
			String b = e.getActionCommand();
			if(b.equals("  메 인  ")) {
				DefaultFrame.mainMenu.mainMedia.setVisible(true);
				DefaultFrame.mainMenu.mainRank.setVisible(false);
				DefaultFrame.mainMenu.mainStore.setVisible(false);
				DefaultFrame.mainMenu.mainCart.setVisible(false);
				DefaultFrame.mainMenu.mainSearch.setVisible(false);
				DefaultFrame.mainMenu.mainMediaInfo.setVisible(false);
				DefaultFrame.mainMenu.mainStoreInfo.setVisible(false);
				DefaultFrame.mainMenu.mainMyMedia.setVisible(false);
				DefaultFrame.mainMenu.mainEvent.setVisible(false);
			}else if(b.equals("  순 위  ")){
				DefaultFrame.mainMenu.mainMedia.setVisible(false);
				DefaultFrame.mainMenu.mainRank.setVisible(true);
				DefaultFrame.mainMenu.mainStore.setVisible(false);
				DefaultFrame.mainMenu.mainCart.setVisible(false);
				DefaultFrame.mainMenu.mainSearch.setVisible(false);
				DefaultFrame.mainMenu.mainMediaInfo.setVisible(false);
				DefaultFrame.mainMenu.mainStoreInfo.setVisible(false);
				DefaultFrame.mainMenu.mainMyMedia.setVisible(false);
				DefaultFrame.mainMenu.mainEvent.setVisible(false);

			}else if(b.equals(" 스토어 ")){
				DefaultFrame.mainMenu.mainMedia.setVisible(false);
				DefaultFrame.mainMenu.mainRank.setVisible(false);
				DefaultFrame.mainMenu.mainStore.setVisible(true);
				DefaultFrame.mainMenu.mainCart.setVisible(false);
				DefaultFrame.mainMenu.mainSearch.setVisible(false);
				DefaultFrame.mainMenu.mainMediaInfo.setVisible(false);
				DefaultFrame.mainMenu.mainStoreInfo.setVisible(false);
				DefaultFrame.mainMenu.mainMyMedia.setVisible(false);
				DefaultFrame.mainMenu.mainEvent.setVisible(false);

			}else if(b.equals(" 내 영상 ")){
				DefaultFrame.mainMenu.mainMedia.setVisible(false);
				DefaultFrame.mainMenu.mainRank.setVisible(false);
				DefaultFrame.mainMenu.mainStore.setVisible(false);
				DefaultFrame.mainMenu.mainCart.setVisible(false);
				DefaultFrame.mainMenu.mainSearch.setVisible(false);
				DefaultFrame.mainMenu.mainMediaInfo.setVisible(false);
				DefaultFrame.mainMenu.mainStoreInfo.setVisible(false);
				DefaultFrame.mainMenu.mainMyMedia.setVisible(true);
				DefaultFrame.mainMenu.mainEvent.setVisible(false);

			}else if(b.equals("평점/리뷰")){
				DefaultFrame.mainMenu.mainMedia.setVisible(false);
				DefaultFrame.mainMenu.mainRank.setVisible(false);
				DefaultFrame.mainMenu.mainStore.setVisible(false);
				DefaultFrame.mainMenu.mainCart.setVisible(false);
				DefaultFrame.mainMenu.mainSearch.setVisible(false);
				DefaultFrame.mainMenu.mainMediaInfo.setVisible(false);
				DefaultFrame.mainMenu.mainStoreInfo.setVisible(false);
				DefaultFrame.mainMenu.mainMyMedia.setVisible(false);
				DefaultFrame.mainMenu.mainEvent.setVisible(true);
			}else {
				
			}
		}
		
	}
	
	@SuppressWarnings("serial")
	class MenuSwitch extends JPanel{
		public MainMedia mainMedia;
		public MainRank mainRank;
		public MainStore mainStore;
		public MainCart mainCart;
		public MainEvent mainEvent;
		public MainMediaInfo mainMediaInfo;
		public void change(String b) {
			DefaultFrame.mainMenu.removeAll();
			if(b.equals("  메 인  ")) {
				mainMedia=new MainMedia();
				mainMedia.setBounds(0,0,1620, 980);
				mainMedia.setBackground(Color.WHITE);
				DefaultFrame.mainMenu.add(mainMedia);
			}else if(b.equals("  순 위  ")){
				mainRank = new MainRank();
				mainRank.setBounds(0,0,1620,980);
				mainRank.setBackground(Color.WHITE);
				DefaultFrame.mainMenu.add(mainRank);
			}else if(b.equals(" 스토어 ")){
				mainStore=new MainStore();
				mainStore.setBounds(0,0,1620, 980);
				mainStore.setBackground(Color.WHITE);
				DefaultFrame.mainMenu.add(mainStore);
			}else if(b.equals(" 내 영상 ")){
				mainCart=new MainCart();
				mainCart.setBounds(0,0,1620, 980);
				mainCart.setBackground(Color.WHITE);
				DefaultFrame.mainMenu.add(mainCart);
			}else if(b.equals("평점/리뷰")){
				
			}else {
				
			}
			
		}
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

