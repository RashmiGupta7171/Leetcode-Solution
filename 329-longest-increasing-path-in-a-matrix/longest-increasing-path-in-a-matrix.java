class Solution {
    private int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }

        int m = matrix.length;
        int n = matrix[0].length;
        int[][] memo = new int[m][n];
        int maxLength = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                maxLength = Math.max(maxLength, dfs(matrix, i, j, memo));
            }
        }

        return maxLength;
    }

    private int dfs(int[][] matrix, int row, int col, int[][] memo) {
        if (memo[row][col] != 0) {
            return memo[row][col];
        }

        int max = 1;
        int m = matrix.length;
        int n = matrix[0].length;

        for (int[] dir : directions) {
            int newRow = row + dir[0];
            int newCol = col + dir[1];

            if (newRow >= 0 && newRow < m &&
                newCol >= 0 && newCol < n &&
                matrix[newRow][newCol] > matrix[row][col]) {

                max = Math.max(max, 1 + dfs(matrix, newRow, newCol, memo));
            }
        }

        memo[row][col] = max;
        return max;
    }
}