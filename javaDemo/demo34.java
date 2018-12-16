class demo34 {
    public static void main(String[] args) {
        new FinalDef().test1();
        new FinalDef().test2();        
    }
}

class FinalDef {
    private final Integer num1 = 555;
    private final Integer num2 = 555;
    private final String str1 = "12345";
    private final String str2 = "12345";

    public void test1() {
        System.out.println("num1==num2 **********" + (num1 == num2));
    }

    public void test2() {
        System.out.println("str1 == str2 ************* " + (str1 == str2));
    }
}