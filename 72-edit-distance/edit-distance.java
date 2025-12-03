class Solution {
    public int minDistance(String word1, String word2) {
        char[] s1 = word1.toCharArray();
        char[] s2 = word2.toCharArray();
        int m = s1.length , n = s2.length;
        int[][] cache = new int[m+1][n+1];

        for(int i = 0 ; i <= n  ; i++){
            cache[0][i] = i;
        }
        for(int i = 0 ; i <=m ; i++){
            cache[i][0] = i;
        }
        for(int i = 1 ; i <= m  ; i++){
          //  cache[i][0] = i;
            for(int j = 1 ; j <= n ; j++){
                if(s1[i-1] == s2[j-1]){
                    cache[i][j] = cache[i-1][j-1];
                }
                else{
                    int replace = cache[i-1][j-1];
                    int delete = cache[i-1][j];
                    int insert = cache[i][j-1];
                    cache[i][j] = Math.min(replace , Math.min(delete , insert)) + 1;
                }
            }
        }
        return cache[m][n];
    }
}