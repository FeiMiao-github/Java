//使用继承时的注意点

public class demo17 {
    public demo17() {
        test();
    }

    public void test() {
        System.out.println("一个即将被覆盖的方法！");
    }
}

class Sub extends demo17 {
    private String name;

    @Override
    public void test() {
        System.out.println(this.name + " --- 重写父类方法");
    }

    public static void main(String[] args) {
        Sub subInstance = new Sub();
        // this.name 为null, 调用了 sub 类的 test() 方法
        System.out.println(subInstance.name);
    }
}