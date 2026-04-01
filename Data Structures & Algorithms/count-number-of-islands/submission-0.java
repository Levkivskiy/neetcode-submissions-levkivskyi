class Solution {
    char[][] grid;
    int row = 0;
    int col = 0;

    public void fillWater(int r, int c) {
        if (r == row || c == col || Math.min(r, c) < 0 || grid[r][c] == '0') {
            return;
        }

        grid[r][c] = '0';
        fillWater(r + 1, c);
        fillWater(r - 1, c);
        fillWater(r, c + 1);
        fillWater(r, c - 1);
    }

    public int numIslands(char[][] grid) {
        this.grid = grid;
        row = grid.length;
        col = grid[0].length;

        int count = 0;
        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                if(grid[i][j] == '1') {
                    count++;
                    fillWater(i, j);
                }
            }
        }

        return count;
    }
}
