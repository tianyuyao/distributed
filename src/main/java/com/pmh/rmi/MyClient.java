package com.pmh.rmi;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
/**
 * @ClassName: MyClient
 * @Description: client端
 * @author Roman
 * @date 2017年9月30日 下午6:08:08
 */
public class MyClient {
	public static void main(String[] args) throws MalformedURLException, RemoteException, NotBoundException {
		// 服务引入
//		MyService service = (MyService) Naming.lookup("rmi://localhost:8080/myservice");
		MyService service = (MyService) Naming.lookup("rmi://localhost:9000/hello");
		// 远程调用方法
		System.out.println("远程调用：" + service.handler());
	}
}
