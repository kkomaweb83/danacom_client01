package com.da.na;

import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;


public class DanaComMain extends JFrame {
	JPanel cards;
	CardLayout card;
	DanaComLogin danaComLogin;
	DanaComProess danaComProess;
	
	public DanaComMain() {
		setTitle("로그인");
		card = new CardLayout();
		cards = new JPanel(card);
		
		danaComLogin = new DanaComLogin(this);
		danaComProess = new DanaComProess(this);
		cards.add(danaComLogin, "danaComLogin");
		cards.add(danaComProess, "danaComProess");
		
		add(cards);
		
		Dimension ds = Toolkit.getDefaultToolkit().getScreenSize();
		setBounds(ds.width/2 -200, ds.height/2 - 260, 400, 520);
		setResizable(false);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		new DanaComMain();
	}

}
