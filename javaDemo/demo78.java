import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

/* Writer */
public class demo78 {
	public static void main(String[] args) throws Throwable {
		new demo78().test0();
	}
	
	public void test0() throws IOException{
		String str =
				"将进酒\r\n" + 
				"唐代：李白\r\n" + 
				"\r\n" + 
				"君不见，黄河之水天上来，奔流到海不复回。\r\n" + 
				"君不见，高堂明镜悲白发，朝如青丝暮成雪。\r\n" + 
				"人生得意须尽欢，莫使金樽空对月。\r\n" + 
				"天生我材必有用，千金散尽还复来。\r\n" + 
				"烹羊宰牛且为乐，会须一饮三百杯。\r\n" + 
				"岑夫子，丹丘生，将进酒，杯莫停。\r\n" + 
				"与君歌一曲，请君为我倾耳听。(倾耳听 一作：侧耳听)\r\n" + 
				"钟鼓馔玉不足贵，但愿长醉不复醒。(不足贵 一作：何足贵；不复醒 一作：不愿醒/不用醒)\r\n" + 
				"古来圣贤皆寂寞，惟有饮者留其名。(古来 一作：自古；惟 通：唯)\r\n" + 
				"陈王昔时宴平乐，斗酒十千恣欢谑。\r\n" + 
				"主人何为言少钱，径须沽取对君酌。\r\n" + 
				"五花马，千金裘，呼儿将出换美酒，与尔同销万古愁。";
		FileWriter fw = new FileWriter("toast.txt");
		System.out.println(Arrays.toString(new File(".").list()));
		
		fw.write(str);
		
		fw.close();
		
	}
}
