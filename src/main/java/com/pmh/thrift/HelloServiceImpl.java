package com.pmh.thrift;

import org.apache.thrift.TException;

/**
 * 
 * @ClassName: HelloServiceImpl
 * @Description: thrift 实现方法
 * @author Roman
 * @date 2017年10月11日 下午3:35:38
 */
public class HelloServiceImpl implements HelloService.Iface {

	@Override
	public String sayHello(User user) throws TException {
		return "hello" + user.getName() + user.getEmail();
	}

}
