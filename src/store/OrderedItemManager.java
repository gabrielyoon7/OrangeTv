package store;

import java.util.ArrayList;
import java.util.List;

import facade.DataEngineInterface;
import manage.Manageable;
import manage.Manager;
import store.Order.OrderedItem;

public class OrderedItemManager extends Manager implements DataEngineInterface {
	private static OrderedItemManager mgr = null;
	private OrderedItemManager() {}
	public static OrderedItemManager getInstance() {
		if (mgr == null)
			mgr = new OrderedItemManager();
		return mgr;
	}
	List<OrderedItem> mylist;
	public void setOrder(Order order) {
		mylist = order.orderedItemList;
	}
	private String[] headers = {"상품명", "가격", "개수", "소계"};
	public String[] getColumnNames() {
		return headers;
	}
	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void readAll(String filename) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Manageable> search(String kwd) {
		// TODO Auto-generated method stub
		List<Manageable> result = new ArrayList();
		for (OrderedItem od: mylist)
			result.add((Manageable) od);
		return result;  // mylist 리턴 안됨. <OrderedItem> -> <Manageable> 불가
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
