class Solution {
    int[][] grid;
    int[][] visited;
    int row;
    int col;

    public record Coordinate(int r, int c) {
    }

    public void islandsAndTreasure(int[][] grid) {
        this.grid = grid;
        this.row = grid.length;
        this.col = grid[0].length;

        for (int r = 0; r < row; r++) {
            for (int c = 0; c < col; c++) {
                if (grid[r][c] == 0) {
                    this.visited = new int[row][col];
                    bfs(r, c);
                }
            }
        }
    }

    public void bfs(int startR, int startC) {

        Queue<Coordinate> queue = new ArrayDeque<>();
        queue.offer(new Coordinate(startR, startC));
        int distance = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                Coordinate curr = queue.poll();
                int r = curr.r;
                int c = curr.c;

                if (Math.min(curr.r, curr.c) < 0 || curr.r >= row || curr.c >= col || grid[r][c] == -1 || visited[r][c] == 1)
                    continue;

                queue.offer(new Coordinate(r + 1, c));
                queue.offer(new Coordinate(r - 1, c));
                queue.offer(new Coordinate(r, c + 1));
                queue.offer(new Coordinate(r, c - 1));

                visited[r][c] = 1;
                if (grid[r][c] == 0) continue;

                grid[r][c] = grid[r][c] == 2147483647 ? distance : Math.min(grid[r][c], distance);
            }
            distance++;
        }
    }
}
