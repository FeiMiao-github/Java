// instanceof 用于判断前面的对象是否是后面的类（或其子类或实现类）的对象

public class demo16 extends Fu {
    public static void main(String[] args) {
        Fu fInstance = new demo16();

        System.out.println("fInstance instanceof Fu" + "...." + (fInstance instanceof Fu));
    }
}

class Fu {
    public void getMsg() {
        System.out.println("class name: " + Fu.class.getName());
    }
}

class OtherClass {
    public void getMsg() {
        System.out.println("class name: " + OtherClass.class.getName());
    }
}