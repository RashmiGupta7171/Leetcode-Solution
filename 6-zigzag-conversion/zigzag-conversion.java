class Solution {
    public String convert(String s, int numRows) {
        StringBuilder[] ans = new StringBuilder[numRows];
        for(int i=0; i<numRows; i++){
            ans[i] = new StringBuilder();
        }
        char[] arr = s.toCharArray();
        int index = 0 ;
        int n = arr.length;
        while(index < n){
            for(int j = 0; j < numRows && index < n; j++){
                ans[j].append(arr[index++]);
            }
            for(int j = numRows-2 ; j > 0 && index < n ; j--){
                ans[j].append(arr[index++]);
            }
        }
        StringBuilder res = ans[0];
        for(int i = 1 ; i < numRows ; i++){
            res.append(ans[i].toString());
        }
        return res.toString();
    }
}
