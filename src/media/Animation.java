package media;

import java.util.ArrayList;
import java.util.Scanner;

import manage.Manageable;

public class Animation extends Media{

	int season;
	int episode;
	String state;
	ArrayList<String> actorList = new ArrayList<>();
	@Override
	public void read(Scanner scan) {
	
		super.read(scan);
		season = scan.nextInt();
		episode = scan.nextInt();
		state = scan.next();
		while(true) {
			String actor = null;
			actor = scan.next();
			if(actor.contentEquals("0"))
				break;
			actorList.add(actor);
		}
	}
	@Override
	public void print(boolean check) {
		super.print(check);
		if(check) {
		System.out.printf("����: %d / ȸ��: %d / �濵����: %s\n�����ι�: ", season, episode, state);
		for(String actor: actorList) {
			System.out.printf("%s ",actor);
		}
	}}
	@Override
	public boolean matches(String kwd) {
		if(super.matches(kwd))
			return true;
		for (String actor : actorList) {
			if(actor.contains(kwd))
				return true;
		}
		return false;
	}
	@Override
	public boolean matches(String[] kwdArr) {
		
		if(super.matches(kwdArr))
			return true;
		for(String kwd: kwdArr) {
			if(!matches(kwd))
				return false;
		}
		return true;
	}
	
}
