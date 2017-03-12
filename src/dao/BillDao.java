package dao;

import java.util.List;

import vo.Bill;

public interface BillDao {
	public boolean doCreate(Bill bill) throws Exception;
	public Bill findById(String s)throws Exception;
	public boolean delete(Bill bill) throws Exception;
	public List<Bill> findAll() throws Exception;
}
