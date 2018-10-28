package test_jdbc;

import java.util.Scanner;

public class updateFGrade {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("请输入年级号：");
		int gid = input.nextInt();
		System.out.println("请输入修改内容：");
		String name = input.next();
		
		String sql = "update grade set name = ? where gid = ?";
		
		BaseDao baseDao = new BaseDao();
		
		int temp = baseDao.executeUpdate(sql,new Object [] {name,gid});
		if(temp>0) {
			System.out.println("修改成功");
		}else {
			System.out.println("修改失败");
		}
		
		baseDao.closeAll();
		
	}
}
