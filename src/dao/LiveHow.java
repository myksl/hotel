package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import vo.Admin;
import vo.Room;
import vo.Live;

public class LiveHow implements LiveDao {
	public Connection conn;
	public PreparedStatement prest ;
	public LiveHow(Connection c) {
		this.conn = c;
	}
	@Override
	public boolean doCreate(Live live) throws Exception{
		boolean flag = false;
		String sql = "insert into live values(?,?,?,?,?,?,?,?)";
		prest = conn.prepareStatement(sql);
		prest.setString(1, live.getId());
		prest.setString(2, live.getOrderId());
		prest.setString(3, live.getUserId());
		prest.setString(4, live.getBillState());
		prest.setInt(5, live.getPeople());
		prest.setString(6, live.getRoom().getNumber());
		prest.setString(7, live.getRoom().getPrice());
		prest.setString(8, live.getRoom().getType());
		if(prest.executeUpdate()>0){
			flag = true;
		}
		prest.close();
		return flag;
	}

	@Override
	public Live findById(String s) throws Exception{
		Live live = null;
		Room room = null;
		String sql = "select * from live where id =?";
		prest = conn.prepareStatement(sql);
		prest.setString(1, s);
		ResultSet rs = prest.executeQuery();
		while(rs.next()){
			live = new Live();
			room = new Room();
			live.setId(rs.getString(1));
			live.setOrderId(rs.getString(2));
			live.setUserId(rs.getString(3));
			live.setBillState(rs.getString(4));
			live.setPeople(rs.getInt(5));
			room.setNumber(rs.getString(6));
			room.setPrice(rs.getString(7));
			room.setType(rs.getString(8));
			live.setRoom(room);
		}
		prest.close();
		return live;
	}

	@Override
	public boolean delete(Live live) throws Exception{
		boolean flag = false;
		String sql = "delete from live where id = ?";
		prest = conn.prepareStatement(sql);
		if(prest.executeUpdate()>0){
			flag = true;
		}
		prest.close();
		return flag;
	}
	@Override
	public List<Live> findAll() throws Exception {
		Room room = null;
		Live live = null;
		List<Live> list = new ArrayList<Live>();
		String sql = "select * from Live ";
		prest = conn.prepareStatement(sql);
		ResultSet rs = prest.executeQuery();
		while(rs.next()){
			room = new Room();
			live = new Live();
			live.setId(rs.getString(1));
			live.setOrderId(rs.getString(2));
			live.setUserId(rs.getString(3));
			live.setBillState(rs.getString(4));
			live.setPeople(rs.getInt(5));
			room.setNumber(rs.getString(6));
			room.setPrice(rs.getString(7));
			room.setType(rs.getString(8));
			live.setRoom(room);
			list.add(live);
		}
		prest.close();
		return list;
	}

}
