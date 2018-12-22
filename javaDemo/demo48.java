import java.util.Arrays;

/**
 * demo48 使用Lambda表达式
 */
public class demo48 {
    public static void main(String[] args) {
        new demo48().test();
    }

    public void test() {
        int[] target = { 1, 2, 3, 4, 5 };
        CallCommand cc = new CallCommand(target);
        cc.execute(new PrintArray());

        // 匿名内部类
        cc.execute(new Command() {
            public void process(int[] target) {
                for (int i = 0; i < target.length; i++) {
                    target[i] += 1;
                }
            }
        });

        cc.execute(new PrintArray());

        // Lambda表达式
        cc.execute((int[] t) -> {
            for (int i = 0; i < t.length; i++) {
                t[i] *= 2;
            }
        });

        cc.execute(new PrintArray());

        // Lambda表达式
        new Target().CallInterfaceTest(() -> {
            System.out.println("hello world!");
        });

    }
}

interface Command {
    public void process(int[] target);
}

class PrintArray implements Command {
    @Override
    public void process(int[] target) {
        System.out.println(Arrays.toString(target));
    }
}

class CallCommand {
    private int[] array;

    CallCommand(int[] array) {
        this.array = array;
    }

    public void execute(Command command) {
        command.process(this.array);
    }
}

interface TestInterface {
    public void test();
}

class Target {
    public void CallInterfaceTest(TestInterface t) {
        t.test();
    }
}
