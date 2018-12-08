class demo20 {
    // 打印对象
    public static void main(String[] args) {
        demo20 demo = new demo20();

        demo.printObject();
        demo.printHashCode();
    }
    
    private void printObject() {
        System.out.println("print Object ---- " + this);
    }
    
    private void printHashCode() {
        System.out.println("print HashCode --- " + this.getClass().getSimpleName() + "@" + Integer.toHexString(this.hashCode()));
    }
}