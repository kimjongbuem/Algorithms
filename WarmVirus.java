import java.util.Scanner;

public class WarmVirus {

	static int INF = 10000;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		int nodeCount = scanner.nextInt();
		int nodeLinkCount = scanner.nextInt();
		int answer = 0;
		
		boolean [][] d = new boolean[7][7];
		
		for(int i = 0; i < nodeLinkCount;i++) {
			int start = scanner.nextInt();
			int end = scanner.nextInt();
			d[start - 1][end - 1] = true;
		}
		for(int i = 0; i < nodeCount;i++) {
			for(int j = 0; j < nodeCount; j++) {
				for(int k = 0; k < nodeCount;k++) {
					if(d[j][i] && d[i][k]) d[j][k] = true;
				}
			}
		}
		
		for(int i = 1; i < nodeCount; i++ ) 
			if(d[0][i]) answer++;
		
		
		System.out.println(answer);
	}

}
