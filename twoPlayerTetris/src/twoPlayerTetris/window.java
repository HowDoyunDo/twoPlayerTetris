package twoPlayerTetris;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class window extends JFrame {
	
	public static String label1 = "Delete Line : 0\nLevel : 1\nSpeed : 1.0sec";
	public static String label2 = "Delete Line : 0\nLevel : 1\nSpeed : 1.0sec";
	public static String gameMent = " ■스페이스바를 누르면 시작합니다.■\n\n" 
				+ "<Left Player Key>		* 총 10줄 삭제 시 레벨업\n" 
				+ "   W S A D			* 3줄 삭제 시 상대 배드블럭 등장\n" 
				+ "<Right Player Key>		* 레벨 업 시 랜덤 한 라인 증가, 스피드 0.1초 증가\n" 
				+ "   ↑ ↓ ← →\n";
	JButton[][] blockFrm1 = new JButton[20][12];	//테트리스 게임 프레임
	JButton[][] blockFrm2 = new JButton[20][12];	//테트리스 게임 프레임
	JButton[][] nextBlc1 = new JButton[4][4];
	JButton[][] nextBlc2 = new JButton[4][4];
	JTextArea textArea = new JTextArea(gameMent);
	JTextArea delLineCnt1 = new JTextArea(label1);
	JTextArea delLineCnt2 = new JTextArea(label1);
	

	public window(String title) {
		synchronized (this) {
			setSize(860, 650);
			setTitle(title);
			setLocationRelativeTo(null); // 윈도우 화면 중앙
			
			
			
			setLayout(new BorderLayout(1, 1));	//전체 레이아웃
			
			JPanel p1frm = new JPanel();	//p1프레임
			JPanel p2frm = new JPanel();	//p2프레임
			
			p1frm.setLayout(new BorderLayout(1, 1));
			p2frm.setLayout(new BorderLayout(1, 1));
			
			
			
			/*@@@@@@@@@@@@@@	1p화면	@@@@@@@@@@@@@*/
			JPanel gameFrm1 = new JPanel();	//게임프레임
			JPanel rightFrm1 = new JPanel();	//정보프레임
			rightFrm1.setLayout(new BorderLayout(20, 20));	//정보프레임 배치

			JPanel nextFrm1 = new JPanel();	//다음 블록프레임
			nextFrm1.setPreferredSize(new Dimension(1, 92));	//다음블록프레임 높이
			nextFrm1.setLayout(new GridLayout(4, 4, 1, 1));	//다음 블록프레임 내부

			gameFrm1.setBorder(new TitledBorder(new LineBorder(Color.BLACK, 5), "Game")); // 게임프레임 테두리
			rightFrm1.setBorder(new TitledBorder(new LineBorder(Color.BLACK, 5), "Next Block")); // 정보프레임 테두리

			gameFrm1.setPreferredSize(new Dimension(300, 550));	//게임프레임 너비
			gameFrm1.setLayout(new GridLayout(20, 12, 1, 1));	//게임프레임 내부

			for (int i = 0; i < 20; i++) {	//게임프레임 블록 삽입
				for (int j = 0; j < 12; j++) {
					blockFrm1[i][j] = new JButton("");
					blockFrm1[i][j].setBackground(Color.LIGHT_GRAY);
					gameFrm1.add(blockFrm1[i][j]);
				}
			}
			for (int i = 0; i < 4; i++) {	//정보프레임 블록 삽입
				for (int j = 0; j < 4; j++) {
					nextBlc1[i][j] = new JButton("");
					nextBlc1[i][j].setBackground(Color.LIGHT_GRAY);
					nextFrm1.add(nextBlc1[i][j]);
				}
			}

			rightFrm1.setPreferredSize(new Dimension(110, 550));	//정보프레임 높이
			rightFrm1.add(nextFrm1, "North");	//정보프레임 삽입
			delLineCnt1.setPreferredSize(new Dimension(1, 100));	//게임정보 높이
			rightFrm1.add(delLineCnt1, "South");	//게임정보 삽입
			
			p1frm.add(gameFrm1, "West");
			p1frm.add(rightFrm1, "East");
			
			
			/*@@@@@@@@@@@@@@	2p화면	@@@@@@@@@@@@@*/
			JPanel gameFrm2 = new JPanel();	//게임프레임
			JPanel rightFrm2 = new JPanel();	//정보프레임
			rightFrm2.setLayout(new BorderLayout(20, 20));	//정보프레임 배치

			JPanel nextFrm2 = new JPanel();	//다음 블록프레임
			nextFrm2.setPreferredSize(new Dimension(1, 92));	//다음블록프레임 높이
			nextFrm2.setLayout(new GridLayout(4, 4, 1, 1));	//다음 블록프레임 내부

			gameFrm2.setBorder(new TitledBorder(new LineBorder(Color.BLACK, 5), "Game")); // 게임프레임 테두리
			rightFrm2.setBorder(new TitledBorder(new LineBorder(Color.BLACK, 5), "Next Block")); // 정보프레임 테두리

			gameFrm2.setPreferredSize(new Dimension(300, 550));	//게임프레임 너비
			gameFrm2.setLayout(new GridLayout(20, 12, 1, 1));	//게임프레임 내부

			for (int i = 0; i < 20; i++) {	//게임프레임 블록 삽입
				for (int j = 0; j < 12; j++) {
					blockFrm2[i][j] = new JButton("");
					blockFrm2[i][j].setBackground(Color.LIGHT_GRAY);
					gameFrm2.add(blockFrm2[i][j]);
				}
			}
			for (int i = 0; i < 4; i++) {	//정보프레임 블록 삽입
				for (int j = 0; j < 4; j++) {
					nextBlc2[i][j] = new JButton("");
					nextBlc2[i][j].setBackground(Color.LIGHT_GRAY);
					nextFrm2.add(nextBlc2[i][j]);
				}
			}

			rightFrm2.setPreferredSize(new Dimension(110, 550));	//정보프레임 높이
			rightFrm2.add(nextFrm2, "North");	//정보프레임 삽입
			delLineCnt2.setPreferredSize(new Dimension(1, 100));	//게임정보 높이
			rightFrm2.add(delLineCnt2, "South");	//게임정보 삽입
			
			p2frm.add(gameFrm2, "West");
			p2frm.add(rightFrm2, "East");
			
			textArea.setPreferredSize(new Dimension(1, 130));
			add(textArea, "South");	//진행창 삽입
			add(p1frm, "East");
			add(p2frm, "West");
			
			
			
			
			

			setDefaultCloseOperation(EXIT_ON_CLOSE);
			setResizable(false);
			setVisible(true);
			setFocusable(true);
		}
	
	}
	
	public window() {}

}
