package gui;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import facade.DataEngineInterface;
import facade.UIData;
import gui.SideMenuLeftPane.MyActionListener;
import main.Main;
import media.Media;

public class TableController implements ListSelectionListener {
    DefaultTableModel tableModel;
    JTable table;
    int selectedIndex = -1;
    int subtotal = 0; // 소계값 = 굿즈가격 * 수량
    DataEngineInterface dataMgr;
    @SuppressWarnings("serial")
	void init(DataEngineInterface mgr) {
    	dataMgr = mgr;
    	tableModel = new DefaultTableModel(mgr.getColumnNames(), 0){  //셀 수정 못하게 하는 부분
    		 public boolean isCellEditable(int row, int column){
    			    return false;
    		 }
    	};
    	loadData("");
    	
    	table = new JTable(tableModel);
        ListSelectionModel rowSM = table.getSelectionModel();
        rowSM.addListSelectionListener(this);
        table.setPreferredScrollableViewportSize(new Dimension(500, 220));
        table.setFillsViewportHeight(true);
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); 
        tableClick();
    }
    void tableClick() {
    	table.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				// 순위에 있는 테이블 클릭시 해당 영상 mediainfo로 이동
				if(table.getColumnCount()>=7) {
					int row = table.getSelectedRow();
					Media media = null;
					media = Main.mediaMgr.find((String) table.getModel().getValueAt(row,0));
					MainMenu.mainRank.setVisible(false);
					MainMenu.mainSearch.setVisible(false);
					MainMenu.mainMedia.clickEvent(e, media);
				}			 
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
    		
    	});
    }
    // 매니저에서 검색된 객체들을 테이블에 보여준다. kwd가 ""면 모두 출력
    void loadData(String kwd) {
    	List<?> result = dataMgr.search(kwd);
    	tableModel.setRowCount(0);
    	for (Object m : result)
    		tableModel.addRow(((UIData)m).getUiTexts());
    }
    void addRow(String[] editTexts) {  // 행 추가, 새로운 객체 생성해서 엔진에서 추가
		try {
			dataMgr.addNewItem(editTexts);
		} catch (Exception ex) {  // 추가 중 오류 발생
			ex.printStackTrace();
			JOptionPane.showMessageDialog(null, "추가 데이터 오류");
			return;
		}
		tableModel.addRow(editTexts);
    }
    // 현재 선택된 행을 SongMgr에서 삭제하고 테이블에서 삭제
    void removeRow() {
    	if (selectedIndex < 0) return;
    	String key = (String)tableModel.getValueAt(selectedIndex, 0);
    	dataMgr.remove(key);
    	tableModel.removeRow(selectedIndex);
    }
    // 현재 선택된 행을 편집창의 내용으로 수정
    void updateRow(String[] editTexts) {
    	if (selectedIndex < 0) return;
		try {
			dataMgr.update(editTexts);
    	} catch (Exception ex) {  // SongMgr에서 수정 중 오류 발생
			ex.printStackTrace();  
			JOptionPane.showMessageDialog(null, "수정 중 데이터 오류");
    		return;
    	}
    	for (int i = 0; i < editTexts.length; i++) {
    		tableModel.setValueAt(editTexts[i], selectedIndex, i);
    	}
    }
    // 선택된 행이 변경되면 그 내용을 편집창으로 보냄
    public void valueChanged(ListSelectionEvent e) {
        ListSelectionModel lsm = (ListSelectionModel)e.getSource();
        if (!lsm.isSelectionEmpty()) {
        	selectedIndex = lsm.getMinSelectionIndex();
        	String[] rowTexts = new String[tableModel.getColumnCount()];
        	for (int i = 0; i < rowTexts.length; i++)
        		rowTexts[i] = (String)tableModel.getValueAt(selectedIndex, i);
        	//if(dataMgr instanceof store.GoodsManager)
        		//MainStore.bottom.moveSelectedToEdits(rowTexts);
        }
    }
    
    //subtotal 리턴하는 메소드
    public int getSubtotal() {
    	// 선택된 행의 소계값(굿즈 가격 * 수량)을 추출	
    	int row = table.getSelectedRow();
		subtotal = Integer.parseInt((String) table.getModel().getValueAt(row, 3));
    	return subtotal;
    }
}
