class Solution {
        record Pair(int node, int weight) {
    }

    public int swimInWater(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;

        Map<Integer, List<Integer>> adj = new HashMap<>();

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                List<Integer> neigh = new ArrayList<>();

                if (i + 1 != row)
                    neigh.add(grid[i + 1][j]);
                if (i - 1 >= 0)
                    neigh.add(grid[i - 1][j]);
                if (j + 1 != col)
                    neigh.add(grid[i][j + 1]);
                if (j - 1 >= 0)
                    neigh.add(grid[i][j - 1]);

                adj.put(grid[i][j], neigh);
            }
        }

        Map<Integer, Integer> res = new HashMap<>();
        PriorityQueue<Pair> heap = new PriorityQueue<>(Comparator.comparingInt(Pair::weight));
        heap.add(new Pair(grid[0][0], grid[0][0]));

        while (!heap.isEmpty()) {
            Pair curr = heap.poll();
            if(res.containsKey(curr.node))
                continue;

            res.put(curr.node, curr.weight);
            if(curr.node == grid[row - 1][col - 1]) {
                break;
            }
            for (int neigh : adj.get(curr.node)) {
                if(!res.containsKey(neigh)) {
                    heap.add(new Pair(neigh, Math.max(neigh, curr.weight)));
                }
            }
        }

        return res.getOrDefault(grid[row - 1][col - 1], 0);
    }
}
