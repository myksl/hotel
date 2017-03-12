package dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import database.Database;
import vo.Admin;
import vo.Order;

public class OrderProxy implements OrderDao {
	private Database database =null;
	private OrderHow orderHow = null;
	public OrderProxy() throws Exception {
		database = new Database();
		orderHow = new OrderHow(database.getConnection());
	}
	@Override
	public boolean doCreate(Order order) {
		boolean flag = false;
		try {
			flag = orderHow.doCreate(order);
			
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
	public Order findById(String s) {
		Order order = null;
		try {
			order = orderHow.findById(s);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				database.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return order;
	}
	@Override
	public boolean delete(Order order) {
		boolean flag = false;
		try {
			flag = orderHow.delete(order);
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
	public List<Order> findAll() throws Exception {
		List<Order> list = new ArrayList<Order>();
		try {
			list = orderHow.findAll();
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
