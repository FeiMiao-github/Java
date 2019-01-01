import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

public class demo79 {
	public static void main(String[] args) {
		try(
				FileOutputStream fStream = new FileOutputStream("test.txt");
				PrintStream pStream = new PrintStream(fStream)
						) {
			try {
				pStream.println("春江潮水连海平，海上明月共潮生。");
				pStream.println(new demo79());
			} finally {
				// TODO: handle finally clause
				pStream.close();
				pStream.close();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
