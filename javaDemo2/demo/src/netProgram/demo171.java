package netProgram;

import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/* URL */
public class demo171 {
	public static void main(String[] args) throws IOException {
		System.out.println("start");
//		URL url = new URL("http://www.baidu.com");
		
//		File f = new File("/baidu.txt");
		
		DownUtil du = new DownUtil("https://static.zhihu.com/heifetz/assets/sign_bg.db29b0fb.png", "/baidu.png", 2);
		
		try {
			du.downThread();
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		
		while (true) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			System.out.println("[Rate: " + du.getCompleteRate() + "% ]");
		}
	}
}

// 实现多线程下载工具类
class DownUtil {
	private String path; // 定义下载资源路径
	private String targetPath; // 定义保存路径
	private int threadNum; // 定义需要多少线程下载资源
	private DownThread[] threads; // 定义下载的线程对象
	private int fileSize; // 定义下载文件大小

	public DownUtil(String path, String targetPath, int threadNum) {
		this.path = path;
		this.targetPath = targetPath;
		this.threadNum = threadNum;
		this.threads = new DownThread[threadNum];
	}

	public void downThread() throws Exception {
		URL url = new URL(path);
		HttpURLConnection conn = beforeDownload(url);
		conn.setRequestProperty("Connection", "Keep-Alive");

		/* 获取文件大小 */
		fileSize = conn.getContentLength();
		conn.disconnect();
		int currentPartSize = fileSize / threadNum + 1;
		RandomAccessFile file = new RandomAccessFile(targetPath, "rw");
		/* 设定本地文件大小 */
		file.setLength(fileSize);
		file.close();
		for (int i = 0; i < threadNum; i++) {
			/* 设定每个文件下载位置 */
			int startPos = i * currentPartSize;
			
			RandomAccessFile currentPart = new RandomAccessFile(targetPath, "rw");
			currentPart.seek(startPos);
			
			/* 创建下载线程 */
			threads[i] = new DownThread(startPos, currentPartSize, currentPart);
			threads[i].start();
		}
	}
	
	public double getCompleteRate() {
		int sumSize = 0;
		
		for (var t: threads) {
			sumSize += t.getLength();
		}
		
		System.out.println("[ file size: " + fileSize + "\tsumSize: " + sumSize + "]");
		return sumSize * 1.0 / fileSize; 
	}
	
	private HttpURLConnection beforeDownload(URL url) throws IOException {
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setConnectTimeout(5 * 1000); // 5s
		conn.setRequestMethod("GET");
		conn.setRequestProperty("ACCEPT",
				"image/gif, image/jpeg, image/pjpeg, image/pjpeg, "
						+ "application/x-shockwave-flash, application/xaml+xml, "
						+ "application/vnd.ms-xpsdocument, application/x-ms-xbap"
						+ "application/x-ms-application, application/vnd.ms-excel"
						+ "application/vnd.ms-powerpoint, application/msword, */*");
		conn.setRequestProperty("Accept-Language", "zh-CN");
		conn.setRequestProperty("Charset", "UTF-8");
		
		return conn;
	}

	private class DownThread extends Thread {
		private int startPos;
		private int currentPartSize;
		private RandomAccessFile currentPart;
		
		/* 已经下载完成的字节数 */
		private int length;
		
		public DownThread(int startPos, int currentPartSize, RandomAccessFile currentPart) {
			this.startPos = startPos;
			this.currentPartSize = currentPartSize;
			this.currentPart = currentPart;
		}
		
		public int getLength() {
			return length;
		}
		
		@Override
		public void run() {
			try {
				URL url = new URL(path);
				HttpURLConnection conn = beforeDownload(url);
				
				InputStream instream = conn.getInputStream();
				
				/* 跳过startPos个字节 */
				instream.skip(startPos);
				
				byte[] buffer = new byte[1024];
				int hasRead = 0;
				
				while (length < currentPartSize && (hasRead = instream.read(buffer)) > 0) {
					currentPart.write(buffer);
					length += hasRead;
				}
				
				currentPart.close();
				instream.close();
				
			} catch (MalformedURLException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			super.run();
		}
	}
}

class Connect {
	public void testDemo() throws IOException {
		URL url = new URL("http://www.baidu.com");
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setConnectTimeout(1000);
		conn.setRequestMethod("GET");
		conn.setRequestProperty("Accept", "image/git, image/jpeg, image/pjpeg, image/pjpeg");
		conn.setRequestProperty("Connection", "Keep-Alive");

		int fileSize = conn.getContentLength();
		System.out.println("[" + url.getHost() + "]file size: " + fileSize + "[" + url.getPort() + "]");

		/* 获取协议名称 */
		System.out.println("[" + "协议名称: " + url.getProtocol() + "]");

		/* 获取查询字符串 */
		System.out.println("[" + "查询字符串: \n" + url.getQuery() + "]");

		conn.disconnect();
	}
}