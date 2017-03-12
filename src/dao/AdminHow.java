package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;



import vo.Admin;

public class AdminHow implements AdminDao{
	public Connection conn;
	public PreparedStatement prest ;
	public AdminHow(Connection c) {
		this.conn = c;
	}
	@Override
	public boolean doCreate(Admin admin) throws Exception {
		boolean flag = false;
		String sql = "insert into admin values(?,?,?)";
		prest = conn.prepareStatement(sql);
		prest.setString(1, admin.getUsername());
		prest.setString(2, admin.getPassword());
		prest.setString(3, admin.getLevel());
		if(prest.executeUpdate()>0){
			flag = true;
		}
		prest.close();
		return flag;
	}
	@Override
	public boolean check(Admin admin) throws Exception {
		boolean flag = false;
		String sql = "select password from admin where username =?";
		prest = conn.prepareStatement(sql);
		prest.setString(1, admin.getUsername());
		ResultSet rs = prest.executeQuery();
		while(rs.next()){
			if(admin.getPassword().equals(rs.getString(1))){
				flag = true;;
			}

		}
		prest.close();
		return flag;
	}
	@Override
	public boolean delete(Admin admin) throws Exception {
		boolean flag = false;
		String sql = "delete from admin where username = ?";
		prest = conn.prepareStatement(sql);
		if(prest.executeUpdate()>0){
			flag = true;
		}
		prest.close();
		return flag;
	}
	@Override
	public boolean find(String s) throws Exception {
		boolean flag = false;
		String sql = "select * from admin where username =?";
		prest = conn.prepareStatement(sql);
		prest.setString(1, s);
		ResultSet rs = prest.executeQuery();
		while(rs.next()){
			flag = true;
		}
		prest.close();
		return flag;
	}
	@Override
	public List<Admin> findAll() throws Exception {
		Admin admin = null;
		List<Admin> list = new ArrayList<Admin>();
		String sql = "select * from admin ";
		prest = conn.prepareStatement(sql);
		ResultSet rs = prest.executeQuery();
		while(rs.next()){
			admin = new Admin();
			admin.setUsername(rs.getString(1));
			admin.setPassword(rs.getString(2));
			admin.setLevel(rs.getString(3));
			list.add(admin);
		}
		prest.close();
		return list;
	}
}
