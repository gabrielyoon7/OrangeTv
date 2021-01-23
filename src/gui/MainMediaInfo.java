package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.Action;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import gui.MainStoreInfo.RoundedButton;
import media.CommentManager;
import media.Media;
import media.MediaManager;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class MainMediaInfo extends JPanel{
	/* 
	 * 이 화면에 출력될 요소는 바깥부분(MainMedia)에서 조절할건데 수정이 필요할까요?
	 * lblNewLabel_1내용 다 지웠는데 정상 작동 해서 지우는게 나을 것 같습니다.
	 * 이 클래스는 공간을 규정하는 용도로만 사용해도 될 것 같아요.
	 * -2020.11.17 윤주현-
	 */
	int leftPoint;
	JPanel panel1;
	JPanel panel2;
	JPanel panel3;
	public JLabel pointLabel;
	public JLabel lblNewLabel_1;
	public JLabel lblNewLabel;
	public JLabel playLabel = new JLabel();
	public RoundedButton button;
	public RoundedButton paymentButton;
	public JLabel goodsCode[];
	TableSelectionDemo mediaPane_1;
	static Media seletedMedia = new Media();//mainmeida클래스에서 클릭이벤트 메소드에서 선택된 미디어가 뭔지 받아오려고 만듦
	public MediaPlayer mediaPlayer;
	
	public MainMediaInfo(Media media) {
		setLayout(null);
		setBounds(0,0,1330, 980);
		
		panelLeftUp(media);//좌측상단 영상 정보 부분
		panelLeftDown();//좌측하단 코멘트 부분
		panelRight(media); //우측 영상 이미지
		
		button = new RoundedButton("메인으로 가기");
		button.setBounds(1170, 30, 120, 40);
		button.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				DefaultFrame.mainMenu.mainMedia.setVisible(true);
				DefaultFrame.mainMenu.mainRank.setVisible(false);
				DefaultFrame.mainMenu.mainStore.setVisible(false);
				DefaultFrame.mainMenu.mainCart.setVisible(false);
				DefaultFrame.mainMenu.mainSearch.setVisible(false);
				DefaultFrame.mainMenu.mainMediaInfo.setVisible(false);
			}
		});
		add(button);

		pointLabel = new JLabel();
		pointLabel.setSize(300, 20);
		pointLabel.setLocation(370, 40);
		pointLabel.setText("보유 포인트 "+LogIn.user.point+"점");
		pointLabel.setFont(new Font("HY견고딕", Font.BOLD, 20));
		add(pointLabel);
		
		
		paymentButton = new RoundedButton("결제하기");
		paymentButton.setBounds(80,30, 120, 40);
		paymentButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
			
				leftPoint = LogIn.user.point - seletedMedia.price;
				if(leftPoint < 0) {
					JOptionPane.showMessageDialog(null, "포인트가 부족합니다.","결제 창",JOptionPane.INFORMATION_MESSAGE);
				}
				else {
					for(int i = 0; i<LogIn.user.mediaCart.size(); i++) {
						String s = LogIn.user.mediaCart.get(i);
						if(s.equals(""+seletedMedia.num)) {
							if(LogIn.user.getPremium().equals("O")) {
								JOptionPane.showMessageDialog(null, "이미 구매한 상품입니다.","결제 창",JOptionPane.INFORMATION_MESSAGE);
								break;
							} else {
								JOptionPane.showMessageDialog(null, "이미 결제한 상품입니다.","결제 창",JOptionPane.INFORMATION_MESSAGE);
								break;
							}
						}else if(i == LogIn.user.mediaCart.size()-1) {
							if(LogIn.user.getPremium().equals("O")) {
								JOptionPane.showMessageDialog(null, "구매되었습니다.","결제 창",JOptionPane.INFORMATION_MESSAGE);
								LogIn.user.mediaCart.add(""+seletedMedia.num);
								DefaultFrame.mainMenu.remove(MainMenu.mainMyMedia);
								DefaultFrame.mainMenu.MainMyMedia();
								break;
							} else {
								JOptionPane.showMessageDialog(null, "결제되었습니다.","결제 창",JOptionPane.INFORMATION_MESSAGE);
								LogIn.user.setPoint(leftPoint);
								pointLabel.setText("보유 포인트 " + leftPoint+"점");
								MainMenu.mainStoreInfo.pointLabel.setText("보유 포인트 " + leftPoint+"점");
								LogIn.user.mediaCart.add(""+seletedMedia.num);
								DefaultFrame.mainMenu.remove(MainMenu.mainMyMedia);
								DefaultFrame.mainMenu.MainMyMedia();
								MainMenu.privatePage.lblNewLabel_6.setText(LogIn.user.getPoint()+"점 ("+LogIn.user.getPremium()+")");
								break;
							}
						}
					}
				}
			}
		});
		add(paymentButton);

		
	}
	
	public void logo() {//로고 눌렀을 때 메인화면이 뜨도록 구현하는건 어떤지 검토 필요
	      setLayout(null);
	      ImageIcon icon = new ImageIcon("GUI/playButton.png");
	      Image img=icon.getImage();
	      Image changeImg = img.getScaledInstance(150, 150, Image.SCALE_SMOOTH);
	      ImageIcon changeIcon = new ImageIcon(changeImg);
	      playLabel = new JLabel();
	      playLabel.setIcon(changeIcon);
	      playLabel.setSize(150,150);
	      playLabel.setLocation(110, 570);
	      playLabel.addMouseListener(new MouseAdapter() {//로고 눌렀을때 메인으로 복귀 (메인 메뉴 조작 수정시 여기도 같이 수정해줘야합니다.)
				@Override
				public void mouseClicked(MouseEvent e) {
					for(int i = 0; i<LogIn.user.mediaCart.size(); i++) {
						String num = LogIn.user.mediaCart.get(i);
						if(num.equals(""+seletedMedia.num)) { // 결제(구매)한 상품만 재생되도록 함. 
							mediaPlayer = new MediaPlayer(seletedMedia);
							mediaPlayer.setVisible(false);
							mediaPlayer.setVisible(true);
							DefaultFrame.mainMenu.mainMedia.setVisible(false);
							DefaultFrame.mainMenu.mainRank.setVisible(false);
							DefaultFrame.mainMenu.mainStore.setVisible(false);
							DefaultFrame.mainMenu.mainCart.setVisible(false);
							DefaultFrame.mainMenu.mainSearch.setVisible(false);
							DefaultFrame.mainMenu.mainMediaInfo.setVisible(true);
							/*mediaPlayer = new MediaPlayer(seletedMedia);
							mediaPlayer.setVisible(false);
							mediaPlayer.setVisible(true);*/
							break;
						}
						else if(i == LogIn.user.mediaCart.size()-1) {
							JOptionPane.showMessageDialog(null, "결제(구매)후 이용해주세요.","Media Player",JOptionPane.INFORMATION_MESSAGE);
						}
					}
				}
		      });
	      add(playLabel);
	   }
	
	
	
	public void createInfo(Media media) {
		panelLeftUp(media);//좌측상단 영상 정보 부분
		panelLeftDown();//좌측하단 코멘트 부분
		panelRight(media); //우측 영상 이미지
	}

	public void panelLeftUp(Media media) {
		setLayout(null);
		panel2 = new JPanel();
		panel2.setLayout(null);
		panel2.setBounds(550,100,681, 350);
		panel2.setBackground(Color.WHITE);
		panel2.setBorder(BorderFactory.createLineBorder(Color.gray, 3));
		add(panel2);
		
		String genre = null;
		for(String g : media.genreList) {
			genre+=g+" ";
		}
		String country = null;
		for(String c : media.countryList) {
			country+=c+" ";
		}

	
		lblNewLabel_1 = new JLabel(); // 빈 라벨을 일단 생성
		lblNewLabel_1.setBounds(10, 10, 670, 235);
		panel2.add(lblNewLabel_1);
		
		goodsCode = new JLabel[media.goodsList.size()];
		for(int i = 0; i<media.goodsList.size(); i++) {
			goodsCode[i] = new JLabel();
			goodsCode[i].setText(""+media.goodsList.get(i));
			goodsCode[i].setBounds(113, 551, 76, 29);
			panel2.add(goodsCode[i]);
		}
		
		logo();
	}
	
	public void panelLeftDown() {
		setLayout(null);
		panel1 = new JPanel();
		panel1.setBounds(550, 470, 681, 240);
		add(panel1);
		tableCreate(1001);
	}

	public void panelRight(Media media) {
		String num = Integer.toString(media.num);
		String address="mediaImage/"+num+".jpg";
		setLayout(null);
		panel3 = new JPanel();
		panel3.setBounds(88,100,430, 630);
		panel3.setBackground(Color.WHITE);
		ImageIcon icon = new ImageIcon(address);//media.fileAddress
	    Image img=icon.getImage();
	    Image changeImg = img.getScaledInstance(400,600, Image.SCALE_SMOOTH);
	    ImageIcon changeIcon = new ImageIcon(changeImg);

	    add(panel3);
		panel3.setLayout(null);
		
		
		
		lblNewLabel = new JLabel(changeIcon);
		lblNewLabel.setBounds(12, 10, 400,600);
		panel3.add(lblNewLabel);
		
		
	}
	public void tableCreate(int num) {
		mediaPane_1 = new TableSelectionDemo();
		mediaPane_1.addComponentsToPane(CommentManager.getInstance());
		mediaPane_1.tableController.loadData(""+num);
		panel1.setLayout(new BorderLayout());
		panel1.add(mediaPane_1, BorderLayout.CENTER);
	}
	public void clearTable() {
		panel1.removeAll();
	}
	
	class MediaPlayer extends JFrame{
		private Image background;
		public JLabel playLabel;
		public JPanel panel;
		public JScrollPane pane;
		public MediaPlayer() {}
		public MediaPlayer(Media media) { 
			// setting
			setLayout(null);
	        setTitle("Media Player");
	        setSize(1500, 835);
	        setResizable(false);
	        setLocation(0, 0);
	        ImageIcon icon = new ImageIcon("mediaImage/"+media.num+".jpg");
		    Image img=icon.getImage();
		    Image changeImg = img.getScaledInstance(1500,800, Image.SCALE_SMOOTH);
	        background = new ImageIcon(changeImg).getImage();
	        panel = new JPanel() {
	        	public void paintComponent(Graphics g) {
	                g.drawImage(background, 0, 0, null);
	                setOpaque(false); //그림을 표시하게 설정,투명하게 조절
	                super.paintComponent(g);
	            }
	        };
	        panel.setLayout(null);
	        panel.setBounds(0, 0, 1500,800);
	        icon = new ImageIcon("GUI/videoPlayerLayout.png");
		    img=icon.getImage();
		    changeImg = img.getScaledInstance(1500,800, Image.SCALE_SMOOTH);
		    ImageIcon changeIcon = new ImageIcon(changeImg);
		    playLabel = new JLabel(changeIcon);
		    playLabel.setBounds(0, 0, 1500,800);
		    panel.add(playLabel);
		    pane = new JScrollPane(panel);
		    setContentPane(pane);
	        setVisible(true);        // visible
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
          //Color c=new Color(255,247,242); 
    	  Color c=new Color(249,172,25);//배경색 결정
          //Color o=new Color(247,99,12); //글자색 결정
          Color o=new Color(255,255,255); //글자색 결정
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
          graphics.setColor(o); 
          graphics.setFont(getFont()); 
          graphics.drawString(getText(), textX, textY); 
          graphics.dispose(); 
          super.paintComponent(g); 
          }
       }
}
