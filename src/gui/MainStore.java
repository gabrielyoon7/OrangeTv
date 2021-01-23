package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;

import facade.DataEngineInterface;
import main.Main;
import manage.Manageable;
import media.Media;
import store.Goods;
import store.GoodsManager;
import store.OrderManager;
import store.OrderedItemManager;
import user.User;

public class MainStore extends JPanel {
	JPanel panel1, mainPanel;
	JScrollPane scroll, scroll2, mainScroll;
	String kwd;
	RoundedButton btnNewButton;
	JLabel lblNewLabel;
public MainStore() {
	setLayout(null);
	setBounds(0,0,1340, 980);
	
	panel1 = new JPanel();
	//panel.setBounds(0,0,1520, 1420);
	//add(panel);
	
	mainScroll = new JScrollPane();
	mainScroll.setViewportView(panel1);
	//scrollPane.getVerticalScrollBar().setUnitIncrement(1000);
	mainScroll.setBounds(0,0,1340,980);
	mainScroll.getViewport().getView().setBackground(Color.WHITE);
	add(mainScroll);
	panel1.setLayout(null);
	int num = 0;
	
	if(Main.goodsMgr.mList.size() == 0) {
		num = Main.goodsMgr.mList.size()/4;
	}
	else {
		num = Main.goodsMgr.mList.size()/4;
		num+=1;
	}
	
	
	JPanel panel = new JPanel(new GridLayout(num+1,4,2,3));
	panel.setBounds(0, 70, 1330, 900);
	
	scroll = new JScrollPane();
	scroll.setBounds(0, 70, 1330, 900);
	scroll.setViewportView(panel);
	scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
	scroll.getViewport().getView().setBackground(Color.WHITE);
	panel1.add(scroll);
	
	JLabel lblNewLabel_1 = new JLabel("�����");
	lblNewLabel_1.setBounds(30, 10, 250, 50);
	lblNewLabel_1.setFont(new Font("HY�߰��", Font.BOLD, 35));
	
	panel1.add(lblNewLabel_1);	
	
	RoundedButton cartButton = new RoundedButton("����");
	cartButton.setBounds(1230, 10, 100, 50);
	cartButton.setFont(new Font("HY�߰��", Font.BOLD, 20));
	cartButton.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			DefaultFrame.mainMenu.mainMedia.setVisible(false);
			DefaultFrame.mainMenu.mainRank.setVisible(false);
			DefaultFrame.mainMenu.mainStore.setVisible(false);
			DefaultFrame.mainMenu.mainCart.setVisible(true);
			DefaultFrame.mainMenu.mainSearch.setVisible(false);
			DefaultFrame.mainMenu.mainMediaInfo.setVisible(false);
			DefaultFrame.mainMenu.mainStoreInfo.setVisible(false);
		}
		
	});
	panel1.add(cartButton);
	
	
	JLabel labels[] = new JLabel[Main.goodsMgr.mList.size()];
	
	for (int i =  0; i < Main.goodsMgr.mList.size(); i++)
	{
		String address_2 = "goodsImage/"+Main.storeMgr.goodsNumbers.get(i)+".jpg"; //�̹��� ��θ� String �������� ����
		ImageIcon Icon = new ImageIcon(address_2); 
		Image img=Icon.getImage();
	    Image changeImg = img.getScaledInstance(250,250, Image.SCALE_SMOOTH); //�̹��� ũ�� ���� ����
	    ImageIcon changeIcon = new ImageIcon(changeImg);
	      labels[i] = new JLabel(changeIcon);
	      labels[i].setText(Main.storeMgr.goodsNames.get(i));
	      labels[i].setHorizontalTextPosition(JLabel.CENTER);
	      labels[i].setVerticalTextPosition(JLabel.BOTTOM);
	      labels[i].addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				clickEvent(e); // �޼ҵ�� ��û
			}
	      });
	      panel.add(labels[i]);
	}
}
	
	public void clickEvent(MouseEvent e) {
		MainMenu.mainStore.setVisible(false);//���� ȭ�� off
		JLabel name = (JLabel)e.getSource();
		String title = name.getText();
		Goods goods = Main.goodsMgr.find(title);//����� ��ġ�ϴ� goods �ҷ�����
		
		//panelLeftUp ���� ����
		MainMenu.mainStoreInfo.goodsInfo.setText("<html><h1>"+goods.name+"</h1><br/><h2>�� ����: "+goods.price + "��"
				+"<br/>�� ���� ���� : "+goods.left+"�� <br/>"+"�� ���ۻ�: "+goods.company+"<br/>�� ����: "+goods.information+"</h2><br/><html/>");
		
		MainMenu.mainStoreInfo.goods = goods;
		//panelRight ���� ����
		String num = Integer.toString(goods.num);//Ŭ���� ������ ������ȣ�� String���� ��ȯ
		String address="goodsImage/"+num+".jpg";//�̹��� ��θ� String �������� ����
		ImageIcon icon = new ImageIcon(address);
	    Image img=icon.getImage();
	    Image changeImg = img.getScaledInstance(500, 500, Image.SCALE_SMOOTH);
	    ImageIcon changeIcon = new ImageIcon(changeImg);
	    MainMenu.mainStoreInfo.goodsImage.setIcon(changeIcon);
		MainMenu.mainStoreInfo.setVisible(true);
		
		MainMenu.mainStoreInfo.pointLabel_1.setText("���� "+goods.price+"��");

		String medianum = goods.mediaNum;
		String mediaAdd = "mediaImage/"+medianum+".jpg";
		ImageIcon micon = new ImageIcon(mediaAdd);
		Image mimg=micon.getImage();
	    Image mchangeImg = mimg.getScaledInstance(80, 100, Image.SCALE_SMOOTH);
	    ImageIcon mchangeIcon = new ImageIcon(mchangeImg);
	    MainMenu.mainStoreInfo.mediaImage.setIcon(mchangeIcon);
	    MainMenu.mainStoreInfo.mediaImage.setText(goods.mediaNum);
		MainMenu.mainStoreInfo.mediaImage.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				MainMenu.mainStoreInfo.setVisible(false);
				MainMenu.mainMedia.clickEvent(e, null);
			}
	      });
	}
	
	//��ư ������
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
    	  Color c=new Color(249,172,25);//���� ����
          //Color o=new Color(247,99,12); //���ڻ� ����
          Color o=new Color(255,255,255); //���ڻ� ����
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