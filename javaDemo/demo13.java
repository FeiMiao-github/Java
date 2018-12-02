public class demo13 extends Fu {
    public void description() {
        System.out.println("sub class!");
    }

    public void subSpeak() {
        System.out.println("子类");
    }

    public static void main(String[] args) {
        Fu instancesFu = new demo13();
        // instancesFu.description();
        instancesFu.speak();
    }
}

class Fu {
    public void description() {
        System.out.println("Super class!");
    }

    public void speak() {
        System.out.println("父类");
    }
}