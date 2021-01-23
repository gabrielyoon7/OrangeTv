package gui;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import main.Main;
import media.Media;

public class MainMyMedia extends JPanel{
	
	JPanel panel1, mainPanel;
	JScrollPane scroll, scroll2, scroll3, scroll4, mainScroll;
	String kwd;
	JButton btnNewButton, btnNewButton2;
	JLabel lblNewLabel;
	public MainMyMedia(){
		setLayout(null);
		setBounds(0,0,1340, 980);
		
		panel1 = new JPanel();
		
		mainScroll = new JScrollPane();
		mainScroll.setViewportView(panel1);
		mainScroll.setBounds(0,0,1340,980);
		mainScroll.getViewport().getView().setBackground(Color.WHITE);
		add(mainScroll);
		panel1.setLayout(null);
		
		ArrayList<String> arr = new ArrayList<String>();
		arr.addAll(LogIn.user.mediaCart);
		
		int num = 0;
		
		if((arr.size()%4) == 0) {
			num = arr.size()/4;
		}
		else {
			num = arr.size()/4;
			num+=1;
		}
		
		JPanel panel = new JPanel(new GridLayout(num,4,2,3));
		panel.setBounds(0, 40, 1330, 900);
		
		scroll = new JScrollPane();
		scroll.setBounds(0, 40, 1330, 900);
		scroll.setViewportView(panel);
		scroll.getViewport().getView().setBackground(Color.WHITE);
		panel1.add(scroll);
		createLabel(num, arr, panel);
		lblNewLabel = new JLabel("���� ������ ����");
		lblNewLabel.setBounds(586, 14, 215, 15);
		panel1.add(lblNewLabel);
	}
		
	public void createLabel(int num, ArrayList<String> arr, JPanel panel) {
		
		
		JLabel labels[] = new JLabel[(4*num)];
		
		for (int i =  0; i < 4*num; i++)
		{
			if(i == arr.size()) {
				break;
			}
			Media m = null;
		    String title = arr.get(i);
		    m = Main.mediaMgr.find(title);
		    String address_2 = "mediaImage/"+m.num+".jpg"; //�̹��� ��θ� String �������� ����
			ImageIcon Icon = new ImageIcon(address_2); 
			Image img=Icon.getImage();
		    Image changeImg = img.getScaledInstance(250,300, Image.SCALE_SMOOTH); //�̹��� ũ�� ���� ����
		    ImageIcon changeIcon = new ImageIcon(changeImg);
		      labels[i] = new JLabel(changeIcon);
		      labels[i].setText(m.title);
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
		MainMenu.mainMedia.setVisible(false);//���� ȭ�� off
		for(JLabel label : MainMenu.mainMediaInfo.goodsCode) {
			MainMenu.mainMediaInfo.panel2.remove(label);
		}
		JLabel name = (JLabel)e.getSource();
		String title = name.getText();
		Media media = (Media)Main.mediaMgr.find(title);//����� ��ġ�ϴ� media �ҷ�����
		MainMediaInfo.seletedMedia = media;
		String genre = ""; //genre String ����
		for(String g : media.genreList) {
			genre+=g+" ";
		}
		String country = ""; //country String ����
		for(String c : media.countryList) {
			country+=c+" ";
		}
		//panelLeftUp ���� ����
		int age = media.age;
		String s = "";
		if(age == 0) {
			s = "��ü������";
		} 
		else if(age == 19){
			s = "û�ҳ�����Ұ�";
		}	
	    else {
	    	s = age+"��������";
		}
		MainMenu.mainMediaInfo.lblNewLabel_1.setText("<html><h1>"+media.title+"("+media.year+")</h1><br/>"+
		"���� : "+media.rate+"��(��ȸ�� "+media.view+"ȸ)<br/>���: "+s+"<br/>"+"�帣: "+genre+" ����: "+country+
		"<br/>���ۻ�: "+media.company+" ����: "+media.director+",<br/>����: "+media.information+"<br/><html/>");
		JLabel lblNewLabel_2 = new JLabel("���� ��ǰ: ");
		lblNewLabel_2.setBounds(32, 500, 76, 29);
		MainMenu.mainMediaInfo.panel2.add(lblNewLabel_2);
		
		MainMenu.mainMediaInfo.goodsCode = new JLabel[media.goodsList.size()];
		for(int i = 0; i<media.goodsList.size(); i++) {
			String num = ""+media.goodsList.get(i);//Ŭ���� ������ ������ȣ�� String���� ��ȯ
			String address="goodsImage/"+num+".jpg";//�̹��� ��θ� String �������� ����
			ImageIcon icon = new ImageIcon(address);
		    Image img=icon.getImage();
		    Image changeImg = img.getScaledInstance(90, 90, Image.SCALE_SMOOTH);
		    ImageIcon changeIcon = new ImageIcon(changeImg);
		    MainMenu.mainMediaInfo.goodsCode[i] = new JLabel(changeIcon);
		    MainMenu.mainMediaInfo.goodsCode[i].setText(num);
		    MainMenu.mainMediaInfo.goodsCode[i].setHorizontalTextPosition(JLabel.CENTER);
		    MainMenu.mainMediaInfo.goodsCode[i].setVerticalTextPosition(JLabel.BOTTOM);
			MainMenu.mainMediaInfo.goodsCode[i].setBounds(32+((i+1)*95), 470, 90, 80);
			MainMenu.mainMediaInfo.goodsCode[i].addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					MainMenu.mainMediaInfo.setVisible(false);
					MainMenu.mainStore.clickEvent(e);
				}
		      });
			MainMenu.mainMediaInfo.panel2.add(MainMenu.mainMediaInfo.goodsCode[i]);
		}
		
		//panelLeftDown ���� ���� (�����ʿ�)
		MainMenu.mainMediaInfo.clearTable();
		MainMenu.mainMediaInfo.setVisible(false);
		MainMenu.mainMediaInfo.tableCreate(media.num);
		MainMenu.mainMediaInfo.setVisible(true);
		
		//panelRight ���� ����
		String num = Integer.toString(media.num);//Ŭ���� ������ ������ȣ�� String���� ��ȯ
		String address="mediaImage/"+num+".jpg";//�̹��� ��θ� String �������� ����
		ImageIcon icon = new ImageIcon(address);
	    Image img=icon.getImage();
	    Image changeImg = img.getScaledInstance(400, 600, Image.SCALE_SMOOTH);
	    ImageIcon changeIcon = new ImageIcon(changeImg);
	    MainMenu.mainMediaInfo.lblNewLabel.setIcon(changeIcon);
		MainMenu.mainMediaInfo.setVisible(true);
	}

}
