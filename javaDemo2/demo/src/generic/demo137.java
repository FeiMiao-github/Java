package generic;

//import java.util.ArrayList;
//import java.util.List;

public class demo137 {
	public static void main(String[] args) {
//		List<String> [] las = new ArrayList<String>[10];
	}
	
	static class Apple<T> {
		T size;
		
		public Apple() {}
		public Apple(T size) {
			this.size = size;
		}
		
		public void setSize(T size) {
			this.size = size;
		}
		
		public T getSize() {
			return this.size;
		}
	}
}

class Test {
	private String s = Test.class.getName();
	public String getInfo() {
		return this.s;
	}
}
