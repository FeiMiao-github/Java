package proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class HandlerProxyMain {

	public static void main(String[] args) {
		RealSubject real = new RealSubject();
		InvocationHandler handler = new Handler(real);
		Subject sub = (Subject)Proxy.newProxyInstance(real.getClass().getClassLoader(),
				real.getClass().getInterfaces(), handler);
		
		sub.saleBook();
	}
}
