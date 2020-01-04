import java.util.Scanner;

public class Q14501 {
	static int max = 0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[]t = new int[N + 1];
		int[]p = new int[N + 1];
		for(int i = 1; i <= N;i++)
		{
			t[i] = sc.nextInt();
			p[i] = sc.nextInt();
		}
		for(int i = 1; i <= N;i++) { // Ã¹½ÃÀÛ.
			int sum = 0;
			int idx = i;
			int curT = 1;
			int nextT = t[i];
			for(int j = i + 1; j <= N;j++) {
				if(nextT == curT) {
					sum += p[idx];
					idx = j;
					nextT = t[j];
					curT = 0;
				}
				curT++;
			}
			max = max > sum ? max : sum;
		}
		System.out.println(max);
	}
}
