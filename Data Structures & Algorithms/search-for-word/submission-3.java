class Solution {
    int row;
    int col;
    char[][] board;
    String word;

    public boolean exist(char[][] board, String word) {
        this.board = board;
        this.word = word;
        row = board.length;
        col = board[0].length;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (dfs(i, j, 0)) {
                    return true;
                }
            }
        }

        return false;
    }

    public boolean dfs(int r, int c, int i) {
        if (word.length() == i) {
            return true;
        }
        if (Math.min(r, c) < 0 || r >= row || c >= col) {
            return false;
        }
        if (board[r][c] != word.charAt(i) || board[r][c] == '0') {
            return false;
        }
        i++;
        char temp = board[r][c];
        board[r][c] = '0';
        boolean res = dfs(r - 1, c, i) ||
                dfs(r + 1, c, i) ||
                dfs(r, c - 1, i) ||
                dfs(r, c + 1, i);
        board[r][c] = temp;
        return res;
    }
}
