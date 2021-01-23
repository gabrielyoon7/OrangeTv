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
			System.out.println("-----------�Է� ����------------");
			System.out.println("���� �Ұ���. ���� �� �����ϴٰ� �˷���");
			System.out.println("�ϳ� �߰��ɶ����� �����ؼ� �ű⼼��.");			
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
	String left; //���� ����
	String company; //���ۻ�
	public String mediaNum;
	String information; //��ǰ ����
	
	public void read(Scanner scan) {
		System.out.println("������ȣ(4�ڸ���) : ");
		num = scan.next();
		name = scan.nextLine();
		System.out.println("��ǰ��(���� ���) : ");
		name = scan.nextLine();
		System.out.println("���� : ");
		price = scan.next();
		System.out.println("��������(1~100) : ");
		left = scan.next();
		System.out.println("���ۻ� : ");
		company = scan.next();
		System.out.println("���� ���� �ڵ�(�ݵ�� ���� �ִ� Media��ȣ�� �����ϼ���!) : ");
		mediaNum = scan.next();
		//information = scan.nextLine();
		System.out.println("����(���� ���) : ");
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
			System.out.println("����� ����");
		}
	}
	public void run() {
		read(scan);
		write();
	}
}

