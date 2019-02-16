package multithreading;

/*	线程相关类: 	ThreadLocal	线程局部变量  */
public class demo167 {
	public static void main(String[] args) {
		demo167 demo = new demo167();
		AccountTL account = new AccountTL("初始");
		
		demo.run(account);
		new ThreadTL(account, "线程1").start();
		new ThreadTL(account, "线程2").start();
		new ThreadTL(account, "线程3").start();
	}
	
	public void run(AccountTL account) {
		for (int i = 0; i < 10; i++) {
			if (i == 6) {
				account.setName(Thread.currentThread().getName());
			}
			
			System.out.println("[" + account.getName() + "]"
					+ i);
		}
	}
}

class AccountTL {
	private ThreadLocal<String> name = new ThreadLocal<String>();
	
	public AccountTL(String name) {
		this.name.set(name);
		System.out.println(this.name.get());
	}
	
	public void setName(String name) {
		this.name.set(name);
	}
	
	public String getName() {
		return this.name.get();
	}
}

class ThreadTL extends Thread {
	private AccountTL account;
	
	public ThreadTL(AccountTL at, String threadName) {
		super(threadName);
		account = at;
	}
	
	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			if (i == 6) {
				account.setName(this.getName());
			}
			
			System.out.println("[" + account.getName() + "]"
					+ i);
		}
	}
}
