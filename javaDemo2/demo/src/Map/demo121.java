package Map;

import java.util.WeakHashMap;

/**
 * @author JZ
 * WeakHashMap 实现类
 * 与HashMap 相比， key-value 可能会被自动删除
 */
public class demo121 {
	public static void main(String[] args) {
		WeakHashMap<String, String> whmap = new WeakHashMap<String, String>();
		
		whmap.put(new String("语文"), new String("良好"));
		whmap.put(new String("数学"), new String("中等"));
		whmap.put(new String("英语"), new String("及格"));
		
		whmap.put("Java", new String("优秀"));
		
		/* 回收对象前 */
		System.out.println(whmap);
		
		System.gc();
		System.runFinalization();
		
		/* 回收对象后 */
		System.out.println(whmap);
	}
}
