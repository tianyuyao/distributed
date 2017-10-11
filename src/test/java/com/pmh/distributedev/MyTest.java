package com.pmh.distributedev;

import org.apache.thrift.TException;

import com.pmh.thrift.SimpleInvoker;

public class MyTest {
	public void test() throws TException{
    	SimpleInvoker simpleInvoker = new SimpleInvoker();
    	simpleInvoker.startServer();
    	simpleInvoker.startClient();
    }

}
