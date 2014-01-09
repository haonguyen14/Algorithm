#include <iostream>
#include <stdlib.h>


class Heap {
	private:
		vector<int> mHeap;

	public:
		Heap(int *input);
		void insert(int n);
		void deleteMin();
		int  getMin();
		bool isEmpty();
};


int getParent(int);
int getLeftChild(int);
int getRightChild(int);
int swap(vector<int> &, int, int);
