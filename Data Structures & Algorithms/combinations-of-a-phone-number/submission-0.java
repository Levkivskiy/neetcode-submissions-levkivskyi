class Solution {
    List<String> res = new ArrayList<>();
    String[] digitToChar = {
            "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"
    };

    public List<String> letterCombinations(String digits) {
        if (digits.isEmpty()) return res;
        res.add("");
        for (char charDigit : digits.toCharArray()) {
            int digit = charDigit - '0';
            List<String> pass = new ArrayList<>();

            for (String generated : res) {
                for (char currChar : digitToChar[digit].toCharArray()) {
                    pass.add(generated + currChar);
                }
            }
            res = pass;
        }

        return res;
    }
}