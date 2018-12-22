/**
 * demo43 使用内部类
 */
public class demo43 {
    public static void main(String[] args) {
        new demo43().test();
    }

    public void test() {
        new OuterClass();
        
        printInnerStaticClassNum();
        printInnerClassNum();
    }
    
    /* 类外访问静态类 */
    public void printInnerStaticClassNum() {
    	int num = new OuterClass.InnerStaticClass().getNum();
    	System.out.println("Class: " + OuterClass.InnerStaticClass.class.getSimpleName() + ", num = " + num);
    	System.out.println("Class: " + OuterClass.InnerStaticClass.class.getSimpleName() 
    			+ ", String = " + new OuterClass.InnerStaticClass().deString);
    }
    
    /* 类外访问非静态类 */
    public void printInnerClassNum() {
    	int num = new OuterClass().new InnerClass().getNum();
    	System.out.println(OuterClass.InnerClass.class.getSimpleName() + " --- "
    			+ " num = " + num);
    }
}

class OuterClass {
    // 鸡肋的局部内部类
    static {
        class InnerClassInStaticCode {
            private int num = 3;

            public int getNum() {
                return this.num;
            }

            public void setNum(int i) {
                this.num = i;
            }
        }
        
        InnerClassInStaticCode instance = new InnerClassInStaticCode();
        System.out.println(InnerClassInStaticCode.class.getSimpleName() + instance.getNum());
        new InnerClassInStaticCode().setNum(5);
        
        System.out.println(instance.getNum());
    }
    static class InnerStaticClass {
        private int num = 4;
        String deString = getClass().getSimpleName();
        
        public int getNum() {
        	return this.num;
        }
    }
    class InnerClass{
    	private int num = 4;
    	static final String string2 = "123456"; // 静态变量不能声明在非静态内部类中，除非是个常量
    	String string = "测试非静态内部类";
    	
    	public void setNum(int num) {
			this.num = num;
		}
    	
    	public int getNum() {
    		return this.num;
    	}
    }
// 不可访问
//    public void testInnerClassInStaticCode() {
//    	int num = new OuterClass.InnerClassInStaticCode().getNum();
//    	System.out.println(num + "hahaha");
//    }
}

