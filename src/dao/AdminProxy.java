package dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import vo.Admin;
import database.Database;

public class AdminProxy implements AdminDao{
	private Database database =null;
	private AdminHow adminHow = null;
	public AdminProxy() throws Exception {
		database = new Database();
		adminHow = new AdminHow(database.getConnection());
	}
	@Override
	public boolean doCreate(Admin admin) {
		boolean flag = false;
		try {
			flag = adminHow.doCreate(admin);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				database.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return flag;
	}
	@Override
	public boolean find(String s) {
		boolean flag = false;
		try {
			flag = adminHow.find(s);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				database.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return flag;
	}
	@Override
	public boolean delete(Admin admin) {
		boolean flag = false;
		try {
			flag = adminHow.delete(admin);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				database.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return flag;
	}
	@Override
	public boolean check(Admin admin)  {
		boolean flag = false;
		try {
			flag = adminHow.check(admin);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				database.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return flag;
	}
	@Override
	public List<Admin> findAll() throws Exception {
		List<Admin> list = new ArrayList<Admin>();
		try {
			list = adminHow.findAll();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				database.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}
	
}
