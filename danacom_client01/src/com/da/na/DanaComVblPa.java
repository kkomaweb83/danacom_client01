package com.da.na;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EtchedBorder;

public class DanaComVblPa extends JPanel {
	DanaComMain danaComMain;
	
	JPanel centerListPa, centerTopPa, centerBodyPa;
	JLabel centerTitleJl;
	JButton vblPreCreateJb;
	
	JPanel vblListPa, vblListTopPa;
	DanaComVblDetailPa[] vblList_detailPa;
	JScrollPane vblListJsp;
	JLabel vblListTop01Jl, vblListTop02Jl, vblListTop03Jl, vblListTop04Jl;
	
	public DanaComVblPa() {
	}
	public DanaComVblPa(DanaComMain danaComMain) {
		this.danaComMain = danaComMain;
		
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		// 중간 리스트 영역
		centerListPa = new JPanel();
		centerListPa.setLayout(new BoxLayout(centerListPa, BoxLayout.Y_AXIS));
		
		centerTopPa = new JPanel();
		centerTopPa.setLayout(new FlowLayout(FlowLayout.LEFT));
		centerTitleJl = new JLabel("▶ 회원 견적서");
		centerTitleJl.setPreferredSize(new Dimension(600, 25));
		vblPreCreateJb = new JButton("견적서등록");
		centerTopPa.add(centerTitleJl);
		centerTopPa.add(vblPreCreateJb);
		centerListPa.add(centerTopPa);
		
		centerBodyPa = new JPanel();
		centerBodyPa.setLayout(new FlowLayout(FlowLayout.LEFT));
		
		vblListPa = new JPanel();
		vblListPa.setLayout(new FlowLayout(FlowLayout.LEFT));
		vblListPa.setBorder(new EtchedBorder(EtchedBorder.LOWERED));
		vblListPa.setPreferredSize(new Dimension(890, 650));
		vblListJsp = new JScrollPane(vblListPa, 
				ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, 
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		
		vblListTopPa = new JPanel();
		vblListTopPa.setLayout(new FlowLayout(FlowLayout.LEFT));
		
		vblListTop01Jl = new JLabel("번호");
		vblListTop01Jl.setHorizontalAlignment(JLabel.CENTER);
		vblListTop01Jl.setBorder(new EtchedBorder(EtchedBorder.LOWERED));
		vblListTop01Jl.setPreferredSize(new Dimension(70, 30));
		
		vblListTop02Jl = new JLabel("제목");
		vblListTop02Jl.setHorizontalAlignment(JLabel.CENTER);
		vblListTop02Jl.setBorder(new EtchedBorder(EtchedBorder.LOWERED));
		vblListTop02Jl.setPreferredSize(new Dimension(580, 30));
		
		vblListTop03Jl = new JLabel("날짜");
		vblListTop03Jl.setHorizontalAlignment(JLabel.CENTER);
		vblListTop03Jl.setBorder(new EtchedBorder(EtchedBorder.LOWERED));
		vblListTop03Jl.setPreferredSize(new Dimension(100, 30));
		
		vblListTop04Jl = new JLabel("공유여부");
		vblListTop04Jl.setHorizontalAlignment(JLabel.CENTER);
		vblListTop04Jl.setBorder(new EtchedBorder(EtchedBorder.LOWERED));
		vblListTop04Jl.setPreferredSize(new Dimension(100, 30));
		
		vblListTopPa.add(vblListTop01Jl);
		vblListTopPa.add(vblListTop02Jl);
		vblListTopPa.add(vblListTop03Jl);
		vblListTopPa.add(vblListTop04Jl);
		vblListPa.add(vblListTopPa);
		
		centerBodyPa.add(vblListJsp, BorderLayout.NORTH);
		centerListPa.add(centerBodyPa);
		
		add(centerListPa);
		
		vblPreCreateJb.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				DanaComProtocol writePort = null;
				
				try {
					writePort = new DanaComProtocol();
					writePort.setP_cmd(3001);
					
					danaComMain.connWrite(writePort);
					
				} catch (Exception e1) {
					e1.printStackTrace();
				} 
				
				danaComMain.danaComProess.centerCardLayout.show(danaComMain.danaComProess.danaComVblInsertPa.getParent(), "danaComVblInsertPa");
			}
		});
	}
	public void setVblList(DanaComProtocol readPort) {
		vblListPa.removeAll();
		
		vblListTopPa.add(vblListTop01Jl);
		vblListTopPa.add(vblListTop02Jl);
		vblListTopPa.add(vblListTop03Jl);
		vblListTopPa.add(vblListTop04Jl);
		vblListPa.add(vblListTopPa);
		
		List<VirBillVo> vir_list = readPort.getVir_list();
		
		int totSize = vir_list.size();
		vblListPa.setPreferredSize(new Dimension(890, (85*totSize > 650?85*totSize:650)));
		
		vblList_detailPa = new DanaComVblDetailPa[totSize];
		for(int i = 0; i < vir_list.size(); i++){
			vblList_detailPa[i] = new DanaComVblDetailPa(danaComMain, (VirBillVo)vir_list.get(i));
			vblListPa.add(vblList_detailPa[i]);
		}
		
		vblListPa.revalidate();
		vblListPa.repaint();
	}

}
