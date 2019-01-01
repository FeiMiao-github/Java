import java.io.File;

/* file filter*/
public class demo74 {
	public static void main(String[] args) {
		new demo74().vfilterTetst();
	}
	
	public void vfilterTetst() {
		File file = new File("F:\\github\\java\\javaDemo\\");
		File[] fileList = file.listFiles((f)->(f.getName().endsWith("") && f.isDirectory()));
		for (File f: fileList) System.out.print("[fileList]" + f + "\n");
	}
}
