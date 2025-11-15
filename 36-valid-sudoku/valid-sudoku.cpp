// class Solution {
// public:
// bool isSafe(vector<vector<char>>& board , int row, int col , int dig){
//     //horizontal
//     for(int j = 0; j < 9; j++){
//         if(board[row][j] == dig){
//             return false;
//         }
//     }
//     //vertical
//     for(int i = 0; i < 9; i++){
//         if(board[i][col] == dig){
//             return false;
//         }
//     }
//     //grid
//     int srow = (row / 3) * 3;
//     int scol = (col / 3) * 3;
//     for(int i = srow; i <= srow +2 ; i++){
//         for(int j = scol ; j <= scol + 2 ; j++){
//              if(board[i][j] == dig){
//                  return false;
//              }
//         }
//     }
//     return true;
// }
//   bool helper(vector<vector<char>>& board , int row , int col){
//     if(row == 9){
//         return true;
//     }
//     int nextRow = row ;
//     int nextCol = col + 1;
//     if(nextCol == 9){
//         nextRow = row + 1;
//         nextCol = 0;
//     }
//     if(board[row][col]  != '.'){
//         return helper(board , nextRow , nextCol);
//     }
//     for(char dig = '1' ; dig <= '9' ; dig++){
//         if(isSafe(board , row , col , dig)){
//             board[row][col] = dig;
//             if(helper(board , nextRow , nextCol)){
//                 return true;
//             }
//             board[row][col] = '.';
//         }
//     }
//     return false;
//   }
//    void solveSudoku(vector<vector<char>>& board) {
//     helper(board , 0 , 0);
        
//     }
// };




class Solution {
public:
    bool isValidSudoku(vector<vector<char>>& board) {
        // Use vectors of sets to track row, column, and box values
        vector<unordered_set<char>> rows(9);
        vector<unordered_set<char>> cols(9);
        vector<unordered_set<char>> boxes(9);

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char current = board[i][j];
                
                if (current != '.') {
                    // Check row
                    if (rows[i].count(current)) return false; 
                    rows[i].insert(current);

                    // Check column
                    if (cols[j].count(current)) return false;
                    cols[j].insert(current);

                    // Check 3x3 sub-box
                    int boxIndex = (i / 3) * 3 + (j / 3);
                    if (boxes[boxIndex].count(current)) return false;
                    boxes[boxIndex].insert(current);
                }
            }
        }
        return true;
    }
};
