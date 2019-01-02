import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;

public class demo81 {
	public static void main(String[] args) {
		String src = "从明天起，做一个幸福的人\r\n"
				+ "喂马，劈柴，周游世界\r\n"
				+ "从明天起，关心粮食和蔬菜\r\n"
				+ "我有一座房子，面朝大海，春暖花开\r\n"
				+ " 从明天起，和每一个情人通信\r\n"
				+ "告诉他们我的幸福\r\n";
		char[] buffer = new char[32];
		int hasRead = 0;
		StringBuilder sBuilder = new StringBuilder();
		
		try (StringReader sR = new StringReader(src)){
			try {
				while ((hasRead = sR.read(buffer)) > 0) {
					System.out.println("[hasRead]" + hasRead + "bytes");
					sBuilder.append(buffer, 0, hasRead);
				}
			} finally {
				sR.close();
			}
		}catch (IOException e) {
			e.printStackTrace();
		}
		
		try (StringWriter sWriter = new StringWriter()){
			try {
				sWriter.write("有一个美丽的新世界\r\n");
				sWriter.write("他在远方等我\r\n");
				sWriter.write("那里有天真的孩子\r\n");
				sWriter.write("还有美丽的酒窝\r\n");
				
				System.out.println("start displaying-----");
				System.out.println(sWriter.toString());
				
			} finally {
				sWriter.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
