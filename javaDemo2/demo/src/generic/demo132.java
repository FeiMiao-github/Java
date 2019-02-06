package generic;

/* 设定类型形参的上限 */
/* Java 泛型不仅运行在使用通配符时设定上限， 而且可以在定义类型时设定上限 */
public class demo132 {
	public static void main(String[] args) {
		demo132 demo = new demo132();
		demo.test(2);
	}
	
	void test(int key) {
		switch (key) {
		case 1:
			test1();
			break;
			
		case 2:
			test2();
			break;

		default:
			break;
		}
	}
	
	void test1() {
		/* 设定定义类型形参时设定上限 */
		class InnerClass<T extends Number> {
			private T col;
			
			public InnerClass(T c) {
				this.col = c;
			}
			
			public void printCol() {
				System.out.println(this.col + "@" + this);
			}
		}
		
		InnerClass<Integer> inClass = new InnerClass<Integer>(1);
		inClass.printCol();
		
//		InnerClass<String> sClass = new InnerClass<String>("123"); /* error */
	}
	
	void test2() {
		/* 设定定义类型形参时设定多个上限 */
		/**
		 * 至多有一个父类上限和多个接口上限
		 * 如果指定了类上限， 类上限必须位于第一位
		 * */
		class InnerClass<T extends Number & Shape> {
			T col;
			public InnerClass(T c) {
				this.col = c;
			}
			
			void printCol() {
				if (this.col instanceof Shape) {
					System.out.println("[Shape]" + this.col.getDescription());
				} else {
					System.out.println(this.col + "@" + this);
				}
			}
		}
		
		InnerClass<Circle> in = new InnerClass<Circle>(new Circle()); // Circle 继承Number 并实现Shape
		in.printCol();
	}
}

interface Shape {
	default public void draw() {
		System.out.println("draw a " + this.toString());	
	}
	
	default public String getDescription() {
		return this.getClass().getSimpleName() + "@" + this.hashCode();
	}
}

class Circle extends Number implements Shape {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public int intValue() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public long longValue() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public float floatValue() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double doubleValue() {
		// TODO Auto-generated method stub
		return 0;
	}}

class Rectangle implements Shape {}