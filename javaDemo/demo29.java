public class demo29 {
    

    public static void main(String[] args) {
        Name n = new Name("小", "明");

        Person p = new Person(n);
        Name pN = p.getName();

        System.out.println(pN.getName());
        pN.setFirstName("大");
        System.out.println(p.getName().getName());

    }
}

class Name {
    private String firstName = "";
    private String lastName = "";

    Name(String fN, String lN) {
        this.firstName = fN;
        this.lastName = lN;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public String getName() {
        return this.firstName + "·" + this.lastName;
    }

    public void setFirstName(String fn) {
        this.firstName = fn;
    }

    public void setLastName(String ln) {
        this.lastName = ln;
    }
}

class Person {
    private final Name name ;

    Person(Name n) {
        this.name = new Name(n.getFirstName(), n.getLastName());
    }

    public Name getName() {
        return new Name(name.getFirstName(), name.getLastName());
    }
    
}