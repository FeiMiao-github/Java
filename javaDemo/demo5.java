// 递归运算
public class demo5 {
    //计算数列

    // f(0) = 1
    // f(1) = 4
    // f(n+2) = 2*f(n+1) + f(n)
    // 计算f(10)

    public int f(int n) {
        if (n == 0) {
            return 1;
        } else if (n == 1) {
            return 4;
        } else {
            return 2 * f(n - 1) + f(n - 2);
        }
    }

    // f(20) = 1
    // f(19) = 4
    // f(n+2) = 2*f(n+1) + f(n)
    // 计算f(10)

    public int f1(int n) {
        if (n == 20) {
            return 1;
        } else if (n == 19) {
            return 4;
        } else {
            return f1(n + 2) - 2 * f1(n + 1);
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            int result = new demo5().f(i);
            System.out.println(i + "结果是: " + result);
        }

        for (int i = 10; i < 21; i++) {
            int result = new demo5().f1(i);
            System.out.println(i + "结果是: " + result);
        }
    }
}