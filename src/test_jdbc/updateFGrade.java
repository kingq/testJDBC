package test_jdbc;

import java.util.Scanner;

public class updateFGrade {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("�������꼶�ţ�");
		int gid = input.nextInt();
		System.out.println("�������޸����ݣ�");
		String name = input.next();
		
		String sql = "update grade set name = ? where gid = ?";
		
		BaseDao baseDao = new BaseDao();
		
		int temp = baseDao.executeUpdate(sql,new Object [] {name,gid});
		if(temp>0) {
			System.out.println("�޸ĳɹ�");
		}else {
			System.out.println("�޸�ʧ��");
		}
		
		baseDao.closeAll();
		
	}
}
