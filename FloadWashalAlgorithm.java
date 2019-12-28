import java.util.LinkedList;

public class FloadWashalAlgorithm {
	static int INF = 100000 , NIL = 100000;
	public static void main(String[] args) {
	
		
		int[][] dist = {
				{0,3,8,INF,-4},	
				{INF,0,INF,1,7},	
				{INF,4,0,INF,INF},	
				{2,INF,-5,0,INF},
				{INF,INF,INF,6,0},	
		};
		int[][] prevNode = {
				{NIL,1,1,NIL,1},
				{NIL,NIL,NIL,2,2},
				{NIL,3,NIL,NIL,NIL},
				{4,NIL,4,NIL,NIL},
				{NIL,NIL,NIL,5,NIL}
		};
		
		//�ʱ� �� ����//
		System.out.println();
		for(int i = 0; i < 5; i++) { // ���İ��� ���
			for(int j = 0; j < 5; j++) {  // ��߳��
				for(int k = 0; k < 5; k++) { // �������
					
					if(dist[j][i] >= INF &&  dist[i][k] >= INF) continue;
					
					if(dist[j][i] + dist[i][k] < dist[j][k]) {
						dist[j][k] = dist[j][i] + dist[i][k];
						prevNode[i][k] = i; 
					}
					 
				}
			}
		}
		
		// �Ϸ� �� ���̺� //
		System.out.println();
	}
}
