package set;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

import org.junit.jupiter.api.Test;

/* 操作Collection 集合里的元素 */
public class demo99 {
	
	@Test
	public void test() {
		Collection<Object> c = new ArrayList<>();
		/* 添加元素 */
		c.add("孙悟空");
		
		/* 基本类型自动装箱 */
		c.add(6);
		
		/* size() 获取元素个数 */
		System.out.println("c集合的元素个数是： " + c.size());
		
		/* 删除指定元素 */
		c.remove(6);
		
		System.out.println("c集合的元素个数是： " + c.size());
		
		/* 判断是否存在元素 “孙悟空”*/
		System.out.println("是否存在\"元素孙悟空\"：" + c.contains("孙悟空"));
		c.add("猪八戒");
		
		/* c集合中的元素 */
		System.out.println("c集合中的元素" + c);
		
		Collection<String> books = new HashSet<String>();
		
		books.add("西游记");
		books.add("三国演义");
		books.add("孙悟空");
		System.out.println("c 集合是否完全包含books: " + c.containsAll(books));
		
		/* 用c集合的内容减去books里的所有元素 */
		c.removeAll(books);
		System.out.println("c 集合中的元素： " + c);
		
		c.clear();
		System.out.println("c 集合中的元素： " + c);
		
		/* 从 books 中删除 c 中不存在的元素 */
		books.retainAll(c);
		System.out.println("books 中的元素" + books);
	}
	
	@Test
	public void test2() {
		
		
	}
}
