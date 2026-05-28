class Solution {

    public List<List<String>> solveNQueens(int n) {

        List<List<String>> ans = new ArrayList<>();

        char[][] board = new char[n][n];

        // Fill board with '.'
        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }

        boolean[] col = new boolean[n];
        boolean[] diag1 = new boolean[2 * n];
        boolean[] diag2 = new boolean[2 * n];

        solve(0, n, board, ans, col, diag1, diag2);

        return ans;
    }

    private void solve(int row, int n, char[][] board,
                       List<List<String>> ans,
                       boolean[] col,
                       boolean[] diag1,
                       boolean[] diag2) {

        // Base case
        if (row == n) {
            ans.add(build(board));
            return;
        }

        for (int c = 0; c < n; c++) {

            int d1 = row - c + n;
            int d2 = row + c;

            // Check if queen can be placed
            if (col[c] || diag1[d1] || diag2[d2]) {
                continue;
            }

            // Place queen
            board[row][c] = 'Q';
            col[c] = true;
            diag1[d1] = true;
            diag2[d2] = true;

            // Recur for next row
            solve(row + 1, n, board, ans, col, diag1, diag2);

            // Backtrack
            board[row][c] = '.';
            col[c] = false;
            diag1[d1] = false;
            diag2[d2] = false;
        }
    }

    private List<String> build(char[][] board) {

        List<String> temp = new ArrayList<>();

        for (char[] row : board) {
            temp.add(new String(row));
        }

        return temp;
    }
}