package media;

import java.util.ArrayList;
import java.util.Scanner;

import facade.UIData;
import main.Main;
import manage.Manageable;

public class Media implements Manageable, Comparable<Media>, UIData{
	public int num;
	public int year;
	public String title;
	public String information;
	public String company;
	public String director;
	public int age;
	public int view;
	public int rate;
	public int price;
	public ArrayList<String> countryList = new ArrayList<>();
	public ArrayList<String> genreList = new ArrayList<>();
	public ArrayList<Comment> commentsList = new ArrayList<>();
	public String fileAddress;//이거 더미데이터인가요?
	public ArrayList<Integer> goodsList = new ArrayList<>();
	@Override
	public void read(Scanner scan) {
		num=scan.nextInt();
		Main.mediaMgr.numbers.add(""+num);
		year=scan.nextInt();
		title=scan.nextLine();
		Main.mediaMgr.titles.add(title);
		information=scan.nextLine();
		company=scan.next();
		director=scan.next();
		age=scan.nextInt();
		view=scan.nextInt();
		rate=scan.nextInt();
		price=scan.nextInt();
		while(true) {
			String country = null;
			country = scan.next();
			if(country.equals("0")) {
				break;
			}
			countryList.add(country);
		}
		while(true) {
			String genre = null;
			genre = scan.next();
			if(genre.equals("0")) {
				break;
			}
			genreList.add(genre);
			
		}
		for(String genre : genreList) {
			if(genre.contains("공포")) {
				Main.mediaMgr.fearTitles.add(title);
			}
			else if(genre.contains("스릴러")) {
				Main.mediaMgr.thrillerTitles.add(title);
			}
			else if(genre.contains("액션")) {
				Main.mediaMgr.actionTitles.add(title);
			}
			else if(genre.contains("코미디")) {
				Main.mediaMgr.comedyTitles.add(title);
			}
			else if(genre.contains("SF")) {
				Main.mediaMgr.sfTitles.add(title);
			}
			else if(genre.contains("미스터리")) {
				Main.mediaMgr.mysteryTitles.add(title);
			}
			else if(genre.contains("드라마")) {
				Main.mediaMgr.dramaTitles.add(title);
			}
			else if(genre.contains("멜로")) {
				Main.mediaMgr.meloTitles.add(title);
			}
			else if(genre.contains("로맨스")) {
				Main.mediaMgr.romanceTitles.add(title);
			}
		}
		fileAddress="mediaImage/"+num+".jpg";
	}

	@Override
	public void print(boolean check) {
		if(!check) {
			System.out.printf("\n○ %s(%d점)",title, rate);
		}
		else {
			System.out.printf("\n\n※고유번호 : %d※ (개봉년도 : %d년)\n제목 : %s\n"
					+ "제작사 : %s / 감독 : %s / 등급 : %d\n"
					+ "조회수 : %d회 / 별점: %d점 / 가격 : %d원\n"
					+ "설명 : %s\n"
					,num, year, title, company, director, age, view, rate, price,information);
			System.out.printf("연관 상품 코드 : ");
			for(Integer goods:goodsList)
				System.out.printf("%d ", goods);
			System.out.printf("\n%s",fileAddress);
			System.out.printf("제작국가 : ");
			for(String country:countryList)
				System.out.printf("%s ",country);
			System.out.printf("/ 장르 : ");
			for(String genre:genreList)
				System.out.printf("%s ",genre);
			for(Comment c:commentsList)//BUG 순서가 이상함.
				c.print(true);
		}
	}
	public void printTitle() {
		System.out.printf("%s\n",title);
	}

	@Override
	public boolean matches(String kwd) {
		if(kwd.contentEquals((num/1000)+""))
			return true;
		if (kwd.length() == 0)
			return true;
		if(kwd.length()<2)
			return false;
		if(kwd.contains((""+num)))
			return true;
		if(kwd.equals(""+num))
			return true;
		if(title.contains(kwd))
			return true;
		if(company.contains(kwd))
			return true;
		if(director.contains(kwd))
			return true;
		if(kwd.equals(""+year))
			return true;
		for (String country : countryList)
			if(country.contains(kwd))
				return true;
		for (String genre : genreList)
			if(genre.contains(kwd))
				return true;
		return false;
	}
	public boolean matches(String[] kwdArr) {
		for (String kwd : kwdArr) {
			if(!matches(kwd))
				return false;
		}
		return true;
	}

	@Override
	public int compareTo(Media media) {//Media용 mList의 정렬 기준을 rate로 정해줌.
		if (this.rate < media.rate) {
            return -1;
        }
		if (this.rate > media.rate) {
            return 1;
        }
		return 0;
	}
	
	public int getRate() {
		return this.rate;
	}

	@Override
	public void set(Object[] uitexts) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String[] getUiTexts() {
		// TODO Auto-generated method stub
		String genreString = "";
		for (String genre : genreList)
			genreString+=genre+" ";
		String countryString = "";
		for (String country : countryList)
			countryString+=country+" ";
		String text[] = new String[7];
		text[0] = title;
		text[1] = ""+year;
		text[2] = ""+age;
		text[3] = ""+rate;
		text[4] = countryString;
		text[5] = genreString;
		text[6] = ""+view;
		return text;
	}

	/*public boolean genreMatches(String genre) {
		for(String g : genreList) {
			if(genre.equals(g)) {
				return true;
			}
		}
		return false;
	}*/

	
}
