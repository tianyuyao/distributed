package com.pmh.rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
/**
 * @ClassName: MyServiceImpl
 * @Description: 服务端实现接口
 * 必须继承UnicastRemoteObject  定义服务调用方与服务提供方对象实例 建立一对一连接
 * @author Roman
 * @date 2017年9月30日 下午5:55:31
 */
public class MyServiceImpl extends UnicastRemoteObject implements MyService{

	/**
	* @Fields serialVersionUID : 系统生成
	*/ 
	private static final long serialVersionUID = -4917080264127272186L;

	protected MyServiceImpl() throws RemoteException {
		super();
	}

	/**
	 * 运行在server端
	 */
	@Override
	public String handler() throws RemoteException {
		System.out.println("My First RMI Procedureb !");
		return "My First RMI Procedureb ! ";
	}

}
