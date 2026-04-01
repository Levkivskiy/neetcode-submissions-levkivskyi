class Solution {
    int[][] cache;
    int row = 0;
    int col = 0;

    public int memo(int r, int c) {
        if (r >= row || c >= col) {
            return 0;
        }
        if (r == row - 1 || c == col - 1) {
            return 1;
        }
        if (cache[r][c] != -1) {
            return cache[r][c];
        }
        cache[r][c] = memo(r + 1, c) + memo(r, c + 1);
        return cache[r][c];
    }

    public int uniquePaths(int m, int n) {
        cache = new int[n][m];
        row = n;
        col = m;
        for (int i = 0; i < row; i++) {
            Arrays.fill(cache[i], -1);
        }

        return memo(0, 0);
    }
}
