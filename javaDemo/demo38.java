/**
 * demo38
 */
public class demo38 {
    public static void main(String[] args) {
        demo38 demo = new demo38();
        demo.test();
    }

    public void test() {
        int[] intArray = { 1, 2, 3, 4 };

        this.commandTest(intArray, new PrintCommand());
        this.commandTest(intArray, new AddCommand(3));
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
