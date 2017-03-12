package factory;

import dao.RoomProxy;


public class RoomFactory {
	public static RoomProxy get() throws Exception{
		return new RoomProxy();
	}
}
