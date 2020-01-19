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
	public static String gameMent = " �ὺ���̽��ٸ� ������ �����մϴ�.��\n\n" 
				+ "<Left Player Key>		* �� 10�� ���� �� ������\n" 
				+ "   W S A D			* 3�� ���� �� ��� ���� ����\n" 
				+ "<Right Player Key>		* ���� �� �� ���� �� ���� ����, ���ǵ� 0.1�� ����\n" 
				+ "   �� �� �� ��\n";
	JButton[][] blockFrm1 = new JButton[20][12];	//��Ʈ���� ���� ������
	JButton[][] blockFrm2 = new JButton[20][12];	//��Ʈ���� ���� ������
	JButton[][] nextBlc1 = new JButton[4][4];
	JButton[][] nextBlc2 = new JButton[4][4];
	JTextArea textArea = new JTextArea(gameMent);
	JTextArea delLineCnt1 = new JTextArea(label1);
	JTextArea delLineCnt2 = new JTextArea(label1);
	

	public window(String title) {
		synchronized (this) {
			setSize(860, 650);
			setTitle(title);
			setLocationRelativeTo(null); // ������ ȭ�� �߾�
			
			
			
			setLayout(new BorderLayout(1, 1));	//��ü ���̾ƿ�
			
			JPanel p1frm = new JPanel();	//p1������
			JPanel p2frm = new JPanel();	//p2������
			
			p1frm.setLayout(new BorderLayout(1, 1));
			p2frm.setLayout(new BorderLayout(1, 1));
			
			
			
			/*@@@@@@@@@@@@@@	1pȭ��	@@@@@@@@@@@@@*/
			JPanel gameFrm1 = new JPanel();	//����������
			JPanel rightFrm1 = new JPanel();	//����������
			rightFrm1.setLayout(new BorderLayout(20, 20));	//���������� ��ġ

			JPanel nextFrm1 = new JPanel();	//���� ���������
			nextFrm1.setPreferredSize(new Dimension(1, 92));	//������������� ����
			nextFrm1.setLayout(new GridLayout(4, 4, 1, 1));	//���� ��������� ����

			gameFrm1.setBorder(new TitledBorder(new LineBorder(Color.BLACK, 5), "Game")); // ���������� �׵θ�
			rightFrm1.setBorder(new TitledBorder(new LineBorder(Color.BLACK, 5), "Next Block")); // ���������� �׵θ�

			gameFrm1.setPreferredSize(new Dimension(300, 550));	//���������� �ʺ�
			gameFrm1.setLayout(new GridLayout(20, 12, 1, 1));	//���������� ����

			for (int i = 0; i < 20; i++) {	//���������� ��� ����
				for (int j = 0; j < 12; j++) {
					blockFrm1[i][j] = new JButton("");
					blockFrm1[i][j].setBackground(Color.LIGHT_GRAY);
					gameFrm1.add(blockFrm1[i][j]);
				}
			}
			for (int i = 0; i < 4; i++) {	//���������� ��� ����
				for (int j = 0; j < 4; j++) {
					nextBlc1[i][j] = new JButton("");
					nextBlc1[i][j].setBackground(Color.LIGHT_GRAY);
					nextFrm1.add(nextBlc1[i][j]);
				}
			}

			rightFrm1.setPreferredSize(new Dimension(110, 550));	//���������� ����
			rightFrm1.add(nextFrm1, "North");	//���������� ����
			delLineCnt1.setPreferredSize(new Dimension(1, 100));	//�������� ����
			rightFrm1.add(delLineCnt1, "South");	//�������� ����
			
			p1frm.add(gameFrm1, "West");
			p1frm.add(rightFrm1, "East");
			
			
			/*@@@@@@@@@@@@@@	2pȭ��	@@@@@@@@@@@@@*/
			JPanel gameFrm2 = new JPanel();	//����������
			JPanel rightFrm2 = new JPanel();	//����������
			rightFrm2.setLayout(new BorderLayout(20, 20));	//���������� ��ġ

			JPanel nextFrm2 = new JPanel();	//���� ���������
			nextFrm2.setPreferredSize(new Dimension(1, 92));	//������������� ����
			nextFrm2.setLayout(new GridLayout(4, 4, 1, 1));	//���� ��������� ����

			gameFrm2.setBorder(new TitledBorder(new LineBorder(Color.BLACK, 5), "Game")); // ���������� �׵θ�
			rightFrm2.setBorder(new TitledBorder(new LineBorder(Color.BLACK, 5), "Next Block")); // ���������� �׵θ�

			gameFrm2.setPreferredSize(new Dimension(300, 550));	//���������� �ʺ�
			gameFrm2.setLayout(new GridLayout(20, 12, 1, 1));	//���������� ����

			for (int i = 0; i < 20; i++) {	//���������� ��� ����
				for (int j = 0; j < 12; j++) {
					blockFrm2[i][j] = new JButton("");
					blockFrm2[i][j].setBackground(Color.LIGHT_GRAY);
					gameFrm2.add(blockFrm2[i][j]);
				}
			}
			for (int i = 0; i < 4; i++) {	//���������� ��� ����
				for (int j = 0; j < 4; j++) {
					nextBlc2[i][j] = new JButton("");
					nextBlc2[i][j].setBackground(Color.LIGHT_GRAY);
					nextFrm2.add(nextBlc2[i][j]);
				}
			}

			rightFrm2.setPreferredSize(new Dimension(110, 550));	//���������� ����
			rightFrm2.add(nextFrm2, "North");	//���������� ����
			delLineCnt2.setPreferredSize(new Dimension(1, 100));	//�������� ����
			rightFrm2.add(delLineCnt2, "South");	//�������� ����
			
			p2frm.add(gameFrm2, "West");
			p2frm.add(rightFrm2, "East");
			
			textArea.setPreferredSize(new Dimension(1, 130));
			add(textArea, "South");	//����â ����
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
