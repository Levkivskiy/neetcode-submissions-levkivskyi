class Solution {
    public record Pair(char task, int minPossible) {
    }

    public int leastInterval(char[] tasks, int n) {
        int[] minAppeared = new int[26];
        PriorityQueue<Pair> heap = new PriorityQueue<>(Comparator.comparingInt(Pair::minPossible));

        for (char task : tasks) {
            int min = minAppeared[task - 'A'];
            heap.add(new Pair(task, min));
            minAppeared[task - 'A'] = min + n + 1;
        }

        int count = 0;

        while (!heap.isEmpty()) {
            if (heap.peek().minPossible <= count) {
                heap.poll();
            }
            count++;
        }

        return count;
    }
}
