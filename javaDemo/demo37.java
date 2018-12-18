//  简单工厂设计模式
public class demo37 {
    public static void main(String[] args) {
        demo37 demo = new demo37();
        demo.test();
    }

    private void test() {
        Computer c = new Computer();

        c.printIn("简单工厂模式");
        c.printOut();
    }
}

class Computer {
    private Output o;

    Computer() {
        this.o = new OutputFactory().getOutput();
    }

    public void printIn(String msg) {
        o.getPrintDate(msg);
    }

    public void printOut() {
        o.out();
    }
}

class OutputFactory {
    public Output getOutput() {
        // return new Printer();
        return new BetterPrinter();
    }
}

interface Output {
    public void out();

    public void getPrintDate(String msg);
}

class Printer implements Output{
    public static final int MAX_CACHE_LINE = 3;
    private int dateNum = 0;
    private String[] printDate = new String[MAX_CACHE_LINE];

    @Override
    public void out() {
        while (dateNum > 0) {
            System.out.println("打印机输出 ---" + printDate[0]);
            System.arraycopy(printDate, 1, printDate, 0, --dateNum);
        }
    }

    public void getPrintDate(String msg) {
        if (dateNum > MAX_CACHE_LINE) {
            System.out.println("输出队列已满~~~~");
        } else {
            printDate[dateNum++] = msg;
        }
    }
}

class BetterPrinter implements Output{
    public static final int MAX_CACHE_LINE = 3;
    private int dateNum = 0;
    private String[] printDate = new String[MAX_CACHE_LINE];

    @Override
    public void out() {
        while (dateNum > 0) {
            System.out.println("更好的打印机输出 ---" + printDate[0]);
            System.arraycopy(printDate, 1, printDate, 0, --dateNum);
        }
    }

    public void getPrintDate(String msg) {
        if (dateNum > MAX_CACHE_LINE) {
            System.out.println("输出队列已满~~~~");
        } else {
            printDate[dateNum++] = msg;
        }
    }
}