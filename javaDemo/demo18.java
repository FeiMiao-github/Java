public class demo18 {
    public static void main(String[] args) {
        /**1
         * Demo.sayS();
         * 输出结果： 
         * 长在红旗下的好少年！=> 静态代码块
         * hello, 树先生！ => 静态方法
         **/

        /** 2
         * String s = Demo.stringS;
         * System.out.println(s);
         * 输出结果：
         * 长在红旗下的好少年！
         * 忠犬八公
         **/
        
        /**3
         * new Demo();
         * 长在红旗下的好少年！
         * 构造
         */

        
        /**4
         * new Demo().say();
         * 长在红旗下的好少年！
         * 忠犬八公
         * 构造
         * 这个杀手不太冷
         */

        /**
         * new Demo();
         * new Demo();
         * 长在红旗下的好少年！
         * 忠犬八公(静态代码块只在类生成的时候运行一次！)
         * 
         * 根红苗正的四好青年
         * 构造
         * 根红苗正的四好青年
         * 构造
         */
    }
}

class Demo {
    String string = "皮皮虾号";

    static String stringS = "忠犬八公";
    private int num = 1;


    public static void sayS() {
        System.out.println("hello, 树先生！");
    }

    public void say() {
        System.out.println("这个杀手不太冷");
    }

    public Demo() {
        System.out.println("构造");
    }

    static {
        System.out.println("长在红旗下的好少年！");
        System.out.println(stringS);
    }

    {
        System.out.println("根红苗正的四好青年");
    }
}
