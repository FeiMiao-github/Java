

/**
 * demo41 // 外部类访问内部类变量
 */
public class demo41 {
    public static void main(String[] args) {
        new demo41().test();
    }
    
    private void test() {
        String s = new OuterClass().getInnerClasString();
        System.out.println("resolve getInnerClassString is --- " + s);
    }
}

class OuterClass {
    // 类内访问内部类变量
    public String getInnerClasString(){
        return new InnerClass().innerClasString;

        // return innerClasString;
        // 不能直接调用
    }
    class InnerClass {
        String innerClasString = "inner class string";
    }
}