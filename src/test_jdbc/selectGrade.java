package test_jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class selectGrade {
	public static void main(String[] args) {
		
		try {
			//连接驱动
			Class.forName("com.mysql.jdbc.Driver");
			//获取连接
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/dt72","root", "123456");
			//获取执行
			Statement st = conn.createStatement();
			//sql语句
			String sql = "select * from grade";
			
			System.out.println("年级编号"+"  "+"年级");
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				System.out.println(rs.getInt("gid")+"         "+rs.getString("name"));
				
			}
			
			//关闭资源
			rs.close();  rs = null;
			st.close();  st = null;
			conn.close();  conn = null;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
