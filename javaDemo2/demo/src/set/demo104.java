package set;

import java.util.HashSet;
import java.util.Iterator;
import java.util.stream.Stream;
/*
   * 可变对象加入到HashSet中之后， 尽量不要修改集合元素中参与计算的 
 * hashCode 和 equals 的实例变量， 否则将会导致 HashSet 无法
  * 正确操纵这些元素
 * */
public class demo104 {
	public static void main(String[] args) {
		HashSet<Object> hashSet = new HashSet<Object>();
		
		hashSet.add(new R(5));
		hashSet.add(new R(15));
		hashSet.add(new R(25));
		
		
		hashSet.add(new R(-5));
		hashSet.add(new R(9));
		hashSet.add(new R(-2));
		hashSet.add(new R(-2));
		
		/* 打印HashSet集合， 集合元素没有重复 */
		System.out.println(hashSet);
		
		Iterator<Object> it = hashSet.iterator();
		/* 为第一个元素的 count 变量赋值 */
		R first = (R)it.next(); /*hashCode 为 -2*/ 

		first.count = 3;
		/* 输出HashSet集合 */
		System.out.println(hashSet);
		
		hashSet.remove(new R(3));/* new R(3) hashCode 为 3*/
		
		/* 删除失败*/
		System.out.println(hashSet);
		
		/* 添加元素-2 */
		hashSet.add(new R(-2));
		System.out.println(hashSet);
		
		/* 尝试获取元素 hashCode 为 -2 的值 */
		Stream<Object> stream_2 = hashSet.stream().filter(obj -> obj.hashCode() == new R(-2).hashCode());
		stream_2.forEach(ele -> System.out.println(ele.toString()));
		
		System.out.println(hashSet);
		
		System.out.println(hashSet.contains(new R(3))); /* false */
		it = hashSet.iterator();
//		System.out.println(it.next().equals(new R(3))); /* true */
		{
			R temp = (R) it.next();
			
			if (temp.equals(new R(3))) {
				it.remove(); /* 采用迭代器删除成功 */
			}
			// hashSet.remove(temp); 删除失败
		} 
		System.out.println(hashSet);

		
		/* 删除成功
		 *  */
		hashSet.remove(new R(-2));
		System.out.println(hashSet);
	}
}

class R {
	int count;
	
	public R(int count) {
		this.count = count;
	}
	
	@Override
	public String toString () {
		return "R" + "[count: " + this.count + ", @" + this.hashCode() + "]";
	}
	
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		
		if (o != null && o.getClass() == R.class) {
			return this.count == ((R)o).count;
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		return this.count;
	}
}
