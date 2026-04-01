class Solution {
    public record Pair(int x, int y, int distance) implements Comparable<Pair> {
        @Override
        public int compareTo(Pair o2) {
            return Integer.compare(o2.distance, this.distance);
        }
    }
    
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Pair> heap = new PriorityQueue<>();

        for (int[] point : points) {
            int x = point[0];
            int y = point[1];
            int dist = point[0] * point[0] + point[1] * point[1];
            heap.offer(new Pair(x, y, dist));
            if (heap.size() > k) {
                heap.poll();
            }
        }

        int[][] result = new int[k][2];
        int i = 0;
        while (!heap.isEmpty()) {
            Pair pair = heap.poll();
            result[i++] = new int[]{pair.x, pair.y};
        }
        return result;
    }
}