import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Q1655 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		PriorityQueue<Integer> pq1 = new PriorityQueue<Integer>();
		PriorityQueue<Integer> pq2 = new PriorityQueue<Integer>(Collections.reverseOrder());
		int n = sc.nextInt(); 
		for(int i = 1; i <= n; i++) {
			int k = sc.nextInt();
			if(i % 2 == 1) {
				if(pq1.isEmpty() || pq1.peek() >= k ) {
					pq2.add(k);
				}else {
					int p = pq1.poll();
					pq2.add(p);
					pq1.add(k);
				}
				System.out.println(pq2.peek());
			}
			else {
				if(pq2.isEmpty()|| pq2.peek() <= k) pq1.add(k);
				else {
					int p = pq2.poll();
					pq1.add(p);
					pq2.add(k);
				}
				System.out.println(pq2.peek());
			}
		} sc.close();
	}

}
