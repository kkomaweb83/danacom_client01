package com.da.na;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


public class DanaComLogin extends JPanel {
	DanaComMain danaComMain;
	
	JPanel pg1, pg2, pg3, jp1, jp2, jp3;
	JTextField t_mem_id;
	JPasswordField t_mem_pass;
	JButton jbMemComAdd, jbMemComLogin;
	
	Socket s = null;
	ObjectOutputStream oos = null;
	ObjectInputStream ois = null;
	
	public DanaComLogin() {}
	
	public DanaComLogin(DanaComMain danaComMain) {
		setLayout(new BorderLayout());
		
		this.danaComMain = danaComMain;
		
		pg1 = new JPanel();
		pg1.add(new JLabel("로그인 창"));
		
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
		
		pg2.add(jp1);
		pg2.add(jp2);
		pg2.add(jp3);
		
		pg3 = new JPanel();
		
		add(pg1, BorderLayout.NORTH);
		add(pg3, BorderLayout.CENTER);
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
				boolean idpw_chk = false;
				MemComVo memComWriteVo = null;
				MemComVo memComReadVo = null;
				
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
					s = new Socket("localhost", 8888);
					oos = new ObjectOutputStream(s.getOutputStream());
					
					memComWriteVo = new MemComVo();
					memComWriteVo.setCmd(100);
					memComWriteVo.setMem_id(u_mem_id);
					memComWriteVo.setMem_pass(u_mem_pass);
					
					oos.writeObject(memComWriteVo);
					oos.flush();
					
					ois = new ObjectInputStream(s.getInputStream());
					
					memComReadVo = (MemComVo)ois.readObject();
					
					if(memComReadVo.getCmd() == 101){
						idpw_chk = true;
					}else{
						t_mem_id.setText("");
						t_mem_pass.setText("");
						t_mem_id.requestFocus();
						JOptionPane.showMessageDialog(getParent(), memComReadVo.getMsg());
						return;
					}
					
					// 로그인 성공
					if(idpw_chk){
						t_mem_id.setText("");
						t_mem_pass.setText("");
						
						// 견적서 메인화면 : 쓰레드 통신 시작
						danaComMain.danaComProess.proessStart(memComReadVo);
						
						Dimension ds = Toolkit.getDefaultToolkit().getScreenSize();
						danaComMain.setBounds(20, 20, 1300, 850);
						
						danaComMain.card.show(getParent(), "danaComProess");
					}
					
				} catch (Exception e1) {
					e1.printStackTrace();
				} finally {
					try {
						if(s != null) s.close();
						if(oos != null) oos.close();
						if(ois != null) ois.close();
					} catch (Exception e2) {
						System.out.println(e2);
					}
				}
			}
		});
	}
}
