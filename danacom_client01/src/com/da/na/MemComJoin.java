package com.da.na;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class MemComJoin extends JFrame {
	JPanel pg1, pg2, jp1, jp2, jp21, jp3, jp4, jp5, jp7;
	JTextField t_mem_id, t_mem_name, t_mem_email, t_mem_hp;
	JPasswordField t_mem_pass;
	JButton jb1, jb3, jb4;
	
	boolean id_chk = false;
	String chk_id = "";
	
	FileInputStream fis = null;
	BufferedInputStream bis = null;
	FileOutputStream fos = null;
	BufferedOutputStream bos = null;
	String read_path = "";
	
	Socket s = null;
	ObjectOutputStream oos = null;
	ObjectInputStream ois = null;
	
	public MemComJoin() {
		setTitle("회원가입");
		
		pg1 = new JPanel();
		pg1.add(new JLabel("회원가입 창"));
		
		pg2 = new JPanel();
		pg2.setLayout(new BoxLayout(pg2, BoxLayout.Y_AXIS));
		jp1 = new JPanel();
		jp1.add(new JLabel("ID : "));
		jp1.setLayout(new FlowLayout(FlowLayout.LEFT));
		t_mem_id = new JTextField(15);
		jb1 = new JButton("중복검사");
		jp1.add(t_mem_id);
		jp1.add(jb1);
		
		jp2 = new JPanel();
		jp2.setLayout(new FlowLayout(FlowLayout.LEFT));
		jp2.add(new JLabel("PW : "));
		t_mem_pass = new JPasswordField(15);
		jp2.add(t_mem_pass);
		
		jp3 = new JPanel();
		jp3.setLayout(new FlowLayout(FlowLayout.LEFT));
		jp3.add(new JLabel("NAME : "));
		t_mem_name = new JTextField(15);
		jp3.add(t_mem_name);
		
		jp4 = new JPanel();
		jp4.setLayout(new FlowLayout(FlowLayout.LEFT));
		jp4.add(new JLabel("EMAIL : "));
		t_mem_email = new JTextField(15);
		jp4.add(t_mem_email);
		
		jp5 = new JPanel();
		jp5.setLayout(new FlowLayout(FlowLayout.LEFT));
		jp5.add(new JLabel("HP : "));
		t_mem_hp = new JTextField(15);
		jp5.add(t_mem_hp);
		
		jp7 = new JPanel();
		jb3 = new JButton("회원가입");
		jb4 = new JButton("취소");
		jp7.add(jb3);
		jp7.add(jb4);
		
		pg2.add(jp1);
		pg2.add(jp2);
		pg2.add(jp3);
		pg2.add(jp4);
		pg2.add(jp5);
		pg2.add(jp7);
		
		add(pg1, BorderLayout.NORTH);
		add(pg2, BorderLayout.CENTER);
		
		Dimension ds = Toolkit.getDefaultToolkit().getScreenSize();
		setBounds(50, 50, 400, 520);
		setResizable(false);
		setVisible(true);
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// 중복검사
		jb1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				id_chk = false;
				String u_mem_id = t_mem_id.getText().trim();
				
				DanaComProtocol writePort = null;
				DanaComProtocol readPort = null;
				MemComVo memComWriteVo = null;
				
				if("".equals(u_mem_id)){
					JOptionPane.showMessageDialog(getParent(), "아이디 를 입력하세요!");
					t_mem_id.requestFocus();
				}else{
					try {
						s = new Socket("localhost", 8888);
						oos = new ObjectOutputStream(s.getOutputStream());
						
						memComWriteVo = new MemComVo();
						memComWriteVo.setCmd(200);
						memComWriteVo.setMem_id(u_mem_id);
						
						writePort = new DanaComProtocol();
						writePort.setP_cmd(200);
						writePort.setMemComVo(memComWriteVo);
						
						oos.writeObject(writePort);
						oos.flush();
						
						ois = new ObjectInputStream(s.getInputStream());
						readPort = (DanaComProtocol)ois.readObject();
						
						if(readPort.getMemComVo().getCmd() == 201){
							t_mem_id.requestFocus();
						}else{
							id_chk = true;
							chk_id = u_mem_id;
						}
						JOptionPane.showMessageDialog(getParent(), readPort.getMemComVo().getMsg());
						
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
			}
		});
		
		// 회원가입
		jb3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String u_mem_id = t_mem_id.getText().trim();
				String u_mem_pass = new String(t_mem_pass.getPassword()).trim();
				String u_mem_name = t_mem_name.getText().trim();
				String u_mem_email = t_mem_email.getText().trim();
				String u_mem_hp = t_mem_hp.getText().trim();
				
				DanaComProtocol writePort = null;
				DanaComProtocol readPort = null;
				MemComVo memComWriteVo = null;
				MemComVo memComReadVo = null;
				
				if("".equals(u_mem_id)){
					JOptionPane.showMessageDialog(getParent(), "아이디 를 입력하세요!");
				}else{
					if(!id_chk || !chk_id.equals(u_mem_id)){
						id_chk = false;
						JOptionPane.showMessageDialog(getParent(), "아이디 중복검사를 하세요!");
						t_mem_id.requestFocus();
					}else{
						if("".equals(u_mem_pass)){
							JOptionPane.showMessageDialog(getParent(), "비밀번호 를 입력하세요!");
							t_mem_pass.requestFocus();
						}else if("".equals(u_mem_name)){
							JOptionPane.showMessageDialog(getParent(), "이름 을 입력하세요!");
							t_mem_name.requestFocus();
						}else{
							try {
								s = new Socket("localhost", 8888);
								oos = new ObjectOutputStream(s.getOutputStream());
								
								memComWriteVo = new MemComVo(0,u_mem_id,u_mem_pass,u_mem_name,u_mem_email,u_mem_hp,1000,"","n");
								memComWriteVo.setCmd(300);
								
								writePort = new DanaComProtocol();
								writePort.setP_cmd(300);
								writePort.setMemComVo(memComWriteVo);
								
								oos.writeObject(writePort);
								oos.flush();
								
								ois = new ObjectInputStream(s.getInputStream());
								readPort = (DanaComProtocol)ois.readObject();
								
								JOptionPane.showMessageDialog(getParent(), readPort.getMemComVo().getMsg());
								if(readPort.getMemComVo().getCmd() == 301){
									dispose();
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
					}
				}
			}
		});
		
		jb4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
	}
}
