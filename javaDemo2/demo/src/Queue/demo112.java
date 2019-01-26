package Queue;

import java.util.PriorityQueue;

public class demo112 {
	public static void main(String[] args) {
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		
		/* PriorityQueue 是按照元素大小重新排序， 按照从小到大顺序移出队列 */
		pq.add(1);
		pq.add(-1);
		pq.add(0);
		pq.add(-3);
		
		o(pq);
		
		o(pq.peek());
		o(pq);
		
		pq.poll();
		o(pq + "[poll]");
		
		o(pq.remove());
		o(pq);
	}
	
	public static void o(Object o) {
		System.out.println(o.toString());
	}
}
