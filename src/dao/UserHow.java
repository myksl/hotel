package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import vo.Room;
import vo.User;

public class UserHow implements UserDao {
	public Connection conn;
	public PreparedStatement prest ;
	public UserHow(Connection c) {
		this.conn = c;
	}
	
	@Override
	public boolean doCreate(User user) throws Exception{
		boolean flag = false;
		String sql = "insert into user values(?,?,?,?)";
		prest = conn.prepareStatement(sql);
		prest.setString(1, user.getName());
		prest.setString(2, user.getCardId());
		prest.setString(3, user.getId());
		prest.setString(4, user.getPhone());
		if(prest.executeUpdate()>0){
			flag = true;
		}
		prest.close();
		return flag;
	}

	@Override
	public List<User> findByName(String s) throws Exception{
		List<User> list = new ArrayList<User>();
		User user = null;
		String sql = "select * from user where name =?";
		prest = conn.prepareStatement(sql);
		prest.setString(1, s);
		ResultSet rs = prest.executeQuery();
		while(rs.next()){
			user = new User();
			user.setName(rs.getString(1));
			user.setCardId(rs.getString(2));
			user.setId(rs.getString(3));
			user.setPhone(rs.getString(4));
			list.add(user);
		}
		prest.close();
		return list;
	}

	@Override
	public boolean delete(User user) throws Exception{
		boolean flag = false;
		String sql = "delete from user where id = ?";
		prest = conn.prepareStatement(sql);
		if(prest.executeUpdate()>0){
			flag = true;
		}
		prest.close();
		return flag;
	}
	@Override
	public List<User> findAll() throws Exception {
		User user = null;
		List<User> list = new ArrayList<User>();
		String sql = "select * from user ";
		prest = conn.prepareStatement(sql);
		ResultSet rs = prest.executeQuery();
		while(rs.next()){
			user = new User();
			user.setName(rs.getString(1));
			user.setCardId(rs.getString(2));
			user.setId(rs.getString(3));
			user.setPhone(rs.getString(4));
			list.add(user);
		}
		prest.close();
		return list;
	}
	@Override
	public User findById(String s) throws Exception {
		User user = null;
		String sql = "select * from user where id =?";
		prest = conn.prepareStatement(sql);
		prest.setString(1, s);
		ResultSet rs = prest.executeQuery();
		while(rs.next()){
			user = new User();
			user.setName(rs.getString(1));
			user.setCardId(rs.getString(2));
			user.setId(rs.getString(3));
			user.setPhone(rs.getString(4));
		}
		return user;
	}

}
