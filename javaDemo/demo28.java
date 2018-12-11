// 不可变类

public class demo28 {
    public static void main(String[] args) {
        String string = new ImmutableClass("泥嚎").getString();
        System.out.println(string);
    }
}

class ImmutableClass {
    private final String string;

    ImmutableClass(String string) {
        this.string = string;
    }

    public String getString() {
        return string;
    }

    public boolean equals(Object obj) {
        if (this == obj)
            return true;

        if (obj != null && (obj.getClass() == ImmutableClass.class)) {
            if (((ImmutableClass)obj).string.equals(this.string)) {
                return true; 
            }
        }
        return false;
    }
}