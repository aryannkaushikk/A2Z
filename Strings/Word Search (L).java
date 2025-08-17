"""
Approach

Set the current cell to '#' so as to not use it again
Before returning set it back to original character
"""

class Solution {
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    int n, m;

    boolean outOfBound(int i, int j) {
        return i < 0 || i >= n || j < 0 || j >= m;
    }

    boolean dfs(char[][] board, String word, int x, int i, int j) {
        if (x == word.length()) return true;
        if (outOfBound(i, j)) return false;
        if (board[i][j] != word.charAt(x)) return false;

        char val = board[i][j];
        board[i][j] = '#';

        for (int k = 0; k < 4; k++) {
            if (dfs(board, word, x + 1, i + dx[k], j + dy[k])) {
                board[i][j] = val;
                return true;
            }
        }

        board[i][j] = val;
        return false;
    }

    public boolean exist(char[][] board, String word) {
        n = board.length;
        m = board[0].length;

        if (!canForm(board, word)) return false;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == word.charAt(0) && dfs(board, word, 0, i, j)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean canForm(char[][] board, String word) {
        int[] countBoard = new int[128], countWord = new int[128];
        for (char[] row : board) for (char c : row) countBoard[c]++;
        for (char c : word.toCharArray()) {
            countWord[c]++;
            if (countWord[c] > countBoard[c]) return false;
        }
        return true;
    }
}
