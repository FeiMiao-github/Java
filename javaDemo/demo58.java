import java.util.Scanner;
import java.util.ArrayList;

public class demo58 {
    public static void main(String[] args) {
        demo58 d = new demo58();

        Scanner scan = new Scanner(System.in);
        System.out.print("输入一个数: ");
        int i = scan.nextInt();
        switch(i) {
            default:
                System.out.println("运行结束！");
                return;
            case 0:
                d.test1();break;
            case 1:
                d.test2();break;
            case 2:
                d.test3();break;
            case 3:
                d.test4();break;
            case 4:
                d.test5();break;
        }
    }

    public void test1() {
        Input i = new Input();
        i.setNum();
        System.out.println("i: " + i.getNum());
    }

    public void test2() {
        Input i = new Input();
        i.setStrings();
        String[] s = i.getStrings();
        int index = 0;
        
        for(String ele: s) {
            System.out.println((index++) + ": " + ele);
        }
    }

    public void test3() {
        System.out.print("[12345]\b[abcde]");
    }

    public void test4() {
        System.out.print("[12345]\r[abcde]");
    }

    public void test5() {
        Scanner s = new Scanner(System.in);
        System.out.println("Scanner FileTest.java 文件内容如下：");

        while (s.hasNextLong()) {
            // 输出文件的下一行
            System.out.println("next Line: --- [" + s.nextLong() + "]");
        }
    }
}

class Input{
    private int num;
    private String[] strings;

    public void setStrings(){
        System.out.println("输入字符串: ");

        ArrayList<String> s = new ArrayList<String>();

        Scanner inputString = new Scanner(System.in);
        // inputString.useDelimiter(" ");
        while (inputString.hasNext()) {
            String string = inputString.next();
            if (string.equals("quit\n") || string.equals("q")
                || string.equals("Q")) {
                    break;
            }
            System.out.println("键盘输入了： [" + string + "]");
            System.out.println("字符串长度： [" + string.length() + "]");
            s.add(string);
        }

        strings = s.toArray(new String[s.size()]);
    }

    public String[] getStrings(){
        return this.strings;
    }

    public void setNum() {
        System.out.print("input a num: ");

        // System in 代表标准输入，即键盘输入
        Scanner inputNum = new Scanner(System.in);

        this.num = inputNum.nextInt();
    }

    public int getNum() {
        return this.num;
    }
}