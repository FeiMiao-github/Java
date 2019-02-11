package multithreading;

/* 线程通信 */
public class demo157 {
	public static void main(String[] args) {
		Demo demo = new Demo("账户", 1000);
		DrawDemo dd = new DrawDemo("账户1", 200.0, demo);
		DepositDemo ded = new DepositDemo("账户1", 200, demo);
				
		dd.start();
		ded.start();
	}
}

class DrawDemo extends Thread {
	private double db;
	private Demo demo;
	
	public DrawDemo(String name, double db, Demo demo) {
		super(name);
		this.demo = demo;
		this.db = db;
	}
	
	@Override
	public void run() {
		for (int i = 0; i < 100; i++) {
			System.out.println(1);
			demo.draw(db);
		}
	}
}


class DepositDemo extends Thread {
	private double dp;
	private Demo demo;
	
	public DepositDemo(String name, double db, Demo demo) {
		super(name);
		this.demo = demo;
		this.dp = db;
	}
	
	@Override
	public void run() {
		for (int i = 0; i < 100; i++) {
			System.out.println(1);
			demo.deposit(dp);
		}
	}
}

class Demo {
	private String accountNo;
	private double balance;
	
	private boolean flag = true; // false;
	
	public Demo() {}
	public Demo(String an, double b) {
		this.accountNo = an;
		this.balance = b;
	}
	
	public double getBalance() {
		return this.balance;
	}
	
	public String getAccountNo() {
		return this.accountNo;
	}
	
	public synchronized void draw(double db) {
		if (db > this.balance) {
			System.out.println("余额不足");
		} else {
			try {
				if (!flag) {
					wait();
				} else {
					System.out.println("[" + Thread.currentThread().getName() + "]取钱"
							+ db + "$, 余" + (balance - db) + "$");
					this.balance -= db;
					flag = false;
					notifyAll();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public synchronized void deposit(double depositAmount) {
		try {
			if (flag) {
				// has deposited true
				wait();
			} else {
				// 存款
				System.out.println("[" + Thread.currentThread().getName() + "]存钱"
						+ depositAmount + "$, 余" + (balance + depositAmount) + "$");
				
				this.balance += depositAmount;
				flag = true;
				this.notify();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
