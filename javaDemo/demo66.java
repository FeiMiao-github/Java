package demo;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/* 线程安全ThreadLocalRandom和Random */
public class demo66 {
	public static void main(String[] args) {
		new demo66().test();
	}
	
	public void test() {
		byte[] bytes = new byte[4];
		Random random = new Random();
		System.out.println("boolean >>>" + random.nextBoolean());
		System.out.println("Double >>>" + random.nextDouble());
		System.out.println("Int >>> " + random.nextInt());
		random.nextBytes(bytes);
		for (byte b: bytes)
			System.out.println("Byte" + b);
		
		ThreadLocalRandom tLocalRandom = ThreadLocalRandom.current();
		System.out.println("Double >>> " + tLocalRandom.nextDouble());
	}  
}
