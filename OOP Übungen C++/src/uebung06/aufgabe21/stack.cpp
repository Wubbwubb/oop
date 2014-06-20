#include <iostream>
#include <mainchooser.h>

class Stack {

private:
	int maxSize;
	int topElement;
	int* items;

	bool full() const {
		return topElement >= maxSize;
	}

public:
	Stack(int size) {
		maxSize = size;
		topElement = 0;
		items = new int[maxSize];
	}

	~Stack() {
		delete[] items;
	}

	bool empty() const {
		return topElement <= 0;
	}

	void push(int value) {
		if (!full()) {
			items[topElement] = value;
			topElement++;
		} else {
			std::cout << "stack is full" << std::endl;
		}
	}

	int top() const {
		int result;
		if (!empty()) {
			result = items[topElement - 1];
		} else {
			std::cout << "stack is empty" << std::endl;
		}
		return result;
	}

	int pop() {
		int result = top();
		topElement--;
		return result;
	}

	int const * begin() {
		return &items[0];
	}

	int const * end() {
		return &items[topElement];
	}

};

#if MAINMETHOD == STACK
int main() {

	const int size = 10;
	Stack stack(size);
	for (int i = 0; i < size + 1; ++i) {
		int value = i + 1;
		std::cout << "push: " << value << std::endl;
		stack.push(value);
	}

	const Stack stack2 = stack;

	int top = stack.top();
	int top2 = stack2.top();

	std::cout << "top: " << top << std::endl;
	std::cout << "top2: " << top2 << std::endl;

	auto iter = stack.begin();
	auto end = stack.end();

	std::cout << "iter:" << std::endl;
	while (iter != end) {
		std::cout << *iter << std::endl;
		iter++;
	}
	std::cout << "iter end:" << std::endl;

	for (int i = 0; i < size + 1; ++i) {
		int value = stack.pop();
		std::cout << "pop: " << value << std::endl;
	}

	return 0;
}
#endif
