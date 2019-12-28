import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class ConferenceReady {

	static int INF = 10000;
	static int MAX = 101;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		int nodeCount = scanner.nextInt();
		int nodeLinkCount = scanner.nextInt();
		
		int answer = 0;
		
		int[][] d = new int[MAX][MAX]; // test 
		
		LinkedList<Node> nodeList = new LinkedList<Node>();
		LinkedList<Integer> representations = new LinkedList<Integer>();
		for(int i = 1; i <= nodeCount;i++) {
			nodeList.add(new Node(i));
			for(int j = 1; j <= nodeCount;j++) {
				d[i][j] = INF;
			}
		}
		
		for(int i = 0; i < nodeLinkCount;i++) {
			int start = scanner.nextInt();
			int end = scanner.nextInt();
			nodeList.get(start - 1).List.add(nodeList.get(end - 1));
			nodeList.get(end - 1).List.add(nodeList.get(start - 1));
			d[start][end] = 1;
			d[end][start] = 1;
		}
		// 워셜  알고리즘 //
		for(int i = 1; i <= nodeCount;i++) {
			for(int j = 1; j <= nodeCount; j++) {
				for(int k = 1; k <= nodeCount;k++) {
					if(d[j][i] + d[i][k] < d[j][k]) d[j][k] = d[j][i] + d[i][k];
				}
			}
		}
		for(int i = 1; i <= nodeCount;i++) d[i][i] = 0;
		
		
		for(int i = 0; i <nodeList.size();i++) { // 모든 노드들 반복
			if(!nodeList.get(i).checked) {
				
				int curRepresentation = -1;
				LinkedList<Integer> numbers = new LinkedList<Integer>();
				Queue<Node> queue = new LinkedList<Node>();
				queue.add(nodeList.get(i)); nodeList.get(i).checked = true;
				while(!queue.isEmpty()) { // b f s를 이용한 해당 리스트의 연결 체크완료
					Node cur = queue.poll();
					numbers.add(cur.number); // 대표 후보자 추가
					for(Node n : cur.List) {
						if(!n.checked) { 
						n.checked = true;
						queue.add(n);
						}
					}
				}
				int min = Integer.MAX_VALUE;
				for(int r = 0; r < numbers.size();r++) { // 대표후보자 => 거리 합이 가장 작은 대표(인덱스)를 구함
					int nIdx = numbers.get(r); ;
					int sum = 0;
					for(int u = 1; u <= nodeCount; u++) {
						if(d[nIdx][u] == INF) continue;
						sum += d[nIdx][u];
					}
					if(min > sum) {
						min = sum;
						curRepresentation = nIdx; // 대표 
					}
				}
				representations.add(curRepresentation);
				answer++;
			}
		}
		System.out.println(answer);
		representations.stream().forEach(i -> System.out.println(i));
	}
	static class Node{
		LinkedList<Node> List = new LinkedList<Node>();
		boolean checked = false;
		int number;
		Node(int num){
			number = num;
		}
	}

}
