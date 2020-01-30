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
		int n; // ��ȣ
		LinkedList<Line> LineList;
		boolean checked = false; // �ش� ��尡 üũ�Ǿ����� Ȯ����. 
		Node(int n){
			this.n = n;
			this.LineList = new LinkedList<Line>();
		}
	}
	 
	static class Line{
		int v; // ����ġ
		Node d; // �������
		//boolean checked = false; // �ش� ������ üũ�Ǿ����� Ȯ����.
		Line(Node d, int v){
			this.d = d; this.v = v;
		}
	}
}
