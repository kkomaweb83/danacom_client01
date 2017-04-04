package com.da.na;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;

public class DanaComVblRProPa extends JPanel {
	DanaComMain danaComMain;

	JPanel centerBodyRight6_1Pa, centerBodyRight6_2Pa;
	JLabel vbb_pro_jl, vbb_price_jl;
	JButton vbb_pro_jb;
	
	Image image1;
	CanvasTest1 ct1 = new CanvasTest1();
	Toolkit toolkit = getToolkit();
	
	String pro_pcl_no = "";
	int pro_disprice = 0;
	String pro_ch2_price = "";
	String ppt_pro_name = "";
	int pro_no = 0;
	ProductVo proVo_r;
	
	public DanaComVblRProPa() {
	}
	public DanaComVblRProPa(DanaComMain danaComMain, ProductVo proVo, DanaComVblRProPclPa[] centerBodyLeft2_1Pa) {
		this.danaComMain = danaComMain;
		
		centerBodyRight6_1Pa = new JPanel();
		centerBodyRight6_1Pa.setLayout(new FlowLayout(FlowLayout.LEFT));
		centerBodyRight6_1Pa.setBorder(new EtchedBorder(EtchedBorder.LOWERED));
		ct1.setPreferredSize(new Dimension(50, 50));
		image1 = toolkit.getImage("C:/util/dana_img/"+proVo.getPmg_file());
		centerBodyRight6_1Pa.add(ct1);
		
		centerBodyRight6_2Pa = new JPanel();
		centerBodyRight6_2Pa.setLayout(new BoxLayout(centerBodyRight6_2Pa, BoxLayout.Y_AXIS));
		vbb_pro_jl = new JLabel(proVo.getPpt_pro_name());
		vbb_pro_jl.setPreferredSize(new Dimension(330, 25));
		vbb_price_jl = new JLabel(proVo.getPro_ch_price());
		centerBodyRight6_2Pa.add(vbb_pro_jl);
		centerBodyRight6_2Pa.add(vbb_price_jl);
		
		vbb_pro_jb = new JButton("선택");
		centerBodyRight6_1Pa.add(centerBodyRight6_2Pa);
		centerBodyRight6_1Pa.add(vbb_pro_jb);
		add(centerBodyRight6_1Pa);
		
		pro_pcl_no = proVo.getPro_pcl_no();
		pro_disprice = proVo.getPro_disprice();
		pro_ch2_price = proVo.getPro_ch_price();
		ppt_pro_name = proVo.getPpt_pro_name();
		pro_no = proVo.getPro_no();
		this.proVo_r = proVo;
		
		vbb_pro_jb.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				for(int i = 0; i < centerBodyLeft2_1Pa.length; i++){
					if(pro_pcl_no.equals(centerBodyLeft2_1Pa[i].pcl_no)){
						centerBodyLeft2_1Pa[i].setPclPro(proVo_r);
					}
				}
			}
		});
	}
	
	private class CanvasTest1 extends JPanel {
		@Override
		public void paint(Graphics g) {
			g.clearRect(0, 0, getWidth(), getHeight());
			g.drawImage(image1, 0, 0, 50, 50, this);
			
		}
	}
}
