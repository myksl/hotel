package dao;

import java.util.List;

import vo.Order;

public interface OrderDao {
	public boolean doCreate(Order order)throws Exception;
	public Order findById(String s)throws Exception;
	public boolean delete(Order order)throws Exception;
	public List<Order> findAll() throws Exception;
}
