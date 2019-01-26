package testData;

public final class TestClass implements Comparable<TestClass>{
	private int num;
	
	public TestClass() {};
	
	public TestClass(int num) {
		this.num = num;
	}
	
	@Override
	public String toString() {
		return this.getClass().getSimpleName() + "@" 
				+ this.num;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		
		if (obj.getClass() == TestClass.class) {
			return ((TestClass)obj).num == this.num;
		}
		
		return false;
	}
	
	@Override
	public int hashCode() {
		return this.num;
	}
	
	public static TestClass[] initeTestClasses(int n) {
		TestClass[] tc = new TestClass[n];
		
		for (var i = 0; i < n; i++) {
			tc[i] = new TestClass(i);
			System.out.println(tc[i]);
		}
		
		return tc;
	}

	@Override
	public int compareTo(TestClass o) {
		return this.num - o.num;
	}
}
