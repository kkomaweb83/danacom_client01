package com.da.na;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
	JPanel centerBodyRight6_21Pa, centerBodyRight6_22Pa, centerBodyRight6_23Pa;
	JLabel vbb_pro_jl, vbb_pro_name_jl, vbb_price_jl;
	JButton vbb_pro_jb, vbb_pcl_jb;
	JSpinner grade_sp;
	SpinnerNumberModel numModel;
	String pcl_no = ""; 
	String pcl_name = "";
	ProductVo proVo_m = null;
	
	public DanaComVblRProPclPa() {
	}

	public DanaComVblRProPclPa(DanaComMain danaComMain, ProClassVo proClassVo, String mode) {
		this.danaComMain = danaComMain;
		
		centerBodyRight6_1Pa = new JPanel();
		centerBodyRight6_1Pa.setLayout(new FlowLayout(FlowLayout.LEFT));
		centerBodyRight6_1Pa.setBorder(new EtchedBorder(EtchedBorder.LOWERED));
		
		centerBodyRight6_2Pa = new JPanel();
		centerBodyRight6_2Pa.setLayout(new BoxLayout(centerBodyRight6_2Pa, BoxLayout.X_AXIS));
		vbb_pcl_jb = new JButton(proClassVo.getPcl_name());
		vbb_pcl_jb.setPreferredSize(new Dimension(100, 25));
		pcl_no = proClassVo.getPcl_no();
		pcl_name = proClassVo.getPcl_name();
		
		vbb_pro_jl = new JLabel("    ☜ 항목을 클릭하세요.");
		vbb_pro_jl.setPreferredSize(new Dimension(340, 25));
		
		vbb_pro_name_jl = new JLabel("");
		vbb_pro_name_jl.setPreferredSize(new Dimension(340, 25));
		
		//스피너 넘버모델 셋팅                                                   
		grade_sp = new JSpinner();
		numModel = new SpinnerNumberModel(1, 1, 5, 1); //초기값, 최소값, 최대값, 단계
        grade_sp.setModel(numModel);
        grade_sp.setPreferredSize(new Dimension(50, 25));
		
		vbb_price_jl = new JLabel("");
		vbb_price_jl.setPreferredSize(new Dimension(100, 25));
		
		vbb_pro_jb = new JButton("삭제");
		
		centerBodyRight6_21Pa = new JPanel();
		centerBodyRight6_21Pa.setLayout(new BoxLayout(centerBodyRight6_21Pa, BoxLayout.Y_AXIS));
		
		centerBodyRight6_22Pa = new JPanel();
		centerBodyRight6_22Pa.setLayout(new BoxLayout(centerBodyRight6_22Pa, BoxLayout.X_AXIS));
		
		centerBodyRight6_23Pa = new JPanel();
		centerBodyRight6_23Pa.setLayout(new FlowLayout(FlowLayout.RIGHT));
		
		centerBodyRight6_2Pa.add(vbb_pcl_jb);
		centerBodyRight6_2Pa.add(vbb_pro_jl);
		
		centerBodyRight6_1Pa.add(centerBodyRight6_2Pa);
		add(centerBodyRight6_1Pa);
		
		vbb_pcl_jb.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				DanaComProtocol writePort = null;
				try {
					writePort = new DanaComProtocol();
					writePort.setP_cmd(3011);
					writePort.setPcl_no(pcl_no);
					
					danaComMain.connWrite(writePort);
					
				} catch (Exception e1) {
					e1.printStackTrace();
				} 
			}
		});
		
		vbb_pro_jb.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				delItem();
				
				centerBodyRight6_2Pa.add(vbb_pcl_jb);
				centerBodyRight6_2Pa.add(vbb_pro_jl);
				
				centerBodyRight6_1Pa.add(centerBodyRight6_2Pa);
				
				centerBodyRight6_1Pa.revalidate();
				centerBodyRight6_1Pa.repaint();
			}
		});
	}
	
	public void setPclPro(ProductVo proVo_r){
		delItem();
				
		vbb_pro_name_jl.setText(proVo_r.getPpt_pro_name());
		centerBodyRight6_22Pa.add(vbb_pro_name_jl);
		
		centerBodyRight6_21Pa.add(centerBodyRight6_22Pa);
		
		vbb_price_jl.setText(proVo_r.getPro_ch_price());
		
		centerBodyRight6_23Pa.add(grade_sp);
		centerBodyRight6_23Pa.add(vbb_price_jl);
		centerBodyRight6_23Pa.add(vbb_pro_jb);
		
		centerBodyRight6_21Pa.add(centerBodyRight6_23Pa);
		
		centerBodyRight6_2Pa.add(vbb_pcl_jb);
		centerBodyRight6_2Pa.add(centerBodyRight6_21Pa);
		
		centerBodyRight6_1Pa.add(centerBodyRight6_2Pa);
		
		centerBodyRight6_1Pa.revalidate();
		centerBodyRight6_1Pa.repaint();
		
		proVo_m = proVo_r;
		
	}
	
	public void delItem(){
		centerBodyRight6_2Pa.removeAll();
		centerBodyRight6_21Pa.removeAll();
		centerBodyRight6_22Pa.removeAll();
		centerBodyRight6_23Pa.removeAll();
		proVo_m = null;
	}
	
}
