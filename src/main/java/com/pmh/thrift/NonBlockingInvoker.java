package com.pmh.thrift;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import org.apache.thrift.TException;
import org.apache.thrift.TProcessor;
import org.apache.thrift.async.TAsyncClientManager;
import org.apache.thrift.protocol.TCompactProtocol;
import org.apache.thrift.protocol.TProtocolFactory;
import org.apache.thrift.server.TNonblockingServer;
import org.apache.thrift.server.TServer;
import org.apache.thrift.transport.TFramedTransport;
import org.apache.thrift.transport.TNonblockingServerSocket;
import org.apache.thrift.transport.TNonblockingServerTransport;
import org.apache.thrift.transport.TNonblockingSocket;
import org.apache.thrift.transport.TNonblockingTransport;
import org.apache.thrift.transport.TTransportException;

/**
 * 
 * @ClassName: NonBlockingInvoker
 * @Description: 异步非阻塞模式
 * @author Roman
 * @date 2017年10月11日 下午3:56:02
 */
public class NonBlockingInvoker {
	public void startServer() throws TTransportException{
		int port = 8091;
		//创建processor
		TProcessor tprocessor = new HelloService.Processor<HelloService.Iface>(new HelloServiceImpl());
		//创建非阻塞transport
		TNonblockingServerTransport serverTransport = new TNonblockingServerSocket(port);
		//创建protocol
		TCompactProtocol.Factory protocol = new TCompactProtocol.Factory();
		//创建transprot数据传输方式，非阻塞
		TFramedTransport.Factory transport = new TFramedTransport.Factory();
		TNonblockingServer.Args args = new TNonblockingServer.Args(serverTransport);
		args.processor(tprocessor);
		args.transportFactory(transport);
		args.protocolFactory(protocol);
		//创建服务器
		TServer server = new TNonblockingServer(args);
		server.serve();
	}
	
	public void startClient() throws IOException, TException, InterruptedException{
		String ip = "127.0.0.1";
		int port = 8091;
		int timeOut = 1000;
		
		TAsyncClientManager clientManager = new TAsyncClientManager();
		TNonblockingTransport transport = new TNonblockingSocket(ip, port, timeOut);
		TProtocolFactory tprotocol = new TCompactProtocol.Factory();
		HelloService.AsyncClient asyncClient = new HelloService.AsyncClient(tprotocol, clientManager, transport);
		
		//客户端异步调用
		User user = new User();
		user.setName("tian--Async");
		user.setEmail("asdfsdafdas");
		CountDownLatch latch = new CountDownLatch(1);
		//回调接口实现
		AsynInvokerCallback callBack = new AsynInvokerCallback(latch);
		asyncClient.sayHello(user, callBack);
		//等待调用返回
		latch.await(5,TimeUnit.SECONDS);
	}
}
