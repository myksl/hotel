package dao;


import java.util.List;

import vo.Admin;

public interface AdminDao {
	public boolean doCreate(Admin admin) throws Exception;
	public boolean check(Admin admin) throws Exception;
	public boolean delete(Admin admin) throws Exception;
	public boolean find(String s)throws Exception;
	public List<Admin> findAll() throws Exception;
	
}
