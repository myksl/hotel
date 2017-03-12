package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import vo.Admin;
import vo.Room;

public class RoomHow implements RoomDao {
	public Connection conn;
	public PreparedStatement prest ;
	public RoomHow(Connection c) {
		this.conn = c;
	}
	@Override
	public boolean doCreate(Room room) throws Exception{
		boolean flag = false;
		String sql = "insert into room (number,state,type,price) values (?,?,?,?)";
		prest = conn.prepareStatement(sql);
		prest.setString(1, room.getNumber());
		prest.setString(2, room.getState());
		prest.setString(3, room.getType());
		prest.setString(4, room.getPrice());
		if(prest.executeUpdate()>0){
			flag = true;
		}
		
		return flag;
	}

	@Override
	public List<Room> findByType(String s) throws Exception{
		List<Room> list = new ArrayList<Room>();
		Room room = null;
		String sql = "select * from room where type =?";
		prest = conn.prepareStatement(sql);
		prest.setString(1, s);
		ResultSet rs = prest.executeQuery();
		while(rs.next()){
			room = new Room();
			room.setNumber(rs.getString(1));
			room.setState(rs.getString(2));
			room.setType(rs.getString(3));
			room.setPrice(rs.getString(4));
			list.add(room);
		}
		return list;
	}

	@Override
	public boolean delete(Room room) throws Exception{
		boolean flag = false;
		String sql = "delete from room where number = ?";
		prest = conn.prepareStatement(sql);
		if(prest.executeUpdate()>0){
			flag = true;
		}
		return flag;
	}
	@Override
	public boolean liveState(String s) throws Exception {
		boolean flag = false;
		String sql = "update room set state = '入住' where number =?";
		prest = conn.prepareStatement(sql);
		prest.setString(1, s);
		if(prest.executeUpdate()>0){
			flag = true;
		}
		prest.close();
		return flag;
	}
	@Override
	public boolean orderState(String s) throws Exception {
		boolean flag = false;
		String sql = "update room set state = '预订' where number =?";
		prest = conn.prepareStatement(sql);
		prest.setString(1, s);
		if(prest.executeUpdate()>0){
			flag = true;
		}
		prest.close();
		return flag;
	}
	@Override
	public boolean noState(String s) throws Exception {
		boolean flag = false;
		String sql = "update room set state = '未住' where 	liveId =?";
		prest = conn.prepareStatement(sql);
		prest.setString(1, s);
		if(prest.executeUpdate()>0){
			flag = true;
		}
		prest.close();
		return flag;
	}
	@Override
	public List<Room> findAll() throws Exception {
		Room room = null;
		List<Room> list = new ArrayList<Room>();
		String sql = "select * from room ";
		prest = conn.prepareStatement(sql);
		ResultSet rs = prest.executeQuery();
		while(rs.next()){
			room = new Room();
			room.setNumber(rs.getString(1));
			room.setState(rs.getString(2));
			room.setType(rs.getString(3));
			room.setPrice(rs.getString(4));
			room.setOrderId(rs.getString(5));
			room.setLiveId(rs.getString(6));
			list.add(room);
		}
		prest.close();
		return list;
	}
	@Override
	public Room findById(String s) throws Exception {
		Room room = null;
		String sql = "select * from room where number =?";
		prest = conn.prepareStatement(sql);
		prest.setString(1, s);
		ResultSet rs = prest.executeQuery();
		while(rs.next()){
			room = new Room();
			room.setNumber(rs.getString(1));
			room.setState(rs.getString(2));
			room.setType(rs.getString(3));
			room.setPrice(rs.getString(4));
			room.setOrderId(rs.getString(5));
			room.setLiveId(rs.getString(6));
		}
		return room;
	}
	@Override
	public boolean setlive(String s,String x) throws Exception {
		boolean flag = false;
		String sql = "update room set liveId =? where number =?";
		prest = conn.prepareStatement(sql);
		prest.setString(1, s);
		prest.setString(2, x);
		if( prest.executeUpdate()>0){
			flag = true;
			
		}
		return flag;
	}
	@Override
	public boolean setorder(String s,String x) throws Exception {
		boolean flag = false;
		String sql = "update room set orderId =? where number =?";
		prest = conn.prepareStatement(sql);
		prest.setString(1, s);
		prest.setString(2, x);
		if( prest.executeUpdate()>0){
			flag = true;
		}
		return flag;
	}
	@Override
	public String getlive(String s) throws Exception {
		String live= null;
		String sql = "select liveId from room where number =?";
		prest = conn.prepareStatement(sql);
		prest.setString(1, s);
		ResultSet rs = prest.executeQuery();
		while(rs.next()){
			live = rs.getString(1);
		}
		return live;
	}
	@Override
	public String getorder(String s) throws Exception {
		String order= null;
		String sql = "select orderId from room where number =?";
		prest = conn.prepareStatement(sql);
		prest.setString(1, s);
		ResultSet rs = prest.executeQuery();
		while(rs.next()){
			order = rs.getString(1);
		}
		return order;
	}
}
