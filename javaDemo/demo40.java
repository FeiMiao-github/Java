/**
 * demo40
 */
enum InnerClassType {
    FIRST, SECOND, THIRD;
}

public class demo40 {
    public static void main(String[] args) {
        demo40 demo = new demo40();
        demo.test();

        demo.test(InnerClassType.FIRST);
        demo.test(InnerClassType.SECOND);
        demo.test(InnerClassType.THIRD);
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
    
    public void test(InnerClassType t) {
        Cow c = new Cow();
        int iargs;

        switch (t) {
        case FIRST:
            iargs = 0;
            break;
        case SECOND:
            iargs = 1;
            break;
        case THIRD:
            iargs = 2;
            break;
        default:
            iargs = -1;
            break;
        }
        
        if (iargs != -1) {
            c.testInnerClassNonStatic(iargs);
        }
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
    
    public void testInnerClassNonStatic(int args) {
        InnerClassNonStatic t = new InnerClassNonStatic();
        t.getTempString(args);
    }
    /**
     * InnerClassNonStatic 非静态内部类
     */
    public class InnerClassNonStatic {
        String tempString = "InnerClass Non-Static";

        public void test() {
            System.out.println("非静态内部类中不能有静态成员");
        }
        
        public void getTempString(int args) {
            String tempString = "getTempString";
            switch (args) {
            case 0:
                System.out.println("内部类中函数的TempString = " + tempString);
                break;
            case 1:
                System.out.println("内部类中的成员TempString = " + this.tempString);
                break;
            case 2:
                System.out.println("外部类中的成员变量TempString = " + Cow.this.tempString);
                break;
            default:
                break;
            }
        }
    }
}