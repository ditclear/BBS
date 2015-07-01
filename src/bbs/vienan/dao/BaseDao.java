package bbs.vienan.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BaseDao {
	protected Connection con = null;
	protected PreparedStatement ps = null;
	protected ResultSet rs = null;

	public Connection openConnection() {

		try {
			System.out.println("111");
			Class.forName("oracle.jdbc.OracleDriver");
			con = DriverManager
					.getConnection("jdbc:oracle:thin:@localhost:1521:orcl",
							"system", "System123456");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();

		}
		System.out.println("数据库连接成功");
		return con;
	}

	public void closeResouce() {
		try {
			if (rs != null)
				rs.close();
			if (ps != null)
				ps.close();
			if (con != null)
				con.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("数据库已关闭");
	}
}
