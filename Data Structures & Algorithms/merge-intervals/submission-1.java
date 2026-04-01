class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(x -> x[0]));
        int[] toAdd = intervals[0];
        List<int[]> res = new ArrayList<>();

        for (int i = 1; i < intervals.length; i++) {
            if (toAdd[1] < intervals[i][0]) {
                res.add(toAdd);
                toAdd = intervals[i];
            } else {
                toAdd[1] = Math.max(toAdd[1], intervals[i][1]);
            }
        }

        res.add(toAdd);
        return res.toArray(new int[res.size()][2]);
    }
}
