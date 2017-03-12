package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import vo.Admin;
import vo.Order;
import vo.User;

public class OrderHow implements OrderDao {
	public Connection conn;
	public PreparedStatement prest ;
	public OrderHow(Connection c) {
		this.conn = c;
	}
	@Override
	public boolean doCreate(Order order)throws Exception {
		boolean flag = false;
		String sql = "insert into orde values(?,?,?,?,?,?,?,?)";
		prest = conn.prepareStatement(sql);
		prest.setString(1, order.getId());
		prest.setString(2, order.getLeftTime());
		prest.setString(3, order.getComeTime());
		prest.setString(4, order.getRoomId());
		prest.setString(5, order.getUser().getPhone());
		prest.setString(6, order.getUser().getName());
		prest.setString(7, order.getUser().getId());
		prest.setInt(8, order.getPeople());
		if(prest.executeUpdate()>0){
			flag = true;
		}
		prest.close();
		return flag;
	}

	@Override
	public Order findById(String s) throws Exception{
		Order order = null;
		User user =null;
		String sql = "select * from orde where id =?";
		prest = conn.prepareStatement(sql);
		prest.setString(1, s);
		ResultSet rs = prest.executeQuery();
		while(rs.next()){
			order = new Order();
			user = new User();
			order.setId(rs.getString(1));
			order.setLeftTime(rs.getString(2));
			order.setComeTime(rs.getString(3));
			order.setRoomId(rs.getString(4));
			user.setPhone(rs.getString(5));
			user.setName(rs.getString(6));
			user.setId(rs.getString(7));
			order.setPeople(rs.getInt(8));
			order.setUser(user);
		}
		prest.close();
		return order;
	}

	@Override
	public boolean delete(Order order) throws Exception{
		boolean flag = false;
		String sql = "delete from orde where id = ?";
		prest = conn.prepareStatement(sql);
		if(prest.executeUpdate()>0){
			flag = true;
		}
		prest.close();
		return flag;
	}
	@Override
	public List<Order> findAll() throws Exception {
		User user = null;
		Order order = null;
		List<Order> list = new ArrayList<Order>();
		String sql = "select * from orde ";
		prest = conn.prepareStatement(sql);
		ResultSet rs = prest.executeQuery();
		while(rs.next()){
			order = new Order();
			user= new User();
			order.setId(rs.getString(1));
			order.setLeftTime(rs.getString(2));
			order.setComeTime(rs.getString(3));
			order.setRoomId(rs.getString(4));
			user.setPhone(rs.getString(5));
			user.setName(rs.getString(6));
			user.setId(rs.getString(7));
			order.setPeople(rs.getInt(8));
			order.setUser(user);
			list.add(order);
		}
		prest.close();
		return list;
	}

}
