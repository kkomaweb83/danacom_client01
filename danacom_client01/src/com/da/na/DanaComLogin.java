package com.da.na;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


public class DanaComLogin extends JPanel {
	DanaComMain danaComMain;
	
	JPanel pg1, pg2, jp1, jp2, jp3;
	JPanel pg1_1Pa, pg1_2Pa;
	JTextField t_mem_id;
	JPasswordField t_mem_pass;
	JButton jbMemComAdd, jbMemComLogin;
	
	Image main_ima01, main_ima02;
	CanvasMain01 ct1 = new CanvasMain01();
	CanvasMain02 ct2 = new CanvasMain02();
	Toolkit toolkit = getToolkit();

	
	public DanaComLogin() {}
	
	public DanaComLogin(DanaComMain danaComMain) {
		setLayout(new BorderLayout());
		
		this.danaComMain = danaComMain;
		
		pg1 = new JPanel();
		pg1.setLayout(new BoxLayout(pg1, BoxLayout.Y_AXIS));
		
		pg1_1Pa = new JPanel();
		ct1.setPreferredSize(new Dimension(244, 126));
		URL imageURL = getClass().getClassLoader().getResource("dana_img/" + "danawa_logo_main_01.png");
		main_ima01 = toolkit.getImage(imageURL);
		pg1_1Pa.add(ct1);
		
		pg1_2Pa = new JPanel();
		ct2.setPreferredSize(new Dimension(320, 120));
		URL imageURL2 = getClass().getClassLoader().getResource("dana_img/" + "danawa_logo_main_02.png");
		main_ima02 = toolkit.getImage(imageURL2);
		pg1_2Pa.add(ct2);
		
		pg1.add(pg1_1Pa);
		pg1.add(pg1_2Pa);
		
		pg2 = new JPanel();
		pg2.setLayout(new BoxLayout(pg2, BoxLayout.Y_AXIS));
		jp1 = new JPanel();
		jp1.add(new JLabel("ID : "));
		t_mem_id = new JTextField(15);
		jp1.add(t_mem_id);
		
		jp2 = new JPanel();
		jp2.add(new JLabel("PW : "));
		t_mem_pass = new JPasswordField(15);
		jp2.add(t_mem_pass);
		
		jp3 = new JPanel();
		jbMemComAdd = new JButton("회원가입");
		jbMemComLogin = new JButton("로그인");
		jp3.add(jbMemComAdd);
		jp3.add(jbMemComLogin);
		jp3.add(new JLabel(" "));
		
		pg2.add(jp1);
		pg2.add(jp2);
		pg2.add(jp3);
		pg2.add(new JLabel(" "));
		
		add(pg1, BorderLayout.CENTER);
		add(pg2, BorderLayout.SOUTH);
		
		// 회원가입
		jbMemComAdd.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new MemComJoin();
			}
		});
		
		// 로그인
		jbMemComLogin.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String u_mem_id = t_mem_id.getText().trim();
				String u_mem_pass = new String(t_mem_pass.getPassword()).trim();
				
				DanaComProtocol writePort = null;
				MemComVo memComWriteVo = null;
				
				if("".equals(u_mem_id)){
					JOptionPane.showMessageDialog(getParent(), "ID 를 입력하세요!");
					t_mem_id.requestFocus();
					return;
				}
				
				if("".equals(u_mem_pass)){
					JOptionPane.showMessageDialog(getParent(), "PW 를 입력하세요!");
					t_mem_pass.requestFocus();
					return;
				}
				
				try {
					memComWriteVo = new MemComVo();
					memComWriteVo.setCmd(100);
					memComWriteVo.setMem_id(u_mem_id);
					memComWriteVo.setMem_pass(u_mem_pass);
					
					writePort = new DanaComProtocol();
					writePort.setP_cmd(100);
					writePort.setMemComVo(memComWriteVo);
					
					danaComMain.conn(writePort);
					
				} catch (Exception e1) {
					e1.printStackTrace();
				} 
			}
		});
	}
	
	// 로그인 결과
	public void loginResult(DanaComProtocol readPort){
		boolean idpw_chk = false;
		
		if(readPort.getMemComVo().getCmd() == 101){
			idpw_chk = true;
		}else{
			t_mem_id.setText("");
			t_mem_pass.setText("");
			t_mem_id.requestFocus();
			JOptionPane.showMessageDialog(getParent(), readPort.getMemComVo().getMsg());
			return;
		}
		
		// 로그인 성공
		if(idpw_chk){
			t_mem_id.setText("");
			t_mem_pass.setText("");
			
			// 견적서 메인화면
			danaComMain.danaComProess.proessStart(readPort.getMemComVo());
			
			Dimension ds = Toolkit.getDefaultToolkit().getScreenSize();
			danaComMain.setBounds(20, 20, 1200, 750);
			
			danaComMain.card.show(getParent(), "danaComProess");
		}
	}
	
	private class CanvasMain01 extends JPanel {
		@Override
		public void paint(Graphics g) {
			g.clearRect(0, 0, getWidth(), getHeight());
			g.drawImage(main_ima01, 0, 0, 244, 126, this);
			
		}
	}
	
	private class CanvasMain02 extends JPanel {
		@Override
		public void paint(Graphics g) {
			g.clearRect(0, 0, getWidth(), getHeight());
			g.drawImage(main_ima02, 0, 0, 320, 120, this);
			
		}
	}
}
