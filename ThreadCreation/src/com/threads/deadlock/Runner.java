/**
 * 
 */
package com.threads.deadlock;

import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author 10661300
 *
 */
public class Runner {

	private Account acc1 = new Account();
	private Account acc2 = new Account();

	private Lock lock1 = new ReentrantLock();
	private Lock lock2 = new ReentrantLock();

	public void getLocks(Lock lock1, Lock lock2) {
		while (true) {
			boolean getFirstLock = false;
			boolean getSecondLock = false;
			try {
				// Acquire locks
				getFirstLock = lock1.tryLock();
				getSecondLock = lock2.tryLock();

				// Locks not acquired
			} finally {
				if (getFirstLock && getSecondLock) {
					return;
				}

				if (getFirstLock) {
					lock1.unlock();
				}

				if (getSecondLock) {
					lock2.unlock();
				}
			}

			// Locks not acquired
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				System.out.println("Came to sleep: " + e.getMessage());
			}
		}
	}

	public void firstThread() {
		// for (int i = 0; i < 10; i++) {
		getLocks(lock1, lock2);
		Account.transfer(acc1, acc2, Double.valueOf(new Random().nextInt(100)));
		// }
	}

	public void secondThread() {
		// for (int i = 0; i < 10; i++) {
		getLocks(lock2, lock1);
		Account.transfer(acc2, acc1, Double.valueOf(new Random().nextInt(100)));
		// }
	}

	public void finished() {
		System.out.println("Account 1 balance: " + acc1.getBalance());
		System.out.println("Account 2 balance: " + acc2.getBalance());
		System.out.println("Total Balance: " + (acc1.getBalance() + acc2.getBalance()));
	}
}
