package dao;

import java.util.List;

import vo.Live;

public interface LiveDao {
	public boolean doCreate(Live live) throws Exception;
	public Live findById(String s) throws Exception;
	public boolean delete(Live live) throws Exception;
	public List<Live> findAll () throws Exception;
}
