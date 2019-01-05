import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Scanner;

public class demo87 {
	public static void main(String[] args) throws IOException{
		Process ps = Runtime.getRuntime().exec("java -cp F:\\github\\project\\demo\\bin\\ ReadStandard");
		PrintStream pstream = new PrintStream(ps.getOutputStream());
		try {
			pstream.print("普通字符串");
			pstream.println(new demo87());
			pstream.println(Arrays.toString(new byte[]{1, 2, 3, 4, 5, 6}));
		} finally {
			pstream.close();
		}
		
		BufferedReader br = new BufferedReader(new InputStreamReader(ps.getInputStream()));
		Scanner sc = new Scanner(br);
		
		while (sc.hasNextLine()) {
			System.out.println("[br]" + sc.nextLine());
		}
		sc.close();
	}
}

class ReadStandard {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		PrintStream ps = new PrintStream(new FileOutputStream("out.txt"));
		
		try {

			while (sc.hasNextLine()) {
				ps.println("[output]" + sc.nextLine());
			}
		} finally {
			sc.close();
			ps.close();
		}
	}
}