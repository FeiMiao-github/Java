package set;
import java.util.LinkedHashSet;

public  class demo105 {
    public static void main(String[] args) {
        LinkedHashSet<String> lhs = new LinkedHashSet<String>();

        lhs.add("微言大义");
        lhs.add("疯狂的石头");

        System.out.println(lhs);

        lhs.remove("微言大义");
        System.out.println(lhs);
        lhs.add("微言大义");
        System.out.println(lhs);
    }
}