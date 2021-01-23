package media;

import java.util.ArrayList;
import java.util.Scanner;


public class Movie extends Media{
	int time;
	ArrayList<String> actors = new ArrayList<String>();
	
	@Override
	public void read(Scanner scan) {
		super.read(scan);
		time = scan.nextInt();
		while(true) {
			String actor = null;
			actor = scan.next();
			if(actor.equals("0")) {
				break;
			}
			actors.add(actor);
		}
	}

	@Override
	public void print(boolean check) {
		super.print(check);
		if(check) {
		System.out.printf("\n러닝 타임: %d \n", time);
		System.out.printf("출연진: ");
		for(String actor : actors) {
			System.out.printf("%s ", actor);
		}
		System.out.println();
	}}

	@Override
	public boolean matches(String kwd) {
		if(super.matches(kwd)) {
			return true;
		}
		if(kwd.equals(""+time)) {
			return true;
		}
		for(String actor : actors) {
			if(actor.contains(kwd)) {
				return true;
			}
		}
		return false;
	}
	@Override
	public boolean matches(String kwdArr[]) {
		for(String kwd : kwdArr) {
			if(!matches(kwd)) {
				return false;
			}
		}
		return true;
	}
}
