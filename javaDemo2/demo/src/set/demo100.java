package set;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

/* 使用 Lambda 表达式遍历集合 */
public class demo100 {
	public static void main(String[] args) {
		demo100 demo = new demo100();
		
		demo.test2();
	}
	
	public void test0() {
		/* 创建集合 */
		@SuppressWarnings("unchecked")
		Collection<Object> c = (Collection<Object>) prepare();
	
		/* 使用 Iterator 遍历集合元素 */
		/* 获取 c 的迭代器 */
		Iterator<Object> it = c.iterator();
		while (it.hasNext()) {
			String book = (String) it.next();
			System.out.println("[book]" + book);
			
			if (book.equals("水浒传")) {
				it.remove();
			}
			
			/* 对 book 赋值 ，不会改变元素集合本身 */
			
			book = "test string";
		}
		
		System.out.println(c);
	}
	
	public void test1() {
		@SuppressWarnings("unchecked")
		Collection<Object> c = (Collection<Object>) prepare();
		
		Iterator<Object> it = c.iterator();
		
		/* 使用 Lambda 表达式来遍历集合元素 */
		it.forEachRemaining(obj -> System.out.println("迭代元素" + obj));
	}
	
	/* 使用 foreach 循环遍历集合元素 */
	public void test2() {
		@SuppressWarnings("unchecked")
		Collection<Object> c = (Collection<Object>)prepare();
		
		for (Object o: c) {
			String book = (String)o;
			System.out.println(book);
			
			if (book.equals("水浒传")) {
				c.remove(book);
			}
		}
		
		System.out.println(c);
	}
	
	public Collection<?> prepare() {
		Collection<Object> c = new HashSet<Object>();
		
		c.add("西游记");
		c.add("三国演义");
		c.add("水浒传");
		c.add("红楼梦");
		
		/* 使用Lambda表达式来遍历集合元素 */
		/* 实现了方法 void accept() */
/**********************************************************		
 * c.forEach(obj-> System.out.println("迭代元素集合" + obj));
 * System.out.println("c 中的元素" + c); 
 * ********************************************************/
		
		return c;
	}
}
