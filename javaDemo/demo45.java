/**
 * demo45
 */
public class demo45 {

    public static void main(String[] args) {
        demo45 demo = new demo45();
        demo.test();
    }

    public void test() {
        new ToStringClass() {
            public void printClassName(String s) {
                System.out.println(s);
            }
        }.printClassName(("调用了匿名内部类" + ToStringClass.class.getSimpleName()));
        /**  
        * new ToStringClass(){...} 返回的是匿名内部类的实例
        */
    }
}

/* 匿名内部类 */
interface ToStringClass {
    public void printClassName(String s);
}