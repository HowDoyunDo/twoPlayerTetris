package twoPlayerTetris;

import java.sql.*;

public class rankDbAccess {
	//DB사용 변수
	private final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver"; //드라이버
	private final String DB_URL = "jdbc:mysql://localhost/student_db?&useSSL=false"; //접속할 DB 서버
	
	private final String USER_NAME = "student_manager"; //DB에 접속할 사용자 이름을 상수로 정의SS
	private final String PASSWORD = "student0509"; //사용자의 비밀번호를 상수로 정의
	
	public static String all = "!";
	
	public rankDbAccess() {
		
	}

	public void aaa() {
		Connection conn = null; 
		Statement state = null; 
		
	    try{
	    	//리플렉션 방식s
			Class.forName(JDBC_DRIVER);	//드라이버 경로 전달 / 해당 드라이버 미존재 시 예외 전달 / 성공 시 드라이버 사용 가능 
			conn = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);	//sql문 실행을 위해 연결정보를 state로 생성 해야함
			state = conn.createStatement();	//statement객체 반환 성공 시 sql문 실행 가능
			String sql; //SQL문을 저장할 String
			ResultSet rs = state.executeQuery("SELECT * FROM student"); //SQL문을 전달하여 실행
							
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

			//sql문 실행 종료 시 연결 닫기
			rs.close();
			state.close();
			conn.close();
			
		} catch (Exception e) {
			// 예외 발생 시 처리부분

		} finally { // 예외가 있든 없든 무조건 실행
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
