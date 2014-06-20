#include <iostream>
#include <mainchooser.h>

double newton(double (*f1)(double), double (*f2)(double), double x, int n) {
	if (n > 0) {
		return newton(f1, f2, x - (f1(x) / f2(x)), n - 1);
	}
	return x;
}

double f1(double x) {
	return x * x;
}

double f2(double x) {
	return 2.0 * x;
}

#if MAINMETHOD == NEWTON
int main() {

	// Startwert
	const double initialX = 5.0;

	// Abbruchkriterium (Funktion newton(.) wird recursionCount mal rekursiv aufgerufen
	const int recursionCount = 20;

	std::cout << newton(f1, f2, initialX, recursionCount);

	return 0;
}
#endif
