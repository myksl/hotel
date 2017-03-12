package dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import vo.Admin;
import vo.Room;
import database.Database;

public class RoomProxy implements RoomDao{
	private Database database =null;
	private RoomHow roomHow = null;
	public RoomProxy() throws Exception {
		database = new Database();
		roomHow = new RoomHow(database.getConnection());
	}
	@Override
	public boolean doCreate(Room room) {
		boolean flag = false;
		try {
			flag = roomHow.doCreate(room);
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
	public List<Room> findByType(String s) {
		List<Room> list = new ArrayList<Room>();
		try {
			list = roomHow.findByType(s);
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
	@Override
	public boolean delete(Room room) {
		boolean flag = false;
		try {
			flag = roomHow.delete(room);
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
	public boolean liveState(String s) throws Exception {
		boolean flag = false;
		try {
			flag = roomHow.liveState(s);
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
	public boolean orderState(String s) throws Exception {
		boolean flag = false;
		try {
			flag = roomHow.orderState(s);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
	@Override
	public boolean noState(String s) throws Exception {
		boolean flag = false;
		try {
			flag = roomHow.noState(s);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
	@Override
	public List<Room> findAll() throws Exception {
		List<Room> list = new ArrayList<Room>();
		try {
			list = roomHow.findAll();
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
	@Override
	public Room findById(String s) throws Exception {
		Room room = null;
		try {
			room = roomHow.findById(s);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				database.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return room;
	}
	@Override
	public boolean setlive(String s, String x) throws Exception {
		boolean flag = false;
		try {
			flag= roomHow.setlive(s, x);
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
	public boolean setorder(String s, String x) throws Exception {
		boolean flag = false;
		try {
			flag= roomHow.setorder(s, x);
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
	public String getlive(String s) throws Exception {
		String live = null;
		try {
			live= roomHow.getlive(s);
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
	public String getorder(String s) throws Exception {
		String order = null;
		try {
			order= roomHow.getorder(s);
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
}
