// class Solution {
//     public int myAtoi(String s) {
//         s = s.trim();
//         if(s.isEmpty()){
//             return 0;
//         }
//         int i = 0;
//         int sign = 1;
//         int n = s.length();
//         long num = 0;
//         if(s.charAt(i) == '-' || s.charAt(i) == '+'){
//             sign = (s.charAt(i) == '-') ? -1:1;
//             i++;
//         }
//     while(i < n && Character.isDigit(s.charAt(i))){
//     num = num * 10 + (s.charAt(i) - '0');
//     if(num * sign > Integer.MAX_VALUE){
//         return Integer.MAX_VALUE;
//     }
//     if(num * sign < Integer.MAX_VALUE){
//         return Integer.MIN_VALUE;
//     }
//     i++;
//     }
//     return (int)(sign * num);
// }
// }
class Solution {
    public int myAtoi(String s) {
        // Step 1: Remove leading whitespaces
        s = s.trim();
        if (s.isEmpty()) {
            return 0;
        }

        int i = 0;
        int n = s.length();
        int sign = 1;
        long num = 0; // use long to handle overflow safely

        // Step 2: Check for sign
        if (s.charAt(i) == '+' || s.charAt(i) == '-') {
            sign = (s.charAt(i) == '-') ? -1 : 1;
            i++;
        }

        // Step 3: Convert digits to number
        while (i < n && Character.isDigit(s.charAt(i))) {
            num = num * 10 + (s.charAt(i) - '0');

            // Step 4: Handle overflow
            if (sign * num > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            }
            if (sign * num < Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            }

            i++;
        }

        // Step 5: Return final result
        return (int) (sign * num);
    }
}
