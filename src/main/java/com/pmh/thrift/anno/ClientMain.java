package com.pmh.thrift.anno;


import java.net.InetSocketAddress;
import java.util.concurrent.ExecutionException;

import com.facebook.nifty.client.FramedClientConnector;
import com.facebook.swift.service.ThriftClientManager;

public class ClientMain {
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		ThriftClientManager clientManager = new ThriftClientManager();
		FramedClientConnector connector = new FramedClientConnector(new InetSocketAddress("localhost", 8899));
		
		User user = new User();
		user.setName("tian --");
		user.setEmail("dfgdfgdgd");
		
		HelloService helloService = clientManager.createClient(connector, HelloService.class).get();
		String hi = helloService.sayHello(user);
		System.out.println(hi);
	}
}
