import java.util.LinkedList;
import java.util.List;

public class ImmigrationTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	class Solution {
	    public long solution(int n, int[] times) {
	        long answer = 0;
	        List<Tester> list = new LinkedList<ImmigrationTest.Tester>();
	        for(int time : times) {
	        	list.add(new Tester(time)); //ť�� ����������� �ұ��ϰ� �߰��� ���Ұ�� ����Ʈ���� ������
	        }
	        
	        
	        
	        return answer;
	    }
	}
	class Tester{
		private int time;
		List<Integer> testerDesk;
		public Tester(int time) {
			this.time = time;
			testerDesk = new LinkedList<Integer>();
		}
		public void DecrementTime() {
			if(testerDesk.isEmpty()) return;
			testerDesk.set(0, testerDesk.get(0));
			if(testerDesk.get(0) == 0) testerDesk.remove(0);
		}
		public int GetTime() {
			return time;
		}
		public boolean isEmpty() {
			return testerDesk.isEmpty();
		}
	}
}
