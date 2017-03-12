package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import vo.Admin;
import vo.Bill;

public class BillHow implements BillDao{
	public Connection conn;
	public PreparedStatement prest ;
	public BillHow(Connection c) {
		this.conn = c;
	}
	@Override
	public boolean doCreate(Bill bill) throws Exception {
		boolean flag = false;
		String sql = "insert into bill values(?,?,?,?,?)";
		prest = conn.prepareStatement(sql);
		prest.setString(1, bill.getName());
		prest.setString(2, bill.getLiveId());
		prest.setString(3, bill.getOrderId());
		prest.setString(4, bill.getPrice());
		prest.setString(5, bill.getPs());
		if(prest.executeUpdate()>0){
			flag = true;
		}
		prest.close();
		return flag;
	}

	@Override
	public Bill findById(String s) throws Exception{
		Bill bill = null;
		String sql = "select * from bill where liveId =?";
		prest = conn.prepareStatement(sql);
		prest.setString(1, s);
		ResultSet rs = prest.executeQuery();
		while(rs.next()){
			bill = new Bill();
			bill.setName(rs.getString(1));
			bill.setLiveId(rs.getString(2));
			bill.setOrderId(rs.getString(3));
			bill.setPrice(rs.getString(4));
			bill.setPs(rs.getString(5));
		}
		prest.close();
		return bill;
	}

	@Override
	public boolean delete(Bill bill) throws Exception{
		boolean flag = false;
		String sql = "delete from bill where liveId = ?";
		prest = conn.prepareStatement(sql);
		if(prest.executeUpdate()>0){
			flag = true;
		}
		prest.close();
		return flag;
	}
	@Override
	public List<Bill> findAll() throws Exception {
		Bill bill = null;
		List<Bill> list = new ArrayList<Bill>();
		String sql = "select * from bill ";
		prest = conn.prepareStatement(sql);
		ResultSet rs = prest.executeQuery();
		while(rs.next()){
			bill = new Bill();
			bill.setName(rs.getString(1));
			bill.setLiveId(rs.getString(2));
			bill.setOrderId(rs.getString(3));
			bill.setPrice(rs.getString(4));
			bill.setPs(rs.getString(5));
			list.add(bill);
		}
		prest.close();
		return list;
	}
}
