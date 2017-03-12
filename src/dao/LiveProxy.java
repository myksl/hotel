package dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import vo.Admin;
import vo.Live;
import database.Database;

public class LiveProxy implements LiveDao{
	private Database database =null;
	private LiveHow liveHow = null;
	public LiveProxy() throws Exception {
		database = new Database();
		liveHow = new LiveHow(database.getConnection());
	}
	@Override
	public boolean doCreate(Live live) {
		boolean flag = false;
		try {
			flag = liveHow.doCreate(live);
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
	public Live findById(String s) {
		Live live = null;
		try {
			live = liveHow.findById(s);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				database.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return live;
	}
	@Override
	public boolean delete(Live live) {
		boolean flag = false;
		try {
			flag = liveHow.delete(live);
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
	public List<Live> findAll() throws Exception {
		List<Live> list = new ArrayList<Live>();
		try {
			list = liveHow.findAll();
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
