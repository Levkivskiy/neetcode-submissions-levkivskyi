class Solution {
    int row = 0;
    int col = 0;
    int[][] grid;
    Deque<int[]> queue = new ArrayDeque<>();

    public void markAndCheck(int r, int c) {
        if (Math.min(r, c) < 0 || r >= row || c >= col || grid[r][c] == 1) {
            return ;
        } else {
            queue.offer(new int[]{r, c});
            grid[r][c] = 1;
            return;
        }
    }

    public int shortestPathBinaryMatrix(int[][] grid) {
        this.grid = grid;
        row = grid.length;
        col = grid[0].length;
        int distance = 1;

        if(grid[0][0] == 1 || grid[row - 1][col - 1] == 1) {
            return -1;
        }

        grid[0][0] = 1;
        queue.offer(new int[]{0, 0});

        while (!queue.isEmpty()) {
            int length = queue.size();
            for (int i = 0; i < length; i++) {
                int[] pair = queue.poll();
                int r = pair[0];
                int c = pair[1];

                if (r == row - 1 && c == col - 1)
                    return distance;
                int[][] neighbor = {
                        {r - 1, c},
                        {r + 1, c},
                        {r, c - 1},
                        {r, c + 1},
                        {r - 1, c - 1},
                        {r - 1, c + 1},
                        {r + 1, c - 1},
                        {r + 1, c + 1},
                };

                for (int[] np : neighbor) {
                    markAndCheck(np[0], np[1]);
                }
            }
            distance++;
        }

        return -1;
    }
}