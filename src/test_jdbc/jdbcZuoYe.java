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
		System.out.println("�꼶����ϵͳ��");
		System.out.println("1.����꼶  2.�޸��꼶  3.ɾ���꼶 4.��ѯ�꼶");
		int menu = input.nextInt();
		Statement st = getConn();
		String sql = null;
		int temp;
		String name = null;
		int gid;
		switch (menu) {
		case 1:
			System.out.println("����꼶");
			System.out.println("�������꼶���");
			gid = input.nextInt();
			System.out.println("�������꼶");
			name = input.next();
			sql = "insert into grade (gid,name) values('"+gid+"','"+name+"')";
			try {
				temp = st.executeUpdate(sql);
				if(temp>0) {
					System.out.println("����꼶�ɹ�");
				}else {
					System.out.println("����꼶ʧ��");
				}
				closeConn();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			System.out.println("�Ƿ񷵻�ϵͳy/n");
			fage = input.next();
			break;
		case 2:
			System.out.println("�޸��꼶");
			System.out.println("�������꼶���");
			gid = input.nextInt();
			System.out.println("�������꼶");
			name = input.next();
			sql = "update grade set name='"+name+"' where gid='"+gid+"' ";
			try {
				temp = st.executeUpdate(sql);
				if(temp>0) {
					System.out.println("�޸��꼶�ɹ�");
				}else {
					System.out.println("�޸��꼶ʧ��");
				}
				closeConn();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			System.out.println("�Ƿ񷵻�ϵͳy/n");
			fage = input.next();
			break;
		case 3:
			System.out.println("ɾ���꼶");
			System.out.println("�������꼶���");
			gid = input.nextInt();
			sql = "delete from grade where gid='"+gid+"'";
			try {
				temp = st.executeUpdate(sql);
				if(temp>0) {
					System.out.println("ɾ���꼶�ɹ�");
				}else {
					System.out.println("ɾ���꼶ʧ��");
				}
				closeConn();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			System.out.println("�Ƿ񷵻�ϵͳy/n");
			fage = input.next();
			break;
		case 4:
			
			sql = "select * from grade";
			try {
				ResultSet rs = st.executeQuery(sql);
				while(rs.next()) {
					System.out.println(rs.getInt("gid")+"   "+rs.getString("name"));
				}
				//�ر���Դ
				rs.close(); rs=null;
				closeConn();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("�Ƿ񷵻�ϵͳy/n");
			fage = input.next();
			break;

		default:
			System.out.println("ϵͳ�������������޴˹���");
			System.out.println("�Ƿ񷵻�ϵͳy/n");
			fage = input.next();
			break;
		}
		} while(fage.equals("y"));
		System.out.println("�����˳�ϵͳ");
	}


	public static Statement getConn() {
		
		try {
			//jdbc��������
			Class.forName("com.mysql.jdbc.Driver");
			//��ȡ����
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/dt72", "root", "123456");
			//��ȡִ�ж���
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
