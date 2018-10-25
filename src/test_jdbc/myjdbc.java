package test_jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class myjdbc {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("请输入年级编号");
		int gid = input.nextInt();
		System.out.println("请输入修改内容");
		String name = input.next();
		
		try {
			//创建驱动mysql
			Class.forName("com.mysql.jdbc.Driver");
			//获取连接对象
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/dt72", "root", "123456");
			//获取执行对象
			Statement st = conn.createStatement();
			//执行sql语句
			//String sql = "INSERT INTO grade(gid,NAME) VALUES(10,'十年级')";
			//"delete from grade where gid=103"
			String sql = "update grade set name = '"+name+"' where gid = '"+gid+"'";
			int temp = st.executeUpdate(sql);
			if(temp>0) {
				System.out.println("修改数据成功");
			}else {
				System.out.println("修改数据失败");
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
