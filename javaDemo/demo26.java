// 编译时确定变量的值还是运行时确定编译的值
public class demo26 {
    public static void main(String[] args) {
        final String string1 = "罗小黑战记0";
        final String string2 = "罗小黑" + "战记" + "0"; // 存放在常量池
        final String string3 = "罗小黑战记" + String.valueOf(0);  // 调用了方法，存放在内存

        System.out.println(string1);
        System.out.println("string1 == string2 ---- " + (string1 == string2)); // true
        System.out.println("string1 == string2 ---- " + (string1 == string3)); // false

        System.out.println("string1 equals string3 --- " + string1.equals(string3));

        demo26 demo = new demo26();

        demo.test();
        
    }
    
    private final String string1 = "老君";
    private final String string2;

    demo26() {
        final String string3;

        string3 = "老君";

        System.out.println("罗小黑战记第11集");
        string2 = "老君";
        System.out.println("string1 == string2 ---- " + (string1 == string2));
        System.out.println("string1 == string2 ---- " + (string1 == string3));
    };

    public void test() {
        final String string4;
        string4 = "老君";

        System.out.println("string1 == string4 ---- " + (string4 == this.string1));
    }
}