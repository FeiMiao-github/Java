class demo62 {
    public static void main(String[] args) {
        new demo62().test();
    }

    public void test() {
        int ret = new TestNative().methodDemo(3, 5);
        System.out.println("ret value = " + ret);
    }
}
/**
    1. 声明 native 方法
    2. 用 Javah 编译第一步生成的 class 文件，将产生一个 `.h` 文件
    3. 写 `.cpp` 文件实现 native方法。这一步需要包含上一步产生的 `.h` 文件，这个文件中又包含了 
JDK 带的 `jni.h` 文件
    4. 将上一步的 `.cpp` 文件编译成动态链接库文件
    5. 在 Java 中使用 `System` 类的 `loadLibray..()` 方法或 `Runtime` 类的 `loadLibrary()` 方法加载第
四步产生的动态链接库文件，Java 中就可以调用这个 `native` 方法了
 */
class TestNative {
    native int methodDemo (int a, int b);

    static {
        System.loadLibrary("testNative");
    }
}

/* 使用 java demo62 运行 */