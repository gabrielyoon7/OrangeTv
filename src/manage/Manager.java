package manage;


import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import manage.Factory;
import manage.Manageable;

public class Manager<T extends Manageable> {
	public ArrayList<T> mList = new ArrayList<>();
	public T find(String kwd) {
	    for (T m: mList)
	    	if (m.matches(kwd))
	    		return m;
	    return null;
	}
	public void readAll(String filename) {
		Scanner filein = openFile(filename);
		T m = null;
		while (filein.hasNext()) {
			m.read(filein);
			mList.add(m);
		}
		filein.close();
	}
	public void readAll(String filename, Factory<T> fac) {
		Scanner filein = openFile(filename);
		T m = null;
		while (filein.hasNext()) {
			m = fac.create();
			m.read(filein);
			mList.add(m);
		}
		filein.close();
	}

	public void printAll() {
		for (T m : mList) {
			m.print(true);
		}
	}
	public void search(Scanner keyScanner) {
		String kwd = null;
		String[] kwdArr;
		keyScanner.nextLine();
		while (true) {
			System.out.print("\n>> ");
			kwd = keyScanner.nextLine();
			if (kwd.equals("end"))
				break;
			kwdArr=kwd.split(" ");
			for (T m : mList) {
				if (m.matches(kwdArr))
					m.print(true);
			}
		}
	}
	public List<Manageable> findAll(String kwd) {
		List<Manageable> results = new ArrayList<>();
		for (Manageable m: mList)
			if (m.matches(kwd))
				results.add(m);
		return results;
	}
	public Scanner openFile(String filename) {
		Scanner filein = null;
		try {
			filein = new Scanner(new File(filename)); // 한글 입력시 파일 읽기 오류 방지
		} catch (Exception e) {
			System.out.println(filename + ": 파일 없음");
			System.exit(0);
		}
		return filein;
	}
	

}
