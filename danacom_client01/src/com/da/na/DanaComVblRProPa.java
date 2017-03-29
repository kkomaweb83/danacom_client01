package com.da.na;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

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
	
	public DanaComVblRProPa() {
	}
	public DanaComVblRProPa(DanaComMain danaComMain, int i) {
		this.danaComMain = danaComMain;
		
		centerBodyRight6_1Pa = new JPanel();
		centerBodyRight6_1Pa.setLayout(new FlowLayout(FlowLayout.LEFT));
		centerBodyRight6_1Pa.setBorder(new EtchedBorder(EtchedBorder.LOWERED));
		ct1.setPreferredSize(new Dimension(50, 50));
		image1 = toolkit.getImage("C:/util/dana_img/0101_0"+i+"_80.jpg");
		centerBodyRight6_1Pa.add(ct1);
		
		centerBodyRight6_2Pa = new JPanel();
		centerBodyRight6_2Pa.setLayout(new BoxLayout(centerBodyRight6_2Pa, BoxLayout.Y_AXIS));
		vbb_pro_jl = new JLabel("인텔 코어i5-7세대 7600 (카비레이크)(정품) 인텔 코어i5-7세대 7600 (카비레이크)(정품)");
		vbb_pro_jl.setPreferredSize(new Dimension(330, 25));
		vbb_price_jl = new JLabel("100,500원");
		centerBodyRight6_2Pa.add(vbb_pro_jl);
		centerBodyRight6_2Pa.add(vbb_price_jl);
		
		vbb_pro_jb = new JButton("검색");
		centerBodyRight6_1Pa.add(centerBodyRight6_2Pa);
		centerBodyRight6_1Pa.add(vbb_pro_jb);
		add(centerBodyRight6_1Pa);
	}
	
	private class CanvasTest1 extends JPanel {
		@Override
		public void paint(Graphics g) {
			g.clearRect(0, 0, getWidth(), getHeight());
			g.drawImage(image1, 0, 0, 50, 50, this);
			
		}
	}
}
