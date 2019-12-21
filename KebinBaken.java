import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class KebinBaken {
	static int min = 1000000;
	static int answer = 0;
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int n = sc.nextInt(); // 사람수
		int m = sc.nextInt(); // 링크수
		int[] linkA = new int[m];
		int[] linkB = new int[m];
		for(int i = 0; i < m;i++) {
			linkA[i] = sc.nextInt();
			linkB[i] = sc.nextInt();
		}
		System.out.println(new KebinBaken().solution(n, m, linkA, linkB));
		
	}
	int solution(int n, int m, int[] linkA, int[] linkB) {
		LinkedList<N> nodeList = new LinkedList<N>();
		for(int i = 1; i<=5;i++ ) {
			nodeList.add(new N(i));
		}
		for(int i = 0; i < m; i++) {
			nodeList.get(linkB[i] - 1).linkNode.add(nodeList.get(linkA[i] - 1));
			nodeList.get(linkA[i] - 1).linkNode.add(nodeList.get(linkB[i] - 1));
		}
		for(int i = 1;i<=n;i++) {
			Bfs(i,nodeList);
			nodeList.stream().forEach(node -> node.checked = false);
			nodeList.stream().forEach(node -> node.cnt = 0);
		}
		return answer;
	}
	void Bfs(int num, LinkedList<N> nodeList) {
		Queue<N> que = new LinkedList<N>();
		int value = 0;
		que.add(nodeList.get(num - 1)); nodeList.get(num - 1).checked= true;
		while(!que.isEmpty()) { 
			N cur = que.poll();
			for(int i = 0;i < cur.linkNode.size();i++) {
				if(cur.linkNode.get(i).checked) continue;
				cur.linkNode.get(i).checked = true;
				cur.linkNode.get(i).cnt = cur.cnt + 1;
				que.add(cur.linkNode.get(i));
				value += cur.linkNode.get(i).cnt;
			}
		}
		if(min > value) {
			min = value; 
			answer = num;
		}
	}
	class N{
		boolean checked;
		int number;
		int cnt = 0;
		LinkedList<N> linkNode; 
		public N(int number) {
			this.number = number;
			linkNode = new LinkedList<N>();
		}
	}
}
