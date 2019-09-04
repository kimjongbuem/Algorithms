#include <iostream>
#include<vector>
#define MAX_SIZE = 8;
using namespace std;
// 오름차순 합병정렬 //
class SortRule {
public:
	virtual bool operator()(int num1, int num2) const = 0;
};
class AscendingSort : public SortRule {
public:
	bool operator()(int num1, int num2) const {
		if (num1 > num2) return true;
		return false;
	}
};
class DecendingSort : public SortRule {
public:
	bool operator()(int num1, int num2) const {
		if (num1 < num2) return true;
		return false;
	}
};
class Sorts {
public:
	virtual void sort(vector<int>& datas, const SortRule&) = 0;
	void print(vector<int>& datas) const {
		for (int data : datas) {
			cout << data << " ";
		}
		cout << endl;
	}
};
class MergeSort : public Sorts {
private:
public:
	void sort(vector<int>& datas, const SortRule& rule) {
		sorted.resize(8);
		mergeSort(datas, 0, datas.size() - 1,rule);
		for (int data : sorted) {
			cout << data << " ";
		}
		cout << endl;
	}

private:
	void mergeSort(vector<int>& datas,int left, int right, const SortRule& rule) {
		if (!(left < right)) return;
		int mid = (left + right )/ 2;
		
		mergeSort(datas, left, mid,rule);
		mergeSort(datas, mid + 1, right, rule);
		merge(datas, left, mid, right, rule);
	}
	void merge(vector<int>& datas, int left, int mid, int right, const SortRule& rule) {
		int l = left;
		int j = mid + 1;
		int k = left;
		while (l <= mid && j <= right) {
			int d1, d2;
			if (rule(datas[l] , datas[j])) sorted[k++] = datas[l++];
			else sorted[k++] = datas[j++];
		}
		if (l > mid) {
			for (l = j; l <= right; l++)
				sorted[k++] = datas[l];
		}
		else {
			for (; l <= mid; l++)
				sorted[k++] = datas[l];
		}
		for (l = left; l <= right; l++) {
			datas[l] = sorted[l];
		}
	}
private:
	vector<int> sorted;
};


int main() {
	vector<int> datas = { 21,11,30,29,88,455,9,66 };
	Sorts* sort = new MergeSort();
	sort->sort(datas, DecendingSort());
	sort->print(datas);
	system("pause");
}