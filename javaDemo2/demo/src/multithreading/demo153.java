package multithreading;

/* 线程同步 */
public class demo153 {
	public static void main(String[] args) {
		Account account = new Account("1", 1000);
		
		Thread t1 = new DrawThread("1", account, 200);
		Thread t2 = new DrawThread("2", account, 300);
		
		t1.start();
		t2.start();
		
		
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("余额" + account.getBalance());
	}
}

class DrawThread extends Thread {
	private Account account;
	private double drawAccount;
	
	public DrawThread(String name, Account account, double drawAccount) {
		super(name);
		this.account = account;
		this.drawAccount = drawAccount;
	}
	
	public void run() {
		synchronized(account) {
			double balance = account.getBalance();
			if (balance >= drawAccount) {
				System.out.println("[" + this.getName() + "]取" + drawAccount + "￥， 余" + (balance - drawAccount));
				account.setBalance(balance - drawAccount);
			} else {
				System.out.println("余额不足");
			}
		}
	}
}

class Account {
	private String accountNo;
	private double balance;
	
	public Account() {}
	
	public Account(String a, double b) {
		this.accountNo = a;
		this.balance = b;
	}
	
	public double getBalance() {
		return this.balance;
	}
	
	public void setBalance(double b) {
		this.balance = b;
	}
	
	public String getAccountNo() {
		return this.accountNo;
	}
}
