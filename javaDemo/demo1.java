/* 对象、引用和指针*/ 

public class demo1 {
    private String name = "haha";
    private static int num = 0;

    public void printName() {
        System.out.println(this.name + "this.name" + num++);
    }

    public void setName(String name) {
        this.name = name;
    }

    public static void main(String[] args) {
        demo1 test = new demo1();
        test.printName();

        demo1 secondTest = test;
        secondTest.setName("nana");

        test.printName();
    }
}