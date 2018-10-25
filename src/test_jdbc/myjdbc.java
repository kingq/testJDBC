package test_jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class myjdbc {
	public static void main(String[] args) {
		try {
			//创建驱动mysql
			Class.forName("com.mysql.jdbc.Driver");
			//获取连接对象
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/dt72", "root", "123456");
			//获取执行对象
			Statement st = conn.createStatement();
			//执行sql语句
			String sql = "INSERT INTO grade(gid,NAME) VALUES(10,'十年级')";
			int temp = st.executeUpdate(sql);
			if(temp>0) {
				System.out.println("添加数据成功");
			}else {
				System.out.println("添加数据失败");
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
