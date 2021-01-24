package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;

import main.Main;
import media.MediaManager;
import store.GoodsManager;
import store.OrderManager;
import store.OrderedItemManager;
import user.User;

import javax.swing.JScrollPane;
import javax.swing.JScrollBar;

public class MainCart extends JPanel{
   JPanel panel;
   JPanel panel_1, panel_2, panel_3, panel_4, panel_5;
   JPanel media_1;
   JScrollPane scrollPane, scrollPane_1, scrollPane_2, scrollPane_3, scrollPane_4, scrollPane_5;
   private JTable table;
   static TableSelectionDemo basketTable;
   TableController tableController;
   User user;

   @SuppressWarnings("null")
   public MainCart() {
	  setLayout(null);
      setBounds(0,0,1330, 980);

      user = GUIMain.login.user;
      int num = user.getnum();
      basketTable = new TableSelectionDemo();
      OrderedItemManager basket = OrderedItemManager.getInstance();
      basket.setOrder(OrderManager.getInstance().getOrder(num));
      basketTable.addComponentsToPane(basket);
      basketTable.setBounds(0, 0, 1330, 500);
      add(basketTable);
      
      RoundedButton payButton = new RoundedButton("결제하기");
      payButton.setBounds(1113, 554, 160, 70);
      payButton.addActionListener(new ActionListener() {
  		@Override
  		public void actionPerformed(ActionEvent e) {
  			int leftPoint = user.point - basketTable.tableController.getSubtotal();
			if(leftPoint < 0) {
				JOptionPane.showMessageDialog(null, "포인트가 부족합니다.","결제 창",JOptionPane.INFORMATION_MESSAGE);
			}
			else {
				JOptionPane.showMessageDialog(null, "결제되었습니다.","결제 창",JOptionPane.INFORMATION_MESSAGE);
				user.setPoint(leftPoint);
				MainMenu.mainStoreInfo.pointLabel.setText("보유 포인트 " + leftPoint+"점");
				MainMenu.mainMediaInfo.pointLabel.setText("보유 포인트 " + leftPoint+"점");
				MainMenu.privatePage.lblNewLabel_6.setText(user.getPoint()+"점 ("+user.getPremium()+")");
				basketTable.tableController.removeRow();
				JOptionPane.showMessageDialog(GUIMain.mainFrame,"현재 보유 포인트는 "+user.getPoint()+" 포인트 입니다.");
			}
  		}
  	});
      add(payButton);
      
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