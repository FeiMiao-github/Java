/**
 * demo55
 */
public class demo55 {

    public static void main(String[] args) {
        demo55 d = new demo55();
        // d.test();
        d.test2();

    }

    public void test() {
        for (int i = 0; i < 4; i++) {
            new Gctest();
        }
    }

    public void test2() {
        for (int i = 0; i < 4; i++) {
            new Gctest();

            // System.gc(); // 垃圾回收方式1
            Runtime.getRuntime().gc(); // 垃圾回收方式2
        }
    }
}

class Gctest {
    @SuppressWarnings("all")
    public void finalize() {
        System.out.println("系统正在清理。。。");
    }
}

/* 控制台输入 java -verbose:gc demo55 查看详细 */