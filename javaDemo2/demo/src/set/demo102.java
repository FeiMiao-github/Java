package set;

import java.awt.List;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/* 使用Stream 操作集合 */
public class demo102 {
	public static void main(String[] args) {
		IntStream is = IntStream.builder().add(3)
				.add(13)
				.add(-2)
				.add(18).build();
		
		demo102 demo = new demo102();
		
		demo.test3();
	}
	
	public void test(IntStream is) {
		/* 以下代码每次只能执行一行 */
//		System.out.println("is 中的最大值" + is.max().getAsInt());
//		System.out.println("is 中的最小值" + is.min().getAsInt());
//		System.out.println("is 所有 元素的总和" + is.sum());
//		System.out.println("is 所有元素的总数" + is.count());
//		System.out.println("is 的所有元素的平均值" + is.average());
//		System.out.println("is 的所有平方值是否都大于20" + is.allMatch(obj -> (obj * obj > 20)));
//		System.out.println("is 是否存在元素的平方和大于20" + is.anyMatch(obj -> (obj * obj > 20)));
		
		/* 将is映射到一个新的Stream */
		IntStream isNew = is.map(ele -> 2 * ele + 1);
		isNew.forEach(ele -> System.out.println(ele));
		
		/* 中间方法： 中间操作允许流保持打开状态 ， 并运行直接调用后续方法 */
		/* 末端方法： 末端方法时对流的最终操作，当某个方法对流执行末端方法后， 该条流将被消耗 。且不再可用 */
	}
	
	/* 末端方法 */
	public void test2(IntStream is) {
//		is.forEach(ele -> System.out.println("[ele]" + ele));
		Object a= is.findAny().getAsInt();
		System.out.println(a);
	}
	
	public void test3() {
		Collection<String> c = new ArrayList<String>();
		
		c.add("Hello world");
		c.add("大话西游");
		c.add("乌龙院");
		c.add("南方公园");
		
		/* 统计包含“南方”的字符串数量  */
		System.out.println("包含“南方”的字符串数量: " + c.stream().filter(ele -> ele.contains("南方")).count());
		
		
		System.out.printf("集合映射： ");
		/* 调用Stream 的 mapToint() 方法将集合转换为 Stream */
		c.stream().mapToInt(ele -> ele.length()).forEach(ele -> System.out.println(ele));
	}
}
