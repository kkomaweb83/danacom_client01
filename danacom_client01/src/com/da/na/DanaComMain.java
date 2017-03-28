package com.da.na;

import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import javax.swing.JFrame;
import javax.swing.JPanel;


public class DanaComMain extends JFrame implements Runnable {
	JPanel cards;
	CardLayout card;
	DanaComLogin danaComLogin;
	DanaComProess danaComProess;
	
	Socket s = null;
	ObjectOutputStream oos = null;
	ObjectInputStream ois = null;
	
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
	
	@Override
	public void run() {
		DanaComProtocol readPort = null;
		
		try {
			process : while(true){
				readPort = (DanaComProtocol)ois.readObject();
				
				switch(readPort.getP_cmd()){
				case 100:  // 로그인 결과
					danaComLogin.loginResult(readPort);
					break;
				case 2001:  // 접속회원 목록
					danaComProess.getMemComIdList(readPort);
					break;
				case 9999:
					break process;
				}
			}
		} catch (Exception e) {
			System.out.println("run() : " + e);
			e.printStackTrace();
		}
	}
	
	public void conn(DanaComProtocol writePort){
		try {
			s = new Socket("localhost", 8888);
			oos = new ObjectOutputStream(s.getOutputStream());
			ois = new ObjectInputStream(s.getInputStream());
						
			oos.writeObject(writePort);
			oos.flush();
			
			new Thread(DanaComMain.this).start();
			
		} catch (Exception e2) {
			System.out.println(e2);
			e2.printStackTrace();
		} 
	}
	
	public static void main(String[] args) {
		new DanaComMain();
	}

}
