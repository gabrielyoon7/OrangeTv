package main;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
 
public class DataMaker {
	public void run() {
		while(true) {
			System.out.println("-----------입력 시작------------");
			System.out.println("1.드라마 2.애니메이션 3.예능");
			System.out.println("4.다큐시리즈 5.다큐영화 6.영화");
			System.out.println("띄어쓰기 불가능. 가능 시 가능하다고 알려줌");
			System.out.println("하나 추가될때마다 복붙해서 옮기세요.");			
			System.out.println("-----------------------------");
			
			Data dt = new Data();
			dt.run();
		}
	}
	public static void main(String[] args) {
		DataMaker my= new DataMaker();
		my.run();
	}

}
class Data{
	Scanner scan = new Scanner(System.in);
	//Default Field
	String type;
	String num;
	String year;
	String title;
	String infomation;
	String company;
	String director;
	String age;
	String view;
	String rate;
	String price;
	ArrayList<String> countryList = new ArrayList<>();
	ArrayList<String> genreList = new ArrayList<>();
	//Extra Field
	String season;
	String episode;
	String state;
	ArrayList<String> actorList = new ArrayList<>();
	String time;
	
	public void readDefault(Scanner scan) {
		System.out.println("고유번호(4자리수) : ");
		num = scan.next();
		System.out.println("제작년도(4자리수) : ");
		year = scan.next();
		title = scan.nextLine();
		System.out.println("제목(띄어쓰기 허용) : ");
		title = scan.nextLine();
		System.out.println("내용(띄어쓰기 허용) : ");
		infomation = scan.nextLine();
		System.out.println("제작사 : ");
		company = scan.next();
		System.out.println("감독 : ");
		director = scan.next();
		System.out.println("등급(0/7/12/15/19만 입력) : ");
		age = scan.next();
		System.out.println("조회수 : ");
		view = scan.next();
		System.out.println("별점(0~100) : ");
		rate = scan.next();
		System.out.println("가격 : ");
		price = scan.next();
		while (true) {
			String country = null;
			System.out.println("국가(0입력시 종료) : ");
			country = scan.next();
			if (country.equals("0")) {
				break;
			}
			countryList.add(country);
		}
		countryList.add("0");
		while (true) {
			String genre = null;
			System.out.println("장르(0입력시 종료) : ");
			genre = scan.next();
			if (genre.equals("0")) {
				break;
			}
			genreList.add(genre);
		}
		genreList.add("0");
	}
	public void readDramaAnimation(Scanner scan) {
		readDefault(scan);
		System.out.println("시즌(총 시즌) : ");
		season = scan.next();
		System.out.println("회차(총 회차) : ");
		episode = scan.next();
		System.out.println("방영 여부(종영/방영) : ");
		state = scan.next();
		while (true) {
			String actor = null;
			System.out.println("등장인물(0입력시 종료) : ");
			actor = scan.next();
			if (actor.equals("0")) {
				break;
			}
			actorList.add(actor);
		}
		actorList.add("0");
	}
	public void readVarietyDocumentarySeries(Scanner scan) {
		readDefault(scan);
		System.out.println("시즌(총 시즌) : ");
		season = scan.next();
		System.out.println("회차(총 회차) : ");
		episode = scan.next();
	}
	public void readDocumentaryMovie(Scanner scan) {
		readDefault(scan);
		System.out.println("러닝 타임(숫자만) : ");
		time = scan.next();
	}
	public void readMovie(Scanner scan) {
		readDocumentaryMovie(scan);
		while (true) {
			String actor = null;
			System.out.println("등장인물(0입력시 종료) : ");
			actor = scan.next();
			if (actor.equals("0")) {
				break;
			}
			actorList.add(actor);
		}
		actorList.add("0");
	}
	public void writeDefault(PrintWriter fout) {
		fout.write(type+" ");
		fout.write(num+" ");
		fout.write(year+" ");
		fout.write(title+"\n");
		fout.write(infomation+"\n");
		fout.write(company+" ");
		fout.write(director+" ");
		fout.write(age+" ");
		fout.write(view+" ");
		fout.write(rate+" ");
		fout.write(price+" ");
		for(String a : countryList)
			fout.write(a+" ");
		for(String a : genreList)
			fout.write(a+" ");
	}
	public void writeDramaAnimation() {
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter("data/test.txt",true));
			PrintWriter fout = new PrintWriter(bw,true);
			writeDefault(fout);
			fout.write("\n"+season+" ");
			fout.write(episode+" ");
			fout.write(state+" ");
			for(String a : actorList)
				fout.write(a+" ");
			fout.write("\r\n", 0,2);
			fout.close();
		}catch(IOException e) {
			System.out.println("입출력 오류");
		}
	}
	public void writeVarietyDocumentarySeries() {
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter("data/test.txt",true));
			PrintWriter fout = new PrintWriter(bw,true);
			writeDefault(fout);
			fout.write("\n"+season+" ");
			fout.write(episode+" ");
			fout.write("\r\n", 0,2);
			fout.close();
		}catch(IOException e) {
			System.out.println("입출력 오류");
		}
	}
	public void writeDocumentaryMovie() {
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter("data/test.txt",true));
			PrintWriter fout = new PrintWriter(bw,true);
			writeDefault(fout);
			fout.write("\n"+time+" ");
			fout.write("\r\n", 0,2);
			fout.close();
		}catch(IOException e) {
			System.out.println("입출력 오류");
		}
	}
	public void writeMovie() {
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter("data/test.txt",true));
			PrintWriter fout = new PrintWriter(bw,true);
			writeDefault(fout);
			fout.write("\n"+time+" ");
			for(String a : actorList)
				fout.write(a+" ");
			fout.write("\r\n", 0,2);
			fout.close();
		}catch(IOException e) {
			System.out.println("입출력 오류");
		}
	}
	public void run() {
		System.out.println("타입번호(1~6만 가능) : ");
		type=scan.next();
		if(type.equals("1")) {
			//Drama
			readDramaAnimation(scan);
			writeDramaAnimation();
		}else if(type.equals("2")) {
			//Animation
			readDramaAnimation(scan);
			writeDramaAnimation();
		}else if(type.equals("3")) {
			//Variety
			readVarietyDocumentarySeries(scan);
			writeVarietyDocumentarySeries();
		}else if(type.equals("4")) {
			//DocumentarySeries
			readVarietyDocumentarySeries(scan);
			writeVarietyDocumentarySeries();
		}else if(type.equals("5")) {
			//DocumentaryMovie
			readDocumentaryMovie(scan);
			writeDocumentaryMovie();
		}else if(type.equals("6")) {
			//Movie
			readMovie(scan);
			writeMovie();
		}else {
			System.out.println("잘못된 입력. 프로그램 재시작.");
		}
	}
}

