package com.baidu.qa.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.log4j.Logger;
import com.mysql.jdbc.PreparedStatement;

public class MySQLHelper {
	private static Logger LOG = Logger.getLogger(MySQLHelper.class.getName());
	private static final String DRIVER_NAME = "com.mysql.jdbc.Driver";
	private Connection connection = null;
	private String url = "jdbc:mysql://";
	private String user = null;
	private String password = null;
	private Statement stmt = null;
	private PreparedStatement pStmt = null;
	private ResultSet rs = null;

	private MySQLHelper() {
	}

	public MySQLHelper(String ip, int port, String user, String password, String dbName) throws ClassNotFoundException, SQLException {
		this.url = this.url + ip + ":" + port + "/" + dbName;
		this.user = user;
		this.password = password;
	}

	public void open() throws ClassNotFoundException, SQLException {
		Class.forName(DRIVER_NAME);
		if (connection == null || connection.isClosed()) {
			connection = DriverManager.getConnection(this.url, this.user, this.password);
		}
	}

	public Statement createStmt() {
		try {
			this.stmt = this.connection.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return this.stmt;
	}

	public PreparedStatement prepareStmt(String sql) {
		try {
			this.pStmt = (PreparedStatement) this.connection.prepareStatement(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return this.pStmt;
	}

	public ResultSet executeQuery() {
		try {
			this.rs = this.pStmt.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return this.rs;
	}

	public int executeUpdate() {
		int r = 0;
		try {
			boolean a = this.connection.getAutoCommit();

			this.connection.setAutoCommit(false);

			r = this.pStmt.executeUpdate();
			this.connection.commit();
			this.connection.setAutoCommit(a);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return r;
	}

	public void close() {
		try {
			if (this.rs != null) {
				this.rs.close();
			}
			if (this.stmt != null) {
				this.stmt.close();
			}
			if (this.pStmt != null) {
				this.pStmt.close();
			}
			if (this.connection != null)
				this.connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public ResultSet getResultSet(String sql) throws SQLException {
		Statement statement = null;
		if (!this.connection.isClosed()) {
			statement = this.connection.createStatement();
			return statement.executeQuery(sql);
		} else {
			return null;
		}
	}

	public static void main(String[] args) {
		MySQLHelper helper = null;
		try {
			helper = new MySQLHelper("192.168.9.11", 3306, "root", "nopass.test", "test");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String sql = "select * from test.name where id = 1";
		try {
			// helper.getResultSet(sql);
			ResultSet rs = helper.getResultSet(sql);
			while (rs.next()) {
				System.out.println(rs.getString(1));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
