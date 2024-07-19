
import java.util.Scanner;

public class SudokuGame {

    public static void main(String[] args) {
        int[][] sudokuGrid = new int[9][9];
        Scanner scanner = new Scanner(System.in);

        // Initialize Sudoku grid
        initializeGrid(sudokuGrid);

        // Print initial Sudoku grid
        System.out.println("Welcome to Sudoku Game!");
        System.out.println("Enter your Sudoku puzzle (use 0 for empty cells):");
        printGrid(sudokuGrid);

        // Input Sudoku puzzle from user
        inputGrid(sudokuGrid, scanner);

        // Print input Sudoku grid
        System.out.println("\nYour Sudoku puzzle:");
        printGrid(sudokuGrid);

        // Solve Sudoku puzzle
        if (solveSudoku(sudokuGrid)) {
            System.out.println("\nSudoku puzzle solved:");
            printGrid(sudokuGrid);
        } else {
            System.out.println("\nNo solution exists for the given Sudoku puzzle.");
        }

        scanner.close();
    }

    // Function to initialize an empty Sudoku grid
    public static void initializeGrid(int[][] grid) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                grid[i][j] = 0; // Initialize with zeros (empty cells)
            }
        }
    }

    // Function to print the Sudoku grid
    public static void printGrid(int[][] grid) {
        System.out.println("-------------------------");
        for (int i = 0; i < 9; i++) {
            System.out.print("| ");
            for (int j = 0; j < 9; j++) {
                System.out.print(grid[i][j] + " ");
                if ((j + 1) % 3 == 0) {
                    System.out.print("| ");
                }
            }
            System.out.println();
            if ((i + 1) % 3 == 0) {
                System.out.println("-------------------------");
            }
        }
    }

    // Function to input Sudoku puzzle from user
    public static void inputGrid(int[][] grid, Scanner scanner) {
        System.out.println("Enter 9 rows of 9 numbers each (use 0 for empty cells):");
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                grid[i][j] = scanner.nextInt();
            }
        }
    }

    // Function to solve the Sudoku using backtracking
    public static boolean solveSudoku(int[][] grid) {
        int row = -1;
        int col = -1;
        boolean isEmpty = true;

        // Find first empty cell (0)
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (grid[i][j] == 0) {
                    row = i;
                    col = j;
                    isEmpty = false;
                    break;
                }
            }
            if (!isEmpty) {
                break;
            }
        }

        // If there is no empty cell, puzzle is solved
        if (isEmpty) {
            return true;
        }

        // Try placing numbers 1-9 in the empty cell
        for (int num = 1; num <= 9; num++) {
            if (isValid(grid, row, col, num)) {
                grid[row][col] = num;

                // Recursively try to solve the rest of the grid
                if (solveSudoku(grid)) {
                    return true;
                } else {
                    // If placing num doesn't lead to a solution, backtrack
                    grid[row][col] = 0;
                }
            }
        }
        return false; // No valid number found, backtrack
    }

    // Function to check if a number can be placed in the given cell
    private static boolean isValid(int[][] grid, int row, int col, int num) {
        // Check if num is already in the row
        for (int i = 0; i < 9; i++) {
            if (grid[row][i] == num) {
                return false;
            }
        }

        // Check if num is already in the column
        for (int i = 0; i < 9; i++) {
            if (grid[i][col] == num) {
                return false;
            }
        }

        // Check if num is already in the 3x3 sub-grid
        int startRow = row - row % 3;
        int startCol = col - col % 3;
        for (int i = startRow; i < startRow + 3; i++) {
            for (int j = startCol; j < startCol + 3; j++) {
                if (grid[i][j] == num) {
                    return false;
                }
            }
        }

        return true; // Valid to place num in the cell
    }
}