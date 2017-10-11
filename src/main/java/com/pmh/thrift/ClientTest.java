package com.pmh.thrift;

import java.io.IOException;

import org.apache.thrift.TException;

public class ClientTest {
	public static void main(String[] args) throws TException, IOException, InterruptedException {
//		SimpleInvoker simpleInvoker = new SimpleInvoker();
//		simpleInvoker.startClient();
		NonBlockingInvoker nonBlockingInvoker = new NonBlockingInvoker();
		nonBlockingInvoker.startClient();
	}
}
