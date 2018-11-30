// 构造器中调用构造器

public class demo8 {
    private String words = "this is a statement.";

    demo8() {
        System.out.println(this.words + "this.words");
        this.words = "this statement has been changed!";
        System.out.println("demo8() run!");
    }

    demo8(String w) {
        this();
        System.out.println("调用构造器 demo8(String w)！ w = " + w);

    }
    
    public static void main(String[] args) {
        new demo8("hello world");
    }
}