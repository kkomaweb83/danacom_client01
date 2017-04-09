package com.da.na;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;

public class DanaComVbbProPa extends JPanel {
	DanaComMain danaComMain;

	JPanel centerBodyRight6_1Pa, centerBodyRight6_2Pa;
	JLabel vbb_pro_jl, vbb_price_jl, pcl_name_jl, vbb_date_jl, vds_quantity_jl;
	
	Image image1;
	CanvasTest1 ct1 = new CanvasTest1();
	Toolkit toolkit = getToolkit();
	
	VbsVo vbsVo_r;
	
	public DanaComVbbProPa() {
	}
	public DanaComVbbProPa(DanaComMain danaComMain, VbsVo vbsVo) {
		this.danaComMain = danaComMain;
		
		pcl_name_jl = new JLabel(vbsVo.getPcl_name());
		pcl_name_jl.setPreferredSize(new Dimension(80, 50));
		add(pcl_name_jl);
		
		centerBodyRight6_1Pa = new JPanel();
		centerBodyRight6_1Pa.setLayout(new FlowLayout(FlowLayout.LEFT));
		centerBodyRight6_1Pa.setBorder(new EtchedBorder(EtchedBorder.LOWERED));
		ct1.setPreferredSize(new Dimension(80, 70));
		URL imageURL = getClass().getClassLoader().getResource("dana_img/"+vbsVo.getPmg_file());
		image1 = toolkit.getImage(imageURL);
		centerBodyRight6_1Pa.add(ct1);
		
		centerBodyRight6_2Pa = new JPanel();
		centerBodyRight6_2Pa.setLayout(new BoxLayout(centerBodyRight6_2Pa, BoxLayout.Y_AXIS));
		vbb_pro_jl = new JLabel(vbsVo.getPro_name());
		vbb_pro_jl.setPreferredSize(new Dimension(500, 25));
		vbb_date_jl = new JLabel("  등록일 : " + vbsVo.getPro_regdate());
		centerBodyRight6_2Pa.add(vbb_pro_jl);
		centerBodyRight6_2Pa.add(new JLabel(" "));
		centerBodyRight6_2Pa.add(vbb_date_jl);
		
		centerBodyRight6_1Pa.add(centerBodyRight6_2Pa);
		add(centerBodyRight6_1Pa);
		
		vds_quantity_jl = new JLabel("  " + vbsVo.getVds_quantity() + "개");
		vds_quantity_jl.setPreferredSize(new Dimension(50, 50));
		add(vds_quantity_jl);
		vbb_price_jl = new JLabel(vbsVo.getPro_disprice());
		vbb_price_jl.setPreferredSize(new Dimension(100, 50));
		add(vbb_price_jl);
		
		this.vbsVo_r = vbsVo;
	}
	
	private class CanvasTest1 extends JPanel {
		@Override
		public void paint(Graphics g) {
			g.clearRect(0, 0, getWidth(), getHeight());
			g.drawImage(image1, 0, 0, 80, 70, this);
			
		}
	}
}
