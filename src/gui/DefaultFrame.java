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
    	/* 전체 사이즈 : 1920x1080
    	 * 사이즈는 이미 GUIMain클래스에서 결정됨.
    	 * Frame 사이즈가 FHD로 되어있지만 일부 노트북 설정에서 Windows 배율이 125%로 되어있어 OrangeTv 내부 컴포넌트에도 영향을 끼치고 있음.
    	 * 따라서 전체 Frame은 FHD를 기준으로 하고, 125%인 컴퓨터를 위해 JPanel들의 크기를 80% 수준으로 제작함.
    	 * 남은 20%의 여백은 빈 공간으로 두고 이질감이 느껴지지 않도록 설계를 해야함.(배율이 100%인 컴퓨터를 위해.)
    	 */
    	setUpTopPane();//상단 바 생성
    	sideMenuLeftPane();//좌측 메뉴 생성
    	MainMenu();//메인 메뉴 영역 생성
    	RightMargin();//100%배율인 컴퓨터를 위한 영역
    }
    public void setUpTopPane() {
    	/* 최상단에 표기되는 패널.   로고, 검색창, 개인정보가 표기됨. */
    	Color c=new Color(249,172,25);
    	setUpTopPane=new SetUpTopPane();
    	setUpTopPane.setBounds(0, 0, 1920, 100); //(0,0)을 기준으로 1530x100 사이즈
    	setUpTopPane.setBackground(c);
    	add(setUpTopPane);
    }
    public void sideMenuLeftPane() {
    	/* 좌측에 표시되는 패널. 메뉴 버튼이 표시될 예정. 각 버튼은 아래 있는 MainMenu패널을 조작하는 용도로 쓰임. */
    	Color c=new Color(255,247,242);     
    	sideMenuLeftPane=new SideMenuLeftPane();
    	sideMenuLeftPane.setBounds(0, 100, 200, 1500); //(0,100)을 기준으로 200x1500 사이즈
    	sideMenuLeftPane.setBackground(c);
    	add(sideMenuLeftPane);
    }
    public void MainMenu() {
    	/* 중앙에 표시되는 패널
    	 * MainMenu가 실행되면 해당 위치에 올 수 있는 모든 패널이 실행되나, 처음으로 표시되는 것은 MainMedia임.
    	 */
    	mainMenu=new MainMenu();
    	mainMenu.setBounds(200, 100, 2000, 980); //(200,100)을 기준으로 1220x980 사이즈
    	mainMenu.setBackground(new Color(255,247,242)); //검은 화면이 뜨는 경우 MainMenu 실행까지는 성공했다는 뜻.
    	add(mainMenu);
    }
    public void RightMargin() {
    	/*
    	 * 윈도우 화면배율이 100%인 사용자를 위해 채우는 우측 공간. 125%인 컴퓨터에서는 해당 화면이 보이지 않음.
    	 * 배경만 출력 되어야 함.
    	 */
    	Color c=new Color(255,247,242);
    	rightMargin=new RightMargin();
    	rightMargin.setBounds(1540,0,450,1500); //(1540,0)을 기준으로 450x1500 사이즈
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

	public class TimerTest extends JPanel implements ActionListener{//우측 여백이 너무 심심해보여서 임시로 넣어봄
		
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

	            lbPresent = new JLabel("[현재 시각] " + hour + ":" + min + ":" + sec, Label.RIGHT);
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
	            lbPresent.setText("[현재 시각]" + hour + ":" + min + ":" + sec);
	      }
	}
}
