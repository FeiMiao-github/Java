package Map;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;

public class demo117 {
	public static void main(String[] args) {
		demo117 demo = new demo117();

		demo.test2();
	}

	/* 改进的HashMap 和HashTable 实现类 */
	/* 相较与HashTable ， HashMap 可以有且最多有一个key-value对的key 值为null */
	void test() {
		HashMap<Integer, String> hm = new HashMap<Integer, String>();

		hm.put(null, null);
		hm.put(1, null);
		print(hm);
	}
	
	/* HashMap 与 Hashtable 不能保证其中的key-value 的顺序*/
	
	
	/**
	 * 在HashMap中存储和获取对象， 用作key的对象必须实现 equals 和
	 * hashCode 方法 
	 */
	public void  test1() {
		Map<A, B> ht = new Hashtable<A, B>();
		
		ht.put(new A(0), new B());
		ht.put(new A(3), new B());
		
		print("[test1]" + ht.containsValue(new B(1)));
		print("[test1]" + ht.containsKey(new A(2)));
		
		print(ht);
		ht.remove(new A(0));
		print(ht);
	}
	
	/**
	 * 同 hashSet 类似， HashMap and Hashtable class, 
	 * can not call to the Object which has been modified 
	 *  in iterations
	 * */
	public void test2() {
		HashMap<A, String> hm = (HashMap<A, String>) getMap();
		
		Iterator<A> it = hm.keySet().iterator();
		A first = it.next();
		
		first.count = 5;
		print(hm);
		print("[remove new A(5)]" + hm.remove(new A(5))); // deletion fails
		
		print("[hm]" + hm);
		print("contains the key \"new A(5) \""+ hm.containsKey(new A(5)));
		print(hm.get(new A(3))); // return null
		print(hm.get(new A(5))); // return null
	}
	
	public Map<A, String> getMap() {
		HashMap<A, String> map = new HashMap<A, String>();

		map.put(new A(3), "IOS");
		map.put(new A(6), "Windows");
		map.put(new A(9), "Android");

		print(map); // 排序
		return map;
	}

	private void print(Object o) {
		System.out.println(o);
	}
}


class A {
	int count;
	public A(int c) {
		this.count = c;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj == this) return true;
		if (obj != null && obj.getClass() == A.class) {
			return this.count == ((A)obj).count;
		}
		
		return false;
	}
	
	@Override
	public int hashCode() {
		return this.count;
	}
}

class B {
	int value;
	
	B() {}
	B(int v) {this.value = v;}
	@Override
	public boolean equals(Object obj) {
		return true;
	}
}