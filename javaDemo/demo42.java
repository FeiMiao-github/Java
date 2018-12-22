/**
 * demo42 静态内部类
 */
public class demo42 {
    public static void main(String[] args) {
        demo44 d = new demo44();

        d.test();
    }

    public void test() {
        /*  内部类访问外部类 */
        OuterClass.InnerClass.getNum1();
        new OuterClass.InnerClass().getOutNum1();

        /* 外部类访问内部类 */
        new OuterClass().getInnerClassNum();
    }
}

class OuterClass {
    private int num1 = 1;
    private static int staticNum1 = 2;

    public void getInnerClassNum() {
        System.out.println("InnerClass num1 = " + new InnerClass().num1 +
            "\n" + "InnerClass static num = " + InnerClass.staticNum1);
    }

    static class InnerClass {
        private int num1 = 3; // 非静态成员变量
        private static int staticNum1 = 4; // 静态成员变量

        public static void getNum1() {
            String s1 = "InnerClass 里面的 num1 = ";
            final String s2 = "InnerClass 里面的 staticNum1 = ";
            System.out.println(s1 + /*num1 + */
                    new InnerClass().num1 +
                    "\n" + s2 + staticNum1);
        }

        /**********************************************
         *  1.静态内部类不能访问外部类的实例变量，因为静态
         * 内部类属于外部类的静态成员
        *********************************************/
        public void getOutNum1() {
            System.out.println("OuterClass 里面的 staticnum1 = " + OuterClass.staticNum1
                    + "\n" + "OuterClass 里面的 num1 = " + new OuterClass().num1);
        }
    }
}

