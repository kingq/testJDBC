package jdbctool;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;




public class connTool {
	
	private final String driver = "com.mysql.jdbc.Driver";
	private final String url = "jdbc:mysql://localhost:3306/dt72";
	private final String username = "root";
	private final String password="123456";
	
	
	
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	int temp = 0;
	
	/**
	 * 获取jdbc连接数据库
	 */
	public void getConn() {
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, username, password);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			closeJDBC();
		}
		
	}
	
	/**
	 * 数据库的添加、删除、修改操作
	 * @param sql可带参语句
	 * @param params可多个参数
	 * @return sql的改变条数
	 */
	public int executeUpdate(String sql,Object params []) {
		try {
			getConn();
			ps = conn.prepareStatement(sql);
			for (int s = 0; s < params.length; s++) {
				ps.setObject((s+1), params[s]);
			}
			temp = ps.executeUpdate(sql);
			ps.close();ps=null;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			
		}
		return temp;
	}
	
	
	public ResultSet executeQureen(String sql,Object params []) {
		getConn();
		try {
			ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			closeJDBC();
		}
		return rs;
	}
	
	
	/**
	 * 关闭资源
	 */
	
	public void closeJDBC() {
		try {
			if(rs!=null) {
				rs.close();  rs=null;
			}
			
			if(ps!=null) {
				ps.close();ps=null;
			}
			
			if(conn!=null) {
				conn.close();conn=null;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	}
}
