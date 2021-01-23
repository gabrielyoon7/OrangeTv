package media;

import java.util.List;
import java.util.Scanner;

import facade.DataEngineInterface;
import main.Main;
import manage.Factory;
import manage.Manageable;
import manage.Manager;

public class CommentManager extends Manager implements Factory, DataEngineInterface{
	private static CommentManager mgr=null;
	//public MediaManager() {}
	public static CommentManager getInstance() {
		if (mgr == null)
			mgr = Main.commentMgr;
		return mgr;
	}
	private String[] headers = {"영상 제목","작성자", "내용", "별점"};
	public String[] getColumnNames() {
		return headers;
	}
	@Override
	public Manageable find(String kwd) {
		return super.find(kwd);
	}
	@Override
	public List findAll(String kwd) {
		return super.findAll(kwd);
	}
	@Override
	public void printAll() {
		super.printAll();
	}

	@Override
	public void search(Scanner keyScanner) {
		super.search(keyScanner);
	}

	@Override
	public Scanner openFile(String filename) {
		return super.openFile(filename);
	}

	
	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 3;
	}

	

	@Override
	public List<Manageable> search(String kwd) {
		return Main.commentMgr.findAll(kwd);
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
