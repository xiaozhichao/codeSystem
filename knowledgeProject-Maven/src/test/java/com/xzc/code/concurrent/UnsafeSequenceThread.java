package com.xzc.code.concurrent;
public class UnsafeSequenceThread extends Thread {
	private UnsafeSequence u = new UnsafeSequence();
	@Override
    public void run() {
		for(int i = 0 ; i < 6 ; i++){
			System.out.println(Thread.currentThread().getName() + ":" + (u.getNext()));
		}
    }
}

	