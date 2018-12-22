/**
 * demo39 使用匿名内部类重构demo38
 */
public class demo39 {
    public static void main(String[] args) {
        demo39 demo = new demo39();
        demo.test();
    }

    public void test() {
        int[] intArray = { 1, 2, 3, 4 };

        this.commandTest(intArray, new PrintCommand());
        // this.commandTest(intArray, new AddCommand(3)); // 匿名内部类
        this.commandTest(intArray, new Command() {
            @Override
            public void process(int[] targetArray) {
                for (int i = 0; i < targetArray.length; i++) {
                    targetArray[i] += 3;
                }
            }
        });
        this.commandTest(intArray, new PrintCommand());
    }

    public void commandTest(int[] targetArray, Command c) {
        c.process(targetArray);
    }
}

interface Command {
    void process(int[] targetArray);
}

class AddCommand implements Command {
    private int i = 0;

    AddCommand(int i) {
        this.i = i;
    }

    @Override
    public void process(int[] targetArray) {
        for (int i = 0; i < targetArray.length; i++) {
            targetArray[i] += this.i;
        }
    }
}

class PrintCommand implements Command {
    @Override
    public void process(int[] targetArray) {
        System.out.print("{");
        for (int var : targetArray) {
            System.out.print(var);
            System.out.print(", ");
        }
        System.out.println("}");
    }
}
