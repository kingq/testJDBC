package test_jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class selectGrade {
	public static void main(String[] args) {
		
		try {
			//��������
			Class.forName("com.mysql.jdbc.Driver");
			//��ȡ����
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/dt72","root", "123456");
			//��ȡִ��
			Statement st = conn.createStatement();
			//sql���
			String sql = "select * from grade";
			
			System.out.println("�꼶���"+"  "+"�꼶");
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				System.out.println(rs.getInt("gid")+"         "+rs.getString("name"));
				
			}
			
			//�ر���Դ
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
