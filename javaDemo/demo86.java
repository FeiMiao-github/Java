import java.io.IOException;
import java.io.PrintStream;

public class demo86{
    public static void main(String[] args) {
        try {
            Process ps = Runtime.getRuntime().exec("java ReadStandard");
            PrintStream pStream = new PrintStream(new OutputStream(ps.getOutputStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}