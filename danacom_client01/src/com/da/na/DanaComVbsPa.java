package com.da.na;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EtchedBorder;

public class DanaComVbsPa extends JPanel {
	DanaComMain danaComMain;
	
	JPanel centerListPa, centerTopPa, centerBodyPa, centerBodyRightPa;
	JLabel centerTitleJl;
	JButton vbbRecommJb;
	
	JPanel vbbListPa, vbbListTopPa, vbbListTop00Pa;
	DanaComVbbDetailPa vbbList_detailPa;
	JScrollPane vbbListJsp;
	JLabel vbbListTop01Jl, vbbListTop02Jl, vbbListTop03Jl, vbbListTop04Jl, vbbListTop05Jl, vbbListTop06Jl, vbbListTop07Jl;
	DanaComVbbProPa[] vbs_listPa;

	public DanaComVbsPa() {
	}
	
	public DanaComVbsPa(DanaComMain danaComMain) {
		this.danaComMain = danaComMain;
		
		setLayout(new BorderLayout());
		
		// 상단 리스트 영역
		centerListPa = new JPanel();
		centerListPa.setLayout(new BoxLayout(centerListPa, BoxLayout.Y_AXIS));
		
		centerTopPa = new JPanel();
		centerTopPa.setLayout(new FlowLayout(FlowLayout.LEFT));
		centerTitleJl = new JLabel("▶ 공유 견적서 - 상세");
		centerTitleJl.setPreferredSize(new Dimension(600, 20));
		vbbRecommJb = new JButton("견적서 추천");
		centerTopPa.add(centerTitleJl);
		centerTopPa.add(vbbRecommJb);
		centerListPa.add(centerTopPa);
		
		vbbListTop00Pa = new JPanel();
		vbbListTop00Pa.setLayout(new FlowLayout(FlowLayout.LEFT));
		
		vbbListTopPa = new JPanel();
		vbbListTopPa.setLayout(new FlowLayout(FlowLayout.LEFT));
		
		vbbListTop01Jl = new JLabel("번호");
		vbbListTop01Jl.setHorizontalAlignment(JLabel.CENTER);
		vbbListTop01Jl.setBorder(new EtchedBorder(EtchedBorder.LOWERED));
		vbbListTop01Jl.setPreferredSize(new Dimension(70, 30));
		
		vbbListTop02Jl = new JLabel("제목");
		vbbListTop02Jl.setHorizontalAlignment(JLabel.CENTER);
		vbbListTop02Jl.setBorder(new EtchedBorder(EtchedBorder.LOWERED));
		vbbListTop02Jl.setPreferredSize(new Dimension(500, 30));
		
		vbbListTop03Jl = new JLabel("글쓴이");
		vbbListTop03Jl.setHorizontalAlignment(JLabel.CENTER);
		vbbListTop03Jl.setBorder(new EtchedBorder(EtchedBorder.LOWERED));
		vbbListTop03Jl.setPreferredSize(new Dimension(80, 30));
		
		vbbListTop04Jl = new JLabel("날짜");
		vbbListTop04Jl.setHorizontalAlignment(JLabel.CENTER);
		vbbListTop04Jl.setBorder(new EtchedBorder(EtchedBorder.LOWERED));
		vbbListTop04Jl.setPreferredSize(new Dimension(90, 30));
		
		vbbListTop05Jl = new JLabel("추천수");
		vbbListTop05Jl.setHorizontalAlignment(JLabel.CENTER);
		vbbListTop05Jl.setBorder(new EtchedBorder(EtchedBorder.LOWERED));
		vbbListTop05Jl.setPreferredSize(new Dimension(70, 30));
		
		vbbListTop06Jl = new JLabel("조회수");
		vbbListTop06Jl.setHorizontalAlignment(JLabel.CENTER);
		vbbListTop06Jl.setBorder(new EtchedBorder(EtchedBorder.LOWERED));
		vbbListTop06Jl.setPreferredSize(new Dimension(70, 30));
		
		vbbListTop07Jl = new JLabel("베틀등록");
		vbbListTop07Jl.setHorizontalAlignment(JLabel.CENTER);
		vbbListTop07Jl.setBorder(new EtchedBorder(EtchedBorder.LOWERED));
		vbbListTop07Jl.setPreferredSize(new Dimension(80, 30));

		//vbbListTopPa.add(vbbListTop01Jl);
		vbbListTopPa.add(vbbListTop02Jl);
		vbbListTopPa.add(vbbListTop03Jl);
		vbbListTopPa.add(vbbListTop04Jl);
		vbbListTopPa.add(vbbListTop05Jl);
		vbbListTopPa.add(vbbListTop06Jl);
		vbbListTopPa.add(vbbListTop07Jl);
		
		vbbListTop00Pa.add(vbbListTopPa);
		centerListPa.add(vbbListTop00Pa);
		centerListPa.add(new JLabel(" "));
		
		// 중앙 리스트
		centerBodyPa = new JPanel();
		
		centerBodyRightPa = new JPanel();
		centerBodyRightPa.setLayout(new BoxLayout(centerBodyRightPa, BoxLayout.Y_AXIS));
		centerBodyRightPa.setBorder(new EtchedBorder(EtchedBorder.LOWERED));
		centerBodyRightPa.setPreferredSize(new Dimension(900, 530));

		vbbListPa = new JPanel();
		vbbListPa.setLayout(new FlowLayout(FlowLayout.LEFT));
		vbbListPa.setPreferredSize(new Dimension(890, 530));
		vbbListJsp = new JScrollPane(vbbListPa, 
				ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, 
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		
		centerBodyRightPa.add(vbbListJsp);
		centerBodyPa.add(centerBodyRightPa);
		
		add(centerListPa, BorderLayout.NORTH);
		add(centerBodyPa, BorderLayout.CENTER);
	}

	public void setVbsList(DanaComProtocol readPort) {
		vbbListTop00Pa.removeAll();
		vbbListPa.removeAll();
		
		//vbbListTopPa.add(vbbListTop01Jl);
		vbbListTopPa.add(vbbListTop02Jl);
		vbbListTopPa.add(vbbListTop03Jl);
		vbbListTopPa.add(vbbListTop04Jl);
		vbbListTopPa.add(vbbListTop05Jl);
		vbbListTopPa.add(vbbListTop06Jl);
		vbbListTopPa.add(vbbListTop07Jl);
		vbbListTop00Pa.add(vbbListTopPa);
		
		vbbListTop00Pa.setPreferredSize(new Dimension(950, 90));
		VbbVo vbbVo = readPort.getVbbVo();
		vbbList_detailPa = new DanaComVbbDetailPa(danaComMain, vbbVo, "q");
		vbbListTop00Pa.add(vbbList_detailPa);
		vbbListTop00Pa.revalidate();
		vbbListTop00Pa.repaint();
		
		List<VbsVo> vbs_list = readPort.getVbs_list();
		
		int totSize = vbs_list.size();
		vbbListPa.setPreferredSize(new Dimension(890, (110*totSize > 530?110*totSize:530)));
		
		vbs_listPa = new DanaComVbbProPa[totSize];
		for(int i = 0; i < vbs_list.size(); i++){
			vbs_listPa[i] = new DanaComVbbProPa(danaComMain, (VbsVo)vbs_list.get(i));
			vbbListPa.add(vbs_listPa[i]);
		}
		vbbListPa.revalidate();
		vbbListPa.repaint();
		
	}
	
}
