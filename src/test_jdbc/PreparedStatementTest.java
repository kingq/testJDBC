package test_jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PreparedStatementTest {
	public static void main(String[] args) {
		
		try {
			//��������
			Class.forName("com.mysql.jdbc.Driver");
			//���Ӷ���
			Connection conn = DriverManager.getConnection("jdbc:mysql://lacolhost:3306/dt72", "root", "123456");
			//ִ�ж���
			String sql = null;
			int gid = 0;
			String name = null;
			PreparedStatement sp = conn.prepareStatement(sql);
			sp.setInt(1, gid);
			sp.setString(1, name);
			ResultSet rs = sp.executeQuery(sql);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
