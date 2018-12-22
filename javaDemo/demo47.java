import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * demo47 命令模式2
 */
public class demo47 {
    public static void main(String[] args) {
        new demo47().test();
    }

    public void test() {
        TargetArray a = TargetArray.valueOf(new int[] { 1, 2, 3, 4, 5 }); // 命令控制对象
        CallCommand c = new CallCommand(); // 调用命令对象

        c.takeCommand(new add1(a)); // 添加命令
        System.out.println(Arrays.toString(a.getArray()));

        c.placeCommand(); // 执行命令
        System.out.println(Arrays.toString(a.getArray()));

        c.takeCommand(new minus1(a));
        System.out.println(Arrays.toString(a.getArray()));
        
        c.placeCommand();
        System.out.println(Arrays.toString(a.getArray()));
    }
}

class TargetArray {
    private static int[] array;
    private static TargetArray instance;

    private TargetArray(int[] a) {
        array = a;
    }

    public static TargetArray valueOf(int[] array) {
        if (instance == null) {
            instance = new TargetArray(array);
        }

        return instance;
    }

    public int[] getArray() {
        if (array == null) {
            return null;
        } else {
            return array;
        }
    }

    public void add1() {
        for (int i = 0; i < array.length; i++) {
            array[i] += 1;
        }
    }

    public void minus1() {
        for (int i = 0; i < array.length; i++) {
            array[i] -= 1;
        }
    }
}

/* Command */
@SuppressWarnings("all")
interface Command {
    public void process();
}

/* implementation of commands */

class add1 implements Command {
    private TargetArray targetArray;

    add1(TargetArray t) {
        targetArray = t;
    }

    @Override
    public void process() {
        targetArray.add1();
    }
}

class minus1 implements Command {
    private TargetArray targetArray;

    minus1(TargetArray t) {
        targetArray = t;
    }

    @Override
    public void process() {
        targetArray.minus1();
    }
}

/* Call command */
class CallCommand {
    private List<Command> commandList = new ArrayList<Command>();

    public void takeCommand(Command c) {
        commandList.add(c);
    }

    public void placeCommand() {
        for (Command c : commandList) {
            c.process();
        }
        commandList.clear();
    }
}