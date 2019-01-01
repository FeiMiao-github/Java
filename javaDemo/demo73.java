import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;

public class demo73 {
	File helloFile1 = new File("hello_world.cpp");
	File helloFile2 = new File("hello_world_2.cpp");
	File helloFile3 = new File("src");
	File helloFile4 = new File("test.exe");
	File helloFile5 = new File("F:\\github\\project\\demo\\src");
	
	File[] helloFiles = new File[]{
		helloFile1, helloFile2,
		helloFile3, helloFile4,
		helloFile5,};
	
	public static void main(String[] args) {
		demo73 demo = new demo73();
		switch (3) {
		case 0:
			demo.test1();
			break;
		case 1:
			demo.test2();
			break;
		case 2:
			demo.test3();
			break;
		case 3:
			demo.test4();
			break;
		default:
			break;
		}
	}

	/* 测试 */
	public void test1() {
		/* 文件检测相关方法 */
		
		System.out.println("[Name\tExist\tWrite\tRead\tExecute\tFile\tDir\tAbsolute]");
		for(File f: helloFiles) {
			System.out.print("[");
			
			dispName(f);
			/* 文件对象是否存在 */
			System.out.print("\t" + f.exists());
			
			/* 对应文件目录是否可读写  */
			System.out.print("\t" + f.canWrite() + "\t" + f.canRead());
			
			/* 文件可执行 */
			System.out.print("\t" + f.canExecute());
			
			System.out.print("\t" + f.isFile()
					+ "\t" + f.isDirectory()
					+ "\t" + f.isAbsolute());
			System.out.println("\t]");
		}
	}/*test1*/
	
	public void test2() {
		for(File f: helloFiles) {
			if (!f.exists()) continue;
			
			System.out.print("[");
			dispName(f);
			
			/*文件上次修改时间*/
			long modifiedTime = f.lastModified();
			System.out.print("\t" + dispTime(modifiedTime) + ",\t");
			/*文件内容长度*/
			System.out.print(f.length() + "bytes");
			System.out.println("\t]");
		}
	}
	
	public void test3() {
		/* 文件操作的相关方法 */
		try {
			File tempf2 = File.createTempFile("test0000", ".txt");
			System.out.println("[tempfilePath]" + tempf2.getAbsolutePath());
			tempf2.deleteOnExit();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void test4() {
		/*目录操作相关方法*/
		File dir = new File("F:\\github\\project\\demo\\testMkdir");
		
		if (!dir.mkdir()) System.out.println("failed to make dir");
		if (dir.exists()) dir.deleteOnExit();
		
		/* 列出所有文件的子文件名和路径名*/
		String[] fileNameList = dir.getParentFile().list();
		for (String s: fileNameList) System.out.println(s);
		
		/* 列出File对象所有子文件和路径 */
		File[] fileList = dir.getParentFile().listFiles();
		for (File f: fileList) {
			System.out.print(f + "\t");
		}
		System.out.println();
		
		/* 列出系统所有根路径 */
		System.out.print("[ROOTS]");
		File[] roots = File.listRoots();
		for (File f: roots) {
			System.out.print(f);
		}
	}
	
	public void dispName(File f) {
		String dispName = f.getName();
		if (dispName.length() > 5)
			System.out.print(dispName.substring(dispName.length()-5, dispName.length()) );
		else {
			System.out.print(dispName);
		}
	}
	
	public String dispTime(long time) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date(time));
		return "[MT]" + calendar.get(Calendar.YEAR) + "/"
			+ calendar.get(Calendar.MONTH) + "/"
			+ calendar.get(Calendar.DAY_OF_MONTH) + "/"
			+ ", " + calendar.get(Calendar.HOUR_OF_DAY) + ":"
			+ calendar.get(Calendar.MINUTE) + ":"
			+ calendar.get(Calendar.SECOND);
	}
}
