
//         class Solution {
//     public String countAndSay(int n) {
//         if (n == 1) return "1";
        
//         String res = "1";
//         for (int i = 2; i <= n; i++) {
//             res = getNext(res);
//         }
//         return res;
//     }

//     private String getNext(String s) {
//         StringBuilder sb = new StringBuilder();
//         int count = 1;  // count of current character
        
//         for (int i = 1; i < s.length(); i++) {
//             // If current char matches previous one, increase count
//             if (s.charAt(i) == s.charAt(i - 1)) {
//                 count++;
//             } else {
//                 // Otherwise, append count and previous char
//                 sb.append(count).append(s.charAt(i - 1));
//                 count = 1; // reset count
//             }
//         }
        
//         // Append the last run
//         sb.append(count).append(s.charAt(s.length() - 1));
        
//         return sb.toString();
//     }
// }

class Solution{
    public String countAndSay(int n){
        if(n ==1)
        return "1";

        String say = countAndSay(n - 1);
        StringBuilder result = new StringBuilder();

        for(int i = 0; i < say.length() ; i++){
            char ch = say.charAt(i);
            int count = 1;

            while(i < say.length() - 1 && say.charAt(i) == say.charAt(i+1)){
                count++;
                i++;
            }
            result.append(count).append(ch);
        }
        return result.toString();
    }
}
