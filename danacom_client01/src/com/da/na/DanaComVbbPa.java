package com.da.na;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.Vector;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EtchedBorder;
import javax.swing.table.DefaultTableModel;

public class DanaComVbbPa extends JPanel {
	DanaComMain danaComMain;
	
	JPanel centerListPa, centerTopPa, centerBodyPa;
	JLabel centerTitleJl;
	
	JPanel vbbListPa, vbbListTopPa;
	JScrollPane vbbListJsp;
	JLabel vbbListTop01Jl, vbbListTop02Jl, vbbListTop03Jl, vbbListTop04Jl, vbbListTop05Jl, vbbListTop06Jl, vbbListTop07Jl;
	
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
		centerTitleJl.setPreferredSize(new Dimension(850, 25));
		centerTopPa.add(centerTitleJl);
		centerListPa.add(centerTopPa);
		
		centerBodyPa = new JPanel();
		centerBodyPa.setLayout(new FlowLayout(FlowLayout.LEFT));

		vbbListPa = new JPanel();
		vbbListPa.setLayout(new FlowLayout(FlowLayout.LEFT));
		vbbListPa.setBorder(new EtchedBorder(EtchedBorder.LOWERED));
		vbbListPa.setPreferredSize(new Dimension(950, 650));
		vbbListJsp = new JScrollPane(vbbListPa, 
				ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, 
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		
		vbbListTopPa = new JPanel();
		vbbListTopPa.setLayout(new FlowLayout(FlowLayout.LEFT));
		
		vbbListTop01Jl = new JLabel("번호");
		vbbListTop01Jl.setHorizontalAlignment(JLabel.CENTER);
		vbbListTop01Jl.setBorder(new EtchedBorder(EtchedBorder.LOWERED));
		vbbListTop01Jl.setPreferredSize(new Dimension(70, 30));
		
		vbbListTop02Jl = new JLabel("제목");
		vbbListTop02Jl.setHorizontalAlignment(JLabel.CENTER);
		vbbListTop02Jl.setBorder(new EtchedBorder(EtchedBorder.LOWERED));
		vbbListTop02Jl.setPreferredSize(new Dimension(430, 30));
		
		vbbListTop03Jl = new JLabel("글쓴이");
		vbbListTop03Jl.setHorizontalAlignment(JLabel.CENTER);
		vbbListTop03Jl.setBorder(new EtchedBorder(EtchedBorder.LOWERED));
		vbbListTop03Jl.setPreferredSize(new Dimension(80, 30));
		
		vbbListTop04Jl = new JLabel("날짜");
		vbbListTop04Jl.setHorizontalAlignment(JLabel.CENTER);
		vbbListTop04Jl.setBorder(new EtchedBorder(EtchedBorder.LOWERED));
		vbbListTop04Jl.setPreferredSize(new Dimension(90, 30));
		
		vbbListTop05Jl = new JLabel("추천수");
		vbbListTop05Jl.setHorizontalAlignment(JLabel.CENTER);
		vbbListTop05Jl.setBorder(new EtchedBorder(EtchedBorder.LOWERED));
		vbbListTop05Jl.setPreferredSize(new Dimension(70, 30));
		
		vbbListTop06Jl = new JLabel("조회수");
		vbbListTop06Jl.setHorizontalAlignment(JLabel.CENTER);
		vbbListTop06Jl.setBorder(new EtchedBorder(EtchedBorder.LOWERED));
		vbbListTop06Jl.setPreferredSize(new Dimension(70, 30));
		
		vbbListTop07Jl = new JLabel("베틀등록");
		vbbListTop07Jl.setHorizontalAlignment(JLabel.CENTER);
		vbbListTop07Jl.setBorder(new EtchedBorder(EtchedBorder.LOWERED));
		vbbListTop07Jl.setPreferredSize(new Dimension(80, 30));

		vbbListTopPa.add(vbbListTop01Jl);
		vbbListTopPa.add(vbbListTop02Jl);
		vbbListTopPa.add(vbbListTop03Jl);
		vbbListTopPa.add(vbbListTop04Jl);
		vbbListTopPa.add(vbbListTop05Jl);
		vbbListTopPa.add(vbbListTop06Jl);
		vbbListTopPa.add(vbbListTop07Jl);
		vbbListPa.add(vbbListTopPa);
		
		centerBodyPa.add(vbbListJsp, BorderLayout.NORTH);
		centerListPa.add(centerBodyPa);
		
		add(centerListPa);
	}

}
