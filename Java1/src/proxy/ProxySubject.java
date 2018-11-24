package proxy;

public class ProxySubject implements Subject{
	private RealSubject real;
	
	public void setReal(RealSubject real) {
		this.real = real;
	}
	
	public void saleBook() {
		discount();
		real.saleBook();
		give();
	}
	
	private void discount() {
		System.out.println("打折！");
	}
	
	private void give() {
		System.out.println("赠送代金券！");
	}
}
