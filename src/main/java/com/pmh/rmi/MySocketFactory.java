package com.pmh.rmi;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.rmi.server.RMISocketFactory;

/**
 * 
 * @ClassName: MySocketFactory
 * @Description: 工厂模式指定端口 ， 防止被防火墙拦截
 * @author Roman
 * @date 2017年10月9日 上午10:50:05
 */
public class MySocketFactory extends RMISocketFactory {

	@Override
	public Socket createSocket(String host, int port) throws IOException {
		return new Socket(host, port);
	}

	@Override
	public ServerSocket createServerSocket(int port) throws IOException {
		if (port == 0) {
			port = 8080;
		}
		System.out.println("rmi notify port : " + port);
		return new ServerSocket(port);
	}

}
