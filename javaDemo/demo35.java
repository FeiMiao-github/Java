public class demo35 {
    public static void main(String[] args) {
        System.out.println(InterfaceDemo.VALUE_A);
    }
}

/**
 * InterfaceDemo 多继承测试
 */
interface InterfaceDemoA {
    int VALUE_B = 3;

    default void print() {
        System.out.println(InterfaceDemoA.class.getName() + " run!");
    }
}

interface InterfaceDemoB {
    int VALUE_A = 4;

    default void print() {
        System.out.println(InterfaceDemoB.class.getName() + " run!");
    }
}

interface InterfaceDemo extends InterfaceDemoA, InterfaceDemoB {
    int VALUE_C = 5;

    default void print() {
        System.out.println(InterfaceDemo.class.getName() + " run!");
    }
}