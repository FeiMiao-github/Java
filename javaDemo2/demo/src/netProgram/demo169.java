package netProgram;

import java.io.IOException;
import java.net.InetAddress;

/*	使用	InetAddress */
public class demo169 {
	public static void main(String[] args) throws IOException {
		// 根据主机获取对应的InetAdress Instance
		InetAddress ip = InetAddress.getByName("www.baidu.com");
		
		// 获取 ip string
		System.out.println("baidu ip: " + ip.getHostAddress());
		
		// 获取HostName
		System.out.println("baidu host name: " + ip.getHostName());
		
		// 判断是否可达
		System.out.println("baidu是否可达: " + ip.isReachable(200));
		
		// 获取本机Ip Address
		InetAddress local = InetAddress.getLocalHost();
		System.out.println(local);
		
		// get InetAddress instance by the initial ip address
		InetAddress inetInstance = InetAddress.getByAddress(new byte[] {127, 0, 0, 1});
		System.out.println("127, 0, 0, 1 is reachable: " + inetInstance.isReachable(2000));
	}
}
