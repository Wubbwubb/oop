#include <iostream>
#include <mainchooser.h>
#include <vector>

void gameOfLife(std::vector<bool>, int, int, int);
void printBoard(std::vector<bool>*, int, int);
int countNeighbors(std::vector<bool>*, int, int, int, int);
void set(std::vector<bool>*, int, int, int);

#if MAINMETHOD == GAME_OF_LIFE
int main() {

	const int rows = 10;
	const int columns = 10;
	const int generations = 10;

	std::vector<bool> board(rows * columns, false);
	set(&board, columns, 1, 1);
	set(&board, columns, 1, 2);
	set(&board, columns, 2, 1);
	set(&board, columns, 2, 2);
	set(&board, columns, 3, 3);
	set(&board, columns, 4, 3);
	set(&board, columns, 3, 4);
	set(&board, columns, 4, 4);

	gameOfLife(board, rows, columns, generations);

	return 0;
}
#endif

void gameOfLife(std::vector<bool> board, int rows, int columns, int generations) {

	printBoard(&board, rows, columns);

	for (int generation = 0; generation < generations; ++generation) {

		std::vector<bool> newBoard(rows * columns, false);

		for (int row = 0; row < rows; ++row) {
			for (int column = 0; column < columns; ++column) {
				int index = (row * columns) + column;
				int count = countNeighbors(&board, rows, columns, row, column);
				if (board[index]) {
					if (count >= 2 && count <= 3) {
						newBoard[index] = true;
					}
				} else if (count == 3) {
					newBoard[index] = true;
				}
			}
		}

		board = newBoard;
		printBoard(&board, rows, columns);

	}

}

void printBoard(std::vector<bool>* board, int rows, int columns) {

	std::cout << std::endl;
	for (int i = 0; i < columns + 2; ++i) {
		std::cout << "-";
	}
	std::cout << std::endl;

	for (int i = 0; i < rows; ++i) {
		std::cout << "|";
		for (int j = 0; j < columns; ++j) {
			if ((*board)[(i * columns) + j]) {
				std::cout << "X";
			} else {
				std::cout << " ";
			}
		}
		std::cout << "|" << std::endl;
	}

	for (int i = 0; i < columns + 2; ++i) {
		std::cout << "-";
	}
	std::cout << std::endl << std::endl;

}

int countNeighbors(std::vector<bool>* board, int rows, int columns, int row, int column) {

	int count = 0;
	for (int tmpRow = row - 1; tmpRow <= row + 1; ++tmpRow) {
		for (int tmpColumn = column - 1; tmpColumn <= column + 1; ++tmpColumn) {
			if (tmpRow == row && tmpColumn == column) {
				continue;
			}
			if (tmpRow < 0 || tmpRow >= rows || tmpColumn < 0 || tmpColumn >= columns) {
				continue;
			}
			if ((*board)[(tmpRow * columns) + tmpColumn]) {
				++count;
			}
		}
	}

	return count;
}

void set(std::vector<bool>* board, int columns, int row, int column) {
	(*board)[(row * columns) + column] = true;
}
