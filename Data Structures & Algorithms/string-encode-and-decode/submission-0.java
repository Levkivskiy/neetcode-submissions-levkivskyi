class Solution {

    public String encode(List<String> strs) {
        if (strs.isEmpty()) {
            return "";
        }
        StringBuilder string = new StringBuilder();
        for (String curr : strs) {
            String codec = '|' + String.valueOf(curr.length()) + '|';
            string.append(codec);
            string.append(curr);
        }

        return string.toString();
    }

    public void decodeHelper(String str, List<String> res) {
        if (str.isEmpty()) {
            return;
        }
        int r = 1;
        StringBuilder len = new StringBuilder();
        if (str.charAt(0) == '|') {
            while (r < str.length()) {
                if (Character.isDigit(str.charAt(r))) {
                    len.append(str.charAt(r));
                    r++;
                } else if ('|' == str.charAt(r)) {
                    r++;
                    break;
                } else {
                    return;
                }
            }
        }

        int lenStringBuilt = Integer.parseInt(len.toString());

        res.add(str.substring(r, r + lenStringBuilt));
        decodeHelper(str.substring(r + lenStringBuilt), res);
    }

    public List<String> decode(String str) {
        List<String> res = new ArrayList<>();
        decodeHelper(str, res);
        return res;
    }
}
