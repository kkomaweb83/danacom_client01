package com.da.na;

import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;

public class DanaComVblDetailPa extends JPanel {
	DanaComMain danaComMain;
	
	JPanel vblListTopPa;
	JLabel vblListTop02Jl, vblListTop03Jl, vblListTop04Jl;
	JButton vblListTop01Jb;
	
	int vbl_no = 0;
	
	public DanaComVblDetailPa() {
	}
	
	public DanaComVblDetailPa(DanaComMain danaComMain, VirBillVo virBillVo) {
		vblListTopPa = new JPanel();
		vblListTopPa.setLayout(new FlowLayout(FlowLayout.LEFT));
		
		vbl_no = virBillVo.getVbl_no();
		vblListTop01Jb = new JButton(String.valueOf(virBillVo.getVbl_no()));
		vblListTop01Jb.setHorizontalAlignment(JLabel.CENTER);
		vblListTop01Jb.setPreferredSize(new Dimension(60, 30));
		
		vblListTop02Jl = new JLabel(virBillVo.getVbl_title());
		vblListTop02Jl.setHorizontalAlignment(JLabel.LEFT);
		vblListTop02Jl.setBorder(new EtchedBorder(EtchedBorder.LOWERED));
		vblListTop02Jl.setPreferredSize(new Dimension(590, 30));
		
		vblListTop03Jl = new JLabel(virBillVo.getVbl_date());
		vblListTop03Jl.setHorizontalAlignment(JLabel.CENTER);
		vblListTop03Jl.setBorder(new EtchedBorder(EtchedBorder.LOWERED));
		vblListTop03Jl.setPreferredSize(new Dimension(110, 30));
		
		vblListTop04Jl = new JLabel(virBillVo.getVbl_bor_answer());
		vblListTop04Jl.setHorizontalAlignment(JLabel.CENTER);
		vblListTop04Jl.setBorder(new EtchedBorder(EtchedBorder.LOWERED));
		vblListTop04Jl.setPreferredSize(new Dimension(80, 30));
		
		vblListTopPa.add(vblListTop01Jb);
		vblListTopPa.add(vblListTop02Jl);
		vblListTopPa.add(vblListTop03Jl);
		vblListTopPa.add(vblListTop04Jl);
		add(vblListTopPa);
	}

}
