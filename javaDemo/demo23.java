/**
 * 单例类： 只有一个对象的类
 */
public class demo23 {
    public static void main(String[] args) {
        // System.out.println(singleton1.getSingletonInstance());
        // System.out.println(singleton2.getSingletonInstance());
        // System.out.println(singleton3.getSingletonInstance());
        System.out.println(singleton4.getSingletonInstance());
    }
}

class singleton1 {
    private static singleton1 instance;

    private singleton1() {
        System.out.println("1");
    };

    public static singleton1 getSingletonInstance() {
        System.out.println("2");
        instance = new singleton1();
        System.out.println("3");
        return instance;
    }
    // 运行顺序: 2 -> 1 -> 3
}

class singleton2 {
    private static singleton2 instance;

    public singleton2() {
        System.out.println("1");
    }

    static {
        System.out.println("2");
        instance = new singleton2();
        System.out.println("3");
    }

    public static singleton2 getSingletonInstance() {
        System.out.println("4");
        return instance;
    }
    // 运行顺序2 -> 1 -> 3 -> 4
}

class singleton3 {
    private static singleton3 instance = new singleton3();
    
    static {
        System.out.println("1");
    }

    private singleton3() {
        System.out.println("2");
    };

    public static singleton3 getSingletonInstance() {
        System.out.println("3");
        return instance;
    }
    // 运行顺序: 2 -> 1 -> 3
}

class singleton4 {
    static {
        System.out.println("1");
    }

    private singleton4() {
        System.out.println("2");
    };

    public static singleton4 getSingletonInstance() {
        System.out.println("3");
        return instance;
    }

    private static singleton4 instance = new singleton4();
    // 运行顺序: 1 -> 2 -> 3
}