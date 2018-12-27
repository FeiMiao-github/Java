import java.util.Map;
import java.util.Properties;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;

public class demo59 {
    public static void main(String[] args) {
        new demo59().test();
    }

    public void test() {
        Envar ev = new Envar();
        try {
            ev.printEnvironmentVar();
        } catch(Exception e) {
            new Exception("出现了错误！！！");
        }
    }
}

class Envar {
    // 打印环境变量

    public void printEnvironmentVar() throws Exception {
        // 1.获取系统所有的环境变量
        Map<String, String> env = System.getenv();

        for (String name: env.keySet()) {
            System.out.println(name + " ---> " + env.get(name));
        }

        // 获取指定环境啊变量的值
        System.out.println("%path% ----> " + System.getenv("path"));

        // 获取所有的系统属性
        Properties props = System.getProperties();
        // 保存进.txt文件中
        props.store(new FileOutputStream("props.txt"), "System Properties");

        System.out.println(System.getProperty("os.name"));

        // 获取 java.library 的路径
        System.out.println("java.library 路径 start: [" + System.getProperty("java.library.path"));
        System.out.println("] end!");
    }
}