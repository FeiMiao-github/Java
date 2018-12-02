public class demo12 {
    public static void main(String[] args) {
        new F3("hahaha");
    }
}

class F1 {
    public F1() {
        System.out.println("F1");
    }
}

class F2 extends F1{
    public F2() {
        System.out.println("F2");
    }

    public F2(String id) {
        System.out.println("F2" + id);
    }
}

class F3 extends F2 {
    String id = "0";

    public F3(String id) {
        super("hahaha");
        this.id = id;
        System.out.println("F3");
    }
}