class Solution {
    public List<Integer> spiralOrder(int[][] mat) {
         int m = mat.length , n = mat[0].length;
        int srow = 0 , scol = 0 , erow = m - 1 , ecol = n -1;
        List<Integer> ans = new ArrayList<>();
        while(srow <= erow && scol <= ecol){
            //Top
            for(int j = scol ; j <= ecol ; j++){
                ans.add(mat[srow][j]);
            }
            //Right
            for(int i = srow + 1 ; i <= erow ; i++){
                ans.add(mat[i][ecol]);
        }
        //Bottom
        for(int j = ecol -1 ; j >= scol ; j--){
            if(srow == erow){
                break;
            }
                ans.add(mat[erow][j]);
        }
        //Left
        for(int i = erow - 1 ; i >=srow + 1 ; i--){
            if(scol == ecol){
                break;
            }
                ans.add(mat[i][scol]);
        }
        srow++;
        scol++;
        ecol--;
        erow--;
        }
        return ans;
    }
}