import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Q1197 {
	static int answer = 987654321;
	static int temp = 0;
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int v = sc.nextInt(); int e = sc.nextInt();
		LinkedList<Node> nodeList = new LinkedList<Node>();
		for(int i = 0; i < v; i++) nodeList.add(new Node(i + 1));
		for(int i = 0; i < e; i++) nodeList.get(sc.nextInt() - 1).LineList.add(new Line(nodeList.get(sc.nextInt() - 1), sc.nextInt()));
		for(int i = 1; i <= v; i++) DFS(nodeList.get(i - 1)); 
		
	}
	static void DFS(Node start) {
		start.checked = true;
		for(int l = 0; l < start.LineList.size(); l++) {
			if(!start.LineList.get(l).d.checked) {
				temp += start.LineList.get(l).v;
				DFS(start.LineList.get(l).d);
			}
		}
	}
	
	static class Node{
		int n; // 번호
		LinkedList<Line> LineList;
		boolean checked = false; // 해당 노드가 체크되었는지 확인함. 
		Node(int n){
			this.n = n;
			this.LineList = new LinkedList<Line>();
		}
	}
	 
	static class Line{
		int v; // 가중치
		Node d; // 도착노드
		//boolean checked = false; // 해당 라인이 체크되었는지 확인함.
		Line(Node d, int v){
			this.d = d; this.v = v;
		}
	}
}
