package main;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import media.Media;

public class CommentMaker {
	public static void main(String[] args) {
		CommentMaker my= new CommentMaker();
		my.run();
	}
	public void run() {
		while(true) {
			System.out.println("-----------�Է� ����------------");
			System.out.println("���� �Ұ���. ���� �� �����ϴٰ� �˷���");
			System.out.println("�ϳ� �߰��ɶ����� �����ؼ� �ű⼼��.");			
			System.out.println("-----------------------------");
			
			CommentData data = new CommentData();
			data.run();
		}
	}
}
class CommentData{
	Scanner scan = new Scanner(System.in);
	String num;
	String userName;
	String mediaNum;
	String rate;
	String comment;
	ArrayList <String> commentList = new ArrayList<String>();
	ArrayList <String> nameList = new ArrayList<String>();
	private Random randomGenerator;
	Random rand = new Random();
	public void run() {
		int i=0;
		
		readAllComments("src/main/commentExample.txt");
		readAllNames("src/main/nameExample.txt");
		
		System.out.println("1.��� �ڵ�����  2.��� �������� 3.��� ��� Ȯ�� 4.�г��ӿ� �ܾ� ��� Ȯ��");
		i=scan.nextInt();
		if(i==1) {
			autoRead(scan);
			write();
		}else if(i==2) {
			read(scan);
			write();
		}
		else if(i==3){
			for(String c : commentList)
				System.out.println(c);
		}
		else {
			for(String n : nameList)
				System.out.println(n);
		}
	}
	public void autoRead(Scanner scan) {
		System.out.println("��� ������ȣ : ");
		num=scan.next();
/*
		System.out.println("��ۿ� ǥ�õ� �̸� : ");
		userName=scan.next();
		*/
		randomGenerator = new Random();
		int index1 = randomGenerator.nextInt(nameList.size());
		int index2 = randomGenerator.nextInt(nameList.size());
        userName = nameList.get(index1);
        userName+= nameList.get(index2);
        
		System.out.println("�̵�� ��ȣ (�ݵ�� ��Ȯ�� �Է�) : ");
		mediaNum=scan.next();
		
		rate = Integer.toString(rand.nextInt(100));
		
		randomGenerator = new Random();
		int index = randomGenerator.nextInt(commentList.size());
        comment = commentList.get(index);
	}
	
	public void read(Scanner scan) {
		System.out.println("��� ������ȣ : ");
		num=scan.next();
		System.out.println("��ۿ� ǥ�õ� �̸� : ");
		userName=scan.next();
		System.out.println("�̵�� ��ȣ (�ݵ�� ��Ȯ�� �Է�) : ");
		mediaNum=scan.next();
		System.out.println("����(1~100)");
		rate=scan.next();
		scan.nextLine();
		System.out.println("��۳���(���� ���) : ");
		comment=scan.nextLine();
	}
	public void write(PrintWriter fout) {
		fout.write(num+" ");
		fout.write(userName+" ");
		fout.write(mediaNum+" ");
		fout.write(rate+" ");
		fout.write(comment+"\n");
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
	private void readAllComments(String filename) {
		Scanner filein = openFile(filename);
		while (filein.hasNext()) {
			String comment;
			comment = filein.nextLine();
			commentList.add(comment);
		}
		filein.close();		
	}
	private void readAllNames(String filename) {
		Scanner filein = openFile(filename);
		while (filein.hasNext()) {
			String name;
			name = filein.next();
			nameList.add(name);
		}
		filein.close();		
	}
	private Scanner openFile(String filename) {
		Scanner filein = null;
		try {
			filein = new Scanner(new File(filename)); // �ѱ� �Է½� ���� �б� ���� ����
		} catch (Exception e) {
			System.out.println(filename + ": ���� ����");
			System.exit(0);
		}
		return filein;
	}
}
