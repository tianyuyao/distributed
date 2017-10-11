package com.pmh.thrift;

import java.util.concurrent.CountDownLatch;

import org.apache.thrift.TException;
import org.apache.thrift.async.AsyncMethodCallback;

import com.pmh.thrift.HelloService.AsyncClient.sayHello_call;

public class AsynInvokerCallback implements org.apache.thrift.async.AsyncMethodCallback<java.lang.String>{
	
	private CountDownLatch latch;

	public AsynInvokerCallback(CountDownLatch latch) {
		this.latch = latch;
	}

//	@Override
//	public void onComplete(sayHello_call response) {
//		try {
//			System.out.println("AsyncInvokerCallback response : "+response.getResult());
//		} catch (TException e) {
//			e.printStackTrace();
//		}finally {
//			latch.countDown();
//		}
//	}

	@Override
	public void onError(Exception exception) {
		latch.countDown();
	}

	@Override
	public void onComplete(String response) {
		try {
			System.out.println("AsyncInvokerCallback response : "+response);
		}finally {
			latch.countDown();
		}
	}
	

}
