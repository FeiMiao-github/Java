public class demo25 {
    public static void main(String[] args) {
        instance.age = 3;
        System.out.println("instance age === " + instance.age);// 不能对引用变量重新赋值， 但是被引用的变量却是不确定的
    }
    
    private int age;
    private final String strings; // 该实例成员变量在初始化之后不可更改
    private final static demo25 instance;

    demo25() {
        System.out.println("无名天地之始，有名万物之母");
    }

    {
        this.strings = "名可名，非常名";
    }

    static {
        instance = new demo25();
        System.out.println("故常以无欲观其妙");
    }

    public void setAge(int i) {
        this.age = i;
    }

    public void printStrings(String str) {
        System.out.println(strings);
    }
}