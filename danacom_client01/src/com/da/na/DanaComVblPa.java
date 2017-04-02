package com.da.na;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class DanaComVblPa extends JPanel {
	DanaComMain danaComMain;
	
	JPanel centerListPa, centerTopPa, centerBodyPa;
	JLabel centerTitleJl;
	JButton vbbPreCreateJb;
	
	JTable vbbListTable;
	JScrollPane vbbListJsp;
	DefaultTableModel vbbListModel;
	Vector vbbListRowData;
	Vector<String> vbbListColumnNames;
	
	public DanaComVblPa() {
	}
	public DanaComVblPa(DanaComMain danaComMain) {
		this.danaComMain = danaComMain;
		
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		// 중간 리스트 영역
		centerListPa = new JPanel();
		centerListPa.setLayout(new BoxLayout(centerListPa, BoxLayout.Y_AXIS));
		
		centerTopPa = new JPanel();
		centerTopPa.setLayout(new FlowLayout(FlowLayout.LEFT));
		centerTitleJl = new JLabel("▶ 회원 견적서");
		centerTitleJl.setPreferredSize(new Dimension(950, 25));
		vbbPreCreateJb = new JButton("견적서등록");
		centerTopPa.add(centerTitleJl);
		centerTopPa.add(vbbPreCreateJb);
		centerListPa.add(centerTopPa);
		
		centerBodyPa = new JPanel();
		centerBodyPa.setLayout(new BorderLayout());
		
		vbbListRowData = new Vector<>(); 
		vbbListColumnNames = new Vector<>(); 
		vbbListColumnNames.add("번호");
		vbbListColumnNames.add("제목");
		vbbListColumnNames.add("날짜");
		vbbListColumnNames.add("공유여부");
		
		vbbListModel = new DefaultTableModel();
		vbbListModel.setDataVector(vbbListRowData, vbbListColumnNames);
		
		vbbListTable = new JTable(vbbListModel);
		vbbListJsp = new JScrollPane(vbbListTable);
		
		vbbListTable.getColumn("번호").setPreferredWidth(70);
		vbbListTable.getColumn("제목").setPreferredWidth(700);
		vbbListTable.getColumn("날짜").setPreferredWidth(100);
		vbbListTable.getColumn("공유여부").setPreferredWidth(100);
		
		centerBodyPa.add(vbbListJsp, BorderLayout.NORTH);
		centerListPa.add(centerBodyPa);
		
		add(centerListPa);
		
		vbbPreCreateJb.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				DanaComProtocol writePort = null;
				
				try {
					writePort = new DanaComProtocol();
					writePort.setP_cmd(3001);
					
					danaComMain.connWrite(writePort);
					
				} catch (Exception e1) {
					e1.printStackTrace();
				} 
				
				danaComMain.danaComProess.centerCardLayout.show(danaComMain.danaComProess.danaComVblInsertPa.getParent(), "danaComVblInsertPa");
			}
		});
	}

}
