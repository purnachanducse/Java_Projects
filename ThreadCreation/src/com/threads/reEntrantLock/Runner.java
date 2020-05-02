/**
 * 
 */
package com.threads.reEntrantLock;

import java.util.Scanner;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Here We just added await() and signal() methods for demo sake not using
 * Extensively but those are similar like wait() and notify()
 * 
 * Why we will use Re-entrant lock here is synchronization will leads to starvation by making long waiting thread to even wait
 * because if we use synchronization then we don't have gurantee to which thread the lock will go but
 * if we go with Re-entrant lock by passing true as a paramenter with in constructor then long waiting thread will get lock
 * and it will give more performance than the synchronized key word with no proofs for it :) 
 * @author 10661300
 *
 */
public class Runner {

	private ReentrantLock lock = new ReentrantLock(true);
	private Condition condition = lock.newCondition();
	private int count = 0;

	private void counter() {
		for (int i = 0; i < 10000; i++) {
			count++;
		}
	}

	public void firstThread() throws InterruptedException {
		lock.lock();
		condition.await();
		try {
			counter();
		} finally {
			lock.unlock();
		}
	}

	@SuppressWarnings("resource")
	public void secondThread() {
		lock.lock();
		System.out.println("Plz press the a button");
		new Scanner(System.in).next();
		condition.signal();
		try {
			counter();
		} finally {
			lock.unlock();
		}
	}

	public void finished() {
		System.out.println("Count is: " + count);
	}
}
