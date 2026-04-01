class Solution {

    public String maxSub(int L, int R, String s) {
        String res = "";
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            res = s.substring(L, R + 1);
            L--;
            R++;
        }
        return res;
    }

    public String longestPalindrome(String s) {
        String res = "";
        for (int i = 0; i < s.length(); i++) {
            String palindrome = maxSub(i, i, s);
            String palindrome2 = maxSub(i, i + 1, s);

            res = palindrome.length() > res.length() ? palindrome : res;
            res = palindrome2.length() > res.length() ? palindrome2 : res;
        }

        return res;
    }
}