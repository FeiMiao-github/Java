/** 参数可变的方法*/

public class demo4 {

    public void printString(String... strings) {
        for (String ele : strings) {
            System.out.println(ele + ", ");
        }
    }

    public static void main(String[] args) {
        String[] strings = new String[]{ "悯农", "锄禾日当午", "汗滴禾下土", "谁知盘中餐", "粒粒皆辛苦" };
        new demo4().printString(strings);
    }
}