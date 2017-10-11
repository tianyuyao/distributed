package com.pmh.thrift;

import org.apache.thrift.TException;
import org.apache.thrift.TProcessor;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TSimpleServer;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import org.apache.thrift.transport.TTransportException;

/**
 * 
 * @ClassName: SimpleInvoker
 * @Description: 阻塞同步代码
 * @author Roman
 * @date 2017年10月11日 下午3:37:37
 */
public class SimpleInvoker {
	/**
	 * 
	* @Title: startServer
	* @Description: 启动服务
	* @param @throws TTransportException    设定文件
	* @return void    返回类型
	* @throws
	 */
	public void startServer() throws TTransportException {
		//创建processor
		TProcessor tprocessor = new HelloService.Processor<HelloService.Iface>(new HelloServiceImpl());
		//服务端口
		int port = 8091;
		//创建transport 阻塞通信
		TServerSocket serverSocket = new TServerSocket(port);
		//创建protocol
		TBinaryProtocol.Factory protocol = new TBinaryProtocol.Factory();
		//参数加入server端 创建server
		TServer.Args args = new TServer.Args(serverSocket);
		args.processor(tprocessor);
		args.protocolFactory(protocol);
		TServer server = new TSimpleServer(args);
		server.serve();
	}

	/**
	 * 
	* @Title: startClient
	* @Description: 客户端服务调用
	* @param @throws TException    设定文件
	* @return void    返回类型
	* @throws
	 */
	public void startClient() throws TException {
		String ip = "127.0.0.1";
		int port = 8091;
		int timeOut = 1000;
		//创建Transport
		TTransport transport = new TSocket(ip, port, timeOut);
		//创建protocol
		TProtocol protocol = new TBinaryProtocol(transport);
		//创建Client
		HelloService.Client client = new HelloService.Client(protocol);
		transport.open();

		//调用Client方法
		User user = new User();
		user.setName("tian");
		user.setEmail("asdfasf");
		String content = client.sayHello(user);
		System.out.println("content + " + content);
	}
}
