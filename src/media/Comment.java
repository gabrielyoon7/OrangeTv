package media;

import java.util.Scanner;

import facade.UIData;
import main.Main;
import manage.Manageable;

public class Comment implements Manageable, UIData{
	//고유번호 사용자이름 영상번호 별점 댓글내용
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
			System.out.println("해당 미디어 없음"+mediaNum);
		}
		mediaTitle=mediaInfo.title;
		mediaInfo.commentsList.add(this);
	}

	@Override
	public void print(boolean check) {
		if(!check) {
			System.out.printf("\n[영화제목:%s][작성자 %s][별점%d][댓글내용 %s]\n ",mediaTitle, userName, rate, comment);
		}else {
			System.out.printf("\n[작성자 %s][별점%d][댓글내용 %s] ",userName, rate, comment);
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
