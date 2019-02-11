package multithreading;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* 使用Condition控制现场通信  */
public class demo159 {
	public static void main(String[] args) {
		demo159 demo = new demo159("账户", 1000.0);
		
		DepositThread dd1 = new DepositThread(demo, 1000.0, "乙");
		DrawThread dt = new DrawThread(demo, 1000.0, "甲");
		
		dt.start();
		dd1.start();

		try {
			dt.join();
			dd1.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("余额" + demo.getBalance());
	}
	
	static class DrawThread extends Thread {
		private demo159 demo;
		private double amount;
		private String name;
		
		public DrawThread(demo159 d, double amount, String name) {
			super(name);
			this.demo = d;
			this.amount = amount;
		}
		@Override
		public void run() {
			for (int i = 0; i < 50; i++) {
				demo.draw(amount);
			}
		}
	}
	
	static class DepositThread extends Thread {
		private demo159 demo;
		private double amount;
		
		public DepositThread(demo159 d, double amount, String name) {
			super(name);
			this.demo = d;
			this.amount = amount;
		}
		
		public void run() {
			for (int i = 0; i < 50; i++) {
				demo.deposit(amount);
			}
		}
	}

	/* 定义Lock 对象 */
	private final Lock lock = new ReentrantLock();
	/* 获得 Lock 指定的 Condition */
	private final Condition cond = lock.newCondition();

	/* 成员变量 */
	private double balance = 0.0;
	private String accountNo;

	private boolean flag = false;

	public demo159(String a, double b) {
		this.balance = b;
		this.accountNo = a;
	}

	public String getAccountNo() {
		return accountNo;
	}

	public double getBalance() {
		return balance;
	}

	void draw(double balance) {
		lock.lock();
		try {
			if (!flag) {
				cond.await();
			} else {
				System.out.println(Thread.currentThread().getName() + 
						"取" + balance + "$， 余" + (this.balance - balance) + "$");
				this.balance -= balance;
				flag = false;;
				cond.signalAll();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}

	void deposit(double a) {
		lock.lock();
		try {
			if (flag) {
				cond.await();
			} else {
				System.out.println(Thread.currentThread().getName()
						+ "存" + a + "$, 余" + (this.balance + a) + "$");
				this.balance += a;
				this.flag = true;
				cond.signalAll();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}
}
