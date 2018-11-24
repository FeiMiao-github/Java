package lambda;

public class TimedGreeter  {
	
	public static void main(String[] args) {
		FunctionInterface say1 = () -> System.out.println("Hello, baby");
		say1.say();
		
		// ( int x, int y ) ->{ x + y }; 直接匿名函数
		// （x + y ) -> x + y;
		
		
		Runnable run1 = () -> {System.out.println("小伙纸");};
		Runnable run2 = new Runnable() {
			
			@Override
			public void run() {
				System.out.println("小姐姐");
				
			}
		};
		
		run1.run();
		run2.run();
	}
	
	public int add(int x, int y) {
		return x + y;
	}
	
	public interface FunctionInterface{
		public void say();
	}
}
