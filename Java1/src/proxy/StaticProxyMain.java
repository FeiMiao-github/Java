package proxy;

public class StaticProxyMain {
	public static void main(String[] args) {
		RealSubject real = new RealSubject();
		
		//实例化代理类
		ProxySubject proxy = new ProxySubject();
		proxy.setReal(real);
		proxy.saleBook();
	}
}
