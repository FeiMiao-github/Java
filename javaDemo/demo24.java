public class demo24 {
    private static final String staticString = "static string";
    private final String string = "string";

    private final static String staticStrings;
    private final String strings;

    static {
        staticStrings = "static strings";
    }

    public static void main(String[] args) {
        System.out.println(staticString);
        
        demo24 demo = new demo24(); // 
    }

    {
        /**
         * 系统不会对final修饰的变量进行初始化
         *  */
        // System.out.println(strings); 未初始化变量， 因此无法调用

        strings = "山川相缪, 郁乎苍苍";
        System.out.println(strings);
    }
    
    demo24() {
        // strings = "道可道, 非常道"; 已在初始化代码块中赋值， 无法重新赋值
        System.out.println(strings);
    }
}