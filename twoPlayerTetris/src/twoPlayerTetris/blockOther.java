package twoPlayerTetris;

import java.awt.Color;

public class blockOther {
	public static synchronized void allInit() {
		//현재 블록 모양
		tetris.nowBlcShape1 = null;
		tetris.nowBlcShape2 = null;
		//다음블록 모양
		tetris.nextBlcShape1 = null;
		tetris.nextBlcShape2 = null;
		
		//게임상태 변수
		tetris.blcmoving1 = -1;	//-1(블록이동중) 1(블록 멈춤)
		tetris.blcmoving2 = -1;	//-1(블록이동중) 1(블록 멈춤)
		//public static int next = -1;
		tetris.firstBlc1 = 0;
		tetris.firstBlc2 = 0;
		tetris.player1DelLine = 0;
		tetris.player2DelLine = 0;
		tetris.player1level = 1;
		tetris.player2level = 1;
		tetris.bottomLine1 = 19;
		tetris.bottomLine2 = 19;
		
		//블럭 상태변수
		tetris.nowBlcX1 = -1;
		tetris.nowBlcX2 = -1;	
		tetris.nowBlcY1 = -1;
		tetris.nowBlcY2 = -1;
		tetris.nowBlcW1 = -1;
		tetris.nowBlcW2 = -1;
		tetris.nowBlcH1 = -1;
		tetris.nowBlcH2 = -1;
		tetris.nowBlcType1 = -1;
		tetris.nowBlcType2 = -1;
		tetris.endRight1= -1;
		tetris.endRight2= -1;
		tetris.endDown1= -1;
		tetris.endDown2= -1;
		
		tetris.nextBlcType1 = -1;
		tetris.nextBlcType2 = -1;
		
		//블록 떨어지는 속도
		tetris.movingSec1 = 1000;
		tetris.movingSec2 = 1000;
	}
	
	public static synchronized void frmClear(int p) {	//게임판 삭제
		if(p == 1) {
			for (int i = 0; i < 20; i++) {
				for (int j = 0; j < 12; j++) {
					tetris.win.blockFrm1[i][j].setBackground(Color.LIGHT_GRAY);
					;
				}
			}
			for (int i = 0; i < 4; i++) {
				for (int j = 0; j < 4; j++) {
					tetris.win.nextBlc1[i][j].setBackground(Color.LIGHT_GRAY);
					;
				}
			}
		} else {
			for (int i = 0; i < 20; i++) {
				for (int j = 0; j < 12; j++) {
					tetris.win.blockFrm2[i][j].setBackground(Color.LIGHT_GRAY);
					;
				}
			}
			for (int i = 0; i < 4; i++) {
				for (int j = 0; j < 4; j++) {
					tetris.win.nextBlc1[i][j].setBackground(Color.LIGHT_GRAY);
					;
				}
			}
		}
	}
	
	public static synchronized void newNextBlc(int p) {	//다음블록 결정
		if (p == 1) {
			switch (tetris.nextBlcType1 = (int) (Math.random() * 6)) {
			case 0:
				tetris.nextBlcShape1 = tetris.ob.getBlock();
				break;
			case 1:
				tetris.nextBlcShape1 = tetris.ib.getBlock();
				break;
			case 2:
				tetris.nextBlcShape1 = tetris.lb.getBlock();
				break;
			case 3:
				tetris.nextBlcShape1 = tetris.jb.getBlock();
				break;
			case 4:
				tetris.nextBlcShape1 = tetris.tb.getBlock();
				break;
			case 5:
				tetris.nextBlcShape1 = tetris.sb.getBlock();
				break;
			default:
				tetris.nextBlcShape1 = tetris.zb.getBlock();
				break;
			}
			makeNextBlc(1);
		} else {
			switch (tetris.nextBlcType2 = (int) (Math.random() * 6)) {
			case 0:
				tetris.nextBlcShape2 = tetris.ob.getBlock();
				break;
			case 1:
				tetris.nextBlcShape2 = tetris.ib.getBlock();
				break;
			case 2:
				tetris.nextBlcShape2 = tetris.lb.getBlock();
				break;
			case 3:
				tetris.nextBlcShape2 = tetris.jb.getBlock();
				break;
			case 4:
				tetris.nextBlcShape2 = tetris.tb.getBlock();
				break;
			case 5:
				tetris.nextBlcShape2 = tetris.sb.getBlock();
				break;
			default:
				tetris.nextBlcShape2 = tetris.zb.getBlock();
				break;
			}
			makeNextBlc(2);
		}
	}
	
	public static synchronized void makeNextBlc(int p) {	//다음블럭 그리기
		if(p==1) {
			for (int i = 0; i < 4; i++) { // 지우기
				for (int j = 0; j < 4; j++) {
					tetris.win.nextBlc1[i][j].setBackground(Color.LIGHT_GRAY);
				}
			}
			for (int i = 0; i < tetris.nextBlcShape1.length; i++) {
				for (int j = 0; j < tetris.nextBlcShape1.length; j++) {
					if (tetris.nextBlcShape1[i][j] == 1) {
						tetris.win.nextBlc1[i][j].setBackground(Color.blue);
					}
				}
			}
		} else {
			for (int i = 0; i < 4; i++) { // 지우기
				for (int j = 0; j < 4; j++) {
					tetris.win.nextBlc2[i][j].setBackground(Color.LIGHT_GRAY);
				}
			}
			for (int i = 0; i < tetris.nextBlcShape2.length; i++) {
				for (int j = 0; j < tetris.nextBlcShape2.length; j++) {
					if (tetris.nextBlcShape2[i][j] == 1) {
						tetris.win.nextBlc2[i][j].setBackground(Color.ORANGE);
					}
				}
			}
		}
	}
	
	public static void blcEndInfo(int p) {	//블록의 경계 정보 초기화
		if(p == 1) {
			tetris.endRight1 = -1;
			tetris.endDown1 = -1;
			for (int j = tetris.nowBlcH1 - 1; j >= 0; j--) {
				for (int i = 0; i < tetris.nowBlcH1; i++) {
					if (tetris.nowBlcShape1[i][j] == 1) {
						tetris.endRight1 = j;
						break;
					}
				}
				if (tetris.endRight1 != -1)
					break;
			}
			for (int i = tetris.nowBlcH1 - 1; i >= 0; i--) {
				for (int j = 0; j < tetris.nowBlcH1; j++) {
					if (tetris.nowBlcShape1[i][j] == 1) {
						tetris.endDown1 = i;
						break;
					}
				}
				if (tetris.endDown1 != -1)
					break;
			}
		} else {
			tetris.endRight2 = -1;
			tetris.endDown2 = -1;
			for (int j = tetris.nowBlcH2 - 1; j >= 0; j--) {
				for (int i = 0; i < tetris.nowBlcH2; i++) {
					if (tetris.nowBlcShape2[i][j] == 1) {
						tetris.endRight2 = j;
						break;
					}
				}
				if (tetris.endRight2 != -1)
					break;
			}
			for (int i = tetris.nowBlcH2 - 1; i >= 0; i--) {
				for (int j = 0; j < tetris.nowBlcH2; j++) {
					if (tetris.nowBlcShape2[i][j] == 1) {
						tetris.endDown2 = i;
						break;
					}
				}
				if (tetris.endDown2 != -1)
					break;
			}
		}
	}
	
	public static synchronized void insertBlcInfo(int p) {	//블럭 정보 초기화
		if(p == 1) {
			switch (tetris.nowBlcType1) {
			case 0:
				tetris.nowBlcShape1 = tetris.ob.getBlock();
				tetris.nowBlcX1 = tetris.ob.x;
				tetris.nowBlcY1 = tetris.ob.y;
				tetris.nowBlcW1 = tetris.ob.w;
				tetris.nowBlcH1 = tetris.ob.h;
				break;
			case 1:
				tetris.nowBlcShape1 = tetris.ib.getBlock();
				tetris.nowBlcX1 = tetris.ib.x;
				tetris.nowBlcY1 = tetris.ib.y;
				tetris.nowBlcW1 = tetris.ib.w;
				tetris.nowBlcH1 = tetris.ib.h;
				break;
			case 2:
				tetris.nowBlcShape1 = tetris.lb.getBlock();
				tetris.nowBlcX1 = tetris.lb.x;
				tetris.nowBlcY1 = tetris.lb.y;
				tetris.nowBlcW1 = tetris.lb.w;
				tetris.nowBlcH1 = tetris.lb.h;
				break;
			case 3:
				tetris.nowBlcShape1 = tetris.jb.getBlock();
				tetris.nowBlcX1 = tetris.jb.x;
				tetris.nowBlcY1 = tetris.jb.y;
				tetris.nowBlcW1 = tetris.jb.w;
				tetris.nowBlcH1 = tetris.jb.h;
				break;
			case 4:
				tetris.nowBlcShape1 = tetris.tb.getBlock();
				tetris.nowBlcX1 = tetris.tb.x;
				tetris.nowBlcY1 = tetris.tb.y;
				tetris.nowBlcW1 = tetris.tb.w;
				tetris.nowBlcH1 = tetris.tb.h;
				break;
			case 5:
				tetris.nowBlcShape1 = tetris.sb.getBlock();
				tetris.nowBlcX1 = tetris.sb.x;
				tetris.nowBlcY1 = tetris.sb.y;
				tetris.nowBlcW1 = tetris.sb.w;
				tetris.nowBlcH1 = tetris.sb.h;
				break;
			default:
				tetris.nowBlcShape1 = tetris.zb.getBlock();
				tetris.nowBlcX1 = tetris.zb.x;
				tetris.nowBlcY1 = tetris.zb.y;
				tetris.nowBlcW1 = tetris.zb.w;
				tetris.nowBlcH1 = tetris.zb.h;
				break;
			}
		} else {
			switch (tetris.nowBlcType2) {
			case 0:
				tetris.nowBlcShape2 = tetris.ob.getBlock();
				tetris.nowBlcX2 = tetris.ob.x;
				tetris.nowBlcY2 = tetris.ob.y;
				tetris.nowBlcW2 = tetris.ob.w;
				tetris.nowBlcH2 = tetris.ob.h;
				break;
			case 1:
				tetris.nowBlcShape2 = tetris.ib.getBlock();
				tetris.nowBlcX2 = tetris.ib.x;
				tetris.nowBlcY2 = tetris.ib.y;
				tetris.nowBlcW2 = tetris.ib.w;
				tetris.nowBlcH2 = tetris.ib.h;
				break;
			case 2:
				tetris.nowBlcShape2 = tetris.lb.getBlock();
				tetris.nowBlcX2 = tetris.lb.x;
				tetris.nowBlcY2 = tetris.lb.y;
				tetris.nowBlcW2 = tetris.lb.w;
				tetris.nowBlcH2 = tetris.lb.h;
				break;
			case 3:
				tetris.nowBlcShape2 = tetris.jb.getBlock();
				tetris.nowBlcX2 = tetris.jb.x;
				tetris.nowBlcY2 = tetris.jb.y;
				tetris.nowBlcW2 = tetris.jb.w;
				tetris.nowBlcH2 = tetris.jb.h;
				break;
			case 4:
				tetris.nowBlcShape2 = tetris.tb.getBlock();
				tetris.nowBlcX2 = tetris.tb.x;
				tetris.nowBlcY2 = tetris.tb.y;
				tetris.nowBlcW2 = tetris.tb.w;
				tetris.nowBlcH2 = tetris.tb.h;
				break;
			case 5:
				tetris.nowBlcShape2 = tetris.sb.getBlock();
				tetris.nowBlcX2 = tetris.sb.x;
				tetris.nowBlcY2 = tetris.sb.y;
				tetris.nowBlcW2 = tetris.sb.w;
				tetris.nowBlcH2 = tetris.sb.h;
				break;
			default:
				tetris.nowBlcShape2 = tetris.zb.getBlock();
				tetris.nowBlcX2 = tetris.zb.x;
				tetris.nowBlcY2 = tetris.zb.y;
				tetris.nowBlcW2 = tetris.zb.w;
				tetris.nowBlcH2 = tetris.zb.h;
				break;
			}
		}
	}
	
	public static synchronized void initBlc(int p) {	//블럭 정보 초기화
		if (p == 1) {
			tetris.nowBlcX1 = -1;
			tetris.nowBlcY1 = -1;
			tetris.nowBlcW1 = -1;
			tetris.nowBlcH1 = -1;
			tetris.nowBlcType1 = -1;
			tetris.endRight1 = -1;
			tetris.endDown1 = -1;
		} else {
			tetris.nowBlcX2 = -1;
			tetris.nowBlcY2 = -1;
			tetris.nowBlcW2 = -1;
			tetris.nowBlcH2 = -1;
			tetris.nowBlcType2 = -1;
			tetris.endRight2 = -1;
			tetris.endDown2 = -1;
		}
	}
	
	public static synchronized void makeBadBlc(int p) {
		if(p == 1) {
			blockMoving.deleteBlc(2);
			for(int i=0; i<tetris.bottomLine2+1; i++) {
				for(int j=0; j<12; j++) {
					if(i==0)
						tetris.win.blockFrm2[i][j].setBackground(Color.LIGHT_GRAY);
					else if (i==tetris.bottomLine2) {
						if(tetris.win.blockFrm2[i][j].getBackground() == Color.black) {
							tetris.win.blockFrm2[i-1][j].setBackground(Color.black);
						}
					} else {
						if(tetris.win.blockFrm2[i][j].getBackground() == Color.black) {
							tetris.win.blockFrm2[i-1][j].setBackground(Color.black);
						}
						tetris.win.blockFrm2[i][j].setBackground(Color.LIGHT_GRAY);
					}
				}
			}
			for (int i = 0; i < 12; i++) {
				tetris.win.blockFrm2[tetris.bottomLine2][i].setBackground(Color.DARK_GRAY);
			}
 
			blockMoving.makeBlc(2);
			tetris.bottomLine2--;
		} else {
			blockMoving.deleteBlc(1);
			for(int i=0; i<tetris.bottomLine1+1; i++) {
				for(int j=0; j<12; j++) {
					if(i==0)
						tetris.win.blockFrm1[i][j].setBackground(Color.LIGHT_GRAY);
					else if (i==tetris.bottomLine1) {
						if(tetris.win.blockFrm1[i][j].getBackground() == Color.black) {
							tetris.win.blockFrm1[i-1][j].setBackground(Color.black);
						}
					} else {
						if(tetris.win.blockFrm1[i][j].getBackground() == Color.black) {
							tetris.win.blockFrm1[i-1][j].setBackground(Color.black);
						}
						tetris.win.blockFrm1[i][j].setBackground(Color.LIGHT_GRAY);
					}
				}
			}
			for (int i = 0; i < 12; i++) {
				tetris.win.blockFrm1[tetris.bottomLine1][i].setBackground(Color.DARK_GRAY);
			}
 
			blockMoving.makeBlc(1);
			tetris.bottomLine1--;
		}
	}
	
	public static synchronized void levelUpLine() {
		blockMoving.deleteBlc(1);
		for (int i = 0; i < tetris.bottomLine1 + 1; i++) {
			for (int j = 0; j < 12; j++) {
				if (i == 0)
					tetris.win.blockFrm1[i][j].setBackground(Color.LIGHT_GRAY);
				else if (i == tetris.bottomLine1) {
					if (tetris.win.blockFrm1[i][j].getBackground() == Color.black) {
						tetris.win.blockFrm1[i - 1][j].setBackground(Color.black);
					}
					tetris.win.blockFrm1[i][j].setBackground(Color.LIGHT_GRAY);
				} else {
					if (tetris.win.blockFrm1[i][j].getBackground() == Color.black) {
						tetris.win.blockFrm1[i - 1][j].setBackground(Color.black);
					}
					tetris.win.blockFrm1[i][j].setBackground(Color.LIGHT_GRAY);
				}
			}
		}
		for (int i = 0; i < 12; i++) {
			switch (((int) (Math.random() * 10) + 1) % 2) {
			case 0:
				tetris.win.blockFrm1[tetris.bottomLine1][i].setBackground(Color.black);
				break;
			default:
				break;
			}
		}

		blockMoving.makeBlc(1);

		blockMoving.deleteBlc(2);
		for (int i = 0; i < tetris.bottomLine2 + 1; i++) {
			for (int j = 0; j < 12; j++) {
				if (i == 0)
					tetris.win.blockFrm2[i][j].setBackground(Color.LIGHT_GRAY);
				else if (i == tetris.bottomLine2) {
					if (tetris.win.blockFrm2[i][j].getBackground() == Color.black) {
						tetris.win.blockFrm2[i - 1][j].setBackground(Color.black);
					}
					tetris.win.blockFrm2[i][j].setBackground(Color.LIGHT_GRAY);
				} else {
					if (tetris.win.blockFrm2[i][j].getBackground() == Color.black) {
						tetris.win.blockFrm2[i - 1][j].setBackground(Color.black);
					}
					tetris.win.blockFrm2[i][j].setBackground(Color.LIGHT_GRAY);
				}
			}
		}
		for (int i = 0; i < 12; i++) {
			switch (((int) (Math.random() * 10) + 1) % 2) {
			case 0:
				tetris.win.blockFrm2[tetris.bottomLine2][i].setBackground(Color.black);
				break;
			default:
				break;
			}
		}

		blockMoving.makeBlc(2);
	}

}
