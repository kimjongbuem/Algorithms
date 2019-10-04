class Solution {
	public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        for(int i = 0; i < skill_trees.length ; i++) {
        	boolean isExisted = true;
        	int idx = 0;
        	String[] strA = skill_trees[i].split("");
        	for(String s :strA) {
        		if(idx == skill.indexOf(s)) idx++;
        		else if(idx < skill.indexOf(s)) {
        			isExisted = false;
        			break;
        		}
        	}
        	if(isExisted) answer++;
        }
        
        return answer;
    }
}

public class Skill_tries2for {
	public static void main(String arg[]) {
		String[] skill_trees = {"BACDE", "CBADF", "AECB", "BDA"};
		System.out.println(new Solution().solution("CBD", skill_trees));
	}
}
