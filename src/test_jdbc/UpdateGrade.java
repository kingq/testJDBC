package test_jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class UpdateGrade {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		
		try {
			//��������
			Class.forName("com.mysql.jdbc.Driver");
			//��ȡ���Ӷ���
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/dt72", "root", "123456");
			//��ȡִ�ж���
			Statement st = conn.createStatement();
			String sql = null;
			st.executeUpdate(sql);
			
			//�ر���Դ
			st.close();
			conn.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
