package multithreading;

/* 同步方法 */
public class demo154 {
	public static void main(String[] args) {
		AccountDemo ad = new AccountDemo("账户", 1000);
		Thread t1 = new Thread(new Draw(ad, 300), "1");
		Thread t2 = new Thread(new Draw(ad, 200), "2");

		t1.start();
		t2.start();

		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("[余]" + ad.getBalance());
	}

}

class Draw implements Runnable {
	private AccountDemo account;
	private double drawAmount;

	public Draw(AccountDemo a, double drawAmount) {
		this.account = a;
		this.drawAmount = drawAmount;
	}

	@Override
	public void run() {
		this.account.draw(drawAmount);
	}

}

class AccountDemo {
	private double balance;
	private String ID;

	public AccountDemo() {

	}

	public AccountDemo(String an, double b) {
		this.balance = b;
		this.ID = an;
	}

	public String getID() {
		return ID;
	}

	public double getBalance() {
		return this.balance;
	}

	public synchronized void draw(double drawAmount) {
		if (drawAmount > this.balance) {
			System.out.println("余额不足");
		} else {
			System.out.println(
					Thread.currentThread().getName() + "取" + drawAmount + "$, 余" + (balance - drawAmount) + "$");
			this.balance -= drawAmount;
		}
	}
}
