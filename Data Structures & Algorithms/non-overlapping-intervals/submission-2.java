class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(x -> x[1]));

        int toRemove = 0;
        int max = Integer.MIN_VALUE;
        for (int[] curr : intervals) {
            if(curr[0] < max) {
                toRemove++;
            } else {
                max = curr[1];
            }

        }

        return toRemove;
    }
}
