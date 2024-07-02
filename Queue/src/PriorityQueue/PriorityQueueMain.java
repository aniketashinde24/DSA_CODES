package PriorityQueue;

import java.util.PriorityQueue;

public class PriorityQueueMain {

	public static void main(String[] args) {

		PriorityQueue<Integer> q = new PriorityQueue<>();
		q.offer(5);
		q.offer(9);
		q.offer(6);
		q.offer(2);

		while (!q.isEmpty()) {
			System.out.println(q.poll());
		}

	}

}
