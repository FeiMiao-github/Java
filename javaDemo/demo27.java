public class demo27 extends Fu {
    public static void main(String[] args) {
        demo27 demo = new demo27();

        demo.print();
        demo.printString();
        // ((Fu) demo).printString(); 不可访问
    }

    // public void print() { // 方法不可被重写
    //     System.out.println("寄蜉蝣于天地");
    // }

    private void printString() {
        System.out.println("羡长江之无穷");
    }
}

class Fu {
    public final void print() {
        System.out.println("渺沧海之一粟");
    }

    @SuppressWarnings("unused")
    private final void printString() {
        System.out.println("哀吾生之须臾");
    }
}