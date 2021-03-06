package algorithm;

/* 排序算法 */
public class Demo1 {
	public void quickSort(int[] args) {
		for (int i = 1; i < args.length; i++) {
			int j = i - 1; // i =4
			int temp = args[i]; // i =5
			while (j >= 0 && temp < args[j]) {
				args[j+1] = args[j]; 
				j--;
			}
			args[j+1] = temp;
		}
	}
	
	public void bubbleSort(int[] args) {
		for (int i = 0; i < args.length; i++) {
			for (var j = i+1; j < args.length; j++) {
				if (args[i] > args[j]) {
					int temp = args[i];
					args[i] = args[j];
					args[j] = temp;
				}
			}
		}
	}
}
