class Solution {
    static class TrieNode {
        boolean end = false;
        Map<Character, TrieNode> chars = new HashMap<>(26);
    }

    char[][] board;
    int row = 0;
    int col = 0;
    Set<String> foundWord = new TreeSet<>();
    TrieNode head = new TrieNode();

    public List<String> findWords(char[][] board, String[] words) {
        this.board = board;
        row = board.length;
        col = board[0].length;

        for (String str : words) {
            constructTrie(str);
        }

        for (int r = 0; r < row; r++) {
            for (int c = 0; c < col; c++) {
                if (foundWord.size() != words.length) {
                    dfs(r, c, "");
                }
            }
        }

        return new ArrayList<>(foundWord);
    }

    public void dfs(int r, int c, String curr) {
        if (!canContain(curr)) return;
        addword(curr);
        if (Math.min(r, c) < 0 || r == row || c == col) return;
        if (board[r][c] == '.') return;

        char temp = board[r][c];
        board[r][c] = '.';

        dfs(r + 1, c, curr + temp);
        dfs(r - 1, c, curr + temp);
        dfs(r, c + 1, curr + temp);
        dfs(r, c - 1, curr + temp);

        board[r][c] = temp;
    }

    public void addword(String word) {
        if (contain(word))
            foundWord.add(word);
    }

    public void constructTrie(String word) {
        TrieNode curr = head;
        for (char c : word.toCharArray()) {
            if (!curr.chars.containsKey(c)) {
                curr.chars.put(c, new TrieNode());
            }
            curr = curr.chars.get(c);
        }
        curr.end = true;
    }


    public boolean canContain(String word) {
        TrieNode curr = head;
        for (char c : word.toCharArray()) {
            if (!curr.chars.containsKey(c)) {
                return false;
            }
            curr = curr.chars.get(c);
        }
        return true;
    }

    public boolean contain(String word) {
        TrieNode curr = head;
        for (char c : word.toCharArray()) {
            if (!curr.chars.containsKey(c)) {
                return false;
            }
            curr = curr.chars.get(c);
        }
        return curr.end;
    }
}
