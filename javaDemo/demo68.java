import static java.util.Calendar.YEAR;// 静态导入

import java.util.Calendar;
import java.util.Date;

public class demo68 {

	public static void main(String[] args) {
		demo68 demo = new demo68();
		switch (3) {
		case 1:
			demo.test();
			break;
		case 2:
			demo.calendarTest();
			break;
		case 3:
			demo.setDelayTest();
			break;
		default:
			return;
		}
	}
	
	public void test() {
		// 调用 System 获取当前时间
		long t = System.currentTimeMillis();
		System.out.println("[System.currentTimeMillis]" + t);
		
		// 调用 Date 方法获取当前时间
		System.out.println("[Date]" + new Date());
		System.out.println("[Date]" + new Date(0l));
	}
	
	public void calendarTest() {

		Calendar calendar = Calendar.getInstance();
		// Date 和  Calendar 相互转化
		
		Date date = calendar.getTime();
		System.out.println("[Date]" + date);
		System.out.println("[Calendar]" + "Year-" + calendar.get(YEAR));
		System.out.println("[Calendar]" + "Month-" + calendar.get(Calendar.MONTH));
		System.out.println("[Calendar]" + "Max_Month-" + calendar.getMaximum(Calendar.MONTH));
		
		// add 和 roll
		Calendar calendar2 = Calendar.getInstance();
		calendar2.setTime(date);
		
		printCalendar(calendar);
		printCalendar(calendar2);
		calendar2.add(Calendar.MONTH, 1);
		System.out.print("[Month+1]");
		printCalendar(calendar2);
		calendar2.add(Calendar.MONTH, -15);
		System.out.print("[Month-12]");
		printCalendar(calendar2);
		
		calendar2.setTime(date);
		calendar2.roll(Calendar.MONTH, 1);
		printCalendar(calendar2);
		/* 区别在于是否会“进位” */
		
		/* Calendar 容错性检查  默认具有较高的容错性*/
		calendar2.set(Calendar.MONTH, 14);
		System.out.print("[Set_Month_14]");
		printCalendar(calendar2);
		calendar2.setLenient(false); // 设置为不可接受超出范围的值
		
		calendar2.setTime(date); // 重置时间
		printCalendar(calendar2);
		calendar2.set(Calendar.MONTH, 14);
		System.out.print("[calendar2_2]");
		printCalendar(calendar2); // 调用失败, 报出参数不正确异常
		System.out.println("EOF");
	}
	
	public void setDelayTest() {
		System.out.println("[Max_DAY_OF_MONTH]" + Calendar.getInstance().getMaximum(Calendar.DAY_OF_MONTH));
		// set 具有延迟的特性
		Calendar calendar = Calendar.getInstance(); 
		calendar.set(2018, 8, 31); // 9.31
		calendar.set(Calendar.MONTH, 7);// 8.31 
		// 在 get 之前， Calendar 所代表的时间不会立即更改
		
		printCalendar(calendar);
	}
	
	public void printCalendar(Calendar c) {
		System.out.println("[Calendar]" + "Year-" + c.get(Calendar.YEAR)
				+ ", Mont-" + c.get(Calendar.MONTH) 
				+ ", Day-" + c.get(Calendar.DAY_OF_MONTH));
	}
} 