package factory;

import dao.BillProxy;

public class BillFactory {
	public static BillProxy get() throws Exception{
		return new BillProxy();
	}
}
