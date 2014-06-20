#include <iostream>
#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include <mainchooser.h>

int partition(int* a, int l, int r) {
	int pivot = a[r];
	int i = l;

	for (int j = l; j < r; j++) {
		if (a[j] <= pivot) {
			int k = a[i];
			a[i] = a[j];
			a[j] = k;
			i++;
		}
	}

	int c = a[i];
	a[i] = a[r];
	a[r] = c;

	return i;
}

void quicksort(int* a, int l, int r) {
	if (l < r) {
		int m = partition(a, l, r);
		quicksort(a, l, m - 1);
		quicksort(a, m + 1, r);
	}
}

#if MAINMETHOD == QUICKSORT
int main() {
	const int arraySize = 20;
	int a[arraySize];
	srand(time(NULL));
	std::cout << "before quicksort:" << std::endl;
	// fill array with random integers in range [0;99]
	for (int i = 0; i < arraySize; ++i) {
		a[i] = rand() % 100;
		if (i > 0) {
			std::cout << ", ";
		}
		std::cout << a[i];
	}
	std::cout << std::endl << std::endl;

	quicksort(a, 0, arraySize - 1);

	std::cout << "after quicksort:" << std::endl;
	// print sorted array
	for (int i = 0; i < 20; i++) {
		if (i > 0) {
			std::cout << ", ";
		}
		std::cout << a[i];
	}
	return 0;
}
#endif
