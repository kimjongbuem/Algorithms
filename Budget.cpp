#include <string>
#include <vector>
#include<algorithm>
using namespace std;

int solution(vector<int> budgets, int M) {
	int answer = 0;
	sort(budgets.begin(), budgets.end());
	int r = M % budgets.size();
	int avg = M / budgets.size();
	int biggerthanavg = 0;
	long sum = 0;
	for (int i : budgets) sum += i;
	if (sum < M) {
		answer = budgets[budgets.size() - 1];
		return answer;
	}
	for (int i = 0; i < budgets.size(); i++) {
		if (avg >= budgets[i]) r += (avg - budgets[i]);
		else biggerthanavg++;
	}

	answer = avg + r / biggerthanavg;

	return answer;
}






int main() {
	vector<int> budgets = { 120,110,140,150 };
	solution(budgets, 485);
}