package com.pmh.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * @ClassName: MyService
 * @Description: RMI对外服务接口 必须显示声明抛出RemoteException异常
 * @author Roman
 * @date 2017年9月30日 下午5:51:56
 */
public interface MyService extends Remote{
	String handler() throws RemoteException;
}
