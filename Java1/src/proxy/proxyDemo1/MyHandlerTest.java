package proxy.proxyDemo1;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class MyHandlerTest {
	public static void main(String[] args) {
		// 实际类
		Integer i1 = 1;
		Integer i2 = 2;
		
		// 定义处理器Handler
		InvocationHandler i1Handler = new MyHandler(i1);
		InvocationHandler i2Handler = new MyHandler(i2);
		// 运行时定义， 实现了Comparable 接口，不过它的CompareTo 方法调用了invoke()方法
		Object i1Proxy = Proxy.newProxyInstance(null,
				new Class[]{Comparable.class}, i1Handler);
		Object i2Proxy = Proxy.newProxyInstance(null,
				new Class[]{Comparable.class}, i2Handler);
		Object[] elements = {i1Proxy, i2Proxy};

		System.out.print(elements[0]);
	}
}
