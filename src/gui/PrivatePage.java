package gui;

import javax.swing.JPanel;

import gui.SideMenuLeftPane.MyActionListener;
import gui.SideMenuLeftPane.RoundedButton;
import media.CommentManager;
import store.OrderManager;
import user.UserManager;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Action;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class PrivatePage extends JPanel{
	
	RoundedButton btnNewButton;
	RoundedButton btnNewButton_1;
	RoundedButton btnNewButton_2;
	
	JLabel lblNewLabel_6;
	
	PrivateInfo privateInfo;
	PointCharger pointCharger;
	private GUIMain main;
	
	public PrivatePage() {
		setLayout(null);
		setBounds(1215,0,405, 490);
		btnNewButton = new RoundedButton("로그아웃");
		btnNewButton.setBounds(50, 405, 295, 49);
		btnNewButton.setFont(new Font("고딕", Font.BOLD, 17));
		btnNewButton.addActionListener(new ActionButton());
		add(btnNewButton);
	
		btnNewButton_1 = new RoundedButton("충전하기");
		btnNewButton_1.setBounds(200, 350, 145, 49);
		btnNewButton.setFont(new Font("고딕", Font.PLAIN, 17));
		btnNewButton_1.addActionListener(new ActionButton());
		add(btnNewButton_1);
		
		btnNewButton_2 = new RoundedButton("구매이력");
		btnNewButton_2.setBounds(50, 350, 145, 49);
		btnNewButton.setFont(new Font("고딕", Font.PLAIN, 17));
		btnNewButton_2.addActionListener(new ActionButton());
		add(btnNewButton_2);
		
		JLabel lblNewLabel = new JLabel("\uC774\uB984(Level)");
		lblNewLabel.setBounds(43, 56, 76, 25);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\uC0DD\uB144\uC6D4\uC77C(\uC131\uBCC4)");
		lblNewLabel_1.setBounds(43, 103, 105, 25);
		add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("\uC120\uD638\uD558\uB294 \uC7A5\uB974");
		lblNewLabel_2.setBounds(43, 149, 105, 15);
		add(lblNewLabel_2);
		
		JLabel label = new JLabel("\uD3EC\uC778\uD2B8(\uC6D4\uC815\uC561 \uC5EC\uBD80)");
		label.setBounds(43, 193, 131, 15);
		add(label);
		
		JLabel lblNewLabel_3 = new JLabel(LogIn.user.getName()+"님 ("+LogIn.user.getLevel()+")");
		lblNewLabel_3.setBounds(215, 61, 165, 15);
		add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel(LogIn.user.getBirthday()+" ("+LogIn.user.getGender()+")");
		lblNewLabel_4.setBounds(215, 108, 165, 15);
		add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel(LogIn.user.getGenre());
		lblNewLabel_5.setBounds(215, 149, 165, 15);
		add(lblNewLabel_5);
		
		lblNewLabel_6 = new JLabel(LogIn.user.point+"점 ("+LogIn.user.getPremium()+")");
		lblNewLabel_6.setBounds(215, 193, 165, 15);
		add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("\uC804\uD654\uBC88\uD638");
		lblNewLabel_7.setBounds(43, 239, 57, 15);
		add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel(LogIn.user.getPhoneNumber());
		lblNewLabel_8.setBounds(215, 239, 165, 15);
		add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("\uCE74\uB4DC\uBC88\uD638");
		lblNewLabel_9.setBounds(43, 279, 57, 15);
		add(lblNewLabel_9);
		
		JLabel lblNewLabel_10 = new JLabel(LogIn.user.getCardNumber());
		lblNewLabel_10.setBounds(215, 279, 165, 15);
		add(lblNewLabel_10);
		
	}
	class ActionButton implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			String button = e.getActionCommand();
			
			if(button.equals("구매이력")) {
				//개인정보 팝업 뜨기
				//JOptionPane.showMessageDialog(GUIMain.mainFrame, "Click: ");
				//구매이력 뜨게 설계해야함.
				privateInfo = new PrivateInfo();
			} else if(button.equals("충전하기")) {
				//결제 팝업 뜨기
				pointCharger = new PointCharger();
				setVisible(false);
				setVisible(true);
			} else if(button.equals("로그아웃")){
				main.mainFrame.setVisible(false);
				main.login.LogOut();
			}
			else {
				
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
	class PointCharger extends JFrame{
		JButton btnNewButton;
		JButton btnNewButton1;
		JButton btnNewButton2;
		JButton [] buttonArray = new JButton[6];
	    public PointCharger() {
	        // setting
	        setTitle("포인트 충전하기");
	        //setSize(280, 150);
	        setSize(650, 360);
	        setResizable(false);
	        setLocation(600, 350);
	        setVisible(true);        // visible
	        setLayout(new GridLayout(3,0));
			buttonArray[0]=new JButton("50000포인트");
			buttonArray[1]=new JButton("30000포인트");
			buttonArray[2]=new JButton("10000포인트");
			buttonArray[3]=new JButton("5000포인트");
			buttonArray[4]=new JButton("1000포인트");
			buttonArray[5]=new JButton("OrangeTv Premium 신청");
			for(int i=0; i<6; i++) {
				add(buttonArray[i]);
				buttonArray[i].setAlignmentX(LEFT_ALIGNMENT);
				//buttonArray[i].setAlignmentX(CENTER_ALIGNMENT);
				buttonArray[i].setSize(100, 50);
				buttonArray[i].setFont(new Font ("HY견고딕", Font.PLAIN, 20));
				buttonArray[i].addActionListener(new MyActionListener());
				//add(Box.createVerticalStrut(30));
				add(buttonArray[i]);
			}
	        
	    }
	    class MyActionListener implements ActionListener{

			@Override
			public void actionPerformed(ActionEvent e) {
				String button = e.getActionCommand();
				int point=0;
				if(button.equals("50000포인트")) {
					//개인정보 팝업 뜨기
					JOptionPane.showMessageDialog(GUIMain.mainFrame, "50000포인트가 충전되었습니다.");
					point=50000;
				}
				if(button.equals("30000포인트")) {
					//개인정보 팝업 뜨기
					JOptionPane.showMessageDialog(GUIMain.mainFrame, "30000포인트가 충전되었습니다.");
					point=30000;
				}
				if(button.equals("10000포인트")) {
					//개인정보 팝업 뜨기
					JOptionPane.showMessageDialog(GUIMain.mainFrame, "10000포인트가 충전되었습니다.");
					point=10000;
				}
				if(button.equals("5000포인트")) {
					//개인정보 팝업 뜨기
					JOptionPane.showMessageDialog(GUIMain.mainFrame, "5000포인트가 충전되었습니다.");
					point=5000;
				}
				if(button.equals("1000포인트")){
					JOptionPane.showMessageDialog(GUIMain.mainFrame, "1000포인트가 충전되었습니다.");
					point=1000;
				}
				if(button.equals("OrangeTv Premium 신청")) {
					if(LogIn.user.getPremium()=="X") {
						JOptionPane.showMessageDialog(GUIMain.mainFrame, "10000포인트가 차감되었습니다. 프리미엄 회원으로 전환되었습니다.(30일 간)");
						LogIn.user.premium=true;
						LogIn.user.point-=10000;
					}
					else {
						JOptionPane.showMessageDialog(GUIMain.mainFrame, "이미 프리미엄 회원입니다.");
					}
				}
				LogIn.user.point+=point;
				lblNewLabel_6.setText(LogIn.user.point+"점 ("+LogIn.user.getPremium()+")");
				DefaultFrame.mainMenu.mainStoreInfo.pointLabel.setText("보유 포인트 "+LogIn.user.point+"점");
				DefaultFrame.mainMenu.mainMediaInfo.pointLabel.setText("보유 포인트 "+LogIn.user.point+"점");
				setVisible(false);
			}
		}
	}
	class PrivateInfo extends JFrame{
		TableSelectionDemo mediaPane_1;
		JPanel panel1;
	    public PrivateInfo() {
	        // setting
	        setTitle("개인 정보");
	        setSize(650, 360);
	        setResizable(false);
	        setLocation(600, 350);
	        setVisible(true);        // visible
			setLayout(null);
			panel1 = new JPanel();
			panel1.setBounds(0, 0, 650, 360);
			//tableCreate(1001);
			tableCreate(main.login.user.getnum());
			add(panel1);
	    }
	    
		public void tableCreate(int num) {
			mediaPane_1 = new TableSelectionDemo();
			//mediaPane_1.addComponentsToPane(UserManager.getInstance());
			mediaPane_1.addComponentsToPane(OrderManager.getInstance());
			mediaPane_1.tableController.loadData(""+num);
			panel1.setLayout(new BorderLayout());
			panel1.add(mediaPane_1, BorderLayout.CENTER);
		}
	}
}


