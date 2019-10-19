
public class Brute_Force_Search {

	public static void main(String[] args) {
		int m = 4, n = 2; // 3C2 3P2 ...
		int [] set= new int[n]; int[] arr= new int[m];
		for(int i = 1; i<=m;i++) arr[i - 1] = i;
		
		//조합//
		Comb(set, 0 , m, n , 1);
		//중복조합//
		System.out.println();
		//순열//
		Perm(arr, 0 , m , n);
		//중복순열//
		
		
		System.out.println("완전탐색!");

	}
	// 조합 //
	static void Comb(int[] set, int set_size,int m , int n, int value) {
		if(set_size == n) {
			Print_set(set, set_size); return;
		}if(m < value) return;
		
		set[set_size] = value;
		Comb(set,set_size + 1, m, n, value + 1);
		Comb(set, set_size, m , n, value + 1);
		
	}
	// 순열 // 
	static void Perm(int[] arr, int set_size,int m , int n) {
		if(set_size == n) {
			Print_set(arr, set_size); return;
		}
		for(int i = set_size; i < m ;i++) {
			Swap_arr(arr, i, set_size);
			Perm(arr, set_size + 1, m , n);
			Swap_arr(arr, i, set_size);
		}
	}
	static void Swap_arr(int[] arr, int i, int set_size) {
		int temp = arr[i] ;
		arr[i] = arr[set_size];
		arr[set_size] = temp;
	}
	static void Print_set(int[] setOrArr,int set_size) {
		for(int i = 0; i < set_size ; i++) {
			System.out.print(setOrArr[i] +" ");
		}
		System.out.println();
	}
}
