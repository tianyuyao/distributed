package com.pmh.rmi;

import java.io.IOException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.RMISocketFactory;

/**
 * 
 * @ClassName: ServiceMain
 * @Description: server端启动，工厂模式
 * @author Roman
 * @date 2017年10月9日 上午10:59:15
 */
public class ServiceMain {
public static void main(String[] args) throws IOException, AlreadyBoundException {
	LocateRegistry.createRegistry(9000);
	//指定通讯端口，防止被防火墙拦截
	RMISocketFactory.setSocketFactory(new MySocketFactory());
	MyService myService = new MyServiceImpl();
	Naming.bind("rmi://localhost:9000/hello", myService);
	System.out.println("ServiceMain provice RPC Service Now");
}
}
