package proxy;

public class RealSubject implements Subject{
/*真实主体角色，被代理类*/
	@Override
	public void saleBook() {
		System.out.println("卖书！");
	}
}
