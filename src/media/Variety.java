package media;

import java.util.Scanner;

public class Variety extends Media{
	int season;
	int episode;

	@Override
	public void read(Scanner scan) {
		super.read(scan);
		season = scan.nextInt();
		episode = scan.nextInt();
	}

	@Override
	public void print(boolean check) {
		super.print(check);
		if(check) {
		System.out.printf("½ÃÁð: %d, È¸Â÷: %d", season, episode);
		}
	}

	@Override
	public boolean matches(String kwd) {
		if(super.matches(kwd))
			return true;
		return false;
	}

	@Override
	public boolean matches(String[] kwdarr) {
		for(String kwd: kwdarr) {
			if(!matches(kwd))
				return false;
		}
		return true;
	}
}
