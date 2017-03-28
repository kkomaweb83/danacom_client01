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

public class DanaComVbjPa extends JPanel {
	DanaComMain danaComMain;
	
	JPanel centerListPa, centerTopPa, centerBodyPa;
	JLabel centerTitleJl;
	
	JTable vbbListTable;
	JScrollPane vbbListJsp;
	DefaultTableModel vbbListModel;
	Vector vbbListRowData;
	Vector<String> vbbListColumnNames;
	
	public DanaComVbjPa() {
	}
	public DanaComVbjPa(DanaComMain danaComMain) {
		this.danaComMain = danaComMain;
		
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		// 중간 리스트 영역
		centerListPa = new JPanel();
		centerListPa.setLayout(new BoxLayout(centerListPa, BoxLayout.Y_AXIS));
		
		centerTopPa = new JPanel();
		centerTopPa.setLayout(new FlowLayout(FlowLayout.LEFT));
		centerTitleJl = new JLabel("▶ 베틀 견적서");
		centerTopPa.add(centerTitleJl);
		centerListPa.add(centerTopPa);
		
		centerBodyPa = new JPanel();
		centerBodyPa.setLayout(new BorderLayout());
		
		vbbListRowData = new Vector<>(); 
		vbbListColumnNames = new Vector<>(); 
		vbbListColumnNames.add("베틀번호");
		vbbListColumnNames.add("베틀명");
		vbbListColumnNames.add("베틀시작일");
		vbbListColumnNames.add("베틀마감일");
		
		vbbListModel = new DefaultTableModel();
		vbbListModel.setDataVector(vbbListRowData, vbbListColumnNames);
		
		vbbListTable = new JTable(vbbListModel);
		vbbListJsp = new JScrollPane(vbbListTable);
		
		vbbListTable.getColumn("베틀번호").setPreferredWidth(70);
		vbbListTable.getColumn("베틀명").setPreferredWidth(700);
		vbbListTable.getColumn("베틀시작일").setPreferredWidth(100);
		vbbListTable.getColumn("베틀마감일").setPreferredWidth(100);
		
		centerBodyPa.add(vbbListJsp, BorderLayout.NORTH);
		centerListPa.add(centerBodyPa);
		
		add(centerListPa);
	}

}
