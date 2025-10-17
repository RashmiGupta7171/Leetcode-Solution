class Solution {
    public boolean isHappy(int n) {
        Set<Integer> usedIntegers = new HashSet<>();
//         while(true){
//             int sum = 0;
//             while (n != 0){
//                 sum += math.pow(n%10 , 2.0);
//                 n = n/10;
//                 if(sum == 1)
//                 return true;
//                 n = sum;
//                 if (usedIntegers.contains(n))
//                 return false;
//                 usedIntegers.add(n);
//             }
//         }
//     }
// }
 while (n != 1 && !usedIntegers.contains(n)) {
            usedIntegers.add(n);
            n = getSumOfSquares(n);
        }

        return n == 1;
    }

    private int getSumOfSquares(int num) {
        int sum = 0;
        while (num > 0) {
            int digit = num % 10;
            sum += digit * digit;
            num /= 10;
        }
        return sum;
    }
}
