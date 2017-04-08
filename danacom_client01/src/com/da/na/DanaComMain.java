package com.da.na;

import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Enumeration;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.plaf.FontUIResource;


public class DanaComMain extends JFrame implements Runnable {
	JPanel cards;
	CardLayout card;
	DanaComLogin danaComLogin;
	DanaComProess danaComProess;
	
	Socket s = null;
	ObjectOutputStream oos = null;
	ObjectInputStream ois = null;
	
	boolean loginOutExit = true;
	MemComVo memVo = null;
	
	public DanaComMain() {
		setUIFont(new FontUIResource("Gulim", Font.PLAIN, 12));
		
		setTitle("다나컴(danacom)");
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
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				try{
					if(loginOutExit && s != null && !s.isClosed()){
						DanaComProtocol writePort = new DanaComProtocol();
						writePort.setP_cmd(119);  // 종료에 의한 로그아웃
						oos.writeObject(writePort);
						oos.flush();
					}
				} catch (Exception e1) {
					System.out.println("windowClosing() : " + e1);
					e1.printStackTrace();
				} 
				super.windowClosing(e);
			}
		});
	}
	
	@Override
	public void run() {
		DanaComProtocol readPort = null;
		
		try {
			process : while(true){
				readPort = (DanaComProtocol)ois.readObject();
				System.out.println("client run() : " + readPort.getP_cmd());
				
				switch(readPort.getP_cmd()){
				case 100:  // 로그인 결과
					danaComLogin.loginResult(readPort);
					break;
				case 2001:  // 접속회원 목록
					danaComProess.getMemComIdList(readPort);
					break;
				case 3001: // 견적서 등록폼 - 상품분류 조회
					danaComProess.danaComVblInsertPa.setPclList(readPort);
					break;
				case 3011: // 견적서 등록폼 - 상품검색 조건(제조사, 상품분류) 조회
					danaComProess.danaComVblInsertPa.setMkrPclList(readPort);
					break;
				case 3021: // 견적서 등록폼 - 기본 상품검색 조회
					danaComProess.danaComVblInsertPa.setProList(readPort);
					break;
				case 3051: // 회원 견적서 등록 => 등록 초기상태로
					danaComProess.danaComVblInsertPa.vbbPreCreate(readPort);
					break;
				case 3052: // 회원 견적서 수정 => 회원 견적서 리스트
					danaComProess.danaComVblUpdatePa.setVblUpdate(readPort);
					break;
				case 3053: // 회원 견적서 삭제 => 회원 견적서 리스트
					danaComProess.danaComVblUpdatePa.setVblUpdate(readPort);
					break;
				case 3061: // 회원 견적서 리스트 조회
					danaComProess.danaComVblPa.setVblList(readPort);
					break;	
				case 3071: // 회원 견적서 상세
					danaComProess.danaComVblUpdatePa.setPclList(readPort);
					break;	
				case 3072: // 견적서 등록폼 - 상품검색 조건(제조사, 상품분류) 조회
					danaComProess.danaComVblUpdatePa.setMkrPclList(readPort);
					break;
				case 3073: // 견적서 등록폼 - 기본 상품검색 조회
					danaComProess.danaComVblUpdatePa.setProList(readPort);
					break;
				case 2009: // 접속종료(로그아웃)
					s.shutdownInput();
					s.shutdownOutput();
					break process;
				}
			}
		} catch (Exception e) {
			System.out.println("run() : " + e);
			e.printStackTrace();
		} finally {
			try {
				if(ois != null) ois.close();
				if(oos != null) oos.close();
				if(s != null && !s.isClosed()) s.close();
			} catch (Exception e2) {
				System.out.println(e2);
			}
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
	
	public void connWrite(DanaComProtocol writePort){
		try {
			oos.writeObject(writePort);
			oos.flush();
			
		} catch (Exception e2) {
			System.out.println(e2);
			e2.printStackTrace();
		} 
	}
	
	public void setUIFont(FontUIResource f) {
		//UIManager.getLookAndFeelDefaults().put("defaultFont", new Font("Gulim", Font.PLAIN, 12));
		
	    Enumeration keys = UIManager.getDefaults().keys();
	    while (keys.hasMoreElements()) {
	        Object key = keys.nextElement();
	        Object value = UIManager.get(key);
	        if (value instanceof FontUIResource)
	            UIManager.put(key, f);
	    }
	    UIManager.put("Button.font", new Font("돋움", Font.PLAIN, 13));
	}
	
	public static void main(String[] args) {
		new DanaComMain();
	}

}
