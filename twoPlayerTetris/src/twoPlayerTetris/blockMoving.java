package twoPlayerTetris;

import java.awt.Color;

import twoPlayerTetris.tetris;
import twoPlayerTetris.window;
import twoPlayerTetris.blockOther;;

public class blockMoving {
	public static window win = new window();
	public static blockOther bo = new blockOther();
	
	//public static int moveable = -1;
	
	public static synchronized void deleteBlc(int p) {	//블록삭제
		if(p == 1) {
			for (int i = 0; i < tetris.nowBlcW1; i++) { // 이동 전 블록 삭제
				for (int j = 0; j < tetris.nowBlcH1; j++) {
					if (tetris.nowBlcShape1[i][j] == 1)
						tetris.win.blockFrm1[i + tetris.nowBlcX1][j + tetris.nowBlcY1].setBackground(Color.LIGHT_GRAY);
				}
			}
		} else {
			for (int i = 0; i < tetris.nowBlcW2; i++) { // 이동 전 블록 삭제
				for (int j = 0; j < tetris.nowBlcH2; j++) {
					if (tetris.nowBlcShape2[i][j] == 1)
						tetris.win.blockFrm2[i + tetris.nowBlcX2][j + tetris.nowBlcY2].setBackground(Color.LIGHT_GRAY);
				}
			}
		}
	}
	
	public static synchronized void makeBlc(int p) { // 블록생성
		if (p == 1) {
			for (int i = 0; i < tetris.nowBlcW1; i++) { // 이동 후 블록 생성
				for (int j = 0; j < tetris.nowBlcH1; j++) {
					if (tetris.nowBlcShape1[i][j] == 1) {
						tetris.win.blockFrm1[i + tetris.nowBlcX1][j + tetris.nowBlcY1].setBackground(Color.black);
					}
				}
			}
		} else {
			for (int i = 0; i < tetris.nowBlcW2; i++) { // 이동 후 블록 생성
				for (int j = 0; j < tetris.nowBlcH2; j++) {
					if (tetris.nowBlcShape2[i][j] == 1) {
						tetris.win.blockFrm2[i + tetris.nowBlcX2][j + tetris.nowBlcY2].setBackground(Color.black);
					}
				}
			}
		}
	}

	public static synchronized boolean moveAbleDown(int var, int p) {	//이동가능여부 판단
		if(p == 1) {
			boolean able = true;

			deleteBlc(1);

			for (int i = 0; i < tetris.nowBlcW1; i++) { // 이동 후 블록 생성
				for (int j = 0; j < tetris.nowBlcH1; j++) {
					if (tetris.nowBlcShape1[i][j] == 1
							&& ((tetris.win.blockFrm1[i + var][j + tetris.nowBlcY1].getBackground() == Color.black)
							|| (tetris.win.blockFrm1[i + var][j + tetris.nowBlcY1].getBackground() == Color.DARK_GRAY))) {
						able = false;
						makeBlc(1);
						return able;
					}
				}
			}

			return able;
		} else {
			boolean able = true;

			deleteBlc(2);

			for (int i = 0; i < tetris.nowBlcW2; i++) { // 이동 후 블록 생성
				for (int j = 0; j < tetris.nowBlcH2; j++) {
					if (tetris.nowBlcShape2[i][j] == 1
							&& ((tetris.win.blockFrm2[i + var][j + tetris.nowBlcY2].getBackground() == Color.black)
							|| (tetris.win.blockFrm2[i + var][j + tetris.nowBlcY2].getBackground() == Color.DARK_GRAY))) {
						able = false;
						makeBlc(2);
						return able;
					}
				}
			}

			return able;
		}
	}
	
	public static synchronized boolean moveAbleLeft(int var, int p) {	//이동가능여부 판단
		if(p == 1) {
			boolean able = true;

			deleteBlc(1);

			for (int i = 0; i < tetris.nowBlcW1; i++) { // 이동 후 블록 생성
				for (int j = 0; j < tetris.nowBlcH1; j++) {
					if (tetris.nowBlcShape1[i][j] == 1
							&& (tetris.win.blockFrm1[i + tetris.nowBlcX1][j + var].getBackground() == Color.black)) {
						able = false;
						makeBlc(1);
						return able;
					}
				}
			}

			return able;
		} else {
			boolean able = true;
			
			deleteBlc(2);
			
			for (int i = 0; i < tetris.nowBlcW2; i++) {	//이동 후 블록 생성
				for (int j = 0; j < tetris.nowBlcH2; j++) {
					if (tetris.nowBlcShape2[i][j] == 1 
							&& (tetris.win.blockFrm2[i + tetris.nowBlcX2][j + var].getBackground() == Color.black) ) {
						able = false;
						makeBlc(2);
						return able;
					}
				}
			}
			
			return able;
		}
	}
	
	public static synchronized boolean moveAbleRight(int var, int p) {	//이동가능여부 판단
		if(p == 1) {
			boolean able = true;

			deleteBlc(1);

			for (int i = 0; i < tetris.nowBlcW1; i++) { // 이동 후 블록 생성
				for (int j = 0; j < tetris.nowBlcH1; j++) {
					if (tetris.nowBlcShape1[i][j] == 1
							&& (tetris.win.blockFrm1[i + tetris.nowBlcX1][j + var].getBackground() == Color.black)) {
						able = false;
					}
				}
			}

			if (able == false)
				makeBlc(1);

			return able;
		} else {
			boolean able = true;

			deleteBlc(2);

			for (int i = 0; i < tetris.nowBlcW2; i++) { // 이동 후 블록 생성
				for (int j = 0; j < tetris.nowBlcH2; j++) {
					if (tetris.nowBlcShape2[i][j] == 1
							&& (tetris.win.blockFrm2[i + tetris.nowBlcX2][j + var].getBackground() == Color.black)) {
						able = false;
					}
				}
			}

			if (able == false)
				makeBlc(2);

			return able;
		}
	}
	
	public static synchronized void rotaBlc(int p) {	//블럭 회전
		if(p == 1) {
			if (tetris.nowBlcX1 + tetris.endDown1 == tetris.bottomLine1)
				return;

			deleteBlc(1);
			switch (tetris.nowBlcType1) {
			case 0:
				tetris.ob.rotate();
				tetris.nowBlcShape1 = tetris.ob.getBlock();
				break;
			case 1:
				tetris.ib.rotate();
				tetris.nowBlcShape1 = tetris.ib.getBlock();
				break;
			case 2:
				tetris.lb.rotate();
				tetris.nowBlcShape1 = tetris.lb.getBlock();
				break;
			case 3:
				tetris.jb.rotate();
				tetris.nowBlcShape1 = tetris.jb.getBlock();
				break;
			case 4:
				tetris.tb.rotate();
				tetris.nowBlcShape1 = tetris.tb.getBlock();
				break;
			case 5:
				tetris.sb.rotate();
				tetris.nowBlcShape1 = tetris.sb.getBlock();
				break;
			default:
				tetris.zb.rotate();
				tetris.nowBlcShape1 = tetris.zb.getBlock();
				break;
			}
			blockOther.blcEndInfo(1);

			if (tetris.nowBlcY1 + tetris.endRight1 == 12) {
				if (tetris.nowBlcType1 != 1)
					tetris.nowBlcY1--;
				else {
					if (tetris.nowBlcY1 == 9)
						tetris.nowBlcY1 = tetris.nowBlcY1 - 1;
				}
			} else if (tetris.nowBlcY1 + tetris.endRight1 == 13)
				tetris.nowBlcY1 = tetris.nowBlcY1 - 2;
			else if (tetris.nowBlcY1 + tetris.endRight1 == 14)
				tetris.nowBlcY1 = tetris.nowBlcY1 - 3;

			makeBlc(1);
		} else {
			if (tetris.nowBlcX2 + tetris.endDown2 == tetris.bottomLine2)
				return;

			deleteBlc(2);
			switch (tetris.nowBlcType2) {
			case 0:
				tetris.ob.rotate();
				tetris.nowBlcShape2 = tetris.ob.getBlock();
				break;
			case 1:
				tetris.ib.rotate();
				tetris.nowBlcShape2 = tetris.ib.getBlock();
				break;
			case 2:
				tetris.lb.rotate();
				tetris.nowBlcShape2 = tetris.lb.getBlock();
				break;
			case 3:
				tetris.jb.rotate();
				tetris.nowBlcShape2 = tetris.jb.getBlock();
				break;
			case 4:
				tetris.tb.rotate();
				tetris.nowBlcShape2 = tetris.tb.getBlock();
				break;
			case 5:
				tetris.sb.rotate();
				tetris.nowBlcShape2 = tetris.sb.getBlock();
				break;
			default:
				tetris.zb.rotate();
				tetris.nowBlcShape2 = tetris.zb.getBlock();
				break;
			}
			blockOther.blcEndInfo(2);

			if (tetris.nowBlcY2 + tetris.endRight2 == 12) {
				if (tetris.nowBlcType2 != 1)
					tetris.nowBlcY2--;
				else {
					if (tetris.nowBlcY2 == 9)
						tetris.nowBlcY2 = tetris.nowBlcY2 - 1;
				}
			} else if (tetris.nowBlcY2 + tetris.endRight2 == 13)
				tetris.nowBlcY2 = tetris.nowBlcY2 - 2;
			else if (tetris.nowBlcY2 + tetris.endRight2 == 14)
				tetris.nowBlcY2 = tetris.nowBlcY2 - 3;

			makeBlc(2);
		}
	}
	
	public static synchronized void downBlc(int p) {	//블록 한칸 아래로	
		if(p == 1) {
			if (tetris.nowBlcX1 + tetris.endDown1 == tetris.bottomLine1)
				return;

			if (moveAbleDown(tetris.nowBlcX1 + 1,1) == false)
				return;

			deleteBlc(1);
			tetris.nowBlcX1++;
			makeBlc(1);
		} else {
			if (tetris.nowBlcX2 + tetris.endDown2 == tetris.bottomLine2)
				return;

			if (moveAbleDown(tetris.nowBlcX2 + 1,2) == false)
				return;

			deleteBlc(2);
			tetris.nowBlcX2++;
			makeBlc(2);
		}
	}
	
	public static synchronized void leftBlc(int p) {	//블록 한칸 왼쪽으로
		if(p == 1) {
			if (tetris.nowBlcY1 - 1 == -1 || tetris.nowBlcX1 + tetris.endDown1 == tetris.bottomLine1)
				return;

			if (moveAbleLeft(tetris.nowBlcY1 - 1,1) == false)
				return;

			deleteBlc(1);
			tetris.nowBlcY1--;
			makeBlc(1);
		} else {
			if(tetris.nowBlcY2-1==-1 || tetris.nowBlcX2+tetris.endDown2==tetris.bottomLine2)
				return;
			
			if( moveAbleLeft(tetris.nowBlcY2-1,2) == false )
				return;
			
			deleteBlc(2);
			tetris.nowBlcY2--;
			makeBlc(2);
		}
	}
	
	public static synchronized void rightBlc(int p) {	//블록 한칸 오른쪽으로
		if(p == 1) {
			if(tetris.nowBlcY1+tetris.endRight1==11 || tetris.nowBlcX1+tetris.endDown1==tetris.bottomLine1)
				return;
			
			if( moveAbleRight(tetris.nowBlcY1+1,1) == false )
				return;
			
			deleteBlc(1);
			tetris.nowBlcY1++;
			makeBlc(1);
		} else {
			if (tetris.nowBlcY2 + tetris.endRight2 == 11 || tetris.nowBlcX2 + tetris.endDown2 == tetris.bottomLine2)
				return;

			if (moveAbleRight(tetris.nowBlcY2 + 1,2) == false)
				return;

			deleteBlc(2);
			tetris.nowBlcY2++;
			makeBlc(2);
		}
	}
}
