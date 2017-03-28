package com.da.na;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.util.Vector;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class DanaComVbbPa extends JPanel {
	DanaComMain danaComMain;
	
	JPanel centerListPa, centerTopPa, centerBodyPa;
	JLabel centerTitleJl;
	
	JTable vbbListTable;
	JScrollPane vbbListJsp;
	DefaultTableModel vbbListModel;
	Vector vbbListRowData;
	Vector<String> vbbListColumnNames;
	
	public DanaComVbbPa() {
	}
	public DanaComVbbPa(DanaComMain danaComMain) {
		this.danaComMain = danaComMain;
		
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		// 중간 리스트 영역
		centerListPa = new JPanel();
		centerListPa.setLayout(new BoxLayout(centerListPa, BoxLayout.Y_AXIS));
		
		centerTopPa = new JPanel();
		centerTopPa.setLayout(new FlowLayout(FlowLayout.LEFT));
		centerTitleJl = new JLabel("▶ 공유 견적서");
		centerTopPa.add(centerTitleJl);
		centerListPa.add(centerTopPa);
		
		centerBodyPa = new JPanel();
		centerBodyPa.setLayout(new BorderLayout());
		
		vbbListRowData = new Vector<>(); 
		vbbListColumnNames = new Vector<>(); 
		vbbListColumnNames.add("번호");
		vbbListColumnNames.add("제목");
		vbbListColumnNames.add("글쓴이");
		vbbListColumnNames.add("날짜");
		vbbListColumnNames.add("추천수");
		vbbListColumnNames.add("조회수");
		vbbListColumnNames.add("베틀등록");
		
		vbbListModel = new DefaultTableModel();
		vbbListModel.setDataVector(vbbListRowData, vbbListColumnNames);
		
		vbbListTable = new JTable(vbbListModel);
		vbbListJsp = new JScrollPane(vbbListTable);
		
		//DefaultTableCellRenderer celAlignCenter = new DefaultTableCellRenderer();
		//celAlignCenter.setHorizontalAlignment(JLabel.CENTER);
		//DefaultTableCellRenderer celAlignRight = new DefaultTableCellRenderer();
		//celAlignRight.setHorizontalAlignment(JLabel.RIGHT);
		
		vbbListTable.getColumn("번호").setPreferredWidth(70);
		vbbListTable.getColumn("제목").setPreferredWidth(700);
		vbbListTable.getColumn("글쓴이").setPreferredWidth(100);
		vbbListTable.getColumn("날짜").setPreferredWidth(100);
		vbbListTable.getColumn("추천수").setPreferredWidth(80);
		vbbListTable.getColumn("조회수").setPreferredWidth(80);
		vbbListTable.getColumn("베틀등록").setPreferredWidth(100);
		
		centerBodyPa.add(vbbListJsp, BorderLayout.NORTH);
		centerListPa.add(centerBodyPa);
		
		add(centerListPa);
	}

}
