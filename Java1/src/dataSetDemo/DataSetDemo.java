package dataSetDemo;

import java.util.Random;

import dataSetDemo.Employee;

public class DataSetDemo {
	private int num;
	
	public DataSetDemo(int num) {
		this.num = num;
	}
	
	public Employee[] getData() {
		Employee[] e = new Employee[num];
		
		for (int i = 0; i < num; i++) {
			Random r = new Random();
			int time = r.nextInt(4);
			String name = "";
			
			for (int n = 0; n < 4 + time; n++) {
				if(!(n > 0)) name += (char)(65 + new Random().nextInt(25));
				name += (char)(97 + new Random().nextInt(25));
			}
			
			e[i] = new Employee(name, i+1);
		}
		
		return e;
	}
}
