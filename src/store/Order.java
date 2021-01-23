package store;

import java.util.ArrayList;
import java.util.Scanner;

import facade.UIData;
import main.Main;
import manage.Manageable;
import store.Order.OrderedItem;
import user.User;

public class Order implements Manageable, UIData{
	ArrayList<OrderedItem>orderedItemList = new ArrayList<>();
	int orderId;
	User user;
	String date;
	int point;
	@Override
	public void read(Scanner scan) {
		String code = null;
		Goods goods = null;
		String name;
		
		orderId = scan.nextInt();
		name = scan.next();
		user = (User)Main.userMgr.find(name);
		date = scan.next();

		while(true) {
			code = scan.next();
			if(code.contentEquals("0"))
				break;
			goods = (Goods)Main.goodsMgr.find(code);
			if(goods == null) {
				System.out.println("해당 코드 상품 없음: "+ code);
				continue;
			}
			orderedItemList.add(new OrderedItem(goods,scan));
		}
		user.addOrder(this);
		point=0;
		for (OrderedItem od: orderedItemList) {
			point += (od.subtotal())/1000;
		}
	}
	
	class OrderedItem implements UIData, Manageable {
		Goods goods;
		int howMany;
		
		OrderedItem(Goods goods,Scanner scan){
			this.goods = goods;
			this.howMany = scan.nextInt();
			subtotal();
		}
		
		void print() {
			System.out.printf("[%s] %d원 x %d개 = %d원\n", goods.name, goods.price,howMany, goods.price*howMany );
		}
		
		int subtotal() {	
			return  goods.price * howMany;
			 
		}

		@Override
		public void set(Object[] uitexts) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public String[] getUiTexts() {
			String[] texts = new String[4];
			//texts[0] = ""+orderId;
			//texts[1] = user.getId();
			texts[0] = goods.name;
			texts[1] = goods.price+"";
			texts[2] = ""+howMany;
			texts[3] = ""+subtotal();
			return texts;
		}

		@Override
		public void read(Scanner scan) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void print(boolean check) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public boolean matches(String kwd) {
			// TODO Auto-generated method stub
			return true;
		}

		@Override
		public boolean matches(String[] kwdArr) {
			// TODO Auto-generated method stub
			return false;
		}
	}
	
	
	
	@Override
	public void print(boolean check) {
		if(!check) {
			System.out.printf("[주문아이디:%2d] 사용자: %s",orderId, user.getId());
		}
		else {
			System.out.printf("[주문아이디:%2d] 사용자: %s - 포인트: %d점",orderId, user.getId(), point);
			System.out.println();
			for(OrderedItem od: orderedItemList) {
				System.out.printf("\t");
				od.print();
			}
		}
	}
	@Override
	public boolean matches(String kwd) {
		if(kwd.contentEquals(""+orderId))
			return true;
		if(user.matches(kwd))
			return true;
		return false;
	}
	@Override
	public boolean matches(String[] kwdArr) {
		for(String kwd: kwdArr) {
			if(!matches(kwd))
				return false;
		}
		return true;
	}

	public int getPoint() {
		return point;
	}
	@Override
	public void set(Object[] uitexts) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public String[] getUiTexts() {
		String[] texts = new String[5];
		texts[0] = ""+orderId;
		texts[1] = user.getId();
		texts[2] = date;
		texts[3] = "O";
		//if (!payed) texts[3] = "X";
		texts[4] = ""+point;
		return texts;
	}
}
