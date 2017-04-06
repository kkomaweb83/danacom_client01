package com.da.na;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EtchedBorder;

public class DanaComVbjPa extends JPanel {
	DanaComMain danaComMain;
	
	JPanel centerListPa, centerTopPa, centerBodyPa;
	JLabel centerTitleJl;
	
	JPanel vbjListPa, vbjListTopPa;
	JScrollPane vbjListJsp;
	JLabel vbjListTop01Jl, vbjListTop02Jl, vbjListTop03Jl, vbjListTop04Jl;
	
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
		centerBodyPa.setLayout(new FlowLayout(FlowLayout.LEFT));
		
		vbjListPa = new JPanel();
		vbjListPa.setLayout(new FlowLayout(FlowLayout.LEFT));
		vbjListPa.setBorder(new EtchedBorder(EtchedBorder.LOWERED));
		vbjListPa.setPreferredSize(new Dimension(890, 650));
		vbjListJsp = new JScrollPane(vbjListPa, 
				ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, 
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		
		vbjListTopPa = new JPanel();
		vbjListTopPa.setLayout(new FlowLayout(FlowLayout.LEFT));
		
		vbjListTop01Jl = new JLabel("베틀번호");
		vbjListTop01Jl.setHorizontalAlignment(JLabel.CENTER);
		vbjListTop01Jl.setBorder(new EtchedBorder(EtchedBorder.LOWERED));
		vbjListTop01Jl.setPreferredSize(new Dimension(70, 30));
		
		vbjListTop02Jl = new JLabel("베틀명");
		vbjListTop02Jl.setHorizontalAlignment(JLabel.CENTER);
		vbjListTop02Jl.setBorder(new EtchedBorder(EtchedBorder.LOWERED));
		vbjListTop02Jl.setPreferredSize(new Dimension(580, 30));
		
		vbjListTop03Jl = new JLabel("베틀시작일");
		vbjListTop03Jl.setHorizontalAlignment(JLabel.CENTER);
		vbjListTop03Jl.setBorder(new EtchedBorder(EtchedBorder.LOWERED));
		vbjListTop03Jl.setPreferredSize(new Dimension(100, 30));
		
		vbjListTop04Jl = new JLabel("베틀마감일");
		vbjListTop04Jl.setHorizontalAlignment(JLabel.CENTER);
		vbjListTop04Jl.setBorder(new EtchedBorder(EtchedBorder.LOWERED));
		vbjListTop04Jl.setPreferredSize(new Dimension(100, 30));
		
		vbjListTopPa.add(vbjListTop01Jl);
		vbjListTopPa.add(vbjListTop02Jl);
		vbjListTopPa.add(vbjListTop03Jl);
		vbjListTopPa.add(vbjListTop04Jl);
		vbjListPa.add(vbjListTopPa);
		
		centerBodyPa.add(vbjListJsp, BorderLayout.NORTH);
		centerListPa.add(centerBodyPa);
		
		add(centerListPa);
	}

}
