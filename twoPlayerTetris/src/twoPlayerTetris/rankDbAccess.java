package twoPlayerTetris;

import java.sql.*;

public class rankDbAccess {
	//DB��� ����
	private final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver"; //����̹�
	private final String DB_URL = "jdbc:mysql://localhost/student_db?&useSSL=false"; //������ DB ����
	
	private final String USER_NAME = "student_manager"; //DB�� ������ ����� �̸��� ����� ����SS
	private final String PASSWORD = "student0509"; //������� ��й�ȣ�� ����� ����
	
	public static String all = "!";
	
	public rankDbAccess() {
		
	}

	public void aaa() {
		Connection conn = null; 
		Statement state = null; 
		
	    try{
	    	//���÷��� ���s
			Class.forName(JDBC_DRIVER);	//����̹� ��� ���� / �ش� ����̹� ������ �� ���� ���� / ���� �� ����̹� ��� ���� 
			conn = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);	//sql�� ������ ���� ���������� state�� ���� �ؾ���
			state = conn.createStatement();	//statement��ü ��ȯ ���� �� sql�� ���� ����
			String sql; //SQL���� ������ String
			ResultSet rs = state.executeQuery("SELECT * FROM student"); //SQL���� �����Ͽ� ����
							
			while(rs.next()){
				String number = rs.getString("_number");
				String name = rs.getString("name");
				String kor = rs.getString("kor");
				String math = rs.getString("math");
				String eng = rs.getString("eng");
				System.out.println("Number: "+ number + "\nName: " + name + "\nKOR: " + kor); 
				System.out.println("MATH: "+ math + "\nENG: " + eng + "\n-------------\n");
				
				all += number;
				all += name;
				all += kor;
				all += math;
				all += eng;
			}

			//sql�� ���� ���� �� ���� �ݱ�
			rs.close();
			state.close();
			conn.close();
			
		} catch (Exception e) {
			// ���� �߻� �� ó���κ�

		} finally { // ���ܰ� �ֵ� ���� ������ ����
			try {
				if (state != null)
					state.close();
			} catch (SQLException ex1) {
				//
			}

			try {
				if (conn != null)
					conn.close();
			} catch (SQLException ex1) {
				//
			}
		}
	    
	}
}
