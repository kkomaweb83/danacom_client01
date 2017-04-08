package com.da.na;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Vector;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.BevelBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;


public class DanaComProess extends JPanel {
	DanaComMain danaComMain;
	
	JPanel centerListCards;
	CardLayout centerCardLayout;
	DanaComVblPa danaComVblPa;
	DanaComVblInsertPa danaComVblInsertPa;
	DanaComVblUpdatePa danaComVblUpdatePa;
	DanaComVbbPa danaComVbbPa;
	DanaComVbjPa danaComVbjPa;
	DanaComVbbChatPa danaComVbbChatPa;
	
	JPanel leftMenuPa, centerListPa;
	JPanel memComInfoPa, menuListPa, memComJoinPa;
	JLabel memNameJl, memMilJl;
	JButton memComLogOutJb;
	JPanel centerTopPa, centerBodyPa;
	JLabel centerTitleJl;
	TitledBorder leftMenuBd;
	BevelBorder memComInfoBd;
	JButton vblListLinkJb, vbbListLinkJb, btlListLinkJb, vbbChatLinkJb;
	JList memComIdJL;
	JScrollPane memComIdSrl;
	JTable vbbListTable;
	JScrollPane vbbListJsp;
	DefaultTableModel vbbListModel;
	Vector vbbListRowData;
	Vector<String> vbbListColumnNames;

	
	public DanaComProess() {
	}
	public DanaComProess(DanaComMain danaComMain) {
		setLayout(new BorderLayout());
		
		this.danaComMain = danaComMain;
		
		// 왼편 메뉴 영역
		leftMenuPa = new JPanel();
		leftMenuPa.setLayout(new BoxLayout(leftMenuPa, BoxLayout.Y_AXIS));
		leftMenuBd = new TitledBorder("");
		leftMenuBd.setTitlePosition(TitledBorder.ABOVE_TOP); //지정한 위치에 타이틀을 나타내주는 보더...
		leftMenuBd.setTitleJustification(TitledBorder.CENTER); //자리맞춤을 가운데로 지정...
		leftMenuPa.setBorder(leftMenuBd);
		
		// 왼편 상단 로그인 정보
		memComInfoPa = new JPanel();
		memComInfoPa.setLayout(new BoxLayout(memComInfoPa, BoxLayout.Y_AXIS));
		memComInfoPa.setPreferredSize(new Dimension(150, 170));
		//memComInfoBd = new BevelBorder(BevelBorder.RAISED); //3차원적인 테두리 효과를 위한것이고 양각의 옵션을 준다.
		//memComInfoPa.setBorder(memComInfoBd);

		memNameJl = new JLabel("");
		memMilJl = new JLabel("");
		memComLogOutJb = new JButton("로그아웃");
		memComInfoPa.add(new JLabel(" "));
		memComInfoPa.add(memNameJl);
		memComInfoPa.add(new JLabel(" "));
		memComInfoPa.add(memMilJl);
		memComInfoPa.add(new JLabel(" "));
		memComInfoPa.add(memComLogOutJb);
		leftMenuPa.add(memComInfoPa);
		
		// 메뉴링크 리스트
		menuListPa = new JPanel();
		menuListPa.setLayout(new BoxLayout(menuListPa, BoxLayout.Y_AXIS));
		vblListLinkJb = new JButton("회원 견적서");
		vbbListLinkJb = new JButton("공유 견적서");
		btlListLinkJb = new JButton("베틀 견적서");
		vbbChatLinkJb = new JButton("견적서 채팅");
		menuListPa.add(vblListLinkJb);
		menuListPa.add(vbbListLinkJb);
		menuListPa.add(btlListLinkJb);
		//menuListPa.add(vbbChatLinkJb);
		menuListPa.add(new JLabel(" "));
		menuListPa.add(new JLabel(" "));
		leftMenuPa.add(menuListPa);
		
		// 접속회원 목록
		memComJoinPa = new JPanel();
		memComJoinPa.setLayout(new BoxLayout(memComJoinPa, BoxLayout.Y_AXIS));
		memComIdJL = new JList();
		memComIdSrl = new JScrollPane(memComIdJL);
		memComJoinPa.add(memComIdSrl);
		leftMenuPa.add(memComJoinPa);
		leftMenuPa.add(new JLabel(" "));
		leftMenuPa.add(new JLabel("▷ 관리자 메뉴 ◁"));
		leftMenuPa.add(new JButton("상품분류 관리"));
		leftMenuPa.add(new JButton("제조사 관리"));
		leftMenuPa.add(new JButton("상품 리스트"));
		leftMenuPa.add(new JButton("베틀 관리"));
		leftMenuPa.add(new JLabel(" "));
		
		// 중간 리스트 영역
		centerCardLayout = new CardLayout();
		centerListCards = new JPanel(centerCardLayout);
		
		danaComVblPa = new DanaComVblPa(danaComMain);
		danaComVbbPa = new DanaComVbbPa(danaComMain);
		danaComVblInsertPa = new DanaComVblInsertPa(danaComMain);
		danaComVblUpdatePa = new DanaComVblUpdatePa(danaComMain);
		danaComVbjPa = new DanaComVbjPa(danaComMain);
		danaComVbbChatPa = new DanaComVbbChatPa(danaComMain);
		centerListCards.add(danaComVblPa, "danaComVblPa");
		centerListCards.add(danaComVbbPa, "danaComVbbPa");
		centerListCards.add(danaComVblInsertPa, "danaComVblInsertPa");
		centerListCards.add(danaComVblUpdatePa, "danaComVblUpdatePa");
		centerListCards.add(danaComVbjPa, "danaComVbjPa");
		centerListCards.add(danaComVbbChatPa, "danaComVbbChatPa");
		
		add(leftMenuPa, BorderLayout.WEST);
		add(centerListCards, BorderLayout.CENTER);
		
		//로그아웃
		memComLogOutJb.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Dimension ds = Toolkit.getDefaultToolkit().getScreenSize();
				danaComMain.setBounds(ds.width/2 -200, ds.height/2 - 260, 400, 520);
				
				danaComMain.card.show(getParent(), "danaComLogin");
				
				// 소켓종료 : Main 에서 처리
				try {
					DanaComProtocol writePort = new DanaComProtocol();
					writePort.setP_cmd(109);  // 로그아웃
					danaComMain.oos.writeObject(writePort);
					danaComMain.oos.flush();
					
					danaComMain.loginOutExit = false;
					
				} catch (Exception e1) {
					System.out.println("memComLogOutJb() : " + e1);
					e1.printStackTrace();
				} 
			}
		});
		
		vblListLinkJb.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				DanaComProtocol writePort = null;
				try{
					writePort = new DanaComProtocol();
					writePort.setP_cmd(3061);  // 회원 견적서 리스트 조회
					writePort.setMemComVo(danaComMain.memVo);
					
					danaComMain.oos.writeObject(writePort);
					danaComMain.oos.flush();
					
				} catch (Exception e1) {
					System.out.println(e1);
					e1.printStackTrace();
				}
				
				centerCardLayout.show(danaComVbbPa.getParent(), "danaComVblPa");
			}
		});
		vbbListLinkJb.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				DanaComProtocol writePort = null;
				try{
					writePort = new DanaComProtocol();
					writePort.setP_cmd(3081);  // 공유 견적서 리스트 조회
					writePort.setMemComVo(danaComMain.memVo);
					
					danaComMain.oos.writeObject(writePort);
					danaComMain.oos.flush();
					
				} catch (Exception e1) {
					System.out.println(e1);
					e1.printStackTrace();
				}
				
				centerCardLayout.show(danaComVbbPa.getParent(), "danaComVbbPa");
			}
		});
		btlListLinkJb.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				centerCardLayout.show(danaComVbjPa.getParent(), "danaComVbjPa");
			}
		});
		vbbChatLinkJb.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				centerCardLayout.show(danaComVbbChatPa.getParent(), "danaComVbbChatPa");
			}
		});
		
	}
	
	public void proessStart(MemComVo memComReadVo) {
		DanaComProtocol writePort = null;
		try{
			writePort = new DanaComProtocol();
			writePort.setP_cmd(2001);  // 견적서 메인화면 입장 2001 : 접속회원 목록조회
			
			danaComMain.oos.writeObject(writePort);
			danaComMain.oos.flush();
			
			memNameJl.setText(memComReadVo.getMem_name() + " 님");
			memMilJl.setText("포인트 : " + memComReadVo.getMem_mil() + "점");
			
			danaComMain.memVo = memComReadVo;
		} catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();
		}
	}
	
	// 접속 회원ID 목록
	public void getMemComIdList(DanaComProtocol readPort){
		List<String> memComIdList = readPort.getMemComIdList();
		if(memComIdList != null && memComIdList.size() > 0){
			memComIdJL.setListData(memComIdList.toArray());
		}
		
		DanaComProtocol writePort = null;
		try{
			writePort = new DanaComProtocol();
			writePort.setP_cmd(3061);  // 회원 견적서 리스트 조회
			writePort.setMemComVo(danaComMain.memVo);
			
			danaComMain.oos.writeObject(writePort);
			danaComMain.oos.flush();
			
		} catch (Exception e1) {
			System.out.println(e1);
			e1.printStackTrace();
		}
	}
	
}
