/**
 * 
 */
package com.threads;

/**
 * @author 10661300
 *
 */

class Runner extends Thread {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();

		for (int i = 0; i < 10; i++) {
			System.out.println("i: " + i);
			
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

public class ExtendsThreadClass {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Runner runner = new Runner();
		runner.start();

	}

}
