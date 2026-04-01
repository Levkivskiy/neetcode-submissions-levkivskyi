class Solution {
    static record Zip(int position, int speed) {

    };

    public int carFleet(int target, int[] position, int[] speed) {
        PriorityQueue<Zip> heap = new PriorityQueue<>(Comparator.comparingInt(Zip::position).reversed());

        for (int i = 0; i < position.length; i++) {
            heap.offer(new Zip(position[i], speed[i]));
        }

        double prevMax = 0;
        int count = 0;
        while (!heap.isEmpty()) {
            Zip curr = heap.poll();
            if (target - curr.position <= 0) continue;
            double currMax = (double) (target - curr.position) / curr.speed;

            if (currMax > prevMax) {
                count++;
                prevMax = currMax;
            } 
        }

        return count;
    }
}
