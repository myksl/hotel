package factory;

import dao.AdminProxy;


public class AdminFactory {
	public static AdminProxy get() throws Exception{
		return new AdminProxy();
	}
}
