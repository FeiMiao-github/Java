package multithreading;

import java.util.concurrent.locks.ReentrantLock;

/* 同步锁 */
public class demo155 {
	public static void main(String[] args) {
		AccountTest acct = new AccountTest("余额", 1000.0);
		Thread t1 = new Thread(new DrawT(acct, 300.0));
		Thread t2 = new Thread(new DrawT(acct, 700.0));
		
		t1.start();
		t2.start();
		
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("余额" + acct.getBalance());
	}
}

class DrawT implements Runnable {
	AccountTest account;
	double drawAmount;
	
	public DrawT(AccountTest a, double dA) {
		this.account = a;
		this.drawAmount = dA;
	}
	
	@Override
	public void run() {
		this.account.drawBalance(drawAmount);
	}
	
}

class AccountTest {
	/* 可重入锁 */
	private final ReentrantLock lock = new ReentrantLock(); 
	private String ID;
	private double balance;
	
	public AccountTest(String i, double b) {
		this.ID = i;
		this.balance = b;
	}
	
	public double getBalance() {
		return this.balance;
	}
	
	/**
	 * @param v 取钱数量
	 */
	public void drawBalance(double v) {
		lock.lock();
		
		try {
			if (v > this.balance) {
				System.out.println("余额不足");
			} else {
				System.out.println("取" + v + "元， 余"
						+ (balance - v) + "元");
				this.balance -= v;
			}
		} finally {
			lock.unlock();
		}
	}
}