package test_jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class jdbcZuoYe {
	static Connection conn = null;
	static Statement st = null;
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String fage = null;
		do {
		System.out.println("年级管理系统：");
		System.out.println("1.添加年级  2.修改年级  3.删除年级 4.查询年级");
		int menu = input.nextInt();
		Statement st = getConn();
		String sql = null;
		int temp;
		String name = null;
		int gid;
		switch (menu) {
		case 1:
			System.out.println("添加年级");
			System.out.println("请输入年级编号");
			gid = input.nextInt();
			System.out.println("请输入年级");
			name = input.next();
			sql = "insert into grade (gid,name) values('"+gid+"','"+name+"')";
			try {
				temp = st.executeUpdate(sql);
				if(temp>0) {
					System.out.println("添加年级成功");
				}else {
					System.out.println("添加年级失败");
				}
				closeConn();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			System.out.println("是否返回系统y/n");
			fage = input.next();
			break;
		case 2:
			System.out.println("修改年级");
			System.out.println("请输入年级编号");
			gid = input.nextInt();
			System.out.println("请输入年级");
			name = input.next();
			sql = "update grade set name='"+name+"' where gid='"+gid+"' ";
			try {
				temp = st.executeUpdate(sql);
				if(temp>0) {
					System.out.println("修改年级成功");
				}else {
					System.out.println("修改年级失败");
				}
				closeConn();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			System.out.println("是否返回系统y/n");
			fage = input.next();
			break;
		case 3:
			System.out.println("删除年级");
			System.out.println("请输入年级编号");
			gid = input.nextInt();
			sql = "delete from grade where gid='"+gid+"'";
			try {
				temp = st.executeUpdate(sql);
				if(temp>0) {
					System.out.println("删除年级成功");
				}else {
					System.out.println("删除年级失败");
				}
				closeConn();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			System.out.println("是否返回系统y/n");
			fage = input.next();
			break;
		case 4:
			
			sql = "select * from grade";
			try {
				ResultSet rs = st.executeQuery(sql);
				while(rs.next()) {
					System.out.println(rs.getInt("gid")+"   "+rs.getString("name"));
				}
				//关闭资源
				rs.close(); rs=null;
				closeConn();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("是否返回系统y/n");
			fage = input.next();
			break;

		default:
			System.out.println("系统正在升级，暂无此功能");
			System.out.println("是否返回系统y/n");
			fage = input.next();
			break;
		}
		} while(fage.equals("y"));
		System.out.println("您已退出系统");
	}


	public static Statement getConn() {
		
		try {
			//jdbc连接驱动
			Class.forName("com.mysql.jdbc.Driver");
			//获取连接
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/dt72", "root", "123456");
			//获取执行对象
			st = conn.createStatement();
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return st;
	}
	
	
	public static void closeConn() {
		try {
			conn.close();
			conn=null;
			st.close();
			st=null;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
