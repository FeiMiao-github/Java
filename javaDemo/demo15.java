public class demo15 extends SuperClass {
    public static void main(String[] args) {
        SuperClass instance = new demo15();

        instance.getSuperWords();
        ((demo15)instance).getSubWords();
    }

    private String word = "demo15";

    @Override
    public void getWord() {
        System.out.println(demo15.class.getName() + "---" + this.word);
    }

    public void getSubWords() {
        System.out.println(demo15.class.getMethods().getClass().toString() + "---" + this.word);
    }
}

class SuperClass {
    private String word = "SuperClass";

    public void getWord() {
        System.out.println(SuperClass.class.getName() + "---" + word);
    }

    public void getSuperWords() {
        System.out.println(SuperClass.class.getMethods().toString() + "---" + this.word);
    }
}