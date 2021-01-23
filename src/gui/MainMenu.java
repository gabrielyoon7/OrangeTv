package gui;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import main.Main;
import media.Media;
import store.Goods;

public class MainMenu extends JPanel{
	//GUI��Ű�� �ȿ� �ִ� Ŭ���� �� Main���� �����ϴ� Ŭ�������� ���� Main���� ��µ� ������ Ŭ��������.
	static MainMedia mainMedia;
	static MainRank mainRank;
	static MainStore mainStore;
	static MainCart mainCart;
	static MainEvent mainEvent;
	static MainSearch mainSearch;
	static PrivatePage privatePage; 
	static MainMediaInfo mainMediaInfo;
	static MainStoreInfo mainStoreInfo;
	static MainMyMedia mainMyMedia;

	public MainMenu() {
		//�ϴ� ���� �޴��� ��µ� �� �ִ� ��� ���� ���⿡�� �����Ŵ. visible ���δ� SideMenuLeftPane���� �޴� ��ư ������ ����.
		//Mainȭ�鿡 ���� �� �ִ� ��� ���� ���⿡�� �켱 ���� �� ����Ǿ�� ��.
		setLayout(null);
		PrivateCreator();
		MediaCreator();
		RankCreator();
		StoreCreator();
		CartCreator();
		SearchCreator();
		MediaInfoCreator();
		StoreInfoCreator();
		MainMyMedia();
		EventCreator();
	}
	public void MediaCreator() {
		mainMedia=new MainMedia();
		mainMedia.setBounds(0,0,1340, 980);
		mainMedia.setBackground(Color.WHITE);
		mainMedia.setVisible(true);
		this.add(mainMedia);
	}
	public void RankCreator() {
		mainRank = new MainRank();
		mainRank.setBounds(0,0,1340,980);
		mainRank.setBackground(Color.WHITE);
		mainRank.setVisible(false);
		this.add(mainRank);
	}
	public void StoreCreator() {
		mainStore=new MainStore();
		mainStore.setBounds(0,0,1340, 980);
		mainStore.setBackground(Color.WHITE);
		mainStore.setVisible(false);
		this.add(mainStore);
	}
	public void CartCreator() {
		mainCart=new MainCart();
		mainCart.setBounds(0,0,1340, 980);
		mainCart.setBackground(Color.WHITE);
		mainCart.setVisible(false);
		this.add(mainCart);
	}
	public void SearchCreator() {
		mainSearch = new MainSearch();
		mainSearch.setBounds(0,0,1340, 980);
		mainSearch.setBackground(Color.WHITE);
		mainSearch.setVisible(false);
		this.add(mainSearch);
	}
	public void PrivateCreator() {
		privatePage = new PrivatePage();
		privatePage.setBounds(750,0,405, 490);
		privatePage.setBackground(Color.WHITE); //new Color(255,247,242)
		privatePage.setBorder(BorderFactory.createLineBorder(Color.gray, 3));
		privatePage.setVisible(false);
		this.add(privatePage);
	}
	public void MediaInfoCreator() {
		mainMediaInfo = new MainMediaInfo(new Media());
		mainMediaInfo.setBounds(0,0,1340, 980);
		mainMediaInfo.setBackground(new Color(255,247,242));
		mainMediaInfo.setBorder(BorderFactory.createLineBorder(Color.gray, 3));
		mainMediaInfo.setVisible(false);
		this.add(mainMediaInfo);
	}
	public void StoreInfoCreator() {
		mainStoreInfo = new MainStoreInfo();
		mainStoreInfo.setBounds(0,0,1340, 980);
		mainStoreInfo.setBackground(new Color(255,247,242));
		mainStoreInfo.setBorder(BorderFactory.createLineBorder(Color.gray, 3));
		mainStoreInfo.setVisible(false);
		this.add(mainStoreInfo);
	}
	public void MainMyMedia() {
		mainMyMedia = new MainMyMedia();
		mainMyMedia.setBounds(0,0,1340, 980);
		mainMyMedia.setBackground(new Color(255,247,242));
		mainMyMedia.setBorder(BorderFactory.createLineBorder(Color.gray, 3));
		mainMyMedia.setVisible(false);
		this.add(mainMyMedia);
	}
	public void EventCreator() {
		mainEvent = new MainEvent();
		mainEvent.setBounds(0,0,1340, 980);
		mainEvent.setBackground(new Color(255,247,242));
		mainEvent.setBorder(BorderFactory.createLineBorder(Color.gray, 3));
		mainEvent.setVisible(false);
		this.add(mainEvent);
	}
}
