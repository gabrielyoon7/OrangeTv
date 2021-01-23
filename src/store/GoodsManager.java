package store;

import java.util.ArrayList;
import java.util.List;

import facade.DataEngineInterface;
import main.Main;
import manage.Manageable;
import manage.Manager;

public class GoodsManager implements DataEngineInterface {

	private static GoodsManager mgr = null;
	private GoodsManager() {}
	public static GoodsManager getInstance() {
		if (mgr == null)
			mgr = new GoodsManager();
		return mgr;
	}
	//	상품명 가격 남은수량
	private String[] headers = {"상품명", "가격", "남은수량"};
	public String[] getColumnNames() {
		return headers;
	}
	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 4;
	}
	@Override
	public void readAll(String filename) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public List<Manageable> search(String kwd) {
		// TODO Auto-generated method stub
		return Main.goodsMgr.findAll(kwd);
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
