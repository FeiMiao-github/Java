package set;

import java.util.HashSet;

public class demo103 {	
	public static void main(String[] args) {
		HashSet<Object> hs = new HashSet<Object>();
		
		hs.add(new A());
		hs.add(new A());
		hs.add(new B());
		hs.add(new B());
		hs.add(new C());
		hs.add(new C());
		
		System.out.println(hs);
	}
}

class A {
	public boolean equals() {
		return true;
	}
}

class B {
	public int hashCode() {
		return 1;
	}
}

class C {
	public int hashCode() {
		return 2;
	}
	
	public boolean equals(Object o) {
		return true;
	}
}
