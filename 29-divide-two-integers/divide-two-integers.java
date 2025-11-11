// class Solution {
//     public int divide(int dividend, int divisor) {
//         if(dividend == Int_MIN && divisior == -1)
//         return INT_MAX;
//         if(dividend == Int_MIN && divisior == 1)
//         return INT_MIN;
//         long long dd = abs(dividend);
//         long long dv = abs(divisor);
//         int ans = 0;
//         while(dv <= dd){
//             long long sum = dv , count = 1;
//             while(sum < = dd-sum){
//                 sum += sum;
//                 count +=count;
//             }
//             ans +=count;
//             dd -= sum;
//         }
//         if((dividend < 0 && divisior > 0) || (dividend > 0 && divisior < 0))
//         return -ans;
//         return ans;
//     }
// };



class Solution {
    public int divide(int dividend, int divisor) {
        // Handle overflow case
        if (dividend == Integer.MIN_VALUE && divisor == -1)
            return Integer.MAX_VALUE;
        if (dividend == Integer.MIN_VALUE && divisor == 1)
            return Integer.MIN_VALUE;

        // Use long to avoid overflow when taking abs value of Integer.MIN_VALUE
        long dd = Math.abs((long) dividend);
        long dv = Math.abs((long) divisor);
        int ans = 0;

        // Repeatedly subtract divisor multiples from dividend
        while (dd >= dv) {
            long temp = dv, multiple = 1;

            // Double until we can no longer subtract
            while (dd >= (temp << 1)) {
                temp <<= 1;
                multiple <<= 1;
            }

            dd -= temp;
            ans += multiple;
        }

        // Apply sign
        if ((dividend < 0 && divisor > 0) || (dividend > 0 && divisor < 0))
            ans = -ans;

        return ans;
    }
}
