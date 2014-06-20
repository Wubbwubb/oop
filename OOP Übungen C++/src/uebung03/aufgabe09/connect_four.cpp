#include <iostream>
#include <mainchooser.h>
#include <vector>

const int ROWS = 6;
const int COLUMNS = 7;

const int PLAYER1 = 1;
const int PLAYER2 = 2;

void play(std::string, std::string);
int getInput(std::string, std::vector<int>*);
void printTable(std::vector<int>*, std::string, std::string);
int getWinner(std::vector<int>*, int, int, int);

#if MAINMETHOD == CONNECT_FOUR
int main() {

	std::string player1;
	std::string player2;

	std::cout << "Player1: ";
	std::cin >> player1;
	std::cout << std::endl;

	std::cout << "Player2: ";
	std::cin >> player2;
	std::cout << std::endl;

	play(player1, player2);

	return 0;
}
#endif

void play(std::string player1, std::string player2) {

	std::vector<int> table(ROWS * COLUMNS, 0);

	printTable(&table, player1, player2);

	bool active1 = true;
	int winner = 0;
	int roundCounter = ROWS * COLUMNS;

	int column;

	while (roundCounter > 0 && winner == 0) {

		if (active1) {
			column = getInput(player1, &table);
		} else {
			column = getInput(player2, &table);
		}

		int row;
		for (row = 0; row < ROWS; ++row) {
			int index = (row * COLUMNS) + column;
			if (table[index] == 0) {
				if (active1) {
					table[index] = PLAYER1;
				} else {
					table[index] = PLAYER2;
				}
				break;
			}
		}

		printTable(&table, player1, player2);

		if (active1) {
			winner = getWinner(&table, PLAYER1, row, column);
		} else {
			winner = getWinner(&table, PLAYER2, row, column);
		}

		active1 = !active1;
		--roundCounter;
	}

	if (winner != 0) {
		if (winner == PLAYER1) {
			std::cout << player1;
		} else {
			std::cout << player2;
		}
		std::cout << " wins!" << std::endl;
	}

}

void printTable(std::vector<int>* table, std::string player1, std::string player2) {

	std::cout << std::endl << player1 << ": X   " << player2 << ": O" << std::endl << std::endl;
	std::cout << " 1 2 3 4 5 6 7 " << std::endl;

	for (int row = ROWS - 1; row >= 0; --row) {
		std::cout << "|";
		for (int column = 0; column < COLUMNS; ++column) {
			char c = ' ';
			if ((*table)[(row * COLUMNS) + column] == PLAYER1) {
				c = 'X';
			} else if ((*table)[(row * COLUMNS) + column] == PLAYER2) {
				c = 'O';
			}
			std::cout << c << "|";
		}
		std::cout << std::endl;
	}
	std::cout << "---------------" << std::endl << std::endl;

}

int getInput(std::string player, std::vector<int>* table) {
	int column;
	std::cout << player << ": ";
	std::cin >> column;
	--column;

	while (column < 0 || column > COLUMNS - 1 || (*table)[((ROWS - 1) * COLUMNS) + column] != 0) {
		std::cout << player << ": ";
		std::cin.clear();
		std::cin >> column;
		--column;
	}

	return column;
}

int getWinner(std::vector<int>* table, int playerValue, int pRow, int pColumn) {

	int count = 1;

	// check vertical row
	for (int row = pRow - 1; row >= 0; --row) {
		if ((*table)[(row * COLUMNS) + pColumn] == playerValue) {
			++count;
			if (count >= 4) {
				return playerValue;
			}
		} else {
			count = 1;
			break;
		}
	}

	// check horizontal row
	for (int column = pColumn - 1; column >= 0; --column) {
		if ((*table)[(pRow * COLUMNS) + column] == playerValue) {
			++count;
			if (count >= 4) {
				return playerValue;
			}
		} else {
			break;
		}
	}
	for (int column = pColumn + 1; column < COLUMNS; ++column) {
		if ((*table)[(pRow * COLUMNS) + column] == playerValue) {
			++count;
			if (count >= 4) {
				return playerValue;
			}
		} else {
			count = 1;
			break;
		}
	}

	// check diagonal row1
	int row = pRow - 1;
	for (int column = pColumn - 1; column >= 0 && row >= 0; --column, --row) {
		if ((*table)[(row * COLUMNS) + column] == playerValue) {
			++count;
			if (count >= 4) {
				return playerValue;
			}
		} else {
			break;
		}
	}
	row = pRow + 1;
	for (int column = pColumn + 1; column < COLUMNS && row < ROWS; ++column, ++row) {
		if ((*table)[(row * COLUMNS) + column] == playerValue) {
			++count;
			if (count >= 4) {
				return playerValue;
			}
		} else {
			count = 1;
			break;
		}
	}

	// check diagonal row2
	row = pRow + 1;
	for (int column = pColumn - 1; column >= 0 && row < ROWS; --column, ++row) {
		if ((*table)[(row * COLUMNS) + column] == playerValue) {
			++count;
			if (count >= 4) {
				return playerValue;
			}
		} else {
			break;
		}
	}
	row = pRow - 1;
	for (int column = pColumn + 1; column < COLUMNS && row >= 0; ++column, --row) {
		if ((*table)[(row * COLUMNS) + column] == playerValue) {
			++count;
			if (count >= 4) {
				return playerValue;
			}
		} else {
			break;
		}
	}

	return 0;
}
