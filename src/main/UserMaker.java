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
 * �̿ϼ��Դϴ�.
 */
public class UserMaker {
	public void run() {
		while(true) {
			System.out.println("������������������������ ������������������������");
			System.out.println("goods�����Ͱ� ����� Ȯ���Ǹ� User���� goodsCartȰ��ȭ �����ε� ");
			System.out.println("���ݺ��� �ʹ� ���� �����͸� Ȯ������ �����ּ���.");
			System.out.println("������������������������������������������������");
			System.out.println("-----------�Է� ����------------");
			System.out.println("���� �Ұ���. ���� �� �����ϴٰ� �˷���");
			System.out.println("�ϳ� �߰��ɶ����� �����ؼ� �ű⼼��.");	
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
	String premium;//������ �ǵ�� ����
	ArrayList<String> friendList = new ArrayList<>();
	ArrayList<Manageable> mediaCart = new ArrayList<>();
//	ArrayList<Manageable> goodsCart = new ArrayList<>();
	ArrayList<Order> orderList = new ArrayList<>();
	
	public void read(Scanner scan) {
		System.out.println("������ȣ(4�ڸ���) : ");
		num = scan.next();
		System.out.println("�̸� : ");
		name = scan.next();
		System.out.println("���̵�(�����) : ");
		id = scan.next();
		System.out.println("��й�ȣ : ");
		password = scan.next();
		System.out.println("����(����4�ڸ�) : ");
		year = scan.next();
		System.out.println("��(����2�ڸ�) : ");
		month = scan.next();
		System.out.println("��(����2�ڸ�) : ");
		day = scan.next();
		System.out.println("��ȭ��ȣ(010-0000-0000) : ");
		phoneNumber = scan.next();
		System.out.println("ī���ȣ(0000-0000-0000-0000) : ");
		cardNumber = scan.next();
		System.out.println("����(��/��): ");
		gender = scan.next();
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
		System.out.println("����(����) : ");
		level = scan.next();
		System.out.println("����Ʈ(����) : ");
		point = scan.next();
		System.out.println("�����̾�����(O/X) : ");
		premium = scan.next();
		System.out.println("����Ʈ(����) : ");
		point = scan.next();
		System.out.println("�����̾�����(O/X) : ");
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
			System.out.println("����� ����");
		}
	}
	public void run() {
		read(scan);
		write();
	}
}

