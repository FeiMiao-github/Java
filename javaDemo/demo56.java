/**
 * demo56
 */
public class demo56 {

    public static void main(String[] args) {
        new demo56().test();
    }

    public void test() {
        FinalizeTest.test();
    }
}

class FinalizeTest {
    private static FinalizeTest ft = null;

    public FinalizeTest getTest() {
        return ft;
    }

    public void info() {
        System.out.println("测试资源清理");
    }

    public void finalize() {
        System.out.println("系统正在试图清理");

        ft = this;
    }

    public static void test() {
        new FinalizeTest();

        System.gc();
        System.runFinalization();// 方式1
        // Runtime.getRuntime().runFinalization(); // 方式2

        ft.info();
    }
}