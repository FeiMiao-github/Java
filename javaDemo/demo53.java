/**
 * demo53 枚举类的成员、变量、方法和构造器
 */
public class demo53 {
    public static void main(String[] args) {
        new demo53().test();
    }
    
    public void test() {
        Gender g1 = Gender.valueOf(Gender.class, "MALE");

        /* 为枚举的实例变量赋值*/
        g1.nameTest = "男";

        /* 打印枚举的实例变量*/
        System.out.println(g1.nameTest + ": " + g1.toString());

        g1.setName();
        System.out.println(g1.getName());

        Gender g2 = Gender.valueOf(Gender.class, "FEMALE");
        g2.setName();
        System.out.println(g2.getName() + ":" + g2);

        System.out.println(g1 + ": " + g1.getSimpleName());
        
        /* 调用枚举实现的接口方法 */
        g2.getInfo();
        Gender.MALE.getInfo();

        /* 调用枚举类中（匿名类）实例的接口方法 */
        Gender.FEMALE.getInstanceInfo();
    }
}

enum Gender implements Info{
    /* 实例 */
    MALE('M') {
        @Override
        public void getInstanceInfo() {
            System.out.println("这个枚举类表示男");
        }
    },
    FEMALE('F') {
        @Override
        public void getInstanceInfo() {
            System.out.println("这个枚举类表示女");
        }
    };

    /* 构造器 */
    Gender(char s) {
        this.simpleName = s;
    }
    /* 实例变量 */
    String nameTest;
    private String name;
    private char simpleName;

    /* 方法 */
    public void setName() {
        switch (this) {
        case MALE:
            this.name = "男";
            break;
        case FEMALE:
            this.name = "女";
            break;
        }
    }

    public String getName() {
        return this.name;
    }

    public char getSimpleName() {
        return this.simpleName;
    }

    public void getInfo() {
        System.out.println("这是一个枚举类");
    }
}

interface Info {
    abstract void getInfo();

    abstract void getInstanceInfo();
}