class Solution {
    int row = 0;
    int col = 0;

    public int countAndFill(int[][] grid, int r, int c) {
        if (Math.min(r, c) < 0 || r == row || c == col || grid[r][c] == 0) {
            return 0;
        }

        grid[r][c] = 0;
        int count = 0;
        count += countAndFill(grid, r + 1, c);
        count += countAndFill(grid, r - 1, c);
        count += countAndFill(grid, r, c + 1);
        count += countAndFill(grid, r, c - 1);

        return count += 1;
    }

    public int maxAreaOfIsland(int[][] grid) {
        int max = 0;
        row = grid.length;
        col = grid[0].length;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                max = Math.max(countAndFill(grid, i, j), max);
            }
        }

        return max;
    }
}
