/**
 * demo46 对于匿名内部类的变量自动使用final修饰
 */
public class demo46 {
    public static void main(String[] args) {
        new demo46().test();
    }

    public void test() {
        new Interface() {
            int num = 4;
            @Override
            public void print() {
                int num = 3;
                 System.out.println("num = " + num 
                        + ", this.num = " + this.num);

                this.num = 5;
                num = 4;
                System.out.println("num = " + num 
                        + ", this.num = " + this.num);
            }
        }.print();
    }
}

interface Interface {
    public void print();
}