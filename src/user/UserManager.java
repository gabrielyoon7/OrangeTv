package user;

import java.util.List;
import java.util.Scanner;

import facade.DataEngineInterface;
import main.Main;
import manage.Factory;
import manage.Manageable;
import manage.Manager;
import media.Media;
import media.MediaManager;

public class UserManager extends Manager<User> implements Factory, DataEngineInterface{

    private static UserManager mgr=null;
	public static UserManager getInstance() {
		if (mgr == null)
			mgr = Main.userMgr;
		return mgr;
	}
	private String[] headers = {"이름","레벨","선호 하는 장르"};
	public String[] getColumnNames() {
		return headers;
	}
	
	@Override
	public User find(String kwd) {
		return super.find(kwd);
	}

	@Override
	public void readAll(String filename) {
		Scanner filein = openFile(filename);
		while (filein.hasNext()) {
			User user = new User();
			user.read(filein);
			mList.add(user);
		}
		filein.close();
	}

	@Override
	public void printAll() {
		super.printAll();
	}
	public void printForOrderList(){
		for (Manageable m : mList) {
			m.print(false);
		}
	}

	@Override
	public void search(Scanner keyScanner) {
		super.search(keyScanner);
	}

	@Override
	public Scanner openFile(String filename) {
		return super.openFile(filename);
	}
	public Manageable findUser(String id, String password) {
		for(Manageable m : mList) {
			if(m.matches(id) && m.matches(password)) {
				return m;
			}
		}
		return null;
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Manageable> search(String kwd) {
		// TODO Auto-generated method stub
		return null;
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

	@Override
	public Manageable create() {
		// TODO Auto-generated method stub
		return null;
	}
}
