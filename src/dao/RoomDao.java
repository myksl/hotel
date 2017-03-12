package dao;

import java.util.List;

import vo.Room;


public interface RoomDao {
	public boolean doCreate(Room room)throws Exception;
	public List<Room> findByType(String s)throws Exception;
	public Room findById(String s)throws Exception;
	public boolean delete(Room room)throws Exception;
	public boolean liveState(String s)throws Exception;
	public boolean orderState(String s)throws Exception;
	public boolean noState(String s)throws Exception;
	public List<Room> findAll() throws Exception;
	public boolean setorder(String s,String x)throws Exception;
	public String getorder(String s)throws Exception;
	public String getlive(String s )throws Exception;
	public boolean setlive(String s,String x)throws Exception;
}
