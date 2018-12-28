class demo63 {
    public static void main(String [] args) throws Exception{
        // new demo63().test();
        RuntimeTest rtTest = new RuntimeTest();
        //rtTest.printJVMInfo();
        rtTest.execTest();
    }

    public void test() {
        new RuntimeTest().test();
    }
}

class RuntimeTest {
    public void finalize() {
        System.out.print("finalize 正在运行");
    }

    public void test() {
        RuntimeTest f1 = new RuntimeTest();
        RuntimeTest f2 = new RuntimeTest();

        Runtime currentRt = Runtime.getRuntime();

        currentRt.gc(); //garbage collection
        currentRt.runFinalization();

        System.out.print("垃圾回收运行结束！");
    }

    public void printJVMInfo() {
        Runtime rt = Runtime.getRuntime();
        // Returns the number of processors available to the Java virtual machine
        System.out.println("the number of processors : " + rt.availableProcessors());
        // the total amount of memory in the Java virtual machine.
        System.out.println("the total amount of memory in the JVM : " 
            + rt.totalMemory());

        //the maximum amount of memory that the Java virtual machine will attempt to use
        System.out.println("the maximum amount of memory : " 
            + rt.maxMemory());
    }

    public void execTest() throws Exception {
        Runtime rt = Runtime.getRuntime();
        rt.exec("notepad.exe");
        // 打开系统自带的记事本
    }
}