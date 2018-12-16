
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

        System.out.println("------分割线--------");
        new SubClassExtendsAbstractClass().test();
    }
}

interface InterfaceDemo {
    int num = 3; // 默认转换为静态public final变量

    public void test();

    default public void print() {
        System.out.println("革命军人各个要牢记");
    }
}

// Q1: 测试抽象类中的变量是否转换为静态public final变量
abstract class AbstractClass {
    private int num = 3;

    AbstractClass() {System.out.println("name: " + AbstractClass.class.getName());};

    abstract public void test();

    public int getNum() {
        return this.num;
    }

    public void setNum(int num) {
        this.num = num;
    }
}

class SubClassExtendsAbstractClass extends AbstractClass {
    SubClassExtendsAbstractClass() {
        System.out.println("name: " + SubClassExtendsAbstractClass.class.getName());
    }
    @Override
    public void test() {
        SubClassExtendsAbstractClass s = new SubClassExtendsAbstractClass();
        System.out.println("num = " + s.getNum());

        s.setNum(4); // 非final变量
        System.out.println("num = " + s.getNum()); 

        SubClassExtendsAbstractClass newS = new SubClassExtendsAbstractClass();
        System.out.println("num = " + newS.getNum());
        System.out.println("s - num = " + s.getNum()); // 非静态
    }
}

class SubClass implements InterfaceDemo {
    public void say() {
        System.out.println("1234, 1234, 像首歌");
    }

    public void test() {
    };
}