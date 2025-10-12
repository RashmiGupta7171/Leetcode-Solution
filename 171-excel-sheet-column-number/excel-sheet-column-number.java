class Solution {
    public int titleToNumber(String columnTitle) {
      int ans = columnTitle.charAt(0) - 'A' + 1;
      int pow = 26;
      for( int i = 1; i < columnTitle.length(); i++){
        int curr = columnTitle.charAt(i) - 'A' + 1;
        ans *= pow;
        ans +=curr;
      }  
      return ans;
    }
}