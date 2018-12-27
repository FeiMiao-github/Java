/* 返回精确的hashCode */

class demo61 {
    public static void main(String[] args) {
        new demo61().test();
    }

    public void test() {
        this.e.compare1();
        this.e.compareIdentityHashCode();

        this.e.setValue();

        this.e.compare1();
        this.e.compareIdentityHashCode();
    }

    public void setValue() {
        this.e.setValue();
    }

    private CompareIdentityHashCode e;

    demo61() {
        this.e = new CompareIdentityHashCode();
    }
}

class CompareIdentityHashCode{
    private String string1 = "hello";
    private String string2 = "hello";

    public boolean compare1 () {
        System.out.println("string1 hashCode ... [" + Integer.toHexString(string1.hashCode())
            + "], string2.hashCode ...[" + Integer.toHexString(string2.hashCode())  + "]");

        if (string1 == string2) return true;
        else return false;
    }

    public void compareIdentityHashCode() {
        System.out.println("string1 identityHashCode ...[" + Integer.toHexString(System.identityHashCode(string1))  +
            "],  string2 identityHashCode ...[" + Integer.toHexString(System.idenityHashCode(string2)) + "]");
            // 返回真实的hashCode()
    }

    public void setValue() {
        this.string1 = new String("world");
        this.string2 = new String("world");
    }
}