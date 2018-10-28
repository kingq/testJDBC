package jdbctool;

import java.sql.ResultSet;
import java.sql.SQLException;

public class testConn {
	public static void main(String[] args) {
		String sql = "delete from grade where gid=?";
		int gid = 101;
		connTool ct = new connTool();
		int rs = ct.executeUpdate(sql, new Object [] {gid});
		if(rs>0) {
			System.out.println("³É¹¦");
		}
	}
}
