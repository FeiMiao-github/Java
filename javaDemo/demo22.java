public class demo22 {
    public static void main(String[] args) {
        demo22 d1 = new demo22(2);
        demo22 d2 = new demo22(2);

        System.out.println("d1 equals d2? ---- " + d1.equals(d2));

        demo22 d3 = new demo22(2);
        Object d4 = new String("1234567890");

        System.out.println("d3 equals d4? ---- " + d3.equals(d4));
    }
    
    private int id = 1;

    demo22(int i) {
        id = i;
    }

    public int getId() {
        return this.id;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj != null && obj.getClass() == demo22.class) {
            if (((demo22)obj).getId() == this.id)
                return true;
        }

        return false;
    }
}