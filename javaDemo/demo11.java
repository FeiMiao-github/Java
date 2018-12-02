public class demo11 {
    public static void main(String[] args) {
        Fu test = new Zi();
        System.out.println((test.word));// 结果是super
        System.out.println((test.getWord()));//结果是sub，被覆盖
    }
}

class Fu {
    String word = "super";

    public String getWord() {
        return this.word;
    }
}

class Zi extends Fu {
    String word = "sub";

    @Override
    public String getWord() {
        return this.word;
    }
}