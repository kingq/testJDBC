package test_jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class myjdbc {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("�������꼶���");
		int gid = input.nextInt();
		System.out.println("�������޸�����");
		String name = input.next();
		
		try {
			//��������mysql
			Class.forName("com.mysql.jdbc.Driver");
			//��ȡ���Ӷ���
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/dt72", "root", "123456");
			//��ȡִ�ж���
			Statement st = conn.createStatement();
			//ִ��sql���
			//String sql = "INSERT INTO grade(gid,NAME) VALUES(10,'ʮ�꼶')";
			//"delete from grade where gid=103"
			String sql = "update grade set name = '"+name+"' where gid = '"+gid+"'";
			int temp = st.executeUpdate(sql);
			if(temp>0) {
				System.out.println("�޸����ݳɹ�");
			}else {
				System.out.println("�޸�����ʧ��");
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
