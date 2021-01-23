package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Label;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.RoundRectangle2D;
import java.util.Calendar;

import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import main.Main;
import user.User;

import javax.swing.JPasswordField;

public class LogIn extends JFrame{
	private GUIMain main;
    //private TestFrm testFrm;
    private JButton btnLogin;
    private JButton btnInit;
    private JPasswordField passText;
    private JTextField userText;
    private boolean bLoginCheck;
    static User user;//추후 다른 클래스에서 사용자 데이터를 사용할 일이 있으면 이 user를 조회함.

    public static void main(String[] args) {
        //new LoginView();
    }
 
    public LogIn() {
        // setting
        setTitle("OrangeTv 로그인");
        setSize(650, 360);
        setResizable(false);
        setLocation(600, 350);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        JPanel panel = new JPanel();        // panel
        placeLoginPanel(panel);
        imagePanel();
       
        add(panel);        // add
        
        setVisible(true);        // visible
    }

    
    public void imagePanel() {
    	ImageIcon icon = new ImageIcon("GUI/orangeIcon.png");
//    	ImageIcon icon = new ImageIcon("GUI/Orange_logo.png");
    	
	    Image img=icon.getImage();
	    Image changeImg = img.getScaledInstance(300,300, Image.SCALE_SMOOTH);
	    ImageIcon changeIcon = new ImageIcon(changeImg);
		
		JLabel lblNewLabel = new JLabel(changeIcon);
		lblNewLabel.setBounds(10, 10, 300, 300);
		add(lblNewLabel);
    }
    public void placeLoginPanel(JPanel panel){
        panel.setLayout(null);   
        panel.setBackground(new Color(255,247,242));
        JLabel userLabel = new JLabel("아이디");
        userLabel.setBounds(350, 110, 80, 25);
        panel.add(userLabel);
       
        JLabel passLabel = new JLabel("비밀번호");
        passLabel.setBounds(350, 140, 80, 25);
        panel.add(passLabel);
       
        userText = new JTextField(20);
        userText.setBounds(440, 110, 160, 25);
        userText.addActionListener(new ActionListener() {//비번 치다가 enter누르면 바로 로그인 검사
            @Override
            public void actionPerformed(ActionEvent e) {
                isLoginCheck();        
            }
        });
        panel.add(userText);
       
        passText = new JPasswordField(20);
        passText.setBounds(440, 140, 160, 25);
        panel.add(passText);
        passText.addActionListener(new ActionListener() {//비번 치다가 enter누르면 바로 로그인 검사
            @Override
            public void actionPerformed(ActionEvent e) {
                isLoginCheck();        
            }
        });
        
       
        btnInit = new RoundedButton("다시입력");
        btnInit.setBounds(350, 180, 100, 25);
        panel.add(btnInit);
        btnInit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                userText.setText("");
                passText.setText("");
            }
        });
       
        btnLogin = new RoundedButton("로그인");
        btnLogin.setBounds(500, 180, 100, 25);
        panel.add(btnLogin);
        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	isLoginCheck();
            }
        });

    }
   
    public void isLoginCheck(){
        String id = userText.getText();
        String pass = new String(passText.getPassword());
        if(id.equals("") || pass.equals("")) {  // 아이디와 패스워드 미입력시 로그인 성공 방지
        	user = null;
        } else {
        	user = (User)Main.userMgr.findUser(id, pass);
        }
        if(user == null) {
        	 JOptionPane.showMessageDialog(null, "잘못 된 정보입니다.");
        	 userText.setText("");
         	 passText.setText("");
        }else {
        	setVisible(false);
        	main.startGUI();
        	userText.setText("");
        	passText.setText("");
        }
    }
 
   
    // mainProcess와 연동
    public void setMain(GUIMain main) {
        this.main = main;
    }
   
    public boolean isLogin() {     
        return bLoginCheck;
    }
    
    public void LogOut() {
    	setVisible(true);
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