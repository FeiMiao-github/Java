package generic;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
/* 定义泛型接口和类 */
public class demo131 {
	private final static String[] STRINGS = new String[]{"你好", "再见", "有什么事"}; 
	public static void main(String[] args) {
		demo131 demo = new demo131();
		demo.test(3);
	}
	
	public void test(int k) {
		
		switch (k) {
		case 1:
			List<String> listString = new LinkedList<String>();
			
			for (String s: STRINGS) {
				listString.add(s);
			}
			test1(listString);
			break;
			
		case 2:	
		/* 1 */
		{
			List<Shape> l = new LinkedList<Shape>();
			l.add(new Circle());
			l.add(new Rectangle());
			
			Canvas canvas = new Canvas();
			canvas.drawAll(l);
			
			canvas.newDrawAll(l);
		}

			break;
		case 3:
		/* 2 */
		{
			List<Circle> l = new ArrayList<demo131.Circle>();
			
			l.add(new Circle());
			
			Canvas canvas = new Canvas();
			
//			canvas.drawAll(l); /* 参数不符合 */
			canvas.newDrawAll(l);
			canvas.forceDrawAll(l);
		}
			break;
		default:
			break;
		}
	}
	
	/* 使用类型通配符 */
	public void test1(List<?> l) {
		for (int i = 0; i < l.size(); i++) {
			System.out.println(l.get(i));
		}
	}
	
	/* 设定通配符的上限  */
	public void test2() {
		
	}
	
	public abstract class Shape {
		public abstract void draw(Canvas c);
	}
	
	public class Circle extends Shape {
		public void draw(Canvas c) {
			System.out.println("绘制一个圆"  + "@" + c);
		};
	}
	
	public class Rectangle extends Shape {
		@Override
		public void draw(Canvas c) {
			System.out.println("绘制一个矩形" + "@" + c);
		}
	}
	
	public class Canvas {
		public void drawAll(List<Shape> shapes) {
			for (Shape s: shapes) {
				s.draw(this);
			}
		}
		
		public void newDrawAll(List<? extends Shape> shapes) {
			for (Shape s: shapes) {
				s.draw(this);
			}
		}
		
		/* 实现强制类型转换 */
		@SuppressWarnings("unchecked")
		public void forceDrawAll(List<?> shapes) {
			for (Shape s: ((List<Shape>)shapes)) {
				s.draw(this);
			}
		}
	}
}