package factory;

import dao.UserProxy;

public class UserFactory {
	public static UserProxy get() throws Exception{
		return new UserProxy();
	}
}
