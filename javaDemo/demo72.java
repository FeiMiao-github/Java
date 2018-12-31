import java.io.File;
import java.util.Calendar;
import java.util.Date;

public class demo72 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		demo72 demo = new demo72();
		
		/* 以当前路径创建一个  File 对象  */
		File file = new File("你好.cpp");
		/* 直接获取文件名 */
		System.out.println("[FileName]" + file.getName());
		
		/*  创建文件 */
		if (!file.exists()) {
			try {
				file.createNewFile();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		/* 获取文件的父路径 */
		System.out.println("[File Parent Path]" + file.getParent()); 
			/* ----> 由于相对路径， 所以获取父路径可能会出错 ， 此处显示为 null*/
		
		/* 获取文件的绝对路径 */
		System.out.println("[File absolute file path]" + file.getAbsolutePath());
		
		/* 通过绝对路径获取父路径 */
		System.out.println("[File absolute file path]" + file.getAbsoluteFile().getParent());
		
		System.out.println("[exist]" + file.exists());
		
		/* 文件路径 */
		System.out.println("[filePath]" + file.getPath());
		
		File f = new File("hello_world.cpp");
		System.out.println("[rename]" + file.renameTo(f));
		if (file.renameTo(new File("hello_world.cpp"))) {
			System.out.println("[fileName]" + file.getName());
		}
		
		
		file.deleteOnExit();
		
		/* 文件上次修改时间 */
		Calendar calendar = Calendar.getInstance();
		long lMF = f.lastModified();
		calendar.setTime(new Date(lMF));
		System.out.println("[LMF]" + calendar.get(Calendar.YEAR) + "/"
			+ calendar.get(Calendar.MONTH) + "/"
			+ calendar.get(Calendar.DAY_OF_MONTH) + "/"
			+ ", " + calendar.get(Calendar.HOUR_OF_DAY) + ":"
			+ calendar.get(Calendar.MINUTE) + ":"
			+ calendar.get(Calendar.SECOND));

//		f.delete(); // 立即删除文件f
		System.getenv("path");
	}

}
