// 使用接口
/**
 * demo36
 */
public class demo36 implements Product, Output{
    public static void main(String[] args) {
        demo36 demo = new demo36();
        demo.test();
    }
    
    public void test() {
        
        //  TODO: test code
        Output o = new demo36();

        ((demo36)o).getDate("傲来雾，花果香！");
        o.out();
    }

    private String[] printDate = new String[InnerInterfaceDemo36.MAX_CACHE_LINE];
    private int dateNum = 0;

    public void out() {
        while (dateNum > 0) {
            System.out.println("打印机打印 --- " + printDate[0]);
            System.arraycopy(printDate, 1, printDate, 0, --dateNum);
        }
    }

    public void getDate(String msg) {
        if (dateNum >= InnerInterfaceDemo36.MAX_CACHE_LINE) {
            System.out.println("输出队列已满，添加错误");
        } else {
            printDate[dateNum++] = msg;
        }
    }

    @Override
    public int getProduceTime() {
        return 45;
    }
    /**
     * InnerInterfaceDemo36
     */
    public interface InnerInterfaceDemo36 {
        int MAX_CACHE_LINE = 3;
    }
}

interface Product {
    int getProduceTime();
}

interface Output {
    public void out();
}