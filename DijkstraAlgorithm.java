import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class DijkstraAlgorithm {
	static int INF = 999999; static int max = 999999;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		Graph g = new DijkstraAlgorithm().new Graph();
		g.DijkstarNotHeap(4);
		g.Print();
	}
	
	class Graph{
		Vertex[] vertexs;
		int[] prev = new int[5];
		int[] dist = new int[5];
		public Graph() {
			vertexs = new Vertex[5]; 
			for(int i = 0; i < 5; i++) {
				vertexs[i] = new Vertex(i);
			}
			vertexs[4].lines.add(new Line(vertexs[3], 2));
			vertexs[4].lines.add(new Line(vertexs[1], 4));
			vertexs[1].lines.add(new Line(vertexs[0], 3));
			vertexs[3].lines.add(new Line(vertexs[1], 1));
			vertexs[3].lines.add(new Line(vertexs[2], 1));
			vertexs[0].lines.add(new Line(vertexs[2], 6));
			vertexs[0].lines.add(new Line(vertexs[3], 3));
			vertexs[2].lines.add(new Line(vertexs[3], 2));
		}
		public void DijkstarNotHeap(int number) {
			 
			for(int i = 0; i < 5; i++) {
				dist[i] = INF;
				for(int j = 0; j < 5; j++) {
					if(i == j) continue;
				}
			} dist[number] = 0;  
			
			Queue<Vertex> queue = new LinkedList<Vertex>();
			queue.add(vertexs[number]); 
			while(!queue.isEmpty()) {
				Vertex ver = queue.poll();
				for(int i = 0; i < ver.lines.size(); i++) {
					if(!ver.lines.get(i).flag) {
						ver.lines.get(i).flag = true;
						int n = ver.lines.get(i).other.number;
						if(prev[ver.number] == 0) { // 이전 데이터가 없는경우 또는 시작 버텍스인 경우
							prev[n] = ver.number;
							dist[n] = ver.lines.get(i).distance; 
						}else { // 이전 데이터가 있는경우
							if(dist[n] > dist[ver.number] + ver.lines.get(i).distance) {
								prev[n] = ver.number;
								dist[n] = dist[ver.number] + ver.lines.get(i).distance; 
							}
						}
						queue.add(ver.lines.get(i).other);
					}
				}
			}
		}
		public void Print() {
			Arrays.stream(dist).forEach(i -> System.out.println(i));
		}
	}
	class Vertex{
		int number;
		LinkedList<Line> lines = new LinkedList<Line>();
		
		public Vertex(int number) {
			this.number = number;
		}
	}
	class Line{
		Vertex other;
		boolean flag = false;
		int distance;
		Line(Vertex v, int d){
			other = v; distance = d;
		}
	}
}
