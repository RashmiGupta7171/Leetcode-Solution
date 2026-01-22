// class Solution {
//     int m, n;

//     public void solve(char[][] board) {
//         if (board == null || board.length == 0) return;

//         m = board.length;
//         n = board[0].length;

//         // Step 1: Mark all border-connected 'O's as safe
//         for (int i = 0; i < m; i++) {
//             dfs(board, i, 0);
//             dfs(board, i, n - 1);
//         }

//         for (int j = 0; j < n; j++) {
//             dfs(board, 0, j);
//             dfs(board, m - 1, j);
//         }

//         // Step 2: Capture surrounded regions
//         for (int i = 0; i < m; i++) {
//             for (int j = 0; j < n; j++) {
//                 if (board[i][j] == 'O') {
//                     board[i][j] = 'X';
//                 } else if (board[i][j] == '#') {
//                     board[i][j] = 'O';
//                 }
//             }
//         }
//     }

//     private void dfs(char[][] board, int i, int j) {
//         if (i < 0 || j < 0 || i >= m || j >= n || board[i][j] != 'O') {
//             return;
//         }

//         board[i][j] = '#'; // mark as safe

//         dfs(board, i + 1, j);
//         dfs(board, i - 1, j);
//         dfs(board, i, j + 1);
//         dfs(board, i, j - 1);
//     }
// }

class Solution{
    private void dfs(char[][] board , int i , int j , int rows , int cols){
        if(i < 0 || i >= rows || j < 0 || j >= cols || board[i][j] != 'O'){
            return;
        }
        board[i][j] = 'T';
        
        dfs(board , i+1 , j , rows , cols);
        dfs(board , i-1 , j , rows , cols);
        dfs(board , i , j+1 , rows , cols);
        dfs(board , i , j-1 , rows , cols);
    }
    public void solve(char[][] board){
        if(board == null || board.length == 0 || board[0].length == 0){
            return;
        }
        int rows = board.length;
        int cols = board[0].length;

        for(int j = 0 ; j < cols ; j++){
            if(board[0][j] == 'O')
            dfs(board , 0 , j , rows , cols);
            if(board[rows-1][j] == 'O')
            dfs(board , rows-1 , j , rows , cols);
        }
        for(int i = 0 ; i < rows ; i++){
            if(board[i][0] == 'O')
            dfs(board , i , 0 , rows , cols);
            if(board[i][cols-1] == 'O')
            dfs(board , i , cols-1 , rows , cols);
        }
        for(int i = 0 ; i < rows ; i++){
            for(int j = 0 ; j < cols ; j++){
                if(board[i][j] == 'O'){
                board[i][j] = 'X';
            }
            else if(board[i][j] == 'T'){
                board[i][j] = 'O';
            }
            }
        }
    }
}
