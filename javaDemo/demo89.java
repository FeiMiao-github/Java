import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Arrays;
import java.util.Scanner;

/* RandomAccessFile */
public class demo89 {
	public static void main(String[] args) throws IOException {
/* Java 输出流中功能最丰富的文件内容访问类 */
		File out = new File("out.txt");
		System.out.println("[File Path]" + out.getAbsolutePath());
		
		if (!out.exists()) {
			out.createNewFile();
		}
		
		demo89 demo = new demo89();
		Scanner input = new Scanner(System.in);
		
		System.out.print("选择测试项目：");
		switch (input.nextByte()) {
		case 0:
			String s = "今夜鄜州月，闺中只独看\r\n" + 
					"遥怜小儿女，未解忆长安";
			demo.test3(out, 70, "\r\n" + s + "\r\n");
			break;
		case 1:
			demo.test2(out);
			break;
		case 2:
			demo.test1(out);
		default:
			break;
		}
		
		input.close();
	}
	
	/*向指定文件、指定位置插入内容*/
	public void test3(File out, long pos, String inContent) throws IOException {
		File tempFile = File.createTempFile("out", ".tmp", new File("."));
		tempFile.deleteOnExit();
		try(
				RandomAccessFile rf = new RandomAccessFile(out, "rw");
				FileOutputStream otemp = new FileOutputStream(tempFile);
				FileInputStream itemp = new FileInputStream(tempFile); 
				){
			rf.seek(pos);
			
			byte[] buf = new byte[32];
			int hasRead = 0;
			
			/*读入临时文件*/
			while ((hasRead = rf.read(buf)) > 0) {
				otemp.write(buf, 0, hasRead);
			}
			
			/*在文件中插入内容*/
			rf.seek(pos);
			rf.write(inContent.getBytes());

			/*追加插入点以后的内容*/
			while ((hasRead = itemp.read(buf)) > 0) {
				rf.write(buf, 0, hasRead);
			}
			
			rf.close();
			otemp.close();
			itemp.close();
		}
	}	
	
	/*向指定文件追加内容*/
	public void test2(File out) throws IOException {
		RandomAccessFile rf = new RandomAccessFile(out, "rw");
		printFilePointer(rf);
		
		rf.seek(rf.length());
		rf.write("追加内容！\r\n".getBytes());
		rf.close();
	}
	
	/*从指定位置读取文件*/
	public void test1(File out) throws IOException {

		
		RandomAccessFile rf = new RandomAccessFile(out, "r");
		printFilePointer(rf);
		
		if (rf.length() <= 300) {
			System.out.println("[文件长度]" + rf.length());
			return; 
		}
		
		rf.seek(300);
		printFilePointer(rf);
		
		byte[] buff = new byte[300];
		int hasRead = 0;
		while ((hasRead = rf.read(buff)) > 0) {
			String sb = new String(buff, 0, hasRead);
			System.out.println("[Output]" + sb);
		}
		
		rf.close();
	}
	
	/*显示文件当前指针*/
	public void printFilePointer(RandomAccessFile rf) throws IOException {
		System.out.println("[文件指针初始位置]" + rf.getFilePointer());
	}
}
