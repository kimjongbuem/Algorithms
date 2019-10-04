class Solution {
	public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        for(int i = 0; i < skill_trees.length ; i++) {
        	boolean isExisted = false;
        	String str ="";
        	for(int j = 0; j < skill_trees[i].length(); j++) {
        		for(int k = 0; k < skill.length(); k++) {
        			if(skill_trees[i].charAt(j) == skill.charAt(k)) {
        				isExisted = true;
        				str+=skill_trees[i].charAt(j);
        			}
        		}
        	}
    		if(isExisted) {
    			if(str.equals(skill.substring(0, str.length())))answer++;
    		}
        }
        
        return answer;
    }
}

public class Skill_tries {
	public static void main(String arg[]) {
		String[] skill_trees = {"BACDE", "CBADF", "AECB", "BDA"};
		System.out.println(new Solution().solution("CBD", skill_trees));
	}
}
