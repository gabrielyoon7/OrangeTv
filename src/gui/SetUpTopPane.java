package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.RoundRectangle2D;

import javax.swing.Action;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;

import main.Main;
import media.Media;

public class SetUpTopPane extends JPanel{
	public static Boolean bool=false;
    
   public SetUpTopPane() { // �ΰ�-�˻�â-�������� ������ ��ġ
      logo();//�ΰ�
      searchBar();//�˻�â
      privateInfo();//��������
   }
   public void logo() {//�ΰ� ������ �� ����ȭ���� �ߵ��� �����ϴ°� ��� ���� �ʿ�
      setLayout(null);
      ImageIcon icon = new ImageIcon("GUI/Orange_logo_small_rounded_reversed.png");
      Image img=icon.getImage();
      Image changeImg = img.getScaledInstance(250, 70, Image.SCALE_SMOOTH);
      ImageIcon changeIcon = new ImageIcon(changeImg);
      JLabel imageLabel = new JLabel(changeIcon);
      imageLabel.setSize(250, 70);
      imageLabel.setLocation(25,15);
      imageLabel.addMouseListener(new MouseAdapter() {//�ΰ� �������� �������� ���� (���� �޴� ���� ������ ���⵵ ���� ����������մϴ�.)
			@Override
			public void mouseClicked(MouseEvent e) {
				DefaultFrame.mainMenu.mainMedia.setVisible(true);
				DefaultFrame.mainMenu.mainRank.setVisible(false);
				DefaultFrame.mainMenu.mainStore.setVisible(false);
				DefaultFrame.mainMenu.mainCart.setVisible(false);
				DefaultFrame.mainMenu.mainSearch.setVisible(false);
				DefaultFrame.mainMenu.mainMediaInfo.setVisible(false);
			}
	      });
      add(imageLabel);
   }
   public void searchBar() {
      RoundJTextField textField = new RoundJTextField(20);//�� �ؽ�Ʈ�ʵ�
      textField.setText("�̵� �Է��ϼ���");
      textField.setForeground(Color.gray);
      /*Border border = BorderFactory.createLineBorder(Color.red);
      textField.setBorder(border);*/
      textField.setSize(800, 50);
      textField.setLocation(320,25);
      textField.setFont(new Font("���", Font.PLAIN,20));
        textField.addMouseListener(new MouseAdapter(){//���콺�� Ŭ������ �� textField�� �����
            @Override
            public void mouseClicked(MouseEvent e){
                textField.setText("");
                textField.setForeground(Color.black);
            }
        });
        textField.addActionListener(new ActionListener() { //�ؽ�Ʈ �ʵ忡�� �ٷ� ���� ������ �� �˻�    
            @Override
            public void actionPerformed(ActionEvent e) {
            DefaultFrame.mainMenu.mainSearch.clearTable();
            DefaultFrame.mainMenu.mainSearch.setVisible(false);
            DefaultFrame.mainMenu.mainSearch.tableCreate(textField.getText());
            DefaultFrame.mainMenu.mainSearch.setVisible(true);
            DefaultFrame.mainMenu.mainMedia.setVisible(false);
            DefaultFrame.mainMenu.mainRank.setVisible(false);
            DefaultFrame.mainMenu.mainStore.setVisible(false);
            DefaultFrame.mainMenu.mainCart.setVisible(false);
            }
        });
      add(textField);
      RoundedButton button = new RoundedButton("�˻�");
      button.setSize(100,50);
      button.setFont(new Font("HY�߰��", Font.BOLD,20));
      add(button);
      button.setLocation(1130,25);
      button.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {//��ư ������ �� �˻�
            if (e.getActionCommand().equals("�˻�")) {
               DefaultFrame.mainMenu.mainSearch.clearTable();
               DefaultFrame.mainMenu.mainSearch.setVisible(false);
               DefaultFrame.mainMenu.mainSearch.tableCreate(textField.getText());
               DefaultFrame.mainMenu.mainSearch.setVisible(true);
               DefaultFrame.mainMenu.mainMedia.setVisible(false);
               DefaultFrame.mainMenu.mainRank.setVisible(false);
               DefaultFrame.mainMenu.mainStore.setVisible(false);
               DefaultFrame.mainMenu.mainCart.setVisible(false);
               
            }
            else
               DefaultFrame.mainMenu.mainSearch.clearTable();
         }
      });
      
   }
   public void privateInfo(){
      /*[���� �ʿ�]
       * �� ȭ���� ������ �� �������� ȭ�� (������ Ŭ������ Visible true)���� �Ѿ��
       * �� Ŭ���������� LogInŬ�������� �α��� �� User������ ����� ������ �ؾ� �� ������ ����
       * 
       * �׸��� ���� �� privateInfo �޼ҵ忡���� LogInŬ�������� User������ ���� �̸��� ���� �� �� �ֵ��� �ؾ��� �� ����
       * ������� ���� Orange Man���� �����ִ� ���� "OOO�� ȯ���մϴ�." �Ǵ� "OOO / ��� / ����"���� ������ ����
       */
      ImageIcon userFace = new ImageIcon("GUI/orange_profile.png");
      Image userImg=userFace.getImage();
      Image changeUserImg = userImg.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
      ImageIcon changeUserIcon = new ImageIcon(changeUserImg);
      JLabel userImageLabel = new JLabel(changeUserIcon);
      userImageLabel.setSize(50, 50);
      userImageLabel.setLocation(1410,25);
      add(userImageLabel);
      String mention = GUIMain.login.user.getName()+" (Level "+GUIMain.login.user.getLevel()+")";
      RoundedButton userName = new RoundedButton(mention);
      userName.setLocation(1250, 35);
      userName.setSize(150, 30);
      userName.setFont(new Font("HY�߰��", Font.PLAIN,15));
      userName.setForeground(Color.WHITE);
      userName.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            if(bool==true) {
            	DefaultFrame.mainMenu.privatePage.setVisible(false);
            	bool=false;
            }
            else {
            	DefaultFrame.mainMenu.privatePage.setVisible(true);
            	bool=true;
            }
         }
      });
      add(userName);
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
         Color c=new Color(255,247,242); //���� ����
         Color o=new Color(247,99,12); //���ڻ� ����
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
   //�ؽ�Ʈ�ʵ� ������
   public class RoundJTextField extends JTextField {
       private Shape shape;
       public RoundJTextField(int size) {
           super(size);
           setOpaque(false); // As suggested by @AVD in comment.
       }
       protected void paintComponent(Graphics g) {
            g.setColor(getBackground());
            g.fillRoundRect(0, 0, getWidth()-1, getHeight()-1, 15, 15);
            super.paintComponent(g);
       }
       protected void paintBorder(Graphics g) {
            g.setColor(getForeground());
            g.drawRoundRect(0, 0, getWidth()-1, getHeight()-1, 15, 15);
       }
       public boolean contains(int x, int y) {
            if (shape == null || !shape.getBounds().equals(getBounds())) {
                shape = new RoundRectangle2D.Float(0, 0, getWidth()-1, getHeight()-1, 15, 15);
            }
            return shape.contains(x, y);
       }
   }
}

