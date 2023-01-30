import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class SudokuSolver {
    static Set<Character> validChars = new TreeSet<>();

    static {
        for (char c = '1'; c <= '9'; c++) {
            validChars.add(c);
        }
    }

    public static void main(String[] args) {
        char[][] board = {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };

        solveSudoku(board);
    }

    public static void solveSudoku(char[][] board) {
        char[][] solution = board.clone();
        int[][] indxs = new int[9][9];


        Set[][] probableSol = new HashSet[9][9];
        int itr = 0;

        for (int i = 0; i < 9; i++) {
            int j = 0;
            Set<Character> chars = new HashSet<>();
            Set<Integer> indx = new HashSet<>();

            while (j < 9) {
                if (probableSol[i][j] == null)
                    probableSol[i][j] = new HashSet();
                if (solution[i][j] == '.') {
                    indx.add(j);
                    Set<Character> allRemaining = new HashSet<>();
                    allRemaining.addAll(validChars);
                    probableSol[i][j].addAll(probables(allRemaining, solution, i, j));
                } else {
                    chars.add(solution[i][j]);
                    probableSol[i][j].add(solution[i][j]);
                }
                j++;
            }
        }
        while (itr < 5) {
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    if (probableSol[i][j].size() == 1) continue;
                    Character c = findUnique(probableSol, solution[i][j]);
                    if (c != null) {
                        solution[i][i] = c;
                    }
                }
            }
            itr++;
        }

        System.out.println(probableSol);


    }

    private static Character findUnique(Set[][] probableSol, char c) {
        return null;
    }

    private static Collection probables(Set<Character> allRemaining, char[][] solution, int i, int j) {

        removeInRow(allRemaining, solution, i, j);
        removeInColumn(allRemaining, solution, i, j);
        removeInBox(allRemaining, solution, i, j);
        return allRemaining;
    }

    private static void removeInBox(Set<Character> allRemaining, char[][] solution, int i, int j) {

        int bi1 = i / 3;
        int bi2 = i % 3;
        int bj1 = j / 3;
        int bj2 = j % 3;

        for (int k = bi1; k <= bi2; k++) {
            for (int l = bj1; l <= bj2; l++) {
                if (allRemaining.contains(solution[k][l])) {
                    allRemaining.remove(solution[k][l]);
                }
            }
        }
    }

    private static void removeInColumn(Set<Character> allRemaining, char[][] solution, int i, int j) {
        for (int k = 0; k < 9; k++) {
            if (allRemaining.contains(solution[k][j])) {
                allRemaining.remove(solution[k][j]);
            }
        }
    }

    private static void removeInRow(Set<Character> allRemaining, char[][] solution, int i, int j) {

        for (int k = 0; k < 9; k++) {
            if (allRemaining.contains(solution[i][k])) {
                allRemaining.remove(solution[i][k]);
            }
        }

    }
}
