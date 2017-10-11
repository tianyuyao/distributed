package com.pmh.thrift;

import org.apache.thrift.TException;

public class MyTest {
	
	public void test() throws TException{
    	
    }
	
	public static void main(String[] args) throws TException {
//		SimpleInvoker simpleInvoker = new SimpleInvoker();
//    	simpleInvoker.startServer();
//    	simpleInvoker.startClient();
    	NonBlockingInvoker nonBlockingInvoker = new NonBlockingInvoker();
    	nonBlockingInvoker.startServer();
	}

}