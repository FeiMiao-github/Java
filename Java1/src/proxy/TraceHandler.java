package proxy;

import java.lang.reflect.*;

public class TraceHandler implements InvocationHandler {
	private Object target;
	
	public TraceHandler(Object t) {
		this.target = t;
	}

	public Object invoke(Object proxy, Method m, Object[] args) throws Throwable{
		System.out.print(target);
		System.out.print("." + m.getName() + "(");
		if (args != null) {
			for (int i = 0; i < args.length; i++) {
				System.out.print(args[i]);
				if (i < args.length - 1) System.out.println(", ");
			}
		}
		System.out.println(")");
		
		return m.invoke(target, args);
	}
}
