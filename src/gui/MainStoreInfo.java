package gui;

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

import javax.swing.Action;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import main.Main;
import media.Media;
import store.Goods;
import user.User;

public class MainStoreInfo extends JPanel{

	int leftPoint;
	JPanel panel1;
	JPanel panel2;
	public JLabel pointLabel;
	public JLabel pointLabel_1;
	public JLabel goodsImage;
	public JLabel goodsInfo;
	public JLabel mediaImage;
	public RoundedButton backButton;
	public RoundedButton paymentButton;
	private RoundedButton btnNewButton;
	static Goods goods = new Goods();
	private JButton mediaButton;
	JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	
	public MainStoreInfo() {
		setLayout(null);
		setBounds(0,0,1330, 980);
		panelLeft(goods);
		panelright(goods);
		//LogIn.user.point ��� �ʿ�
		pointLabel = new JLabel();
		pointLabel.setSize(300, 20);
		pointLabel.setLocation(370, 40);
		pointLabel.setText("���� ����Ʈ "+LogIn.user.point+"��");
		pointLabel.setFont(new Font("HY�߰��", Font.BOLD, 20));
		
		pointLabel_1 = new JLabel();
		pointLabel_1.setText("���� "+goods.price+"��");
		pointLabel_1.setFont(new Font("HY�߰��", Font.BOLD, 20));
		pointLabel_1.setBounds(600, 40, 300, 20);
		add(pointLabel_1);
		
		backButton = new RoundedButton("������ ����");
		backButton.setBounds(1170, 30, 120, 40);
		backButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				DefaultFrame.mainMenu.mainMedia.setVisible(false);
				DefaultFrame.mainMenu.mainRank.setVisible(false);
				DefaultFrame.mainMenu.mainStore.setVisible(true);
				DefaultFrame.mainMenu.mainCart.setVisible(false);
				DefaultFrame.mainMenu.mainSearch.setVisible(false);
				DefaultFrame.mainMenu.mainMediaInfo.setVisible(false);
				DefaultFrame.mainMenu.mainStoreInfo.setVisible(false);
			}
		});
		
		paymentButton = new RoundedButton("�����ϱ�");
		paymentButton.setBounds(80,30, 120, 40);
		paymentButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				String num = JOptionPane.showInputDialog("��ǰ�� ������ �Է����ּ���.");
				int price = 0;
				if(Integer.parseInt(num) > 0) {
					price = Integer.parseInt(num) * goods.price;
				}
				leftPoint = LogIn.user.point - price;
				if(leftPoint < 0) {
					JOptionPane.showMessageDialog(null, "����Ʈ�� �����մϴ�.","���� â",JOptionPane.INFORMATION_MESSAGE);
				}
				else {
					JOptionPane.showMessageDialog(null, "�����Ǿ����ϴ�.","���� â",JOptionPane.INFORMATION_MESSAGE);
					LogIn.user.setPoint(leftPoint);
					pointLabel.setText("���� ����Ʈ " + leftPoint+"��");
					MainMenu.mainMediaInfo.pointLabel.setText("���� ����Ʈ " + leftPoint+"��");
					MainMenu.privatePage.lblNewLabel_6.setText(LogIn.user.point+"�� ("+LogIn.user.getPremium()+")");
					goods.left -=Integer.parseInt(num);
					goodsInfo.setText("<html><h1>"+goods.name+"</h1><br/><h2>����: "+goods.price + "��"
							+"<br/>���� ���� : "+goods.left+"�� <br/>"+"���ۻ�: "+goods.company+"<br/>����: "+goods.information+"</h2><br/><html/>");
				}
			}
		});
		
		add(backButton);
		add(pointLabel);
		add(paymentButton);
		
		btnNewButton = new RoundedButton("���ϱ�");
		btnNewButton.setBounds(220, 30, 120, 40);
		btnNewButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String num = JOptionPane.showInputDialog("��ǰ�� ������ �Է����ּ���.");
				if(Integer.parseInt(num) > 0) {
					String[] goodsArr = {goods.name, (goods.price+""), num, Integer.toString(goods.price*Integer.parseInt(num))};
					MainCart.basketTable.tableController.addRow(goodsArr);
					JOptionPane.showMessageDialog(null, "���Ͽ� �߰��Ǿ����ϴ�.","�˸� â",JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		add(btnNewButton);
	}

	public void createStoreInfo(Goods goods) {
		panelLeft(goods);
		panelright(goods);
	}
	private void panelright(Goods goods) {
	
		setLayout(null);
		panel2 = new JPanel();
		panel2.setLayout(null);
		panel2.setBounds(673,109,600, 534);
		panel2.setBackground(Color.WHITE);
		panel2.setBorder(BorderFactory.createLineBorder(Color.gray, 3));
		add(panel2);
		
		goodsInfo = new JLabel();
		goodsInfo.setBounds(30, 10, 540, 473);
		panel2.add(goodsInfo);
		
		lblNewLabel_1 = new JLabel("�ش� ���� ����:");
		lblNewLabel_1.setBounds(384, 493, 96, 31);
		panel2.add(lblNewLabel_1);
		
		String num = goods.mediaNum;
		String address="mediaImage/"+num+".jpg";
		ImageIcon icon = new ImageIcon(address);//goods.fileAddress
	    Image img=icon.getImage();
	    Image changeImg = img.getScaledInstance(80, 100, Image.SCALE_SMOOTH);
	    ImageIcon changeIcon = new ImageIcon(changeImg);
	    mediaImage = new JLabel(changeIcon);
	    mediaImage.setBounds(485, 430, 75, 100);
	    panel2.add(mediaImage);
	}

	private void panelLeft(Goods goods) {
		String num = Integer.toString(goods.num);
		String address="goodsImage/"+num+".jpg";
		setLayout(null);
		panel1 = new JPanel();
		panel1.setBounds(88,127,500, 500);
		ImageIcon icon = new ImageIcon(address);//goods.fileAddress
	    Image img=icon.getImage();
	    Image changeImg = img.getScaledInstance(700, 700, Image.SCALE_SMOOTH);
	    ImageIcon changeIcon = new ImageIcon(changeImg);

	    add(panel1);
	    panel1.setLayout(null);
		
		goodsImage = new JLabel(changeIcon);
		goodsImage.setBounds(0, 0, 500, 500);
		panel1.add(goodsImage);
		
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
