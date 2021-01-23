package main;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import manage.Manageable;
import store.Order;
/*
 * 미완성입니다.
 */
public class UserMaker {
	public void run() {
		while(true) {
			System.out.println("■■■■■■■■■■■■■■■■■■■■■■경 고■■■■■■■■■■■■■■■■■■■■■■");
			System.out.println("goods데이터가 충분히 확보되면 User에서 goodsCart활성화 예정인데 ");
			System.out.println("지금부터 너무 많은 데이터를 확보하지 말아주세요.");
			System.out.println("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
			System.out.println("-----------입력 시작------------");
			System.out.println("띄어쓰기 불가능. 가능 시 가능하다고 알려줌");
			System.out.println("하나 추가될때마다 복붙해서 옮기세요.");	
			System.out.println("-----------------------------");
			
			UserData data = new UserData();
			data.run();
		}
	}
	public static void main(String[] args) {
		UserMaker my= new UserMaker();
		my.run();
	}

}
class UserData{
	Scanner scan = new Scanner(System.in);
	String num;
	String name;
	String id;
	String password;
	String year;
	String month;
	String day;
	String phoneNumber;
	String cardNumber;
	String gender;
	ArrayList<String> genreList = new ArrayList<>();
	String level;
	String point;
	String premium;//교수님 피드백 참고
	ArrayList<String> friendList = new ArrayList<>();
	ArrayList<Manageable> mediaCart = new ArrayList<>();
//	ArrayList<Manageable> goodsCart = new ArrayList<>();
	ArrayList<Order> orderList = new ArrayList<>();
	
	public void read(Scanner scan) {
		System.out.println("고유번호(4자리수) : ");
		num = scan.next();
		System.out.println("이름 : ");
		name = scan.next();
		System.out.println("아이디(영어로) : ");
		id = scan.next();
		System.out.println("비밀번호 : ");
		password = scan.next();
		System.out.println("연도(숫자4자리) : ");
		year = scan.next();
		System.out.println("월(숫자2자리) : ");
		month = scan.next();
		System.out.println("일(숫자2자리) : ");
		day = scan.next();
		System.out.println("전화번호(010-0000-0000) : ");
		phoneNumber = scan.next();
		System.out.println("카드번호(0000-0000-0000-0000) : ");
		cardNumber = scan.next();
		System.out.println("성별(남/여): ");
		gender = scan.next();
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
		System.out.println("레벨(숫자) : ");
		level = scan.next();
		System.out.println("포인트(숫자) : ");
		point = scan.next();
		System.out.println("프리미엄여부(O/X) : ");
		premium = scan.next();
		System.out.println("포인트(숫자) : ");
		point = scan.next();
		System.out.println("프리미엄여부(O/X) : ");
		premium = scan.next();
		
	}
	public void write(PrintWriter fout) {
		fout.write(num+" ");
		fout.write(name+" ");
	}
	public void write() {
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter("data/test.txt",true));
			PrintWriter fout = new PrintWriter(bw,true);
			write(fout);
			fout.write("\r\n", 0,2);
			fout.close();
		}catch(IOException e) {
			System.out.println("입출력 오류");
		}
	}
	public void run() {
		read(scan);
		write();
	}
}

