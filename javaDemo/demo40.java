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
        System.out.println(c.InnerClassNonStatic.class.getName());
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
        public void test() {
            System.out.println("非静态内部类中不能有静态成员");
        }
    }
}