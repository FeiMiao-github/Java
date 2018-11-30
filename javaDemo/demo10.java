//  继承

class GFu {
    String description = "i am GFu";
}

class Fu extends GFu {
    private String description = "i am Fu";

    public String getDescription() {
        return this.description;
    }
}

class demo10 extends Fu {
    String description = "i am sub class";

    public void speak() {
        Fu f = new Fu();
        System.out.println(((GFu)f).description);
    }

    public static void main(String[] args) {
        new demo10().speak();
    }
}

