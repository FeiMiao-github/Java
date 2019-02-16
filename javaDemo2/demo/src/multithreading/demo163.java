package multithreading;

public class demo163 {
	public static void main (String[] args) {
		// 设置主线程的异常处理器
		Thread.currentThread().setUncaughtExceptionHandler(new MyHandler());
		
		int a = 5 / 0;
		System.out.println("程序正常结束！");
	}
}

class MyHandler implements Thread.UncaughtExceptionHandler {
	@Override
	public void uncaughtException(Thread t, Throwable e) {
		System.out.println("[" + t.getName() + "]" + e);
	}
}
