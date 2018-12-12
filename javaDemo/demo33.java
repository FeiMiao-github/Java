//  更加彻底的抽象类----- 接口
//  面向接口编程有利于降低耦合

public class demo33  {
    public static void main(String[] args) {
        SubClass instance = new SubClass();

        instance.say();
        instance.print();
        int num_1 = InterfaceDemo.num;
        int num_2 = SubClass.num;

        System.out.println("InterfaceDemo.num = " + num_1
            + ", hashCode = " + InterfaceDemo.class.hashCode());
        System.out.println("SubClass.num = " + num_2
            + ", hashCode = " + SubClass.class.hashCode());

        // InterfaceDemo.num = 10; error, 不可重新分配值
    }
}

interface InterfaceDemo {
    int num = 3; // 默认转换为静态public final变量

    public void test();

    default public void print() {
        System.out.println("革命军人各个要牢记");
    }
}

class SubClass implements InterfaceDemo {
    public void say() {
        System.out.println("1234, 1234, 像首歌");
    }

    public void test() {
    };
}