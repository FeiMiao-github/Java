/** 返回自己 */

public class demo2 {
    public String name = "hehe";

    public demo2 setName(String name) {
        this.name = name;

        return this;
    }

    public String getName() {
        return this.name;
    }

    public static void main(String[] args) {
        String name = new demo2().setName("nana").getName();
        System.out.println("name1: " + name);

        String name2 = new demo2().setName("nana").setName("lala").getName();
        System.out.println("name2: " + name2);
    }
}

// 使用this作为方法的返回值可以使代码更简洁， 但可能会造成更大意义的模糊