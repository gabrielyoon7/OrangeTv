package media;

import java.util.Scanner;

import facade.UIData;
import main.Main;
import manage.Manageable;

public class Comment implements Manageable, UIData{
	//������ȣ ������̸� �����ȣ ���� ��۳���
	int num;
	String userName;
	int mediaNum;
	int rate;
	String comment;
	String mediaTitle;
	@Override
	public void read(Scanner scan) {
		Media mediaInfo=null;
		num=scan.nextInt();
		userName=scan.next();
		mediaNum=scan.nextInt();
		rate=scan.nextInt();
		comment=scan.nextLine();
		mediaInfo=(Media)Main.mediaMgr.find(""+mediaNum);
		if(mediaInfo==null) {
			System.out.println("�ش� �̵�� ����"+mediaNum);
		}
		mediaTitle=mediaInfo.title;
		mediaInfo.commentsList.add(this);
	}

	@Override
	public void print(boolean check) {
		if(!check) {
			System.out.printf("\n[��ȭ����:%s][�ۼ��� %s][����%d][��۳��� %s]\n ",mediaTitle, userName, rate, comment);
		}else {
			System.out.printf("\n[�ۼ��� %s][����%d][��۳��� %s] ",userName, rate, comment);
		}
	}

	@Override
	public boolean matches(String kwd) {
		if(comment.contains(kwd))
			return true;
		if(kwd.equals(userName))
			return true;
		if(mediaTitle.contains(kwd))
			return true;
		if(kwd.contains(""+num))
			return true;
		if(kwd.equals(""+mediaNum))
			return true;
		return false;
	}

	@Override
	public boolean matches(String[] kwdArr) {
		for(String kwd:kwdArr)
			if(!matches(kwd))
				return false;
		return true;
	}

	@Override
	public void set(Object[] uitexts) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String[] getUiTexts() {
		String uiText[] = new String[4];
		uiText[0] = mediaTitle;
		uiText[1] = userName;
		uiText[2] = comment;
		uiText[3] = ""+rate;
		return uiText;
	}

}
