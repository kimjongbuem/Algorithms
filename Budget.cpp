#include <string>
#include <vector>
#include<algorithm>
using namespace std;

int solution(vector<int> budgets, int M) {
	int answer = 0;
	sort(budgets.begin(), budgets.end());

	long sum = 0;
	for (int i : budgets) sum += i;
	if (sum < M) {
		answer = budgets[budgets.size() - 1];
		return answer;
	}
	int mid = 0; int premid = 0;
	int min = 0, max = M;
	int len = budgets.size();
	while (true) {
		sum = 0;
		mid = (max + min) / 2;
		if (mid == premid) break;
		for (int i = 0; i < len; i++) {
			if (mid <= budgets[i]) {
				sum += mid * (len - i);
				break;
			}
			else sum += budgets[i];
		}
		if (sum <= M) min = mid;
		else max = mid;
		premid = mid;
	}
	answer = mid;
	return answer;
}






int main() {
	vector<int> budgets = { 120,110,140,150 };
	solution(budgets, 485);
}