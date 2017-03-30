package com.da.na;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;

public class DanaComVblInsertPa extends JPanel {
	DanaComMain danaComMain;
	
	JPanel centerListPa, centerTopPa, centerTitPa, centerBodyPa;
	JPanel centerBodyRightPa, centerBodyLeftPa; 
	JPanel centerBodyRight1Pa, centerBodyRight2Pa, centerBodyRight3Pa, centerBodyRight4Pa, centerBodyRight5Pa, centerBodyRight6Pa, centerBodyRight7Pa;
	JPanel centerBodyLeft1Pa, centerBodyLeft2Pa;
	DanaComVblRProPa[] centerBodyRight6_1Pa;
	DanaComVblRProPclPa[] centerBodyLeft2_1Pa;
	JComboBox<String> vbb_maker_jcmb;
	JTextField vbb_maker_jt;
	JButton vbb_maker_jb;
	JComboBox<String>[] vbb_pcl_jcmb;
	JPanel vbbProListPa;
	JScrollPane vbbProListJsp, vbbPclListJsp;
	JLabel centerTitleJl, centerTitleJl2;
	JLabel centerBodyRi01Jl, centerBodyLe01Jl;
	JButton vbbCreateJb;
	JTextField vbl_title_jt;
	
	Image image1, image2;
	CanvasTest1 ct1 = new CanvasTest1();
	CanvasTest2 ct2 = new CanvasTest2();
	Toolkit toolkit = getToolkit();
	
	public DanaComVblInsertPa() {
	}
	public DanaComVblInsertPa(DanaComMain danaComMain) {
		this.danaComMain = danaComMain;
		
		setLayout(new BorderLayout());
		
		// 상단
		centerListPa = new JPanel();
		centerListPa.setLayout(new BoxLayout(centerListPa, BoxLayout.Y_AXIS));
		
		centerTopPa = new JPanel();
		centerTopPa.setLayout(new FlowLayout(FlowLayout.LEFT));
		centerTitleJl = new JLabel("▶ 회원 견적서 등록");
		centerTitleJl.setPreferredSize(new Dimension(950, 25));
		vbbCreateJb = new JButton("등록");
		centerTopPa.add(centerTitleJl);
		centerTopPa.add(vbbCreateJb);
		centerListPa.add(centerTopPa);
		
		centerTitPa = new JPanel();
		centerTitPa.setLayout(new FlowLayout(FlowLayout.LEFT));
		centerTitleJl2 = new JLabel("견적서 제목");
		vbl_title_jt = new JTextField();
		vbl_title_jt.setPreferredSize(new Dimension(800, 25));
		centerTitPa.add(centerTitleJl2);
		centerTitPa.add(vbl_title_jt);
		centerListPa.add(centerTitPa);
		
		// 중앙 견적서 영역  ###################################
		centerBodyPa = new JPanel();
		//centerBodyPa.setLayout(new GridLayout(1, 1));
		
		// 왼쪽 검색영역
		centerBodyRightPa = new JPanel();
		centerBodyRightPa.setLayout(new BoxLayout(centerBodyRightPa, BoxLayout.Y_AXIS));
		centerBodyRightPa.setBorder(new EtchedBorder(EtchedBorder.LOWERED));
		centerBodyRightPa.setPreferredSize(new Dimension(500, 700));
		
		centerBodyRight1Pa = new JPanel();
		centerBodyRight1Pa.setLayout(new FlowLayout(FlowLayout.LEFT));
		centerBodyRight1Pa.setBorder(new EtchedBorder(EtchedBorder.LOWERED));
		centerBodyRi01Jl = new JLabel("CPU");
		centerBodyRight1Pa.add(centerBodyRi01Jl);
		
		centerBodyRight2Pa = new JPanel();
		centerBodyRight2Pa.setLayout(new FlowLayout(FlowLayout.LEFT));
		centerBodyRight2Pa.setBorder(new EtchedBorder(EtchedBorder.LOWERED));
		String[] items = {"-- 제조사 --","인텔","AMD"};
		vbb_maker_jcmb = new JComboBox<>(items);
		vbb_maker_jt = new JTextField();
		vbb_maker_jt.setPreferredSize(new Dimension(250, 25));
		vbb_maker_jb = new JButton("검색");
		centerBodyRight2Pa.add(vbb_maker_jcmb);
		centerBodyRight2Pa.add(vbb_maker_jt);
		centerBodyRight2Pa.add(vbb_maker_jb);
		
		centerBodyRight3Pa = new JPanel();
		centerBodyRight3Pa.setLayout(new FlowLayout(FlowLayout.LEFT));
		centerBodyRight3Pa.setBorder(new EtchedBorder(EtchedBorder.LOWERED));
		vbb_pcl_jcmb = new JComboBox[3];
		for(int i = 0; i < vbb_pcl_jcmb.length; i++){
			vbb_pcl_jcmb[i] = new JComboBox<>(items);
			centerBodyRight3Pa.add(vbb_pcl_jcmb[i]);
		}
		
		centerBodyRight4Pa = new JPanel();
		centerBodyRight4Pa.setLayout(new FlowLayout(FlowLayout.RIGHT));
		centerBodyRight4Pa.setBorder(new EtchedBorder(EtchedBorder.LOWERED));
		centerBodyRight4Pa.add(new JLabel("인기상품순 | 신상품순 | 낮은가격순 | 높은가격순"));
		
		centerBodyRight5Pa = new JPanel();
		centerBodyRight5Pa.setLayout(new FlowLayout(FlowLayout.LEFT));
		centerBodyRight5Pa.setBorder(new EtchedBorder(EtchedBorder.LOWERED));
		centerBodyRight5Pa.add(new JLabel("상품 리스트 총(5)개 상품"));
		
		centerBodyRight6Pa = new JPanel();
		centerBodyRight6Pa.setPreferredSize(new Dimension(480, (85*2 > 500?85*10:500)));
		vbbProListJsp = new JScrollPane(centerBodyRight6Pa, 
				ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, 
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		
		centerBodyRight6_1Pa = new DanaComVblRProPa[2];
		for(int i = 0; i < centerBodyRight6_1Pa.length; i++){
			centerBodyRight6_1Pa[i] = new DanaComVblRProPa(danaComMain, (i+1));
			centerBodyRight6Pa.add(centerBodyRight6_1Pa[i]);
		}

		centerBodyRight7Pa = new JPanel();
		centerBodyRight7Pa.setLayout(new FlowLayout(FlowLayout.LEFT));
		centerBodyRight7Pa.setBorder(new EtchedBorder(EtchedBorder.LOWERED));
		centerBodyRight7Pa.add(new JLabel("1 | 2 | 3"));
		
		centerBodyRightPa.add(centerBodyRight1Pa);
		centerBodyRightPa.add(centerBodyRight2Pa);
		centerBodyRightPa.add(centerBodyRight3Pa);
		centerBodyRightPa.add(centerBodyRight4Pa);
		centerBodyRightPa.add(centerBodyRight5Pa);
		centerBodyRightPa.add(vbbProListJsp);
		centerBodyRightPa.add(centerBodyRight7Pa);
		
		// 오른쪽 상품분류 영역
		centerBodyLeftPa = new JPanel();
		centerBodyLeftPa.setLayout(new BoxLayout(centerBodyLeftPa, BoxLayout.Y_AXIS));
		centerBodyLeftPa.setBorder(new EtchedBorder(EtchedBorder.LOWERED));
		centerBodyLeftPa.setPreferredSize(new Dimension(500, 700));
		
		centerBodyLeft1Pa = new JPanel();
		centerBodyLeft1Pa.setLayout(new FlowLayout(FlowLayout.LEFT));
		centerBodyLeft1Pa.setBorder(new EtchedBorder(EtchedBorder.LOWERED));
		centerBodyLe01Jl = new JLabel("총합");
		centerBodyLeft1Pa.add(centerBodyLe01Jl);
		
		centerBodyLeft2Pa = new JPanel();
		centerBodyLeft2Pa.setPreferredSize(new Dimension(480, (85*2 > 670?85*10:670)));
		vbbPclListJsp = new JScrollPane(centerBodyLeft2Pa, 
				ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, 
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		
		centerBodyLeft2_1Pa = new DanaComVblRProPclPa[5];
		for(int i = 0; i < centerBodyLeft2_1Pa.length; i++){
			centerBodyLeft2_1Pa[i] = new DanaComVblRProPclPa(danaComMain, (i+1));
			centerBodyLeft2Pa.add(centerBodyLeft2_1Pa[i]);
		}
		
		centerBodyLeftPa.add(centerBodyLeft1Pa);
		centerBodyLeftPa.add(vbbPclListJsp);
		
		centerBodyPa.add(centerBodyRightPa);
		centerBodyPa.add(centerBodyLeftPa);
		// 중앙 견적서 영역  ###################################

		add(centerListPa, BorderLayout.NORTH);
		add(centerBodyPa, BorderLayout.CENTER);
	}
	
	private class CanvasTest1 extends JPanel {
		@Override
		public void paint(Graphics g) {
			g.clearRect(0, 0, getWidth(), getHeight());
			g.drawImage(image1, 0, 0, 50, 50, this);
			
		}
	}
	
	private class CanvasTest2 extends JPanel {
		@Override
		public void paint(Graphics g) {
			g.clearRect(0, 0, getWidth(), getHeight());
			g.drawImage(image2, 0, 0, 50, 50, this);
			
		}
	}

}
