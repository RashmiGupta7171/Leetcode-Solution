import java.math.BigInteger;

class Solution {
    public String smallestGoodBase(String n) {
        BigInteger num = new BigInteger(n);

        int maxLength = num.bitLength();

        // Try the maximum possible number of digits first
        for (int m = maxLength; m >= 2; m--) {

            BigInteger low = BigInteger.valueOf(2);
            BigInteger high = num.subtract(BigInteger.ONE);

            while (low.compareTo(high) <= 0) {

                BigInteger mid = low.add(high)
                                    .divide(BigInteger.valueOf(2));

                BigInteger sum = BigInteger.ONE;
                BigInteger power = BigInteger.ONE;

                for (int i = 1; i < m; i++) {
                    power = power.multiply(mid);
                    sum = sum.add(power);

                    if (sum.compareTo(num) > 0) {
                        break;
                    }
                }

                int comparison = sum.compareTo(num);

                if (comparison == 0) {
                    return mid.toString();
                } 
                else if (comparison < 0) {
                    low = mid.add(BigInteger.ONE);
                } 
                else {
                    high = mid.subtract(BigInteger.ONE);
                }
            }
        }

        // Every number can be represented as 11 in base n-1
        return num.subtract(BigInteger.ONE).toString();
    }
}