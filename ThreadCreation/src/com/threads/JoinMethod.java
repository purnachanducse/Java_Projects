/**
 * 
 */
package com.threads;

/**
 * @author 10661300
 *	
 */
public class JoinMethod {

	@SuppressWarnings("unused")
	private volatile int count = 0;

	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		JoinMethod joinMethod = new JoinMethod();
		joinMethod.doWork();
	}

	public synchronized void increment() {
		count++;
	}

	public void doWork() throws InterruptedException {
		
		Thread t1 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				for(int i=0;i<10000;i++) {
					increment();
				}
			}
		});
		
		Thread t2 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				for(int i=0;i<10000;i++) {
					increment();
				}
			}
		});
		
		t1.start();
		t2.start();
		
		t1.join();
		t2.join();
		
		System.out.println("Count: "+count);
	}
}
