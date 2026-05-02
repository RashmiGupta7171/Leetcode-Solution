class Solution {
    public void gameOfLife(int[][] board) {
        int m = board.length;
        int n = board[0].length;

        // Directions for 8 neighbors
        int[][] dirs = {
            {-1, -1}, {-1, 0}, {-1, 1},
            {0, -1},          {0, 1},
            {1, -1}, {1, 0}, {1, 1}
        };

        // First pass: apply rules with temporary states
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                int liveNeighbors = 0;

                for (int[] d : dirs) {
                    int x = i + d[0];
                    int y = j + d[1];

                    if (x >= 0 && x < m && y >= 0 && y < n) {
                        // Count original live cells (1 or 2 means originally alive)
                        if (board[x][y] == 1 || board[x][y] == 2) {
                            liveNeighbors++;
                        }
                    }
                }

                // Apply rules
                if (board[i][j] == 1) {
                    if (liveNeighbors < 2 || liveNeighbors > 3) {
                        board[i][j] = 2; // live → dead
                    }
                } else {
                    if (liveNeighbors == 3) {
                        board[i][j] = 3; // dead → live
                    }
                }
            }
        }

        // Second pass: finalize states
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 2) {
                    board[i][j] = 0;
                } else if (board[i][j] == 3) {
                    board[i][j] = 1;
                }
            }
        }
    }
}