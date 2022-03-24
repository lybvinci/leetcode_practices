package com.monster.learn;

import java.util.concurrent.CountDownLatch;

public class Foo1114 {
	//54.63%
	private CountDownLatch mCdl1;
	private CountDownLatch mCdl2;
	public Foo1114() {
		mCdl1 = new CountDownLatch(1);	
		mCdl2 = new CountDownLatch(1);	
	}

	public void first(Runnable printFirst) throws InterruptedException {
			printFirst.run();
			mCdl1.countDown();
	}

	public void second(Runnable printSecond) throws InterruptedException {
			mCdl1.await();	
			printSecond.run();
			mCdl2.countDown();
	}

	public void third(Runnable printThird) throws InterruptedException {
			mCdl1.await();
			mCdl2.await();
			printThird.run();
	}	
}
