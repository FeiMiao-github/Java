package proxy;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;;
public class Handler implements InvocationHandler{
	private RealSubject real = null;
	
	public Handler(RealSubject real) {
		super();
		this.real = real;
	}
	
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable{
		discount();
		method.invoke(real, args);
		give();
		return null;
	}
	
	private void discount() {
		System.out.println("打折！");
	}
	
	private void give() {
		System.out.println("赠送购物券！");
	}
}
