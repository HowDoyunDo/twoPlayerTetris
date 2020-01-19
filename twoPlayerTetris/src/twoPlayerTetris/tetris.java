package twoPlayerTetris;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JOptionPane;

import twoPlayerTetris.blockOther;

import blocks.IBlock;
import blocks.JBlock;
import blocks.LBlock;
import blocks.OBlock;
import blocks.SBlock;
import blocks.TBlock;
import blocks.ZBlock;


public class tetris {
	public static window win = new window("2Player Tetris");
	public static IBlock ib = new IBlock(); //블럭 객체 생성
	public static JBlock jb = new JBlock(); 
	public static LBlock lb = new LBlock(); 
	public static OBlock ob = new OBlock(); 
	public static SBlock sb = new SBlock(); 
	public static TBlock tb = new TBlock(); 
	public static ZBlock zb = new ZBlock(); 
	
	//현재 블록 모양
	public static int[][] nowBlcShape1;
	public static int[][] nowBlcShape2;
	//다음블록 모양
	public static int[][] nextBlcShape1;
	public static int[][] nextBlcShape2;
	
	//게임상태 변수
	public static int blcmoving1 = -1;	//-1(블록이동중) 1(블록 멈춤)
	public static int blcmoving2 = -1;	//-1(블록이동중) 1(블록 멈춤)
	//public static int next = -1;
	public static int state = 0;	//0(첫 시작대기) 1(진행중) 2(재시작 대기)
	public static int firstBlc1 = 0;
	public static int firstBlc2 = 0;
	public static int player1DelLine = 0;
	public static int player2DelLine = 0;
	public static int player1level = 1;
	public static int player2level = 1;
	public static int bottomLine1 = 19;
	public static int bottomLine2 = 19;
	
	//블럭 상태변수
	public static int nowBlcX1 = -1;
	public static int nowBlcX2 = -1;	
	public static int nowBlcY1 = -1;
	public static int nowBlcY2 = -1;
	public static int nowBlcW1 = -1;
	public static int nowBlcW2 = -1;
	public static int nowBlcH1 = -1;
	public static int nowBlcH2 = -1;
	public static int nowBlcType1 = -1;
	public static int nowBlcType2 = -1;
	public static int endRight1= -1;
	public static int endRight2= -1;
	public static int endDown1= -1;
	public static int endDown2= -1;
	
	public static int nextBlcType1 = -1;
	public static int nextBlcType2 = -1;
	
	//블록 떨어지는 속도
	public static double movingSec1 = 1000;
	public static double movingSec2 = 1000;
	
	public static String winnerName= "";
	public static String loserName= "";
	
	public static synchronized void main(String[] args) {
		Thread1of1 newBlc1 = new Thread1of1();
		Thread1of2 downBlc1 = new Thread1of2();
		
		Thread2of1 newBlc2 = new Thread2of1();
		Thread2of2 downBlc2 = new Thread2of2();
		
		
		win.addKeyListener(new KeyListener() {
			
			@Override
			public void keyPressed(KeyEvent e) {	//테트리스 조작 
				switch(e.getKeyCode()){
		     	case KeyEvent.VK_UP:
		     		blockMoving.rotaBlc(1);
		     		break;
		     	case KeyEvent.VK_DOWN:
		     		blockMoving.downBlc(1);
		     		break;
		     	case KeyEvent.VK_LEFT:
		     		blockMoving.leftBlc(1);
		     		break;
		     	case KeyEvent.VK_RIGHT:
		     		blockMoving.rightBlc(1);
		     		break;
		     	case KeyEvent.VK_SPACE:
		     		if(state == 2) {	//재시작 대기
						/*
						 * blockOther.frmClear(1); //화면 삭제 blockOther.frmClear(2);
						 * 
						 * newBlc1.interrupt(); newBlc2.interrupt(); downBlc1.interrupt();
						 * downBlc2.interrupt();
						 * 
						 * Thread1of1 newBlc1 = new Thread1of1(); //새 게임 스레드 생성 Thread1of2 downBlc1 =
						 * new Thread1of2(); Thread2of1 newBlc2 = new Thread2of1(); Thread2of2 downBlc2
						 * = new Thread2of2();
						 * 
						 * newBlc1.start(); newBlc2.start();
						 */
		     			//downBlc1.start();
		     			//downBlc2.start();

		     		} else if (state == 0) {	//첫 시작대기
			     		newBlc1.start();
			     		newBlc2.start();
			     		downBlc1.start();
			     		downBlc2.start();
			     		
			     		window.gameMent = " ■시작합니다.■\n\n" 
			     				+ "<Left Player Key>		* 총 10줄 삭제 시 레벨업\n" 
			     				+ "   W S A D			* 3줄 삭제 시 상대 배드블럭 등장\n" 
			     				+ "<Right Player Key>		* 레벨 업 시 랜덤 한 라인 증가, 스피드 0.1초 증가\n" 
			     				+ "   ↑ ↓ ← →\n";
			     		win.textArea.setText(window.gameMent);
			     		state = 1;
		     		} 
		     		break;
		     	case KeyEvent.VK_W:
		     		blockMoving.rotaBlc(2);
		     		break;
		     	case KeyEvent.VK_S:
		     		blockMoving.downBlc(2);
		     		break;
		     	case KeyEvent.VK_A:
		     		blockMoving.leftBlc(2);
		     		break;
		     	case KeyEvent.VK_D:
		     		blockMoving.rightBlc(2);
		     		break;
				}
				
				
			}

			@Override
			public void keyReleased(KeyEvent e) {}
			
			@Override
			public void keyTyped(KeyEvent e) {}
			
		});
		
		
		
	}
	

	
}

class Thread1of1 extends Thread{	//블럭 생성 스레드

	public void run(){
		synchronized (this) {
			
			while (true) {
				if (tetris.state == 1) {
					if (tetris.blcmoving1 == 1) {
						System.out.println("thrd1. tetris.blcmoving : " + tetris.blcmoving1);
						continue;
					}
					else {
						
						/*@@@@@@@@@@@ 줄 삭제 코드 @@@@@@@@@@@*/
						for(int i=19; i>=0; i--) {
							for(int j=0; j<12; j++) {
								
								if( tetris.win.blockFrm1[i][j].getBackground() != Color.black ) 
									break;	//하나라도 검은블록이 아니면 다음줄 체크
								if( j==11 && (tetris.win.blockFrm1[i][j].getBackground() == Color.black) ) {	//그 줄의 마지막 블록까지 검은 블록이면
									for (int n = 0; n < 12; n++) { // 줄삭제
										tetris.win.blockFrm1[i][n].setBackground(Color.LIGHT_GRAY);
									}
									tetris.player1DelLine++;
								
									if( (tetris.player1DelLine+tetris.player2DelLine) != 0 && ((tetris.player1DelLine+tetris.player2DelLine) % 10) == 0) {	//10줄 삭제 시 레벨 업, 레벨 당 블록 하강속도 0.2초증가
										blockOther.levelUpLine();
										if(tetris.player1level<8) { 
											++tetris.player1level; ++tetris.player2level;  
											tetris.movingSec1 = tetris.movingSec1-100;
											tetris.movingSec2 = tetris.movingSec2-100;
										}
									}
									
									if( tetris.player1DelLine != 0 && (tetris.player1DelLine % 3) == 0) {	//3줄 삭제시 상대 베드블럭
										blockOther.makeBadBlc(1);
									}
										
									for (int k = i - 1; k >= 0; k--) { // 블록 내리기
										for (int l = 0; l < 12; l++) {

											if (tetris.win.blockFrm1[k][l].getBackground() == Color.black) {
												tetris.win.blockFrm1[k][l].setBackground(Color.LIGHT_GRAY);
												tetris.win.blockFrm1[k + 1][l].setBackground(Color.black);
											}
										}
									}
									if(i!=19)
										i++;
									//게임정보 업데이트
									window.label1 = "Delete Line : " + tetris.player1DelLine + "\nLevel : " + tetris.player1level
											+ "\nSpeed : " + (tetris.movingSec1/1000) + "sec";
									tetris.win.delLineCnt1.setText(window.label1);
								}
								
							}
						}
						
						if (tetris.firstBlc1 == 0) { // 첫블럭 판단
							tetris.nowBlcType1 = (int) (Math.random() * 6);
							blockOther.insertBlcInfo(1);
							blockOther.newNextBlc(1);
							tetris.firstBlc1++;
						} else {	// 첫블럭 아닐 때
							tetris.nowBlcType1 = tetris.nextBlcType1;
							blockOther.insertBlcInfo(1);
							blockOther.newNextBlc(1);
							tetris.firstBlc1++;
							
							/*@@@@@@@@@@@ 게임 종료 판단 @@@@@@@@@@@*/
							//생성블록 내리기 불가능 일 때
							if(blockMoving.moveAbleDown(tetris.nowBlcX1+1,1) == false) {
								tetris.state = 2;
								window.gameMent = " ■왼쪽 플레이어 승리!■ \n\n" 
					     				+ "<Left Player Key>		* 총 10줄 삭제 시 레벨업\n" 
					     				+ "   W S A D			* 3줄 삭제 시 상대 배드블럭 등장\n" 
					     				+ "<Right Player Key>		* 레벨 업 시 랜덤 한 라인 증가, 스피드 0.1초 증가\n" 
					     				+ "   ↑ ↓ ← →\n";
								tetris.win.textArea.setText(window.gameMent);
								
								
								blockOther.allInit(); 
								//Thread1of2.interrupted(); //모든 스레드 종료
								//Thread2of2.interrupted(); 
								//Thread2of1.interrupted(); 
								//interrupted(); //현재스레드 종료 
								//tetris.winnerName = JOptionPane.showInputDialog("승자의 이름을 입력하세요.");
								//tetris.loserName = JOptionPane.showInputDialog("패자의 이름을 입력하세요.");
								
								//디비 실행결과
								rankDbAccess rank = new rankDbAccess();
								rank.aaa();
								System.out.println(rankDbAccess.all);
								//JOptionPane.showMessageDialog(null, rank);
								
								break;
								 
							}
						}

						blockOther.blcEndInfo(1);

						blockMoving.makeBlc(1);

						tetris.blcmoving1 = 1;
					}
				}
			}
		}
	}

}

class Thread1of2 extends Thread {	//블럭 떨어지는 스레드

	public void run(){
		synchronized (this) {
			
			while(true) {
				System.out.println("thrd1");

				if( tetris.nowBlcX1+tetris.endDown1 == tetris.bottomLine1 || (blockMoving.moveAbleDown(tetris.nowBlcX1+1,1) == false) ) {
					tetris.blcmoving1 = -1;
					blockOther.initBlc(1);
					yield();
					continue;
				}
					
				blockMoving.makeBlc(1);
				
				tetris.win.setFocusable(true);	//지속적 조작을 위한 포커싱
				
				
				try {
					Thread.sleep((int)tetris.movingSec1);	//블럭 떨어지는 시간간격
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				blockMoving.downBlc(1);
			}
			
		}
	}

}

class Thread2of1 extends Thread{	//블럭 생성 스레드

	public void run(){
		synchronized (this) {
			
			while (true) {
				if (tetris.state == 1) {
					if (tetris.blcmoving2 == 1) {
						System.out.println("thrd2. tetris.blcmoving : " + tetris.blcmoving2);
						continue;
					}
					else {
						
						/*@@@@@@@@@@@ 줄 삭제 코드 @@@@@@@@@@@*/
						for(int i=19; i>=0; i--) {
							for(int j=0; j<12; j++) {
								
								if( tetris.win.blockFrm2[i][j].getBackground() != Color.black ) 
									break;	//하나라도 검은블록이 아니면 다음줄 체크
								if( j==11 && (tetris.win.blockFrm2[i][j].getBackground() == Color.black) ) {	//그 줄의 마지막 블록까지 검은 블록이면
									for (int n = 0; n < 12; n++) { // 줄삭제
										tetris.win.blockFrm2[i][n].setBackground(Color.LIGHT_GRAY);
									}
									tetris.player2DelLine++;
								 
									if( (tetris.player1DelLine+tetris.player2DelLine) != 0 && ((tetris.player1DelLine+tetris.player2DelLine) % 10) == 0) {	//10줄 삭제 시 레벨 업, 레벨 당 블록 하강속도 0.2초증가
										blockOther.levelUpLine();
										if(tetris.player1level<8) { 
											++tetris.player1level; ++tetris.player2level;  
											tetris.movingSec1 = tetris.movingSec1-100;
											tetris.movingSec2 = tetris.movingSec2-100;
										}
									}
									
									if( tetris.player2DelLine != 0 && (tetris.player2DelLine % 3) == 0) {	//3줄 삭제시 상대 베드블럭
										blockOther.makeBadBlc(2);
									}
										
									for (int k = i - 1; k >= 0; k--) { // 블록 내리기
										for (int l = 0; l < 12; l++) {

											if (tetris.win.blockFrm2[k][l].getBackground() == Color.black) {
												tetris.win.blockFrm2[k][l].setBackground(Color.LIGHT_GRAY);
												tetris.win.blockFrm2[k + 1][l].setBackground(Color.black);
											}
										}
									}
									if(i!=19)
										i++;
									//게임정보 업데이트 
									window.label2 = "Delete Line : " + tetris.player2DelLine + "\nLevel : " + tetris.player2level
											+ "\nSpeed : " + (tetris.movingSec2/1000) + "sec";
									tetris.win.delLineCnt2.setText(window.label2);
								}
								
							}
						}
						
						if (tetris.firstBlc2 == 0) { // 첫블럭 판단
							tetris.nowBlcType2 = (int) (Math.random() * 6);
							blockOther.insertBlcInfo(2);
							blockOther.newNextBlc(2);
							tetris.firstBlc2++;
						} else {	// 첫블럭 아닐 때
							tetris.nowBlcType2 = tetris.nextBlcType2;
							blockOther.insertBlcInfo(2);
							blockOther.newNextBlc(2);
							tetris.firstBlc2++;
							
							// 생성블록 내리기 불가능 일 때
							
							/*@@@@@@@@@@@ 게임 종료 판단 @@@@@@@@@@@*/
							//생성블록 내리기 불가능 일 때
							if(blockMoving.moveAbleDown(tetris.nowBlcX2+1,2) == false) {
								tetris.state = 2;
								window.gameMent = " ■오른쪽 플레이어 승리!■ \n\n" 
					     				+ "<Left Player Key>		* 총 10줄 삭제 시 레벨업\n" 
					     				+ "   W S A D			* 3줄 삭제 시 상대 배드블럭 등장\n" 
					     				+ "<Right Player Key>		* 레벨 업 시 랜덤 한 라인 증가, 스피드 0.1초 증가\n" 
					     				+ "   ↑ ↓ ← →\n";
								tetris.win.textArea.setText(window.gameMent);
								
								blockOther.allInit();
					     		//Thread1of2.interrupted();	//모든 스레드 종료
					     		//Thread2of2.interrupted();	
								//Thread1of1.interrupted();	
								//interrupted();	//현재 스레드 종료
								tetris.winnerName = JOptionPane.showInputDialog("승자의 이름을 입력하세요.");
								tetris.loserName = JOptionPane.showInputDialog("패자의 이름을 입력하세요.");
								JOptionPane.showMessageDialog(null, "");
								
								break;
							}
						}

						blockOther.blcEndInfo(2);

						blockMoving.makeBlc(2);

						tetris.blcmoving2 = 1;
					}
				}
			}
		
		}
	}

}

class Thread2of2 extends Thread {	//블럭 떨어지는 스레드

	public void run(){
		synchronized (this) {
			
			while(true) {
				System.out.println("thrd2");

				if( tetris.nowBlcX2+tetris.endDown2 == tetris.bottomLine2 || (blockMoving.moveAbleDown(tetris.nowBlcX2+1,2) == false) ) {
					tetris.blcmoving2 = -1;
					yield();
					continue;
				}
					
				blockMoving.makeBlc(2);
				
				tetris.win.setFocusable(true);	//지속적 조작을 위한 포커싱
				
				
				try {
					Thread.sleep((int)tetris.movingSec2);	//블럭 떨어지는 시간간격
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				blockMoving.downBlc(2);
				
			}
			
		}
	}

}