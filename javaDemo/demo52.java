import java.util.Arrays;

/**
 * demo52 使用 Lambda 表达式调用 Arrays 的类方法
 */
public class demo52 {
    public static void main(String[] args) {
        new demo52().test();
    }

    public void test() {
        String[] arrayStrings = { "HELLO WORLD", "Hello World", "hello world", "HeLlO wOrLd", "hello", "world" };
        Arrays.parallelSort(arrayStrings, (o1, o2) -> o1.length() - o2.length());
        System.out.println(Arrays.toString(arrayStrings));

        int[] arrInt = { 12, 23, -34, 45, -23, 34, -12 };
        Arrays.parallelPrefix(arrInt, (o1, o2) -> o1 * o2);
        System.out.println(Arrays.toString(arrInt));
    }
}