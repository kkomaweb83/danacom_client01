package com.da.na;

import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.EtchedBorder;

public class DanaComVblRProPclPa extends JPanel {
	DanaComMain danaComMain;

	JPanel centerBodyRight6_1Pa, centerBodyRight6_2Pa;
	JLabel vbb_pcl_jl, vbb_pro_jl, vbb_price_jl;
	JButton vbb_pro_jb;
	JSpinner grade_sp;
	SpinnerNumberModel numModel;
	
	public DanaComVblRProPclPa() {
	}

	public DanaComVblRProPclPa(DanaComMain danaComMain, ProClassVo proClassVo, String mode) {
		this.danaComMain = danaComMain;
		
		centerBodyRight6_1Pa = new JPanel();
		centerBodyRight6_1Pa.setLayout(new FlowLayout(FlowLayout.LEFT));
		centerBodyRight6_1Pa.setBorder(new EtchedBorder(EtchedBorder.LOWERED));
		
		centerBodyRight6_2Pa = new JPanel();
		centerBodyRight6_2Pa.setLayout(new BoxLayout(centerBodyRight6_2Pa, BoxLayout.X_AXIS));
		vbb_pcl_jl = new JLabel(proClassVo.getPcl_name());
		vbb_pcl_jl.setPreferredSize(new Dimension(60, 25));
		
		if(mode.equals("update")){
			vbb_pro_jl = new JLabel("인텔 코어i5-7세대 7600 (카비레이크)(정품) 인텔 코어i5-7세대 7600 (카비레이크)(정품)");
			vbb_pro_jl.setPreferredSize(new Dimension(200, 25));
			
			//스피너 넘버모델 셋팅                                                   
			grade_sp = new JSpinner();
			numModel = new SpinnerNumberModel(1, 1, 5, 1); //초기값, 최소값, 최대값, 단계
	        grade_sp.setModel(numModel);
			
			vbb_price_jl = new JLabel("100,500원");
			vbb_price_jl.setPreferredSize(new Dimension(80, 25));
			vbb_pro_jb = new JButton("삭제");
			
			centerBodyRight6_2Pa.add(vbb_pcl_jl);
			centerBodyRight6_2Pa.add(vbb_pro_jl);
			centerBodyRight6_2Pa.add(grade_sp);
			centerBodyRight6_2Pa.add(vbb_price_jl);
			centerBodyRight6_2Pa.add(vbb_pro_jb);
		}else if(mode.equals("insert")){
			vbb_pro_jl = new JLabel("    ☜ 항목을 클릭하세요.");
			vbb_pro_jl.setPreferredSize(new Dimension(350, 25));
			
			centerBodyRight6_2Pa.add(vbb_pcl_jl);
			centerBodyRight6_2Pa.add(vbb_pro_jl);
		}
		
		centerBodyRight6_1Pa.add(centerBodyRight6_2Pa);
		add(centerBodyRight6_1Pa);
	}
	
}
