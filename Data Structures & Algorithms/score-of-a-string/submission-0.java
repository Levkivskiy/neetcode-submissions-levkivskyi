class Solution {
    public int scoreOfString(String s) {
        int sum = 0;
        for(int i = 0; i < s.length() - 1; i ++) {
            int left = s.charAt(i);
            int right = s.charAt(i + 1);
            sum += Math.abs(left - right);
        }

        return sum;
    }
}