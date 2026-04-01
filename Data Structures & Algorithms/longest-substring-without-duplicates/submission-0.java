class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet<>();
        int maxLen = 0;

        int L = 0;
        for (int R = 0; R < s.length(); R++) {
            while (set.contains(s.charAt(R))) {
                set.remove(s.charAt(L));
                L++;
            }
            set.add(s.charAt(R));
            maxLen = Math.max(maxLen, set.size());
        }

        return maxLen;
    }
}
