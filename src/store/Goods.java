package store;

import java.util.Scanner;

import facade.UIData;
import main.Main;
import manage.Manageable;
import media.Media;

public class Goods implements Manageable, UIData{
	/*
	 * �˴� public ó�� �߽��ϴ�.
	 */
	
	Media media;
	
	public int num;
	public String name;
	public int price;
	public int left; //���� ����
	public String company; //���ۻ�
	public String mediaNum; //������ǰ
	public String information; //��ǰ ����
	
	
	@Override
	public void read(Scanner scan) {
		
		num = scan.nextInt();
		Main.storeMgr.goodsNumbers.add(""+num);
		name = scan.nextLine();
		Main.storeMgr.goodsNames.add(name);
		price = scan.nextInt();
		left = scan.nextInt();
		company = scan.next();
		mediaNum = scan.next();
		media=(Media)Main.mediaMgr.find(mediaNum);
		if(media != null)
			media.goodsList.add(num);//Media�� goodsList�� �߰�
		information = scan.nextLine();
	}

	@Override
	public void print(boolean check) {
		if(!check)
			System.out.printf("%s", name);
		else {
			System.out.printf("��ǰ��: %s / ����: %d�� / ��������:%d / ���ۻ�: %s / ��ǰ����: %s\n",name, price,left,company, information);	
		}
	}

	@Override
	public boolean matches(String kwd) {
		if(kwd.equals(num+""))
			return true;
		if(name.contains(kwd))
			return true;
		if(company.contains(kwd))
			return true;
		return false;
	}

	@Override
	public boolean matches(String[] kwdArr) {
		for(String kwd: kwdArr) {
			if(!matches(kwd))
				return false;
		}
		return true;
	}

	@Override
	public void set(Object[] uitexts) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String[] getUiTexts() {
		String[] texts = new String[3];
		texts[0] = name;
		texts[1] = ""+price;
		texts[2] = ""+left;
		return texts;
	}

}
