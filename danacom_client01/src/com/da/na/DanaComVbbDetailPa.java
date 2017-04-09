package com.da.na;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;

public class DanaComVbbDetailPa extends JPanel {
	DanaComMain danaComMain;
	
	JPanel vbbListTopPa;
	JLabel vbbListTop02Jl, vbbListTop03Jl, vbbListTop04Jl, vbbListTop05Jl, vbbListTop06Jl, vbbListTop07Jl;
	JButton vbbListTop01Jb;
	
	String vbb_no = "0";
	
	public DanaComVbbDetailPa() {
	}
	
	public DanaComVbbDetailPa(DanaComMain danaComMain, VbbVo vbbVo, String mode) {
		vbbListTopPa = new JPanel();
		vbbListTopPa.setLayout(new FlowLayout(FlowLayout.LEFT));
		
		vbb_no = vbbVo.getVbb_no();
		vbbListTop01Jb = new JButton(vbb_no);
		vbbListTop01Jb.setHorizontalAlignment(JLabel.CENTER);
		vbbListTop01Jb.setPreferredSize(new Dimension(60, 30));
		
		vbbListTop02Jl = new JLabel(vbbVo.getVbb_title());
		vbbListTop02Jl.setHorizontalAlignment(JLabel.LEFT);
		vbbListTop02Jl.setBorder(new EtchedBorder(EtchedBorder.LOWERED));
		vbbListTop02Jl.setPreferredSize(new Dimension(430, 30));
		
		vbbListTop03Jl = new JLabel(vbbVo.getMem_id());
		vbbListTop03Jl.setHorizontalAlignment(JLabel.CENTER);
		vbbListTop03Jl.setBorder(new EtchedBorder(EtchedBorder.LOWERED));
		vbbListTop03Jl.setPreferredSize(new Dimension(80, 30));
		
		vbbListTop04Jl = new JLabel(vbbVo.getVbb_date());
		vbbListTop04Jl.setHorizontalAlignment(JLabel.CENTER);
		vbbListTop04Jl.setBorder(new EtchedBorder(EtchedBorder.LOWERED));
		vbbListTop04Jl.setPreferredSize(new Dimension(90, 30));
		
		vbbListTop05Jl = new JLabel(vbbVo.getVbb_recomm());
		vbbListTop05Jl.setHorizontalAlignment(JLabel.CENTER);
		vbbListTop05Jl.setBorder(new EtchedBorder(EtchedBorder.LOWERED));
		vbbListTop05Jl.setPreferredSize(new Dimension(70, 30));
		
		vbbListTop06Jl = new JLabel(vbbVo.getVbb_count());
		vbbListTop06Jl.setHorizontalAlignment(JLabel.CENTER);
		vbbListTop06Jl.setBorder(new EtchedBorder(EtchedBorder.LOWERED));
		vbbListTop06Jl.setPreferredSize(new Dimension(70, 30));
		
		vbbListTop07Jl = new JLabel(vbbVo.getVbb_btr_answer());
		vbbListTop07Jl.setHorizontalAlignment(JLabel.CENTER);
		vbbListTop07Jl.setBorder(new EtchedBorder(EtchedBorder.LOWERED));
		vbbListTop07Jl.setPreferredSize(new Dimension(80, 30));
		
		if(mode.equals("g")){
			vbbListTopPa.add(vbbListTop01Jb);
		}else{
			vbbListTop02Jl.setPreferredSize(new Dimension(490, 30));
		}
		vbbListTopPa.add(vbbListTop02Jl);
		vbbListTopPa.add(vbbListTop03Jl);
		vbbListTopPa.add(vbbListTop04Jl);
		vbbListTopPa.add(vbbListTop05Jl);
		vbbListTopPa.add(vbbListTop06Jl);
		vbbListTopPa.add(vbbListTop07Jl);
		add(vbbListTopPa);
		
		vbbListTop01Jb.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				DanaComProtocol writePort = null;
				try {
					writePort = new DanaComProtocol();
					writePort.setP_cmd(3082);
					writePort.setVbb_no(vbb_no);
					
					danaComMain.connWrite(writePort);
					
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				
				danaComMain.danaComProess.centerCardLayout.show(danaComMain.danaComProess.danaComVbsPa.getParent(), "danaComVbsPa");
			}
		});
	}

}
