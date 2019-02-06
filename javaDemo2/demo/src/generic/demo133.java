package generic;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

/* 泛型方法 */
/**
 * @author JZ
 *
 */
public class demo133 {
	public static void main(String[] args) {
		demo133 demo = new demo133();
		
		demo.test(4);
	}
	
	void test(int v) {
		switch (v) {
		case 1:
			test1();
			break;
			
		case 2:
			test2();
			break;
			
		case 3:
			test3();
			break;
			
		case 4:
			test4();
			break;

		default:
			break;
		}
	}
	
	void test1() {
		class Method {
			public void  fromArrayToCollection(Object[] a, Collection<Object> c) {
				for (Object o: a) {
					c.add(o);
				}
			}
		}
		
		Object[] stringO = new Object[] {"o1", "o2", "o3"};
		Collection<Object> c = new HashSet<Object>();
		
		/* 把Object数组的元素添加到Collection组合中 */
		new Method().fromArrayToCollection(stringO, c);
		
		System.out.println("[Collection]" + c);
		
		/* 可见上面的 fromArrayToCollection 方法不可以传入 List<String> */
//		String[] string = {"string1", "string2", "string3"};
//		List<String> l = new ArrayList<String>();
//		Collection<String> cstring = new HashSet<String>();
//		new Method().fromArrayToCollection(string, l);
// 		new Method().fromArrayToCollection(string, cstring); /* error */
//		
//		System.out.println("[Collection]" + l);
		System.out.println();
	}
	
	
	/**
	 *  定义泛型方法
	 */
	public void test2() {
		class MethodClass {
			<T> void fromArrayToCollection(T[] a, Collection<T> c) {
				for (var t: a) {
					c.add(t);
				}
			}
		}
		
		String[] string = {"string1", "string2", "string3"};
		List<String> lstring = new ArrayList<String>();
		new MethodClass().fromArrayToCollection(string, lstring);
		
		System.out.println("[Collection<T>]" + lstring);
	}
	
	/* Right test */
	public void test3() {
		class MethodClass {
			<T> void fromCollectionToCollection(Collection<? extends T> from, Collection<T> to) {
				for (var f: from) {
					to.add(f);
				}
			}
		}
		
		String[] string = {"string1", "string2", "string3"};
		List<Object> oList = new ArrayList<Object>();
		List<String> sList = new ArrayList<String>();
		
		for (var s: string) {
			sList.add(s);
		}
		
		new MethodClass().fromCollectionToCollection(sList, oList);
		
		System.out.println("[sList]" + oList);		
	}
	
	/* 同上 */
	public void test4() {
		class MethodClass {
			@SuppressWarnings("unchecked")
			<T, S extends T> void fromCollectionToCollection(Collection<T> from, Collection<S> to) {
				for (T f: from) {
						to.add((S) f);
				}
			}
		}
		
		String[] string = {"string1", "string2", "string3"};
		List<Object> oList = new ArrayList<Object>();
		List<String> sList = new ArrayList<String>();
		
		for (var s: string) {
			oList.add(s);
		}
		
		new MethodClass().fromCollectionToCollection(oList, sList);
		
		System.out.println("[sList]" + sList);		
	}
}
