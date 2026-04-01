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
    public boolean canAttendMeetings(List<Interval> intervals) {
        Collections.sort(intervals, Comparator.comparingInt(i -> i.start));
        
        int startAfter = -1;
        for (Interval interval : intervals) {
            if (startAfter > interval.start || interval.start >= interval.end) return false;
            startAfter = interval.end;
        }

        return true;
    }
}
