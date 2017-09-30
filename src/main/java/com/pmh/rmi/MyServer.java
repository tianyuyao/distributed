package com.pmh.rmi;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
/**
 * @ClassName: MyServer
 * @Description: 服务端启动
 * @author Roman
 * @date 2017年9月30日 下午6:01:50
 */
public class MyServer {
	public static void main(String[] args) throws RemoteException, MalformedURLException, AlreadyBoundException {
		//创建服务
		MyService service = new MyServiceImpl();
		//注册服务
		LocateRegistry.createRegistry(8080);
		Naming.bind("rmi://localhost:8080/myservice", service);
		System.out.println("ServerMain Provide RPC service now!");
	}
}
