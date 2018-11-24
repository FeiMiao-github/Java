package proxy.proxyDemo1;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MyHandler implements InvocationHandler{
	private Object temp;
	
	public MyHandler(Object temp) {
		this.temp = temp;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.print(temp);
		System.out.print("." + method.getName() + "(");
		if (args != null) {
			for (int i = 0; i < args.length; i++) {
				System.out.print(args[i]);
				if (i < args.length - 1) System.out.println(", ");
			}
		}
		System.out.println(")");
		return method.invoke(temp, args);
	}
	
	public void getMsg() {
		System.out.println("this is a msg!");
	}
}
