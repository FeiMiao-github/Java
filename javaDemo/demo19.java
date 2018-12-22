

// 一个关于自动装箱、自动拆箱的不重要的问题

public class demo19 {
    public static void main(String[] args) {
        demo19 testInstance = new demo19();

        // testInstance.test1();
        // testInstance.test2();
        // testInstance.test3();
        testInstance.test4();

    }
    
    public void test1() {
        Boolean boolObj = true;
        boolean booleanObj = boolObj;

        System.out.println("booleanObj..." + booleanObj);

        booleanObj = Boolean.parseBoolean("true");
        System.out.println("booleanObj..." + booleanObj);
    }
    
    public void test2() {
        Byte byteObj = Byte.parseByte("127");
        System.out.println("byteObj..." + byteObj);
    }

    public void test3() {
        Integer a = 3;
        Integer b = 3;
        System.out.println("a==b ?????");
        System.out.println(a == b);
        // 见源码

        a = 128;
        b = 128;
        System.out.println("a==b ?????");
        System.out.println(a == b);
        // a 和 b 是引用变量，地址不同
    }

    public void test4() {
        Byte t = Byte.valueOf("24", 8); // 24
        int intNum = Integer.parseInt("10", 2);

        System.out.println("t =" + t);
        System.out.println(intNum);


        System.out.println(Integer.toBinaryString(t));
    }

    public void test5() {
        for (int i = 1; i < 8; i++) {
            System.out.println("高位补零， 向右移位" + i + "次, " + Integer.toBinaryString(0B11111111 >>> i));
        }
    }
}