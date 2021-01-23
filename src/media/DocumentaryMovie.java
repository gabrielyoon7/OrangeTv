package media;

import java.util.Scanner;


public class DocumentaryMovie extends Media{

	int time;
	
	@Override
	public void read(Scanner scan) {
		super.read(scan);
		time = scan.nextInt();
	}

	@Override
	public void print(boolean check) {
		super.print(check);
		if(check) {
		System.out.printf("\n·¯´× Å¸ÀÓ: %d ", time);
	}}

	@Override
	public boolean matches(String kwd) {
		if(super.matches(kwd)) {
			return true;
		}
		if(kwd.equals(""+time)) {
			return true;
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
