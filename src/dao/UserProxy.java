package dao;

import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;

import database.Database;
import vo.User;

public class UserProxy implements UserDao{
	private Database database =null;
	private UserHow userHow = null;
	public UserProxy() throws Exception {
		database = new Database();
		userHow = new UserHow(database.getConnection());
	}
	@Override
	public boolean doCreate(User user) {
		boolean flag = false;
		try {
			flag = userHow.doCreate(user);
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
	public List<User> findByName(String s) {
		List<User> list = new ArrayList<User>();
		try {
			list = userHow.findByName(s);
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
	@Override
	public boolean delete(User user) {
		boolean flag = false;
		try {
			flag = userHow.delete(user);
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
	public List<User> findAll() throws Exception {
		List<User> list = new ArrayList<User>();
		try {
			list = userHow.findAll();
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
	@Override
	public User findById(String s) throws Exception {
		User user = null;
		try {
			userHow.findById(s);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				database.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return user;
	}
	
}
