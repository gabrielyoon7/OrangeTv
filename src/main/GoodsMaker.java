package main;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class GoodsMaker {
	public void run() {
		while(true) {
			System.out.println("-----------입력 시작------------");
			System.out.println("띄어쓰기 불가능. 가능 시 가능하다고 알려줌");
			System.out.println("하나 추가될때마다 복붙해서 옮기세요.");			
			System.out.println("-----------------------------");
			
			GoodsData data = new GoodsData();
			data.run();
		}
	}
	public static void main(String[] args) {
		GoodsMaker my= new GoodsMaker();
		my.run();
	}

}
class GoodsData{
	Scanner scan = new Scanner(System.in);
	String num;
	String name;
	String price;
	String left; //남은 수량
	String company; //제작사
	public String mediaNum;
	String information; //상품 정보
	
	public void read(Scanner scan) {
		System.out.println("고유번호(4자리수) : ");
		num = scan.next();
		name = scan.nextLine();
		System.out.println("제품명(띄어쓰기 허용) : ");
		name = scan.nextLine();
		System.out.println("가격 : ");
		price = scan.next();
		System.out.println("남은수량(1~100) : ");
		left = scan.next();
		System.out.println("제작사 : ");
		company = scan.next();
		System.out.println("연관 영상 코드(반드시 실제 있는 Media번호를 참고하세요!) : ");
		mediaNum = scan.next();
		//information = scan.nextLine();
		System.out.println("내용(띄어쓰기 허용) : ");
		scan.next();
		information = scan.nextLine();
	}
	public void write(PrintWriter fout) {
		fout.write(num+" ");
		fout.write(name+"\n");
		fout.write(price+" ");
		fout.write(left+" ");
		fout.write(company+" ");
		fout.write(mediaNum+" ");
		fout.write(information+"\n");
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

