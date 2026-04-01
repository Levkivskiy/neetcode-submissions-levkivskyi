class Solution {
    public boolean isPalindrome(String s) {
        int L = 0;
        int R = s.length() - 1;

        String lowerCase = s.toLowerCase();

        while (L < R) {
            if (!Character.isLetterOrDigit(lowerCase.charAt(L))) {
                L++;
                continue;
            }
            if (!Character.isLetterOrDigit(lowerCase.charAt(R))) {
                R--;
                continue;
            }
            if(lowerCase.charAt(R) != lowerCase.charAt(L))
                return false;
            L++;
            R--;
        }

        return true;
    }
}
