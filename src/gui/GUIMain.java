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
    	/* ��������. ���α׷��� ���� ������ ������ ����
    	 * GUIMainŬ������ main    =>    LogInŬ����   =>    (�α��� ������) GUIMain�� ���� => GUIMain�� startGUI
    	 * �α��� ���� �� MainŬ������ �ֵܼ� �۵� ��Ŵ.
    	 */
    	login = new LogIn();//�α��� Ŭ���� �ȿ��� �α��� ���� �Ǵ� �� startGUI�� ������.
    	main.run();//�α��� ���� �� �ܼ� �۵�
    	
    }
    
    
    public static void startGUI() {
    	// �ڡڡڡڡڡ�(���� ��� �����) LogIn Ŭ������ �� �޼ҵ带 Ȱ��ȭ ��ų ����. �ڡڡڡڡڡ�
    	//startGUI => createAndShowGUI => DefaultFrame ������ �����.
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
    	//����� DefaultFrame�� �ִ� addComponentsToPane�� �����Ű�鼭 4������ �г��� ���� ����
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
    public void paint(Graphics g) {//�׸��� �Լ�
		g.drawImage(background, 0, 0, null);//background�� �׷���
    }
}