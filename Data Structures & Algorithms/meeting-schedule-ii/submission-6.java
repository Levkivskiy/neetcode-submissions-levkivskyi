/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
        if (intervals == null || intervals.isEmpty()) return 0;
        intervals.sort(Comparator.comparingInt(x -> x.start));
        PriorityQueue<Interval> heap = new PriorityQueue<>(Comparator.comparingInt(x -> x.end));

        int max = 0;
        for (Interval interval : intervals) {
            if(heap.isEmpty()) {
                heap.add(interval);
            } else if (heap.peek().end > interval.start) {
                heap.add(interval);
            } else {
                while (!heap.isEmpty() && heap.peek().end <= interval.start) {
                    heap.poll();
                }
                heap.add(interval);
            }
            max = Math.max(max, heap.size());
        }

        return max;
    }
}