import java.util.Scanner;

class demo60{
    public static void main(String[] args) {
        new demo60().test();
    }

    public void test() {
        System.out.print("请选择执行第几个方法?  ---> ");
        int iarg = new Scanner(System.in).nextInt();
        switch(iarg) {
            default: return;
            case 1:
                this.test1(); break;
            case 2:
                this.test2(); break;
        }
    }

    // currentTimeMillis()
    public void test1() {
        System.out.println("System current Time(Millis)" + System.currentTimeMillis() + "ms");
    }

    // nanoTime()
    public ReturnType test2() {
        long r =  System.nanoTime();
        if (r > 0) {
            System.out.println("nano time " + r + "ns");
            return ReturnType.S_SUCCESS;
        } else {
            return ReturnType.S_FAILURE;
        }
    }
}

enum ReturnType {
    S_SUCCESS, S_FAILURE
}