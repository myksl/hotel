package factory;

import dao.LiveProxy;


public class LiveFactory {
	public static LiveProxy get() throws Exception{
		return new LiveProxy();
	}
}
