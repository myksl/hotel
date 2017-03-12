package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Database {
	private static final String Driver = "org.gjt.mm.mysql.Driver";
	private static final String path = "jdbc:mysql://localhost:3306/hotel?useUnicode=true&characterEncoding=utf8";
	private static final String name = "root";
	private static final String pass = "";
	private Connection conn = null;
	public Database() throws Exception {
		Class.forName(Driver);
		conn = DriverManager.getConnection(path, name, pass);
	}
	public Connection getConnection(){
		return this.conn;
	}
	public void close() throws SQLException{
		if(conn!=null){
			conn.close();
		}
	}
	
}
