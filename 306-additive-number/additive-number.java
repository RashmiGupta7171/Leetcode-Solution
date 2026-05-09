class Solution {
    public boolean isAdditiveNumber(String num) {
        int n = num.length();
        for (int i = 1; i <= n / 2; i++) {

            if (num.charAt(0) == '0' && i > 1) {
                break;
            }

            for (int j = 1; Math.max(i, j) <= n - i - j; j++) {

                // Leading zero check for second number
                if (num.charAt(i) == '0' && j > 1) {
                    break;
                }

                if (isValid(i, j, num)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean isValid(int len1, int len2, String num) {
        String s1 = num.substring(0, len1);
        String s2 = num.substring(len1, len1 + len2);

        java.math.BigInteger n1 = new java.math.BigInteger(s1);
        java.math.BigInteger n2 = new java.math.BigInteger(s2);

        int start = len1 + len2;

        while (start < num.length()) {
            java.math.BigInteger sum = n1.add(n2);
            String sumStr = sum.toString();

            // Check if next part matches sum
            if (!num.startsWith(sumStr, start)) {
                return false;
            }

            start += sumStr.length();
            n1 = n2;
            n2 = sum;
        }

        return true;
    }
}