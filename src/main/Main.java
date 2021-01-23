package main;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import gui.GUIMain;
import manage.Factory;
import manage.Manageable;
import manage.Manager;
import media.Comment;
import media.CommentManager;
import media.Media;
import media.MediaManager;
import store.Goods;
import store.Order;
import store.StoreManager;
import user.User;
import user.UserManager;

public class Main{
	Scanner scan = new Scanner(System.in);
	public static MediaManager mediaMgr = new MediaManager();
	public static UserManager userMgr = new UserManager();
	public static StoreManager storeMgr = new StoreManager();
	public static Manager<Goods> goodsMgr = new Manager<>();
	public static Manager<Order> orderMgr = new Manager<>();
	public static CommentManager commentMgr = new CommentManager();
	public User user;
	public ArrayList<String> fileNames = new ArrayList<String>(); //현재 존재하는 사진 파일 제목 목록
	public HashMap<String, Media> mediaImg = new HashMap<String, Media>();
	
	private static Main main=null;
	private Main() {}
	public static Main getInstance() {
		if (main == null)
			main = new Main();
		return main;
	}
	public static void main(String[] args) {
		Main main = new Main();
		main.run();
	}
	public void run() {
		mediaMgr.readAll("data/media.txt");
		Collections.sort(mediaMgr.mList);//순서 오름차순 정렬
		Collections.reverse(mediaMgr.mList);//순서 뒤집기
		
		userMgr.readAll("data/user.txt");
		goodsMgr.readAll("data/goods.txt", new Factory<Goods>() {
			public Goods create() {
				return new Goods();
			}
		});
		orderMgr.readAll("data/order.txt", new Factory<Order>() {
			public Order create() {
				return new Order();
			}
		});
		commentMgr.readAll("data/comment.txt", new Factory<Comment>() {
			public Comment create() {
				return new Comment();
			}
		});
		runMainMenu();
		/*
		 * 관리자용 메뉴 삭제했습니다. 더이상 필요하지 않은것 같아요.
		 */
		
	}
	void login() {//로그인 메소드도 필요한가요?
		String id = null;
		String password = null;
		User user = null;
		
		while(true) {
			System.out.printf("ID: \n");
			id = scan.nextLine();
			System.out.printf("PassWord: \n");
			password = scan.nextLine();
			user = (User)userMgr.findUser(id, password);
			if(user!=null) {
				System.out.printf("로그인되었습니다.\n %s님 환영합니다.\n사용자 등급: %d\n", user.getName(), user.getLevel());
				this.user = user;
				break;
			} else {
				System.out.printf("아이디와 비밀번호가 일치하지 않습니다.\n다시 시도해주세요\n");
				continue;
			}
		}
		
	}
	void runMainMenu() {
		while(true) {
			switch(inputMenu()) {
			case 1: subMenu1(); break;
			case 2: subMenu2(); break;
			case 3: subMenu3(); break;
			}
		}
	}
	private int inputMenu() {
		int num;
		while(true) {
			System.out.println("■■■■■■■■■■■■■■■[OrangeTv]■■■■■■■■■■■■■■■");
			System.out.println("\n(1) 영상\n(2) 유저\n(3) 스토어\n");
			System.out.println("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
			System.out.println("번호입력>>");
			num=scan.nextInt();
			if(num>=1&&num<=3) //메뉴 늘릴때마다 여기 항상 수정해주세요
				return num;
			System.out.println("잘못된 번호입니다.");
		}
	}
	private void subMenu1() {
		int num;
		while (true) {
			System.out.println("▶▶▶소메뉴1 : 영상◀◀◀\n(1)영상 전체 출력\n(2)키워드 검색\n(3)카테고리별 출력\n(4)영상 이미지 목록\n");
			num=scan.nextInt();
			int count=0;
			switch(num) {
			case 0: runMainMenu();break;
			case 1: 
				System.out.printf("================= 영화 리스트 =================");
				mediaMgr.printAll();break;
			case 2: mediaMgr.search(scan);break;
			case 3: printAllCategory(); break;
			case 4: 
				File dir = new File("mediaImage");
				String[] filenames = dir.list();
				for(String file : filenames) {
					int pos = file .lastIndexOf(".");
					String _fileName = file.substring(0, pos);
					fileNames.add(_fileName);
				}
				for(String file : fileNames) {
					System.out.println(file);
					count+=1;
				}
				System.out.printf("\n%d개 검색됨.", count);
			}
		}
		
	}
	private void printAllCategory() {
		int num;
		int count=0;
		List<Manageable> list = null;
		while (true) {
			System.out.println("\n(1) 드라마\n(2) 애니메이션 \n(3) 버라이어티\n(4) 다큐멘터리시리즈\n(5) 다큐멘터리 영화\n(6) 영화 >> ");
			num=scan.nextInt();
			if(num==0) 
				runMainMenu();
			list = mediaMgr.findAll(num+"");
			System.out.printf("================= 영화 리스트 =================\n");
			for(Manageable m: list) {
				m.print(false);
				count+=1;
			}
			System.out.printf("\n%d개 검색됨.", count);
		}
		
	}
	private void subMenu2() {
		int num;
		while (true) {
			System.out.println("▶▶▶소메뉴2 : 유저◀◀◀\n(1)본인 정보 조회\n(2)유저 전체 출력\n(3)유저 검색\n");
			num=scan.nextInt();
			switch(num) {
			case 0: runMainMenu();break;
			case 1: System.out.printf("=============미구현=============\n");break;
			case 2: System.out.printf("================= 회원 리스트 =================\n");
					userMgr.printAll();break;
			case 3:userMgr.search(scan);break;
			}
		}
	}
	private void subMenu3() {
		int num;
		while (true) {
			System.out.println("▶▶▶소메뉴3 : 스토어◀◀◀\n(1)상품 전체 출력\n(2)상품 검색\n(3)전체 주문 리스트\n(4)사용자별 주문 리스트\n");
			num=scan.nextInt();
			switch(num) {
			case 0: runMainMenu();break;
			case 1: 
				System.out.printf("================= 판매 상품 리스트 =================\n");
				goodsMgr.printAll(); break;
			case 2: goodsMgr.search(scan);break;
			case 3:
				System.out.printf("================= 전체 주문 리스트 =================\n");
				orderMgr.printAll();
				break;
			case 4:
				System.out.printf("=============== 사용자별 주문 리스트 =================\n");
				userMgr.printForOrderList();
				break;
			}
		}
	}

}