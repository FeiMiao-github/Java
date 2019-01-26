package Queue;

import java.util.ArrayDeque;
import java.util.Deque;
import org.junit.jupiter.api.Test;

/* Deque 接口与ArrayDeque实现类 
 * */
public class demo113 {
	
	@Test
	public void test1() {
		Deque<String> dq = getDeque();
		
		/* 作为栈来使用 */
		dq.pop();
		print(dq);
		
		/* 作为队列使用 */
		dq.offer("0"); // 在尾部添加元素
		print("[在尾部添加元素]" + dq);
		
		print(dq.poll()); // 移除首部元素
		print("[移除首部元素]"  + dq);
	}
	
	public Deque<String> getDeque() {
		/* Deque 是一个双端队列 */
		Deque<String> dq = new ArrayDeque<String>();
		dq.push("1");
		dq.push("23");
		dq.push("456");
		dq.push("78");
		dq.push("9");
		
		print(dq);
		return dq;
	}
	
	public void print(Object o) {
		System.out.println(o.toString());
	}
}
