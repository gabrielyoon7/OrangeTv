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
			System.out.println("-----------�Է� ����------------");
			System.out.println("1.��� 2.�ִϸ��̼� 3.����");
			System.out.println("4.��ť�ø��� 5.��ť��ȭ 6.��ȭ");
			System.out.println("���� �Ұ���. ���� �� �����ϴٰ� �˷���");
			System.out.println("�ϳ� �߰��ɶ����� �����ؼ� �ű⼼��.");			
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
		System.out.println("������ȣ(4�ڸ���) : ");
		num = scan.next();
		System.out.println("���۳⵵(4�ڸ���) : ");
		year = scan.next();
		title = scan.nextLine();
		System.out.println("����(���� ���) : ");
		title = scan.nextLine();
		System.out.println("����(���� ���) : ");
		infomation = scan.nextLine();
		System.out.println("���ۻ� : ");
		company = scan.next();
		System.out.println("���� : ");
		director = scan.next();
		System.out.println("���(0/7/12/15/19�� �Է�) : ");
		age = scan.next();
		System.out.println("��ȸ�� : ");
		view = scan.next();
		System.out.println("����(0~100) : ");
		rate = scan.next();
		System.out.println("���� : ");
		price = scan.next();
		while (true) {
			String country = null;
			System.out.println("����(0�Է½� ����) : ");
			country = scan.next();
			if (country.equals("0")) {
				break;
			}
			countryList.add(country);
		}
		countryList.add("0");
		while (true) {
			String genre = null;
			System.out.println("�帣(0�Է½� ����) : ");
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
		System.out.println("����(�� ����) : ");
		season = scan.next();
		System.out.println("ȸ��(�� ȸ��) : ");
		episode = scan.next();
		System.out.println("�濵 ����(����/�濵) : ");
		state = scan.next();
		while (true) {
			String actor = null;
			System.out.println("�����ι�(0�Է½� ����) : ");
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
		System.out.println("����(�� ����) : ");
		season = scan.next();
		System.out.println("ȸ��(�� ȸ��) : ");
		episode = scan.next();
	}
	public void readDocumentaryMovie(Scanner scan) {
		readDefault(scan);
		System.out.println("���� Ÿ��(���ڸ�) : ");
		time = scan.next();
	}
	public void readMovie(Scanner scan) {
		readDocumentaryMovie(scan);
		while (true) {
			String actor = null;
			System.out.println("�����ι�(0�Է½� ����) : ");
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
			System.out.println("����� ����");
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
			System.out.println("����� ����");
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
			System.out.println("����� ����");
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
			System.out.println("����� ����");
		}
	}
	public void run() {
		System.out.println("Ÿ�Թ�ȣ(1~6�� ����) : ");
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
			System.out.println("�߸��� �Է�. ���α׷� �����.");
		}
	}
}

