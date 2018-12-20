/**
 * demo40
 */
public class demo40 {
    public static void main(String[] args) {
        demo40 demo = new demo40();
        demo.test();
    }

    private void test() {
        Cow.description();

        Cow c = new Cow();
        c.getCowLeg();
        
        /** 
         * 访问内部类 
        */
        String name = Cow.InnerClassNonStatic.class.getName();
        System.out.println("InnerClassNonStatic in Cow, and name = " + name);
    }
}

// 内部类
class Cow{
    public static void description() {
        System.out.println("一个外部类");
    }

    public int getCowLeg() {
        System.out.println("很长很长");

        return 0;
    }

    /** 访问类内同名变量 */
    String tempString = "Cow";

    /**
     * InnerClass 静态内部类
     */
    public static class InnerClass {
        public static void description() {
            System.out.println("静态类中不能有非静态成员");
        }
    }
    
    /**
     * InnerClassNonStatic 非静态内部类
     */
    public class InnerClassNonStatic {
        String tempString = "InnerClass Non-Static";

        public void test() {
            System.out.println("非静态内部类中不能有静态成员");
        }
        
        public void getTempString() {
            
        }
    }
}

interface Command {
    public void process();
}