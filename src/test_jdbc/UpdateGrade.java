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
			//连接驱动
			Class.forName("com.mysql.jdbc.Driver");
			//获取连接对象
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/dt72", "root", "123456");
			//获取执行对象
			Statement st = conn.createStatement();
			String sql = null;
			st.executeUpdate(sql);
			
			//关闭资源
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
