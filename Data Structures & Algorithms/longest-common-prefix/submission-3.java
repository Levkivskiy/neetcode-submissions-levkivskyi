class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 1) {
            return strs[0];
        }
        int row = 0;
        int col = 0;
        StringBuilder curr = new StringBuilder();
        int minLen = strs[row].length();

        for (String s : strs) {
            minLen = Math.min(minLen, s.length());
        }

        while (col < minLen) {
            while (row + 1 < strs.length) {
                if (strs[row].charAt(col) != strs[row + 1].charAt(col)) {
                    return curr.toString();
                }
                row++;
            }

            curr.append(strs[row].charAt(col));
            col++;
            row = 0;
        }

        return curr.toString();
    }
}