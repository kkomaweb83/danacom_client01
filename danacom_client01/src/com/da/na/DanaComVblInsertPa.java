package com.da.na;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EtchedBorder;

public class DanaComVblInsertPa extends JPanel {
	DanaComMain danaComMain;
	
	JPanel centerListPa, centerTopPa, centerTitPa, centerBodyPa;
	JPanel centerBodyRightPa, centerBodyLeftPa; 
	JPanel centerBodyRight1Pa, centerBodyRight2Pa, centerBodyRight3Pa, centerBodyRight4Pa
		   , centerBodyRight5Pa, centerBodyRight6Pa, centerBodyRight7Pa;
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
		
		// 왼쪽 검색영역
		centerBodyRightPa = new JPanel();
		centerBodyRightPa.setLayout(new BoxLayout(centerBodyRightPa, BoxLayout.Y_AXIS));
		centerBodyRightPa.setBorder(new EtchedBorder(EtchedBorder.LOWERED));
		centerBodyRightPa.setPreferredSize(new Dimension(500, 700));
		
		centerBodyRight1Pa = new JPanel();
		centerBodyRight1Pa.setLayout(new FlowLayout(FlowLayout.LEFT));
		centerBodyRight1Pa.setBorder(new EtchedBorder(EtchedBorder.LOWERED));
		centerBodyRi01Jl = new JLabel("");
		centerBodyRight1Pa.add(centerBodyRi01Jl);
		
		centerBodyRight2Pa = new JPanel();
		centerBodyRight2Pa.setLayout(new FlowLayout(FlowLayout.LEFT));
		centerBodyRight2Pa.setBorder(new EtchedBorder(EtchedBorder.LOWERED));
		vbb_maker_jcmb = new JComboBox<>();
		vbb_maker_jt = new JTextField();
		vbb_maker_jt.setPreferredSize(new Dimension(250, 25));
		vbb_maker_jb = new JButton("검색");
		centerBodyRight2Pa.add(vbb_maker_jcmb);
		centerBodyRight2Pa.add(vbb_maker_jt);
		centerBodyRight2Pa.add(vbb_maker_jb);
		
		centerBodyRight3Pa = new JPanel();
		centerBodyRight3Pa.setLayout(new FlowLayout(FlowLayout.LEFT));
		centerBodyRight3Pa.setBorder(new EtchedBorder(EtchedBorder.LOWERED));

		centerBodyRight4Pa = new JPanel();
		centerBodyRight4Pa.setLayout(new FlowLayout(FlowLayout.RIGHT));
		centerBodyRight4Pa.setBorder(new EtchedBorder(EtchedBorder.LOWERED));
		centerBodyRight4Pa.add(new JLabel("신상품순 | 낮은가격순 | 높은가격순"));
		
		centerBodyRight6Pa = new JPanel();
		centerBodyRight6Pa.setPreferredSize(new Dimension(480, 500));
		vbbProListJsp = new JScrollPane(centerBodyRight6Pa, 
				ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, 
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		
		centerBodyRightPa.add(centerBodyRight1Pa);
		centerBodyRightPa.add(centerBodyRight2Pa);
		centerBodyRightPa.add(centerBodyRight3Pa);
		centerBodyRightPa.add(centerBodyRight4Pa);
		centerBodyRightPa.add(vbbProListJsp);
		
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
		centerBodyLeft2Pa.setPreferredSize(new Dimension(480, 670));
		vbbPclListJsp = new JScrollPane(centerBodyLeft2Pa, 
				ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, 
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

		centerBodyLeftPa.add(centerBodyLeft1Pa);
		centerBodyLeftPa.add(vbbPclListJsp);
		
		centerBodyPa.add(centerBodyRightPa);
		centerBodyPa.add(centerBodyLeftPa);
		// 중앙 견적서 영역  ###################################

		add(centerListPa, BorderLayout.NORTH);
		add(centerBodyPa, BorderLayout.CENTER);
	}
	
	public void setPclList(DanaComProtocol readPort){
		centerBodyLeft2Pa.removeAll();
		
		List<ProClassVo> class_list = readPort.getClass_list();
		
		int totSize = class_list.size();
		for (int i = 0; i < class_list.size(); i++) {
			totSize += ((class_list.get(i)).getPcl_list()).size();
		}
		centerBodyLeft2Pa.setPreferredSize(new Dimension(480, (85*totSize > 670?85*totSize:670)));
		
		for (int i = 0; i < class_list.size(); i++) {
			ProClassVo vo = (ProClassVo)class_list.get(i);
			JLabel tempjl = new JLabel(vo.getPcl_name());
			tempjl.setPreferredSize(new Dimension(300, 25));
			centerBodyLeft2Pa.add(tempjl);
			List<ProClassVo> pcl_list = vo.getPcl_list();
			centerBodyLeft2_1Pa = new DanaComVblRProPclPa[pcl_list.size()];
			for (int j = 0; j < pcl_list.size(); j++) {
				centerBodyLeft2_1Pa[j] = new DanaComVblRProPclPa(danaComMain, (ProClassVo)pcl_list.get(j), "insert");
				centerBodyLeft2Pa.add(centerBodyLeft2_1Pa[j]);
			}
		}
		centerBodyLeft2Pa.revalidate();
		centerBodyLeft2Pa.repaint();
		
		DanaComProtocol writePort = null;
		try {
			writePort = new DanaComProtocol();
			writePort.setP_cmd(3011);
			writePort.setPcl_no("0101");
			
			danaComMain.connWrite(writePort);
			
		} catch (Exception e1) {
			e1.printStackTrace();
		} 
	}
	public void setMkrPclList(DanaComProtocol readPort) {
		centerBodyRi01Jl.setText(readPort.getPcl_name());
		
		vbb_maker_jcmb.removeAllItems();
		vbb_maker_jcmb.addItem("-- 제조사 --");
		for(int i = 0; i < readPort.getMkr_list().size(); i++){
			MakerVo makVo = readPort.getMkr_list().get(i);
			vbb_maker_jcmb.addItem(makVo.getMkr_name());
		}
		
		centerBodyRight3Pa.removeAll();
		vbb_pcl_jcmb = null;
		List<ProClassVo> class_list = readPort.getClass_list();
		centerBodyRight3Pa.setPreferredSize(new Dimension(480, 70));
		
		for (int i = 0; i < class_list.size(); i++) {
			ProClassVo vo = (ProClassVo)class_list.get(i);
			List<ProClassVo> pcl_list = vo.getPcl_list();
			vbb_pcl_jcmb = new JComboBox[pcl_list.size()];
			for (int j = 0; j < pcl_list.size(); j++) {
				ProClassVo vo2 = (ProClassVo)pcl_list.get(j);
				
				vbb_pcl_jcmb[j] = new JComboBox<>();
				vbb_pcl_jcmb[j].addItem(vo2.getPcl_name());
				centerBodyRight3Pa.add(vbb_pcl_jcmb[j]);
				
				List<ProClassVo> pcl_list2 = vo2.getPcl_list();
				
				for (int k = 0; k < pcl_list2.size(); k++) {
					ProClassVo vo3 = (ProClassVo)pcl_list2.get(k);
					vbb_pcl_jcmb[j].addItem(vo3.getPcl_name());
				}
			}
		}
		centerBodyRight3Pa.revalidate();
		centerBodyRight3Pa.repaint();
		
		DanaComProtocol writePort = null;
		try {
			writePort = new DanaComProtocol();
			writePort.setP_cmd(3021);
			writePort.setPcl_no(readPort.getPcl_no());
			
			danaComMain.connWrite(writePort);
			
		} catch (Exception e1) {
			e1.printStackTrace();
		} 
	}
	public void setProList(DanaComProtocol readPort) {
		centerBodyRight6Pa.removeAll();
		
		List<ProductVo> pro_list = readPort.getPro_list();
		
		int totSize = pro_list.size();
		centerBodyRight6Pa.setPreferredSize(new Dimension(480, (85*totSize > 500?85*totSize:500)));
		
		centerBodyRight6_1Pa = new DanaComVblRProPa[totSize];
		for(int i = 0; i < pro_list.size(); i++){
			centerBodyRight6_1Pa[i] = new DanaComVblRProPa(danaComMain, (ProductVo)pro_list.get(i), centerBodyLeft2_1Pa);
			centerBodyRight6Pa.add(centerBodyRight6_1Pa[i]);
		}
		centerBodyRight6Pa.revalidate();
		centerBodyRight6Pa.repaint();
		
	}

}
