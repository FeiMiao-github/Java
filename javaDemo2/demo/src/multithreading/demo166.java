package multithreading;

import java.time.LocalDateTime;
import java.time.temporal.ChronoField;
import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

public class demo166 {
	public static void main(String[] args) {
		int[] arr = new int[100];
		int total = 0;
		Random rd = new Random(LocalDateTime.now().getLong(ChronoField.MICRO_OF_SECOND));

		for (var i = 0; i < 100; i++) {
			total += (arr[i] = rd.nextInt(20));
		}

		System.out.println("total: " + total);
		ForkJoinPool pool = new ForkJoinPool(10);
		PrintTask pt = new PrintTask(arr, 0, arr.length);
		ForkJoinTask<Integer> fjt = pool.submit(pt);

		try {
			System.out.println(fjt.get());
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}

		pool.isShutdown();
	}
}

class PrintTask extends RecursiveTask<Integer> {
	private static final long serialVersionUID = 1L;

	private static final int THRESHOLD = 10;

	private int start;
	private int end;
	private int[] array;

	public PrintTask(int[] array, int start, int end) {
		this.array = array;
		this.end = end;
		this.start = start;
	}

	@Override
	protected Integer compute() {
		int sum = 0;
		if (end - start < THRESHOLD) {
			for (var i = start; i < end; i++) {
				sum += array[i];
			}
		} else {
			// 分解任务
			int mid = (start + end) / 2;

			PrintTask left = new PrintTask(array, start, mid);
			PrintTask right = new PrintTask(array, mid, end);

			left.fork();
			right.fork();

			sum = left.join() + right.join();
		}

		return sum;
	}

}
