class Solution {
    public boolean isValidSudoku(char[][] board) {
        int row = board.length;
        int col = board[0].length;

        for (int r = 0; r < row; r++) {
            Set<Character> set = new HashSet<>();
            for (int c = 0; c < col; c++) {
                char curr = board[r][c];
                if(curr != '.') {
                    if(set.contains(curr)) return false;
                    set.add(curr);
                }
            }
        }

        for (int r = 0; r < row; r++) {
            Set<Character> set = new HashSet<>();
            for (int c = 0; c < col; c++) {
                char curr = board[c][r];
                if(curr != '.') {
                    if(set.contains(curr)) return false;
                    set.add(curr);
                }
            }
        }

        for (int r = 0; r < 3; r++) {
            int innerR = 3 * r;
            for (int c = 0; c < 3; c++) {
                int innerC = 3 * c;

                Set<Character> set = new HashSet<>();
                for (int i = innerR; i < innerR + 3; i++) {
                    for (int j = innerC; j < innerC + 3; j++) {
                        char curr = board[i][j];

                        if(curr != '.') {
                            if(set.contains(curr)) return false;
                            set.add(curr);
                        }
                    }
                }
            }
        }

        return true;
    }
}
