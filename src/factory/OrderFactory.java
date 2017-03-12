package factory;

import dao.OrderProxy;


public class OrderFactory {
	public static OrderProxy get() throws Exception{
		return new OrderProxy();
	}
}
