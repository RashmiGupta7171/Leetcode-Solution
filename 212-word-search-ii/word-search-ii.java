class Solution {

    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        String word;
    }

    private TrieNode root = new TrieNode();
    private List<String> result = new ArrayList<>();

    public List<String> findWords(char[][] board, String[] words) {

        // Build Trie
        for (String word : words) {
            TrieNode node = root;
            for (char ch : word.toCharArray()) {
                int idx = ch - 'a';
                if (node.children[idx] == null) {
                    node.children[idx] = new TrieNode();
                }
                node = node.children[idx];
            }
            node.word = word;
        }

        int m = board.length;
        int n = board[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dfs(board, i, j, root);
            }
        }

        return result;
    }

    private void dfs(char[][] board, int row, int col, TrieNode node) {

        if (row < 0 || col < 0 ||
            row >= board.length || col >= board[0].length ||
            board[row][col] == '#') {
            return;
        }

        char ch = board[row][col];
        TrieNode next = node.children[ch - 'a'];

        if (next == null) {
            return;
        }

        // Found a word
        if (next.word != null) {
            result.add(next.word);
            next.word = null; // avoid duplicates
        }

        board[row][col] = '#';

        dfs(board, row + 1, col, next);
        dfs(board, row - 1, col, next);
        dfs(board, row, col + 1, next);
        dfs(board, row, col - 1, next);

        board[row][col] = ch;
    }
}