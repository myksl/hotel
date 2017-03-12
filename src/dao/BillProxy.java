package dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import vo.Admin;
import vo.Bill;
import database.Database;

public class BillProxy implements BillDao{
	private Database database =null;
	private BillHow billHow = null;
	public BillProxy() throws Exception {
		database = new Database();
		billHow = new BillHow(database.getConnection());
	}
	@Override
	public boolean doCreate(Bill bill) {
		boolean flag = false;
		try {
			flag = billHow.doCreate(bill);
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
	public Bill findById(String s) {
		Bill bill = null;
		try {
			bill = billHow.findById(s);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				database.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return bill;
	}
	@Override
	public boolean delete(Bill bill) {
		boolean flag = false;
		try {
			flag = billHow.delete(bill);
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
	public List<Bill> findAll() throws Exception {
		List<Bill> list = new ArrayList<Bill>();
		try {
			list = billHow.findAll();
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
