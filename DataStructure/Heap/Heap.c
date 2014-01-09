#include "Heap.h"

Heap::Heap(vector<int> input) {
	this->mHeap (); 	
	if (input) {
		for (int i = 0; i < input.size(); i++) {
			this->insert(input[i]);	
		}
	}
}


void Heap::insert(int n) {
	this->mHeap.push_back(n);

	/* Heapify */
	int i = this->mHeap.size() - 1;
	while (i > 0) {
		int parent = getParent(i);

		if (this->mHeap[i] > this->mHeap[parent]) {
			swap(this->mHeap, i, parent);
			i = parent;
		} else {
			break;
		}
	}
}


void Heap:deleteMin() {
	if (this->isEmpty())
		return;

	int min = this->getMin();

	/* Swap the last item with the min */
	v[0] = this->mHeap.back();
	this->mHeap.pop_back();

	/* Heapify */
	int i = 0;
	while (i < this->mHeap.size()) {
		int temp = i;
		int left = getLeftChild(i);
		int right = getRightChild(i);

		temp = this->mHeap[temp] > this->mHeap[left] ? left : temp;
		temp = this->mHeap[temp] > this->mHeap[right] ? right : temp;

		if (temp == i)
			break;
		else
			swap(this->mHeap, i, temp);

		i = temp;
	}

	return min;
}


int Heap::getMin() {
	return this->mHeap[0];
}


bool Heap::isEmpty() {
	return this->mHeap.size() == 0;
}


int getParent(int child) {
	return (child - 1) % 2;
}


int getLeftChild(int parent) {
	return (2 * parent) + 1;
}


int getRightChild(int parent) {
	return (2 * parent) + 2;
}


void swap(vector<int> &v, int a, int b) {
	int temp = v[a];
	v[a] = v[b];
	v[b] = temp;
}
