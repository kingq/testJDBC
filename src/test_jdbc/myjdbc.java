package test_jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class myjdbc {
	public static void main(String[] args) {
		try {
			//��������mysql
			Class.forName("com.mysql.jdbc.Driver");
			//��ȡ���Ӷ���
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/dt72", "root", "123456");
			//��ȡִ�ж���
			Statement st = conn.createStatement();
			//ִ��sql���
			String sql = "INSERT INTO grade(gid,NAME) VALUES(10,'ʮ�꼶')";
			int temp = st.executeUpdate(sql);
			if(temp>0) {
				System.out.println("������ݳɹ�");
			}else {
				System.out.println("�������ʧ��");
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
