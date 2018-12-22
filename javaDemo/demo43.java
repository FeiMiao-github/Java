/**
 * demo43 使用内部类
 */
public class demo43 {
    public static void main(String[] args) {
        new demo43().test();
    }

    public void test() {
        new OuterClass();
    }
}

class OuterClass {
    static {
        class InnerClassInStaticCode {
            private int num = 3;

            public int getNum() {
                return this.num;
            }

            public void setNum(int i) {
                this.num = i;
            }
        }

        InnerClassInStaticCode instance = new InnerClassInStaticCode();
        System.out.println(InnerClassInStaticCode.class.getSimpleName() + instance.getNum());
        new InnerClassInStaticCode().setNum(5);
        System.out.println(instance.getNum());
    }
    class InnerClass {
        
    }
}

