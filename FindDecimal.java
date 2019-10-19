
import java.util.*;

public class FindDecimal {
	//	프로그래머스
	//	완전탐색 - 소수 찾기
	//	(https://programmers.co.kr/learn/courses/30/lessons/42839)
    //  Author: developer.charontea@gmail.com


	public static void main(String[] args) {
		System.out.println(new FindDecimal().solution("17"));
		System.out.println(new FindDecimal().solution("011"));
	}
	static boolean[] checked;
		public int solution(String numbers) {
			checked = new boolean[numbers.length()];
			String numberList[] = new String[numbers.length()];
			for(int i = 0; i<numbers.length();i++) {
				numberList[i] = String.valueOf(numbers.charAt(i));
			}
			Set<Integer> set = new HashSet<Integer>();
			FindDeciamls("",numberList,set);
			
			
			return set.size();
			
	    }
	    public void FindDeciamls(String numbers, String[] numberList , Set<Integer> set) {
	    	if(numbers.length() > numberList.length) return;
	    	
	    	if(numbers.length() != 0) {
	    		int nowNumber = Integer.parseInt(numbers);
	    		if(isPrime(nowNumber)) set.add(nowNumber);
	    	}
	    	for(int i = 0; i < numberList.length; i++) {
	    		if(!checked[i]) {
	    		checked[i] = true;
	    		FindDeciamls(numbers.concat(numberList[i]), numberList, set);
	    		checked[i] = false;
	    		}
	    	}
	    	
	    }
	    static boolean isPrime(int number){
	        boolean TF = true;
	        if(number<2) {
	        	return false;
	        }
	        for(int i=2; i<((number/2)+1); i++){
	            if(number%i==0){
	                TF = false;
	                break;
	            }
	        }
	        return TF;
	    }	    
}

