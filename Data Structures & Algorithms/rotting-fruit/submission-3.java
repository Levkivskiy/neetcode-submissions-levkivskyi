class Solution {
    public record Coor(int r, int c) {
    }

    public int orangesRotting(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        Queue<Coor> queue = new ArrayDeque<>();

        int distance = -1;

        for (int r = 0; r < row; r++) {
            for (int c = 0; c < col; c++) {
                if (grid[r][c] == 2) {
                    queue.offer(new Coor(r, c));
                }
            }
        }

        while (!queue.isEmpty()) {
            int len = queue.size();

            for (int i = 0; i < len; i++) {
                Coor curr = queue.poll();
                int r = curr.r, c = curr.c;

                int[][] neighbors = {
                        {r - 1, c},
                        {r + 1, c},
                        {r, c - 1},
                        {r, c + 1}
                };

                for (int[] neighbor : neighbors) {
                    int neiR = neighbor[0];
                    int neiC = neighbor[1];
                    if (Math.min(neiR, neiC) < 0 || neiR >= row || neiC >= col || grid[neiR][neiC] == 0 || grid[neiR][neiC] == 2)
                        continue;
                    grid[neiR][neiC] = 2;
                    queue.offer(new Coor(neiR, neiC));
                }
            }
            distance++;
        }

        for (int r = 0; r < row; r++) {
            for (int c = 0; c < col; c++) {
                if (grid[r][c] == 1) {
                    return -1;
                }
            }
        }

        return distance == -1 ? 0 : distance;
    }
}
