class Solution {
    record Coordinates(int x, int y) {
    }

    record Pair(int x, int y, int weight) {
    }

    public int minCostConnectPoints(int[][] points) {
        Map<Coordinates, List<Coordinates>> adj = new HashMap<>();

        for (int i = 0; i < points.length; i++) {
            List<Coordinates> neigh = new ArrayList<>();
            for (int j = 0; j < points.length; j++) {
                if (i != j) {
                    neigh.add(new Coordinates(points[j][0], points[j][1]));
                }
            }
            Coordinates node = new Coordinates(points[i][0], points[i][1]);
            adj.put(node, neigh);
        }

        int sum = 0;
        HashSet<Coordinates> visited = new HashSet<>();
        PriorityQueue<Pair> heap = new PriorityQueue<>(Comparator.comparingInt(Pair::weight));
        heap.add(new Pair(points[0][0], points[0][1], 0));


        while (visited.size() != points.length && !heap.isEmpty()) {
            Pair curr = heap.poll();
            Coordinates currCoor = new Coordinates(curr.x, curr.y);
            if (visited.contains(currCoor))
                continue;
            visited.add(currCoor);
            sum += curr.weight;
            for (Coordinates neigh : adj.get(currCoor)) {
                if (!visited.contains(neigh)) {
                    int w = Math.abs(neigh.x - curr.x) + Math.abs(neigh.y - curr.y);
                    heap.add(new Pair(neigh.x, neigh.y, w));
                }
            }
        }

        return sum;
    }
}
