
// `"=="` 和 `"equals()"` 方法
public class demo21 {
    public static void main(String[] args) {
        demo21 demo = new demo21();

        demo.test1();
        System.out.println("\n");

        demo.test3();
        System.out.println("\n");

        demo.test4();
    }

    public void test1() {
        int i1 = 30;
        float i2 = 30f;
        double i3 = 30.0f;
        char i4 = (char) 30;

        System.out.println("i1 == i2 ---- " + (i1 == i2));
        System.out.println("i1 == i3 ---- " + (i1 == i3));
        System.out.println("i1 == i4 ---- " + (i1 == i4));
    }

    public void test2() {
        // Integer i1 = 30;
        // Float i2 = 30f;
        // Double i3 = 30.0;
        // Character i4 = (char) 30;

        // System.out.println("i1 == i2 ---- " + (i1 == i2));
        // System.out.println("i1 == i3 ---- " + (i1 == i3));
        // System.out.println("i1 == i4 ---- " + (i1 == i4));
        // 不可比较
    }

    public void test3() {
        int i = -129;

        Integer i1 = i;
        Integer i2 = i;

        System.out.println("i1 == i2? --- " + (i1 == i2));
        // -128 <= i < 128 时true
        // i > 128 时true
        System.out.println("i1 equals i2" + i1.equals(i2)); // true

        @SuppressWarnings("deprecation")
        Integer i3 = new Integer(i);
        @SuppressWarnings("deprecation")
        Integer i4 = new Integer(i);

        System.out.println("i3 == i4? --- " + (i3 == i4)); // false
        System.out.println("i3 equals i4" + i3.equals(i4)); // true
    }

    public void test4() {
        String str1 = "hello";
        String str2 = "hello";

        System.out.println("str1 == str2 ----" + (str1 == str2)); // 常量池， 编译时就可以确定
        System.out.println("str1 equals str2 ----" + str1.equals(str2));

        String str3 = new String("hello");
        String str4 = new String("hello");

        System.out.println("str3 == str4 ----" + (str3 == str4)); // 不同的堆内存， 运行时确定
        System.out.println("str3 equals str4 ----" + str3.equals(str4));
    }
}