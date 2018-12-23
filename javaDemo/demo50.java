import javax.swing.JFrame;

/**
 * demo50 Lambda表达式引用方法和构造器
 */
public class demo50 {
    public static void main(String[] args) {
        new demo50().test();
    }

    void test() {
        String s = "10010";

        FunctionInterface convertInstance = from -> {
            return Integer.valueOf(s);
        };
        System.out.println(convertInstance.convert(s) + 1);
        
        /* 调用类方法 */
        FunctionInterface convertInstance2 = from -> Integer.valueOf(s, 2);
        System.out.println("convertInstance2.convert = " + convertInstance2.convert(s));

        /* 调用类方法2 */
        FunctionInterface convertInstance3 = Integer::valueOf;
        System.out.println("convertInstance3.convert = " + convertInstance3.convert(s));

        /* 引用特定对象的实例方法 */
        FunctionInterface convertInstance4 = from -> "f12345654321".indexOf(from);
        System.out.println("convertInstance4.convert = " + convertInstance4.convert("21"));

        FunctionInterface convertInstance5 = "f23123121"::indexOf;
        System.out.println("convertInstance5.convert = " + convertInstance5.convert("21"));

        /* 调用某类对象的实例方法 */
        FunctionInterface2 convertInstance6 = (a, b, c) -> a.substring(b, c);
        System.out.println("convertInstance6.convert = " + convertInstance6.subString("hello world", 2, 4));

        FunctionInterface2 convertInstance7 = String::substring;
        System.out.println("convertInstance7.convert = " + convertInstance7.subString("hello world", 2, 6));

        /* 调用构造器 */
        FunctionInterface3 convertInstance8 = a -> new JFrame(a);
        JFrame jf = convertInstance8.consruct("hello world");
        System.out.println(jf);

        FunctionInterface3 convertInstance9 = JFrame::new;
        jf = convertInstance9.consruct("hello jframe");
        System.out.println("convertInstance9.consruct" + jf);
    }
}

@FunctionalInterface
interface FunctionInterface {
    int convert(String from);
}

@FunctionalInterface
interface FunctionInterface2 {
    String subString(String a, int b, int c);
}

@FunctionalInterface
interface FunctionInterface3 {
    JFrame consruct(String a);
}