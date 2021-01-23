package user;

import java.util.ArrayList;
import java.util.Scanner;

import facade.UIData;
import main.Main;
import manage.Manageable;
import media.Movie;
import store.Order;
//goodsCart는 goods데이터 확보가 충분히 된 이후에 활성화
public class User implements Manageable,UIData{
	int num;
	String name;
	String id;
	String password;
	int year;
	int month;
	int day;
	String phoneNumber;
	String cardNumber;
	String gender;
	public ArrayList<String> genreList = new ArrayList<>();
	int level;
	public int point;
	public Boolean premium;//교수님 피드백 참고
	public ArrayList<String> mediaCart = new ArrayList<>();
//	ArrayList<Manageable> goodsCart = new ArrayList<>();
	ArrayList<Order> orderList = new ArrayList<>();
	@Override
	public void read(Scanner scan) {
		String code; //premium 읽는 용도
		num=scan.nextInt();
		name=scan.next();
		id=scan.next();
		password=scan.next();
		year=scan.nextInt();
		month=scan.nextInt();
		day=scan.nextInt();
		phoneNumber=scan.next();
		cardNumber=scan.next();
		gender=scan.next();
		while(true) {
			String genre = null;
			genre = scan.next();
			if(genre.equals("0")) {
				break;
			}
			genreList.add(genre);
		}
		level=scan.nextInt();
		point=scan.nextInt();
		code=scan.next(); //premium 읽는 용도
		premium=code.contentEquals("O");
		
		while(true) {
			String num = null;
			num = scan.next();
			if(num.contentEquals("0")) {
				break;
			}
			mediaCart.add(num);
		}
/*		while(true) {
			String num = null;
			num = scan.next();
			if(num.contentEquals("0")) {
				break;
			}
			Manageable goods = Main.goodsMgr.find(num);
			goodsCart.add(goods);
		}*/
	}

	@Override
	public void print(boolean check) {
		if(!check) {
			System.out.printf("\n■■■고유번호 : %d / 이름 : %s■■■\n",num,name);
			System.out.printf("\n구매 상품 이력: ");
			for(Manageable goods:orderList)
				goods.print(true);
		}else {
			String code;
			if (premium==true)
				code="O";
			else
				code="X";
			System.out.printf("\n■■■■■■고유번호 : %d■■■■■■\n이름 : %s / 아이디 : %s / 비밀번호 : %s\n"
					+ "생년월일 : %d-%d-%d / 전화번호 : %s / 카드번호 : %s / 성별 : %s",
					num, name, id, password, year, month, day, phoneNumber, cardNumber, gender);
			System.out.printf("\n선호하는 장르 : ");
			for(String genre:genreList)
				System.out.printf("%s ",genre);
			System.out.printf("\n레벨 : %d / 포인트 : %d / 월정액여부 : %s", level, point, code);
			System.out.printf("\n               [찜한 영상]");
			for(String media:mediaCart)
				System.out.println(media);
		/*	System.out.printf("\n찜한 상품 : ");
			for(Manageable goods:goodsCart)
				goods.print(true);
			System.out.println("\n");*/
			System.out.printf("\n구매 상품 이력: ");
			for(Manageable goods:orderList)
				goods.print(true);

		}
	}

	@Override
	public boolean matches(String kwd) {
		if (kwd.length() == 0)
			return true;
		if(kwd.equals(""+num))
			return true;
		if(name.contains(kwd))
			return true;
		if(kwd.equals(""+year))
			return true;
		if(kwd.equals(gender))
			return true;
		if(kwd.equals(id))
			return true;
		if(kwd.equals(password))
			return true;
		return false;
	}

	@Override
	public boolean matches(String[] kwdArr) {
		for (String kwd : kwdArr) {
			if(!matches(kwd))
				return false;
		}
		return true;
	}

	public void addOrder(Order order) {
		orderList.add(order);
		point += order.getPoint();
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public int getLevel() {
		return level;
	}

	public int getnum() {
		return num;
	}
	public String getBirthday() {
		return year+"-"+month+"-"+day+"";
	}
	public String getGender() {
		return gender;
	}
	public String getGenre() {
		String genre = "";
		for(String g : genreList) {
			genre+=g+" ";
		}
		return genre;
	}
	public String getPoint() {
		return ""+point;
	}
	public String getPremium() {
		if(premium == true) {
			return "O";
		} else {
			return "X";
		}
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public String getCardNumber() {
		return cardNumber;
	}
	
	public void setPoint(int point) {
		this.point = point;
	}

	@Override
	public void set(Object[] uitexts) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String[] getUiTexts() {
		String genreString = "";
		for (String genre : genreList)
			genreString+=genre+" ";

		String text[] = new String[3];
		text[0] = name;
		text[1] = level+"";
		text[2] = genreString;
		return text;
	}
}
