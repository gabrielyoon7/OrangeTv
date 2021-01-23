package store;

import java.util.ArrayList;
import java.util.Scanner;

import main.Main;
import manage.Manageable;
import manage.Manager;
import manage.Factory;
import user.User;

public class StoreManager extends Manager{
	public ArrayList<String> goodsNames = new ArrayList<String>();
    public ArrayList<String> goodsNumbers = new ArrayList<String>();
    
	private static StoreManager mgr = null;
	public static StoreManager getInstance() {
		if (mgr == null)
			mgr = new StoreManager();
		return mgr;
	}
	private String[] headers = {"name", "code", "price"};
	public String[] getColumnNames() {
		return headers;
	}
/*
	public void run() {

		System.out.printf("================= 판매 상품 리스트 =================\n");
		goodsMgr.printAll();
		System.out.printf("================= 전체 주문 리스트 =================\n");
		orderMgr.printAll();
		System.out.printf("=============== 사용자별 주문 리스트 =================\n");
		Main.userMgr.printAll();
	}*/
}
