package com.da.na;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.BevelBorder;
import javax.swing.border.TitledBorder;


public class DanaComProess extends JPanel {
	DanaComMain danaComMain;
	
	JPanel leftMenuPa, centerListPa;
	JPanel memComInfoPa, menuListPa, memComJoinPa;
	JLabel memNameJl, memMilJl;
	JButton memComLogOutJb;
	JPanel centerTopPa;
	JLabel centerTitleJl;
	TitledBorder leftMenuBd;
	BevelBorder memComInfoBd;
	JButton vblListLinkJb, vbbListLinkJb, btlListLinkJb, vbbChatLinkJb;
	JList memComIdJL;
	JScrollPane memComIdSrl;

	
	public DanaComProess() {
	}
	public DanaComProess(DanaComMain danaComMain) {
		setLayout(new BorderLayout());
		
		this.danaComMain = danaComMain;
		
		// 왼편 메뉴 영역
		leftMenuPa = new JPanel();
		leftMenuPa.setLayout(new BoxLayout(leftMenuPa, BoxLayout.Y_AXIS));
		leftMenuPa.setPreferredSize(new Dimension(200, getHeight()));
		leftMenuBd = new TitledBorder("");
		leftMenuBd.setTitlePosition(TitledBorder.ABOVE_TOP); //지정한 위치에 타이틀을 나타내주는 보더...
		leftMenuBd.setTitleJustification(TitledBorder.CENTER); //자리맞춤을 가운데로 지정...
		leftMenuPa.setBorder(leftMenuBd);
		
		// 왼편 상단 로그인 정보
		memComInfoPa = new JPanel();
		memComInfoPa.setLayout(new BoxLayout(memComInfoPa, BoxLayout.Y_AXIS));
		memComInfoPa.setPreferredSize(new Dimension(190, 200));
		memComInfoBd = new BevelBorder(BevelBorder.RAISED); //3차원적인 테두리 효과를 위한것이고 양각의 옵션을 준다.
		memComInfoPa.setBorder(memComInfoBd);

		memNameJl = new JLabel("");
		memMilJl = new JLabel("");
		memComLogOutJb = new JButton("로그아웃");
		memComInfoPa.add(memNameJl);
		memComInfoPa.add(memMilJl);
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
		menuListPa.add(vbbChatLinkJb);
		leftMenuPa.add(menuListPa);
		
		// 접속회원 목록
		memComJoinPa = new JPanel();
		memComJoinPa.setLayout(new BoxLayout(memComJoinPa, BoxLayout.Y_AXIS));
		memComIdJL = new JList();
		memComIdSrl = new JScrollPane(memComIdJL);
		memComJoinPa.add(memComIdSrl);
		leftMenuPa.add(memComJoinPa);
		
		// 중간 리스트 영역
		centerListPa = new JPanel();
		centerListPa.setLayout(new BoxLayout(centerListPa, BoxLayout.Y_AXIS));
		
		centerTopPa = new JPanel();
		centerTopPa.setLayout(new FlowLayout(FlowLayout.LEFT));
		centerTitleJl = new JLabel("▶ 공유 견적서");
		centerTopPa.add(centerTitleJl);
		centerListPa.add(centerTopPa);
		
		add(leftMenuPa, BorderLayout.WEST);
		add(centerListPa, BorderLayout.CENTER);
		
		//로그아웃
		memComLogOutJb.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Dimension ds = Toolkit.getDefaultToolkit().getScreenSize();
				danaComMain.setBounds(ds.width/2 -200, ds.height/2 - 260, 400, 520);
				
				danaComMain.card.show(getParent(), "danaComLogin");
				
				// 소켓종료
				try {
					DanaComProtocol writePort = new DanaComProtocol();
					writePort.setP_cmd(109);  // 로그아웃
					danaComMain.oos.writeObject(writePort);
					danaComMain.oos.flush();
					
				} catch (Exception e1) {
					System.out.println("memComLogOutJb() : " + e1);
					e1.printStackTrace();
				} finally {
					try {
						if(danaComMain.s != null) danaComMain.s.close();
						if(danaComMain.ois != null) danaComMain.ois.close();
						if(danaComMain.oos != null) danaComMain.oos.close();
					} catch (Exception e2) {
						System.out.println("memComLogOutJb() : " + e2);
						e2.printStackTrace();
					}
				}
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
	}
	
}
