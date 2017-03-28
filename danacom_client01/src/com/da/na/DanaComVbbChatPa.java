package com.da.na;

import java.awt.FlowLayout;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class DanaComVbbChatPa extends JPanel {
	DanaComMain danaComMain;
	
	JPanel centerListPa, centerTopPa, centerBodyPa;
	JLabel centerTitleJl;
	
	public DanaComVbbChatPa() {
	}
	public DanaComVbbChatPa(DanaComMain danaComMain) {
		this.danaComMain = danaComMain;
		
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		// 중간 리스트 영역
		centerListPa = new JPanel();
		centerListPa.setLayout(new BoxLayout(centerListPa, BoxLayout.Y_AXIS));
		
		centerTopPa = new JPanel();
		centerTopPa.setLayout(new FlowLayout(FlowLayout.LEFT));
		centerTitleJl = new JLabel("▶ 견적서 채팅");
		centerTopPa.add(centerTitleJl);
		centerListPa.add(centerTopPa);
		
		add(centerListPa);
	}

}
