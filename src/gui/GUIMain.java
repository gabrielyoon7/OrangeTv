package gui;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.*;

import facade.DataEngineInterface;
import main.Main;
 
public class GUIMain{
    static DataEngineInterface engine;
    static Main main = Main.getInstance();
    static LogIn login;
    static advertisement ad;
    public static void main(String args[]) {
    	/* 시작지점. 프로그램의 진행 방향은 다음과 같음
    	 * GUIMain클래스의 main    =>    LogIn클래스   =>    (로그인 성공시) GUIMain의 광고 => GUIMain의 startGUI
    	 * 로그인 성공 시 Main클래스의 콘솔도 작동 시킴.
    	 */
    	login = new LogIn();//로그인 클래스 안에서 로그인 여부 판단 후 startGUI를 실행함.
    	main.run();//로그인 성공 시 콘솔 작동
    	
    }
    
    
    public static void startGUI() {
    	// ★★★★★★(접근 방법 변경됨) LogIn 클래스가 이 메소드를 활성화 시킬 것임. ★★★★★★
    	//startGUI => createAndShowGUI => DefaultFrame 순으로 실행됨.
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
    	ad=new advertisement();
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
                ad.setVisible(false);
                ad.setVisible(true);
            }
        });
    }
    
    /**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from the
     * event-dispatching thread.
     */
	static JFrame mainFrame = new JFrame("OrangeTv");
    private static void createAndShowGUI() {
    	//실행된 DefaultFrame에 있는 addComponentsToPane를 실행시키면서 4종류의 패널이 붙을 예정
        //Create and set up the window.
    	mainFrame = new JFrame("OrangeTv");
    	Toolkit toolkit = Toolkit.getDefaultToolkit();
    	Image img = toolkit.getImage("GUI/orange_profile.png");
    	mainFrame.setIconImage(img);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setSize(1920, 1080);

        //Create and set up the content pane.
        DefaultFrame newContentPane = new DefaultFrame();
        newContentPane.setLayout(null);
//        mainFrame.setLayout(null);
        newContentPane.addComponentsToPane();
        mainFrame.getContentPane().add(newContentPane);


        //Display the window.
//        mainFrame.pack();
        mainFrame.setVisible(true);
    }
}

class advertisement extends JFrame{
//   GUI/Logo_Orange.png
	private Image background=new ImageIcon("GUI/ad.png").getImage();
    public advertisement() {
    	// setting
        setTitle("ad");
        setSize(600,400);
        setResizable(false);
        setLocation(600, 350);
        setVisible(true);        // visible
    }
    public void paint(Graphics g) {//그리는 함수
		g.drawImage(background, 0, 0, null);//background를 그려줌
    }
}