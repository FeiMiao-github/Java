/** 参数的传递机制 */

public class demo3 {

    private int firstNum = 0;
    private int secondNum = 0;

    demo3() {};

    demo3(int firstNum, int secondNum) {
        this.firstNum = firstNum;
        this.secondNum = secondNum;
    }

    public demo3 swap() {
        int temp = this.firstNum;
        this.firstNum = this.secondNum;
        this.secondNum = temp;

        return this;
    }

    public void swap1(int a, int b) {
        int temp = a;
        a = b;
        b = temp;
    }

    public static void swap2(int a, int b) {
        int temp = a;
        a = b;
        b = temp;
    }

    public static void swap(data test) {
        int temp = test.a;
        test.a = test.b;
        test.b = temp;
        test = null;
        // 加了这一行仍然能构访问main函数中的dateTest
        // 该函数中传递的参数只是main 函数的dateTest的一个复制
    }

    public static void main(String[] args) {
        int a = 3, b = 4;

        int temp = a;
        a = b;
        b = temp;

        System.out.println("a = " + a + ", b = " + b);

        a = 3;
        b = 4;
        new demo3().swap1(a, b);
        System.out.println("a = " + a + ", b = " + b);
        // 交换失败， 因为此时只是把a 的值复制给函数的参数， 函数中创建了新的变量

        a = 3;
        b = 4;
        swap2(a, b);
        System.out.println("a = " + a + ", b = " + b);
        // 交换失败， 原因同上

        demo3 test = new demo3(a, b).swap();
        System.out.println("a = " + test.firstNum + ", b = " + test.secondNum);
        // 交换成功

        data dataTest = new data();

        dataTest.a = a;
        dataTest.b = b;

        swap2(dataTest.a, dataTest.b);

        System.out.println("dataTest.a = " + dataTest.a + ", dataTest.b = " + dataTest.b); // 交换失败

        swap(dataTest);

        System.out.println("dataTest.a = " + dataTest.a + ", dataTest.b = " + dataTest.b); // 交换成功
    }
}

class data {
    int a;
    int b;
}