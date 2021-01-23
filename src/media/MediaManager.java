package media;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import facade.DataEngineInterface;
import main.Main;
import manage.Factory;
import manage.Manageable;
import manage.Manager;

public class MediaManager extends Manager<Media> implements Factory, DataEngineInterface{
	
    public ArrayList<String> titles = new ArrayList<String>();
    public ArrayList<String> numbers = new ArrayList<String>();
    
    // 장르 리스트가 들어올 예정(개수 미정)
    public ArrayList<String> fearTitles = new ArrayList<String>();
    public ArrayList<String> thrillerTitles = new ArrayList<String>();
    public ArrayList<String> actionTitles = new ArrayList<String>();
    public ArrayList<String> comedyTitles = new ArrayList<String>();
    public ArrayList<String> sfTitles = new ArrayList<String>();
    public ArrayList<String> dramaTitles = new ArrayList<String>();
    public ArrayList<String> mysteryTitles = new ArrayList<String>();
    public ArrayList<String> meloTitles = new ArrayList<String>();
    public ArrayList<String> romanceTitles = new ArrayList<String>();
    
	//public MediaManager() {}
    private static MediaManager mgr=null;
	public static MediaManager getInstance() {
		if (mgr == null)
			mgr = Main.mediaMgr;
		return mgr;
	}
	private String[] headers = {"제목", "개봉연도", "등급", "별점", "제작국가", "장르", "조회수"};
	public String[] getColumnNames() {
		return headers;
	}
	
	int type;
	@Override
	public Media find(String kwd) {
		return super.find(kwd);
	}
	
	public void readAll(String filename) {
		Scanner filein = openFile(filename);
		Media m = null;
		while (filein.hasNext()) {
			type = filein.nextInt();
			m = create();
			m.read(filein);
			mList.add(m);
		}
		filein.close();
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
	public Media create() {
		switch(type) {
		case 1:
			return new Drama();
		case 2:
			return new Animation();
		case 3:
			return new Variety();
		case 4:
			return new DocumentarySeries();
		case 5:
			return new DocumentaryMovie();
		case 6:
			return new Movie();
		}
		return null;
	}
	
	@Override
	public List findAll(String kwd) {
		return super.findAll(kwd);
	}
	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 3;
	}
	@Override
	public List<Manageable> search(String kwd) {
		return Main.mediaMgr.findAll(kwd);
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

	/*public void genrePrintAll(String genre) {
		for(Manageable m : mList) {
			if(m.matches(genre)) {
				m.print(false);
			}
		}
	}*/
}
