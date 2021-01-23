package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class DefaultFrame extends JPanel{
	static SetUpTopPane setUpTopPane;
	static SideMenuLeftPane sideMenuLeftPane;
	static MainMenu mainMenu;
	static RightMargin rightMargin;
	
    public DefaultFrame() {
    	super(new BorderLayout());
    }
    void addComponentsToPane() {
    	/* ��ü ������ : 1920x1080
    	 * ������� �̹� GUIMainŬ�������� ������.
    	 * Frame ����� FHD�� �Ǿ������� �Ϻ� ��Ʈ�� �������� Windows ������ 125%�� �Ǿ��־� OrangeTv ���� ������Ʈ���� ������ ��ġ�� ����.
    	 * ���� ��ü Frame�� FHD�� �������� �ϰ�, 125%�� ��ǻ�͸� ���� JPanel���� ũ�⸦ 80% �������� ������.
    	 * ���� 20%�� ������ �� �������� �ΰ� �������� �������� �ʵ��� ���踦 �ؾ���.(������ 100%�� ��ǻ�͸� ����.)
    	 */
    	setUpTopPane();//��� �� ����
    	sideMenuLeftPane();//���� �޴� ����
    	MainMenu();//���� �޴� ���� ����
    	RightMargin();//100%������ ��ǻ�͸� ���� ����
    }
    public void setUpTopPane() {
    	/* �ֻ�ܿ� ǥ��Ǵ� �г�.   �ΰ�, �˻�â, ���������� ǥ���. */
    	Color c=new Color(249,172,25);
    	setUpTopPane=new SetUpTopPane();
    	setUpTopPane.setBounds(0, 0, 1920, 100); //(0,0)�� �������� 1530x100 ������
    	setUpTopPane.setBackground(c);
    	add(setUpTopPane);
    }
    public void sideMenuLeftPane() {
    	/* ������ ǥ�õǴ� �г�. �޴� ��ư�� ǥ�õ� ����. �� ��ư�� �Ʒ� �ִ� MainMenu�г��� �����ϴ� �뵵�� ����. */
    	Color c=new Color(255,247,242);     
    	sideMenuLeftPane=new SideMenuLeftPane();
    	sideMenuLeftPane.setBounds(0, 100, 200, 1500); //(0,100)�� �������� 200x1500 ������
    	sideMenuLeftPane.setBackground(c);
    	add(sideMenuLeftPane);
    }
    public void MainMenu() {
    	/* �߾ӿ� ǥ�õǴ� �г�
    	 * MainMenu�� ����Ǹ� �ش� ��ġ�� �� �� �ִ� ��� �г��� ����ǳ�, ó������ ǥ�õǴ� ���� MainMedia��.
    	 */
    	mainMenu=new MainMenu();
    	mainMenu.setBounds(200, 100, 2000, 980); //(200,100)�� �������� 1220x980 ������
    	mainMenu.setBackground(new Color(255,247,242)); //���� ȭ���� �ߴ� ��� MainMenu ��������� �����ߴٴ� ��.
    	add(mainMenu);
    }
    public void RightMargin() {
    	/*
    	 * ������ ȭ������� 100%�� ����ڸ� ���� ä��� ���� ����. 125%�� ��ǻ�Ϳ����� �ش� ȭ���� ������ ����.
    	 * ��游 ��� �Ǿ�� ��.
    	 */
    	Color c=new Color(255,247,242);
    	rightMargin=new RightMargin();
    	rightMargin.setBounds(1540,0,450,1500); //(1540,0)�� �������� 450x1500 ������
    	rightMargin.setBackground(c);
    	add(rightMargin);
    }

}
class RightMargin extends JPanel{
	public RightMargin() {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		setBounds(0,0,450,1500);
    	TimerTest timerTest = new TimerTest();
		timerTest.setOpaque(true);
		timerTest.setLocation(0, 500);
		add(timerTest);
		setVisible(true);
		
	}

	public class TimerTest extends JPanel implements ActionListener{//���� ������ �ʹ� �ɽ��غ����� �ӽ÷� �־
		
		Calendar calendar1 = Calendar.getInstance(); 
	      int hour = calendar1.get(Calendar.HOUR_OF_DAY); 
	      int min = calendar1.get(Calendar.MINUTE); 
	      int sec = calendar1.get(Calendar.SECOND);

	      javax.swing.Timer timer; 
	      JLabel lbPresent;
	      public TimerTest()

	      {
	            timer = new javax.swing.Timer(1000, this);
	            timer.setInitialDelay(0);
	            timer.start();

	            lbPresent = new JLabel("[���� �ð�] " + hour + ":" + min + ":" + sec, Label.RIGHT);
	            add(lbPresent);
	      }
		@Override
		public void actionPerformed(ActionEvent e)
	      {
	            ++sec;
	            Calendar calendar2 = Calendar.getInstance();
	            hour = calendar2.get(Calendar.HOUR_OF_DAY);
	            min = calendar2.get(Calendar.MINUTE);
	            sec = calendar2.get(Calendar.SECOND);
	            lbPresent.setText("[���� �ð�]" + hour + ":" + min + ":" + sec);
	      }
	}
}
