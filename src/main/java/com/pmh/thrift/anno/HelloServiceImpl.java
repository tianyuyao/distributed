package com.pmh.thrift.anno;

public class HelloServiceImpl implements HelloService {

	@Override
	public String sayHello(User user) {
		return "hello," + user.getName() + user.getEmail();
	}

}
