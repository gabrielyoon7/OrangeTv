package store;

import java.util.List;

import facade.DataEngineInterface;
import main.Main;
import manage.Manageable;
import manage.Manager;

public class OrderManager extends Manager implements DataEngineInterface  {
	private static OrderManager mgr = null;
	private OrderManager() {}
	public static OrderManager getInstance() {
		if (mgr == null)
			mgr = new OrderManager();
		return mgr;
	}
	public Order getOrder(int num) {
		return (Order)Main.orderMgr.find(num+"");
		//return (Order)Main.orderMgr.mList.get(index);
	}
	private String[] headers = {"주문번호", "고객아이디", "날짜", "결재여부", "포인트"};
	public String[] getColumnNames() {
		return headers;
	}
	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 5;
	}
	@Override
	public void readAll(String filename) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public List<Manageable> search(String kwd) {
		// TODO Auto-generated method stub
		return Main.orderMgr.findAll(kwd);
	}
	@Override
	public void addNewItem(String[] uiTexts) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void update(String[] uiTexts) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void remove(String kwd) {
		// TODO Auto-generated method stub
		
	}
}
