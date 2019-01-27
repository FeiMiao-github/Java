package Map;

import java.util.Map;
import java.util.TreeMap;

/**
 * @author JZ SortedMap 接口 和 TreeMap 实现类 TreeMap就是一个红黑树结构
 */
public class demo120 {
	public static void main(String[] args) {
		demo120 demo = new demo120();

		demo.test();
	}

	/**
	 * 自然排序 TreeMap的所有key 必须实现 Comparable 定制排序 不要求 key 实现Comparable 接口
	 */
	void test() {
		/* 定制排序 */
		TreeMap<K, V> map = new TreeMap<K, V>((o1, o2) -> o1.getKey().compareTo(o2.getKey()));

		map.put(new K(1), new V("A"));
		map.put(new K(4), new V("AAAA"));
		map.put(new K(3), new V("AAA"));
		map.put(new K(5), new V("AAAAA"));
		map.put(new K(2), new V("AA"));

		print(map);
		
		Map.Entry<K, V> mEntry = map.firstEntry();
		print(mEntry);
		
		K flag = new K(3);
		
		print(map.lowerEntry(flag));
		print(map.higherEntry(flag));
		
		/* sub Map*/
		print(map.tailMap(flag));
	}

	void print(Object m) {
		System.out.println(m);
	}
}

class K {
	private Integer key;

	public K() {
	}

	public K(int k) {
		this.key = Integer.valueOf(k);
	}
	
	public Integer getKey() {
		return this.key;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;

		if (obj != null && (obj instanceof K)) {
			return ((K) obj).key.equals(this.key);
		}

		return false;
	}

	@Override
	public String toString() {
		return this.getClass().getSimpleName() + "@" + this.key;
	}
}

class K1 extends K implements Comparable<K1> {
	public K1(int k) {
		this.key = Integer.valueOf(k);
	}

	private Integer key;

	@Override
	public int compareTo(K1 o) {
		return this.key.compareTo(o.key);
	}
}

class V {
	private String str = null;

	public V() {
	}

	public V(String s) {
		if (s == null) {
			throw new NullPointerException("hey！！！  guys ~");
		}
		this.str = s;
	}

	@Override
	public String toString() {
		return V.class.getSimpleName() + "@" + str;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == this)
			return true;

		if (obj != null && obj.getClass() == V.class) {
			return ((V) obj).str.equals(this.str);
		}

		return false;
	}

	@Override
	public int hashCode() {
		return super.hashCode();
	}
}
