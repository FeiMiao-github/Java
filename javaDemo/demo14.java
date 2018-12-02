// 文件的输入输出
import java.io.File;
import java.io.IOException;

public class demo14 {
    public void test() {
        System.out.println("hello");
    }

    public static void main(String[] args) throws IOException {
        File file = new File("F:\\github\\Java\\javaDemo\\haha.txt");
        String path = file.getParent();// 获取路径

        File newFile = new File(path + "\\nextTxt.txt");
        System.out.println(newFile.createNewFile());

        System.out.println("path: " + path);
    }
}