#include <string>
#include <vector>
#include<queue>
#include<list>
using namespace std;


class Job {
private:
	int startTime;
	int workTime;
public:
	Job(int start, int work) {
		this->workTime = work; this->startTime= start;
	}
	bool operator<(const Job& job) const {
		if (workTime == job.workTime) return startTime > job.startTime;
		return workTime > job.workTime;
	}
	int getWorkTime() const { return workTime; }
	int getStartTime() const { return startTime; }
};
int solution(vector<vector<int>> jobs) {
	int answer = 0;
	priority_queue<Job> pq;
	vector<Job> list;
	for (int i = 0; i < jobs.size(); i++) {
		Job job = Job(jobs[i][0], jobs[i][1]);
		pq.push(job);
	}
	int size = pq.size();
	for (int i = 0; i < size; i++) {
		list.push_back(pq.top());
		pq.pop();
	}
	int start = 0; int time = 0;
	while (!list.empty()) {

		for (int i = 0; i < list.size(); i++) {
			if (list[i].getStartTime() <= start) {
				start += list[i].getWorkTime();
				time += start - list[i].getStartTime();
				list.erase(list.begin() + i);
				break;
			}
			if (i == list.size() - 1) start++;
		}
	}
	answer = time / jobs.size();
	return answer;
}

int main() {
	vector<vector<int>> jobs{ {0, 3},{1, 9},{2, 6} };
	solution(jobs);
}